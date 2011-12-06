package app.designer;

import java.util.List;

import app.designer.*;
import app.designer.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class AttributeBase 
	extends Concept 
	implements Instance {

	public AttributeBase(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public AttributeBase(CaseInstance caseInstance, long id) {
		super(caseInstance, AttributeBaseEntity.INSTANCE, id);
	}
	
	protected AttributeBase(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<AttributeBase, java.lang.Boolean> readOnly
		= createAttributeValue(AttributeBaseEntity.readOnly);
	
	public java.lang.Boolean getReadOnly() {
		return readOnly.get();
	}

	public void setReadOnly(java.lang.Boolean newValue) {
		readOnly.set(newValue);
	}
	
	public final AttributeValue<AttributeBase, java.lang.Boolean> multivalue
		= createAttributeValue(AttributeBaseEntity.multivalue);
	
	public java.lang.Boolean getMultivalue() {
		return multivalue.get();
	}

	public void setMultivalue(java.lang.Boolean newValue) {
		multivalue.set(newValue);
	}
	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValue<AttributeBase, FormattedValueDesign> valueInTemplatedText
		= createReverseRelationValue(AttributeBaseEntity.valueInTemplatedText);

	public FormattedValueDesign getValueInTemplatedText() {
		return valueInTemplatedText.get();
	}


}
