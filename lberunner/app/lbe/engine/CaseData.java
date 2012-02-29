package lbe.engine;

import java.util.ArrayList;
import java.util.List;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.value.AttributeValue;
import lbe.instance.value.ReadOnlyAttributeValue;
import lbe.instance.value.impl.AttributeValueImpl;
import lbe.model.Attribute;
import lbe.model.Entity;

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
