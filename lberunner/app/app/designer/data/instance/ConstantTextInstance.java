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

public class ConstantTextInstance 
	extends TextInstance 
	implements Instance {

	public ConstantTextInstance(CaseInstance caseInstance) {
		super(caseInstance, ConstantTextEntity.INSTANCE);
	}
	
	protected ConstantTextInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	// Attributes
	
	public final AttributeValue<ConstantTextInstance, java.lang.String> untranslated
		= createAttributeValue(ConstantTextEntity.untranslated);
	
	// Relations

	// Reverse relations

}
