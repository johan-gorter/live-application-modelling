package lbe.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.model.Application;
import lbe.model.flow.Flow;
import lbe.model.flow.Page;

import org.apache.log4j.Logger;

import play.Play;
import play.libs.F.Promise;

public class Case {
	
	private static final Logger LOG = Logger.getLogger(Case.class);

	private static class Waiter {
		Promise<PageElement> promise;
		Application application;
		Session session;

		public Waiter(Promise<PageElement> promise, Application application, Session session) {
			this.promise = promise;
			this.application = application;
			this.session = session;
		}
	}

	private final CaseInstance caseInstance;
	private final CasePersister persister;
	
	private String id;
	private volatile CaseData currentCaseData;
	private List<Waiter> waiters = new ArrayList<Waiter>();
	private Map<String, Session> sessions = new HashMap<String, Session>();
	
	public Case(CaseInstance caseInstance, String id, CasePersister persister) {
		this.caseInstance = caseInstance;
		this.currentCaseData=new CaseData(caseInstance, caseInstance.getVersion());
		this.id = id;
		this.persister = persister;
	}

	public String getId() {
		return id;
	}

	public synchronized Promise<PageElement> waitForChange(int lastCaseVersion, Application application, PageCoordinates pageCoordinates, String sessionId, String userName) {
		LOG.info("waitForChange, last known case version: "+lastCaseVersion+" case version "+currentCaseData.getVersion()
					+" model version "+getModelVersion());
		CaseManager.incrementChangeWaiters();
		Promise<PageElement> promise = new Promise<PageElement>();
		if (currentCaseData.getVersion()>lastCaseVersion) {
			LOG.info("Sending page (not waiting for change)");
			promise.invoke(render(application, pageCoordinates));
			return promise;
		}
		LOG.info("Waiting for change");
		Session session = getOrCreateSession(sessionId, userName);
		session.setPageCoordinates(pageCoordinates);
		waiters.add(new Waiter(promise, application, session));
		return promise;
	}

	private int getModelVersion() {
		if (Play.classloader !=null && Play.classloader.currentState!=null) {
			return Play.classloader.currentState.hashCode();
		}
		return 0;
	}
	
	private PageElement render(Application application, PageCoordinates pageCoordinates) {
		FlowContext context = new FlowContext(currentCaseData, id);
		context.setFlowStack(application.createFlowStack(pageCoordinates, caseInstance));
		return renderPage(context, pageCoordinates.format());
	}
	
	private PageElement startFlow(Application application, PageCoordinates pageCoordinates, String sessionId, String userName) {
		FlowContext context = new FlowContext(currentCaseData, id);
		Flow startFlow = getStartFlow(application, pageCoordinates);
		startFlow.enter("start", context, new Instance[0]);
//		context.setFlowStack(new FlowStack(null, startFlow));
//		String firstTrigger = context.step("start", new Instance[0]);
//		flow(context, firstTrigger, new Instance[0]);
		pageCoordinates = context.getFlowStack().toPageCoordinates();
		Session session = getOrCreateSession(sessionId, userName);
		session.setPageCoordinates(pageCoordinates);
		return renderPage(context, pageCoordinates.format());
	}
	
	public synchronized PageElement renderOrStartFlow(Application application, PageCoordinates pageCoordinates, String sessionId, String userName) {
		if (pageCoordinates==null || pageCoordinates.getPath().size()<2) {
			return startFlow(application, pageCoordinates, sessionId, userName);
		} else {
			return render(application, pageCoordinates);
		}
	}
	
	private Session getOrCreateSession(String sessionId, String userName) {
		Session session = sessions.get(sessionId);
		if (session==null) {
			session = new Session();
			session.setId(sessionId);
			session.setUserName(userName);
			sessions.put(sessionId, session);
		}
		return session;
	}

	private Flow getStartFlow(Application application, PageCoordinates pageCoordinates) {
		if (pageCoordinates==null || pageCoordinates.getPath().size()==0) {
			return application.getExposedFlows()[0];
		}
		return application.getExposedFlow(pageCoordinates.getPath().get(0).getNodeName());
	}

	private PageElement renderPage(FlowContext flowContext, String pageCoordinates) {
		RenderContext renderContext = new RenderContext(flowContext, pageCoordinates);
		PageElement element = flowContext.getPage().render(renderContext);
		return element;
	}

	public synchronized void cancelWaitForChange(Promise<CaseData> promise) {
		waiters.remove(promise);
		CaseManager.decrementChangeWaiters();
	}
	
	public synchronized void submit(Application application, PageCoordinates pageCoordinates, String sessionId, String userName, ChangeContext.FieldChange[] fieldChanges, String submit) {
		FlowContext flowContext = new FlowContext(currentCaseData, id);
		flowContext.setFlowStack(application.createFlowStack(pageCoordinates, caseInstance));
		Page page = flowContext.getPage();
		ChangeContext changeContext = new ChangeContext(flowContext, pageCoordinates.format(), fieldChanges, submit);
		String trigger = page.submit(changeContext);
		flow(flowContext, trigger, changeContext.getSelectedInstancesDuringTrigger());
		getOrCreateSession(sessionId, userName).setPageCoordinates(flowContext.getFlowStack().toPageCoordinates());
		informWaiters();
		this.caseInstance.afterSubmit();
	}
	
	private void flow(FlowContext flowContext, String trigger, Instance[] selectedInstances) {
		while (trigger!=null) {
			trigger = flowContext.step(trigger, selectedInstances);
		}
	}

	public synchronized void informWaiters() {
		currentCaseData = new CaseData(caseInstance, currentCaseData.getVersion()+1);
		CasePersister.INSTANCE.persist(id, currentCaseData.getCaseInstance(), currentCaseData.getVersion());
		LOG.info("New case version: "+currentCaseData.getVersion());
		List<Waiter> promises = waiters;
		waiters = new ArrayList<Waiter>();
		LOG.info("informing "+ promises.size() +"waiters");
		for (Waiter waiter : promises) {
			waiter.promise.invoke(render(waiter.application, waiter.session.getPageCoordinates()));
		}
	}

	public synchronized String startSession(String userName, PageCoordinates pageCoordinates) {
		String sessionId = UUID.randomUUID().toString();
		Session session = new Session();
		session.setId(sessionId);
		session.setUserName(userName);
		session.setPageCoordinates(pageCoordinates);
		sessions.put(sessionId, session);
		return sessionId;
	}
}
