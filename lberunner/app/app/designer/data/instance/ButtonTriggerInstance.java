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

public class ButtonTriggerInstance 
	extends PageElementBaseInstance 
	implements Instance {

	public ButtonTriggerInstance(CaseInstance caseInstance) {
		super(caseInstance, ButtonTriggerEntity.INSTANCE);
	}
	
	protected ButtonTriggerInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	// Attributes
	
	public final AttributeValue<ButtonTriggerInstance, java.lang.String> trigger
		= createAttributeValue(ButtonTriggerEntity.trigger);
	
	// Relations

	// Reverse relations

}
