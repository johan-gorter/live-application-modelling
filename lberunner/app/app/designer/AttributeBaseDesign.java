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

public class AttributeBaseDesign 
	extends Design 
	implements Instance {

	public AttributeBaseDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public AttributeBaseDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, AttributeBaseDesignEntity.INSTANCE, id);
	}
	
	protected AttributeBaseDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<AttributeBaseDesign, java.lang.Boolean> readOnly
		= createAttributeValue(AttributeBaseDesignEntity.readOnly);
	
	public java.lang.Boolean getReadOnly() {
		return readOnly.get();
	}

	public void setReadOnly(java.lang.Boolean newValue) {
		readOnly.set(newValue);
	}
	
	public final AttributeValue<AttributeBaseDesign, java.lang.Boolean> multivalue
		= createAttributeValue(AttributeBaseDesignEntity.multivalue);
	
	public java.lang.Boolean getMultivalue() {
		return multivalue.get();
	}

	public void setMultivalue(java.lang.Boolean newValue) {
		multivalue.set(newValue);
	}
	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValue<AttributeBaseDesign, FormattedValueDesign> valueInTemplatedText
		= createReverseRelationValue(AttributeBaseDesignEntity.valueInTemplatedText);

	public FormattedValueDesign getValueInTemplatedText() {
		return valueInTemplatedText.get();
	}


}
