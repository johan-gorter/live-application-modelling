package org.instantlogic.play;

import java.awt.image.renderable.RenderContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.page.PageElement;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.PageCoordinates;

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

	private final Instance caseInstance;
	private final CasePersister persister;
	
	private String id;
	private volatile CaseData currentCaseData;
	private List<Waiter> waiters = new ArrayList<Waiter>();
	private Map<String, Session> sessions = new HashMap<String, Session>();
	
	public Case(Instance caseInstance, String id, CasePersister persister) {
		this.caseInstance = caseInstance;
		this.currentCaseData=new CaseData(caseInstance, caseInstance.getMetadata().getCaseAdministration().getVersion());
		this.id = id;
		this.persister = persister;
	}

	public String getId() {
		return id;
	}

	public synchronized Promise<PageElement> waitForChange(int lastCaseVersion, Application application, PageCoordinates pageCoordinates, String sessionId, String userName) {
		LOG.info("waitForChange "+application.getName()+", last known case version: "+lastCaseVersion+" case version "+currentCaseData.getVersion()
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
		FlowContext context = new FlowContext(currentCaseData.getCaseInstance(), id);
		context.setFlowStack(application.createFlowStack(pageCoordinates, caseInstance));
		return renderPage(context, pageCoordinates.format());
	}
	
	private PageElement startFlow(Application application, PageCoordinates pageCoordinates, String sessionId, String userName) {
		FlowContext context = new FlowContext(currentCaseData.getCaseInstance(), id);
		Flow startFlow = getStartFlow(application, pageCoordinates);
		startFlow.enter(new FlowEventOccurrence(null, new Instance[0]), context);
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
		FlowEventOccurrence occurrence = page.submit(changeContext);
		flow(flowContext, occurrence);
		getOrCreateSession(sessionId, userName).setPageCoordinates(flowContext.getFlowStack().toPageCoordinates());
		newCaseDataVersion();
		informWaiters();
		this.caseInstance.afterSubmit();
	}

	public void newCaseDataVersion() {
		currentCaseData = new CaseData(caseInstance, currentCaseData.getVersion()+1);
		CasePersister.INSTANCE.persist(id, currentCaseData.getCaseInstance(), currentCaseData.getVersion());
	}
	
	private void flow(FlowContext flowContext, FlowEventOccurrence occurrence) {
		flowContext.logOccurrence(occurrence);
		while (occurrence!=null) {
			occurrence = flowContext.step(occurrence);
		}
	}

	public synchronized void informWaiters() {
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
