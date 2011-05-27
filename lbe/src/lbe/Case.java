package lbe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lbe.instance.Instance;
import lbe.page.PageElement;
import lbe.page.PageRenderer;
import play.libs.F.Promise;

public class Case {
	
	private static class Waiter {
		Promise<PageElement> promise;
		Session session;

		public Waiter(Promise<PageElement> promise, Session session) {
			this.promise = promise;
			this.session = session;
		}
	}

	private final Instance caseInstance;
	
	public Case(Instance caseInstance, String id) {
		this.caseInstance = caseInstance;
		this.currentCaseData=new CaseData(caseInstance, 0);
		this.id = id;
	}

	private String id;
	private CaseData currentCaseData;
	private List<Waiter> waiters = new ArrayList<Waiter>();
	
	public String getId() {
		return id;
	}

	public synchronized void change(Collection<Object> changes) {
		//TODO make change
		currentCaseData = new CaseData(caseInstance, currentCaseData.getVersion()+1);
		List<Waiter> promises = waiters;
		waiters = new ArrayList<Waiter>();
		for (Waiter waiter : promises) {
			waiter.promise.invoke(PageRenderer.renderPage(id, currentCaseData, waiter.session));
		}
	}

	public synchronized Promise<PageElement> waitForChange(int lastCaseVersion, Session session) {
		CaseManager.incrementChangeWaiters();
		Promise<PageElement> promise = new Promise<PageElement>();
		if (currentCaseData.getVersion()>lastCaseVersion) {
			promise.invoke(render(session));
			return promise;
		}
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

	public synchronized void changeValue(Session session, String pageElementId, Object value) {
		PageRenderer.changeValue(id, currentCaseData, session, pageElementId, value);
		
	}
}
