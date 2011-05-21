package lbe;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import lbe.page.Page;

import org.apache.log4j.Logger;

import play.Play;
import play.Play.Mode;
import play.classloading.ApplicationClassloaderState;
import play.libs.F.Promise;

public class CaseManager {

	private static final Logger LOG = Logger.getLogger(CaseManager.class);

	private static int changeWaiters = 0;
	private static ConcurrentHashMap<String, Case> cases = new ConcurrentHashMap<String, Case>();
	private static AtomicLong lastId = new AtomicLong(0);

	private static ApplicationClassloaderState modelState;

	private static Thread modelChangePollThread;
	
	private CaseManager() {}
	
	static {
		if (Play.mode==Mode.DEV) {
			modelState = Play.classloader.currentState;
		}
	}
	
	public static void fireChangesIfModelChanged() {
		if (Play.mode==Mode.DEV) {
			Play.detectChanges();
			if (modelState != Play.classloader.currentState) {
				modelState = Play.classloader.currentState;
				if (LOG.isInfoEnabled()) {
					LOG.info("Model changes detected");
				}
				for (Case c: cases.values()) {
					c.change(Collections.<Object>singleton("reloadModel"));
				}
			} else {
				if (LOG.isDebugEnabled()) {
					LOG.debug("No model changes detected");
				}
			}
		}
	}
	
	private static Runnable modelChangePoller = new Runnable() {
		
		@Override
		public void run() {
			if (LOG.isInfoEnabled()) {
				LOG.info("Model change polling started");
			}
			try {
				while (modelChangePollThread!=null) {
					Thread.sleep(500);
					if (changeWaiters>0) {
						fireChangesIfModelChanged();
					} else {
						modelChangePollThread=null;
					}
					// TODO: synchronize here
				}
			} catch (InterruptedException e) {
			}
			modelChangePollThread=null;
			if (LOG.isInfoEnabled()) {
				LOG.info("Model change polling stopped");
			}
		}
	};
	
	static void incrementChangeWaiters() {
		if (Play.mode==Mode.DEV) {
			synchronized (CaseManager.class) {
				changeWaiters++;
				if (modelChangePollThread==null) {
					modelChangePollThread = new Thread(modelChangePoller, "modelChangePoller");
					modelChangePollThread.start();
				}
			}
		}
	}
	
	static void decrementChangeWaiters() {
		if (Play.mode==Mode.DEV) {
			changeWaiters--;
		}
	}
	
	public static Case create() {
		long id = lastId.incrementAndGet();
		Case c = new Case(""+id);
		cases.put(c.getId(), c);
		return c;
	}
	
	public static void changeCase(long caseId, Collection<Object> changes) {
		Case c = cases.get(caseId);
		c.change(changes);
	}
	
	public static Promise<Page> waitForChange(Session session, int lastCaseVersion) {
		Case c = cases.get(session.getCaseId());
		return c.waitForChange(lastCaseVersion, session);
	}

	public static Case getCase(String caseId) {
		Case result = cases.get(caseId);
		if (result==null) {
			throw new RuntimeException("Case not found, id: "+caseId);
		}
		return result;
	}
}
