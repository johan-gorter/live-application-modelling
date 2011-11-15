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

public class ConstantTextInstance 
	extends TextInstance 
	implements Instance {

	public ConstantTextInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public ConstantTextInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, ConstantTextEntity.INSTANCE, id);
	}
	
	protected ConstantTextInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<ConstantTextInstance, java.lang.String> untranslated
		= createAttributeValue(ConstantTextEntity.untranslated);
	
	public java.lang.String getUntranslated() {
		return untranslated.get();
	}

	
	// Relations

	// Reverse relations

}
