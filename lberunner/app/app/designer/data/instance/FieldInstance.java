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

public class FieldInstance 
	extends PageElementBaseInstance 
	implements Instance {

	public FieldInstance(CaseInstance caseInstance) {
		super(caseInstance, FieldEntity.INSTANCE);
	}
	
	protected FieldInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	// Attributes
	
	public final AttributeValue<FieldInstance, java.lang.Boolean> required
		= createAttributeValue(FieldEntity.required);
	
	public final AttributeValue<FieldInstance, java.lang.Boolean> readOnly
		= createAttributeValue(FieldEntity.readOnly);
	
	// Relations
	
	public final RelationValue<FieldInstance, AttributeInstance> attribute
		= createRelationValue(FieldEntity.attribute);

	// Reverse relations

}
