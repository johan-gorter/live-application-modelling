package app.designer.data.instance;

import java.util.List;

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
		super(caseInstance, AttributeBaseEntity.INSTANCE);
	}
	
	protected AttributeBaseInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	// Attributes
	
	public final AttributeValue<AttributeBaseInstance, java.lang.Boolean> readOnly
		= createAttributeValue(AttributeBaseEntity.readOnly);
	
	public final AttributeValue<AttributeBaseInstance, java.lang.Boolean> multivalue
		= createAttributeValue(AttributeBaseEntity.multivalue);
	
	// Relations

	// Reverse relations

}
