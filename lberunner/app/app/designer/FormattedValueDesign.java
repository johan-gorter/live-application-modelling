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

public class FormattedValueDesign 
	extends StringProducerDesign 
	implements Instance {

	public FormattedValueDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public FormattedValueDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, FormattedValueDesignEntity.INSTANCE, id);
	}
	
	protected FormattedValueDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<FormattedValueDesign, AttributeBase> value
		= createRelationValue(FormattedValueDesignEntity.value);
		
	public AttributeBase getValue() {
		return value.get();
	}
	
	public void setValue(AttributeBase newValue) {
		value.set(newValue);
	}

	// Reverse relations

}
