package org.instantlogic.play;

import org.instantlogic.fabric.Instance;


/**
 * Contains all attributes that have a user-set value. Not thread-safe, synchronize on Case.
 */
public class CaseData {
	private final long version;
	
	private Instance caseInstance;

	public CaseData(Instance caseInstance, long version) {
		this.version = version;
		this.caseInstance = caseInstance;
	}

	public long getVersion() {
		return version;
	}

	public Instance getCaseInstance() {
		return caseInstance;
	}
}
