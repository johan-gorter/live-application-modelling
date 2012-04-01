package org.instantlogic.play;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;
import org.instantlogic.fabric.Instance;

import play.Play;
import play.Play.Mode;
import play.classloading.ApplicationClassloaderState;

public class CaseManager {

	private static final Logger LOG = Logger.getLogger(CaseManager.class);

	private static int changeWaiters = 0;
	private static ConcurrentHashMap<String, Case> cases = new ConcurrentHashMap<String, Case>();
	private static AtomicLong lastId = new AtomicLong(0);

	private static ApplicationClassloaderState modelState;
	private static boolean disabled = false;

	private static Thread modelChangePollThread;
	
	private CaseManager() {}
	
	static {
		if (Play.mode==Mode.DEV) {
			modelState = Play.classloader.currentState;
		}
	}
	
	public static void fireChangesIfModelChanged() {
		if (Play.mode==Mode.DEV && !disabled) {
			synchronized(Play.class)
			{
				try {
					Play.detectChanges();
				} catch (Exception e) {
					LOG.warn("Could not succesfully detect source changes", e);
					return;
				}
				if (modelState != Play.classloader.currentState) {
					modelState = Play.classloader.currentState;
					if (LOG.isInfoEnabled()) {
						LOG.info("Model changes detected, state "+modelState);
					}
					disabled =true;
					for (Case c: cases.values()) {
						c.newCaseDataVersion();
						c.informWaiters();// Sends the page using the old model
						c.newCaseDataVersion();// Makes the browser reload immediately and fetch the page using the new model
						c.informWaiters();// Sends the page using the new model
					}
				} else {
					if (LOG.isDebugEnabled()) {
						LOG.debug("No model changes detected");
					}
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
	
	public static Case create(Instance caseInstance) {
		String id = CasePersister.uniqueId();
		Case c = new Case(caseInstance, id, CasePersister.INSTANCE);
		caseInstance.afterLoading();
		CasePersister.INSTANCE.persist(id, caseInstance, 0);
		cases.put(c.getId(), c);
		return c;
	}
	
	public static <T extends Instance> Case getCase(String caseId, Class<T> ofCaseInstanceType) {
		Case result = cases.get(caseId);
		if (result==null) {
			T caseInstance = CasePersister.INSTANCE.load(caseId, ofCaseInstanceType);
			if (caseInstance==null) {
				throw new RuntimeException("Case not found, id: "+caseId);
			}
			result = new Case(caseInstance, caseId, CasePersister.INSTANCE);
			caseInstance.afterLoading();
			cases.put(caseId, result);
		}
		return result;
	}
}
