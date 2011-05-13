package lbe;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import play.libs.F.Promise;

public class CaseManager {

	private ConcurrentHashMap<Long, Case> cases;
	private AtomicLong lastId = new AtomicLong(0);
	
	public Case create() {
		Case c = new Case(lastId.incrementAndGet());
		cases.put(c.getId(), c);
		return c;
	}
	
	public void changeCase(long caseId, Collection<Object> changes) {
		Case c = cases.get(caseId);
		c.change(changes);
	}
	
	public Promise<Case> waitForChange(long caseId) {
		Case c = cases.get(caseId);
		return c.waitForChange();
	}
}
