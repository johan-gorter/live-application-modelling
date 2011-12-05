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

public class ConstantStringDesign 
	extends StringProducerDesign 
	implements Instance {

	public ConstantStringDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public ConstantStringDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, ConstantStringDesignEntity.INSTANCE, id);
	}
	
	protected ConstantStringDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<ConstantStringDesign, java.lang.String> constant
		= createAttributeValue(ConstantStringDesignEntity.constant);
	
	public java.lang.String getConstant() {
		return constant.get();
	}

	
	// Relations

	// Reverse relations

}
