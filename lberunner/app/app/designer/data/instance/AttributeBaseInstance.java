package app.designer.data.instance;

import java.util.List;

import app.designer.*;
import app.designer.data.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class AttributeBaseInstance 
	extends ConceptInstance 
	implements Instance {

	public AttributeBaseInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public AttributeBaseInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, AttributeBaseEntity.INSTANCE, id);
	}
	
	protected AttributeBaseInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<AttributeBaseInstance, java.lang.Boolean> readOnly
		= createAttributeValue(AttributeBaseEntity.readOnly);
	
	public java.lang.Boolean getReadOnly() {
		return readOnly.get();
	}

	
	public final AttributeValue<AttributeBaseInstance, java.lang.Boolean> multivalue
		= createAttributeValue(AttributeBaseEntity.multivalue);
	
	public java.lang.Boolean getMultivalue() {
		return multivalue.get();
	}

	
	// Relations

	// Reverse relations

}
