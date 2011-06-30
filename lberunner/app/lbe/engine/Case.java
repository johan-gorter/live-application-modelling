package lbe.engine;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import controllers.StartFlow;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.model.Application;
import lbe.model.flow.Flow;
import lbe.model.flow.FlowSource;
import lbe.model.flow.Page;
import play.Play;
import play.libs.F.Promise;

public class Case {
	
	private static final Logger LOG = Logger.getLogger(Case.class);

	private static class Waiter {
		Promise<PageElement> promise;
		Application application;
		PageCoordinates pageCoordinates;

		public Waiter(Promise<PageElement> promise, Application application, PageCoordinates pageCoordinates) {
			this.promise = promise;
			this.application = application;
			this.pageCoordinates = pageCoordinates;
		}
	}

	private final CaseInstance caseInstance;
	private final CasePersister persister;
	private String id;
	private volatile CaseData currentCaseData;
	private List<Waiter> waiters = new ArrayList<Waiter>();
	
	public Case(CaseInstance caseInstance, String id, CasePersister persister) {
		this.caseInstance = caseInstance;
		this.currentCaseData=new CaseData(caseInstance, caseInstance.getVersion());
		this.id = id;
		this.persister = persister;
	}

	public String getId() {
		return id;
	}

	public synchronized Promise<PageElement> waitForChange(int lastCaseVersion, Application application, PageCoordinates pageCoordinates) {
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
		waiters.add(new Waiter(promise, application, pageCoordinates));
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
		context.setPageCoordinates(pageCoordinates);
		application.jumpToPage(context);
		return PageRenderer.renderPage(context);
	}

	public synchronized void cancelWaitForChange(Promise<CaseData> promise) {
		waiters.remove(promise);
		CaseManager.decrementChangeWaiters();
	}
	
	public synchronized PageElement jumpToPage(Application application, PageCoordinates pageCoordinates) {
		FlowContext flowContext = new FlowContext(currentCaseData, id);
		flowContext.setPageCoordinates(pageCoordinates);
		application.jumpToPage(flowContext);
		
		if (!flowContext.isReady()) {
			throw new RuntimeException("Flowing did not result in a page");
		}
		return PageRenderer.renderPage(flowContext);
	}

	public synchronized void submit(Application application, PageCoordinates pageCoordinates, ChangeContext.FieldChange[] fieldChanges, String submit) {
		FlowContext flowContext = new FlowContext(currentCaseData, id);
		flowContext.setPageCoordinates(pageCoordinates);
		application.jumpToPage(flowContext);
		Page page = flowContext.getPage();
		PageRenderer.submit(flowContext, fieldChanges, submit);
		if (flowContext.getTrigger()!=null) {
			flowContext.flow();
		}
		informWaiters();
	}
	
	public synchronized void informWaiters() {
		currentCaseData = new CaseData(caseInstance, currentCaseData.getVersion()+1);
		CasePersister.INSTANCE.persist(id, currentCaseData.getCaseInstance(), currentCaseData.getVersion());
		LOG.info("New case version: "+currentCaseData.getVersion());
		List<Waiter> promises = waiters;
		waiters = new ArrayList<Waiter>();
		LOG.info("informing "+ promises.size() +"waiters");
		for (Waiter waiter : promises) {
			waiter.promise.invoke(render(waiter.application, waiter.pageCoordinates));
		}
	}
}
