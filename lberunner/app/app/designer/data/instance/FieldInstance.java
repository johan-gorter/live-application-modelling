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

public class FieldInstance 
	extends PageFragmentInstance 
	implements Instance {

	public FieldInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public FieldInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, FieldEntity.INSTANCE, id);
	}
	
	protected FieldInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<FieldInstance, java.lang.Boolean> required
		= createAttributeValue(FieldEntity.required);
	
	public java.lang.Boolean getRequired() {
		return required.get();
	}

	
	public final AttributeValue<FieldInstance, java.lang.Boolean> readOnly
		= createAttributeValue(FieldEntity.readOnly);
	
	public java.lang.Boolean getReadOnly() {
		return readOnly.get();
	}

	
	// Relations
	
	public final RelationValue<FieldInstance, AttributeInstance> attribute
		= createRelationValue(FieldEntity.attribute);

	// Reverse relations

}
