package lbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.GsonBuilder;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.page.ChangeContext;
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

	public synchronized void submit(Session session, ChangeContext.FieldChange[] fieldChanges, String submit) {
		PageRenderer.submit(id, currentCaseData, session, fieldChanges, submit);
		try {
			persist();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		informWaiters();
	}
	
	private void persist() throws IOException {
//		File file = new File(id+".tmp");
//		FileOutputStream stream = new FileOutputStream(file);
//		file.renameTo(new File(id+".ser"));
	}

	public synchronized void informWaiters() {
		currentCaseData = new CaseData(caseInstance, currentCaseData.getVersion()+1);
		List<Waiter> promises = waiters;
		waiters = new ArrayList<Waiter>();
		for (Waiter waiter : promises) {
			waiter.promise.invoke(PageRenderer.renderPage(id, currentCaseData, waiter.session));
		}
	}
}
