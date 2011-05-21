package lbe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lbe.page.Page;
import lbe.page.PageRenderer;
import play.libs.F.Promise;

public class Case {
	
	private static class Waiter {
		Promise<Page> promise;
		Session session;

		public Waiter(Promise<Page> promise, Session session) {
			this.promise = promise;
			this.session = session;
		}
		
		
	}
	
	private String id;
	private CaseData currentCaseData=new CaseData(0);
	private List<Waiter> waiters = new ArrayList<Waiter>();
	
	public String getId() {
		return id;
	}

	public Case(String id) {
		this.id = id;
	}

	public synchronized void change(Collection<Object> changes) {
		//TODO make change
		currentCaseData = new CaseData(currentCaseData.getVersion()+1);
		List<Waiter> promises = waiters;
		waiters = new ArrayList<Waiter>();
		for (Waiter waiter : promises) {
			waiter.promise.invoke(PageRenderer.renderPage(id, currentCaseData, waiter.session));
		}
	}

	public synchronized Promise<Page> waitForChange(int lastCaseVersion, Session session) {
		CaseManager.incrementChangeWaiters();
		Promise<Page> promise = new Promise<Page>();
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

	public synchronized Page render(Session session) {
		return PageRenderer.renderPage(id, currentCaseData, session);
	}
}
