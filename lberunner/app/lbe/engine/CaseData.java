package lbe.engine;

import org.instantlogic.fabric.CaseInstance;


/**
 * Contains all attributes that have a user-set value. Not thread-safe, synchronize on Case.
 */
public class CaseData {
	private final int version;
	
	private CaseInstance caseInstance;

	public CaseData(CaseInstance caseInstance, int version) {
		this.version = version;
		this.caseInstance = caseInstance;
	}

	public int getVersion() {
		return version;
	}

	public CaseInstance getCaseInstance() {
		return caseInstance;
	}
}
