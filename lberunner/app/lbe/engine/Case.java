package lbe.engine;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import controllers.StartFlow;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import play.Play;
import play.libs.F.Promise;

public class Case {
	
	private static final Logger LOG = Logger.getLogger(Case.class);

	private static class Waiter {
		Promise<PageElement> promise;
		Session session;

		public Waiter(Promise<PageElement> promise, Session session) {
			this.promise = promise;
			this.session = session;
		}
	}

	private final Instance caseInstance;
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

	public synchronized Promise<PageElement> waitForChange(int lastCaseVersion, Session session) {
		LOG.info("waitForChange, last known case version: "+lastCaseVersion+" case version "+currentCaseData.getVersion()
					+" model version "+Play.classloader.currentState.hashCode());
		CaseManager.incrementChangeWaiters();
		Promise<PageElement> promise = new Promise<PageElement>();
		if (currentCaseData.getVersion()>lastCaseVersion) {
			LOG.info("Sending page (not waiting for change)");
			promise.invoke(render(session));
			return promise;
		}
		LOG.info("Waiting for change");
		waiters.add(new Waiter(promise, session));
		return promise;
	}
	
	public synchronized void cancelWaitForChange(Promise<CaseData> promise) {
		waiters.remove(promise);
		CaseManager.decrementChangeWaiters();
	}

	public synchronized PageElement render(Session session) {
		return PageRenderer.renderPage(id, currentCaseData, session);
	}

	public synchronized void submit(Session session, ChangeContext.FieldChange[] fieldChanges, String submit) {
		PageRenderer.submit(id, currentCaseData, session, fieldChanges, submit);
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
			waiter.promise.invoke(PageRenderer.renderPage(id, currentCaseData, waiter.session));
		}
	}
}
