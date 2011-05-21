package lbe;

/**
 * Contains all attributes that have a user-set value. Immutable.
 */
public class CaseData {
	private final int version;

	public CaseData(int version) {
		this.version = version;
	}

	public int getVersion() {
		return version;
	}

}
