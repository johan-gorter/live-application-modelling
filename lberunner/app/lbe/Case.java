package lbe;

import java.util.Collection;

import play.libs.F.Promise;

public class Case {
	
	private long id;
	private Promise<Case> nextChangePromise = new Promise<Case>();
	
	public long getId() {
		return id;
	}

	public Case(long id) {
		this.id = id;
	}

	public synchronized void change(Collection<Object> changes) {
		Promise<Case> promise = nextChangePromise;
		nextChangePromise = new Promise<Case>();
		promise.invoke(this);
	}

	public synchronized Promise<Case> waitForChange() {
		// TODO: await?
		return nextChangePromise;
	}
}
