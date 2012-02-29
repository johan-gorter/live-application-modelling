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

public class AttributeDeductionDesign 
	extends DeductionDesign 
	implements Instance {

	public AttributeDeductionDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public AttributeDeductionDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, AttributeDeductionDesignEntity.INSTANCE, id);
	}
	
	protected AttributeDeductionDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<AttributeDeductionDesign, AttributeDesign> attribute
		= createRelationValue(AttributeDeductionDesignEntity.attribute);
		
	public AttributeDesign getAttribute() {
		return attribute.get();
	}
	
	public void setAttribute(AttributeDesign newValue) {
		attribute.set(newValue);
	}

	// Reverse relations

}
