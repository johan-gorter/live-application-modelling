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

public class ButtonInstance 
	extends PageElementBaseInstance 
	implements Instance {

	public ButtonInstance(CaseInstance caseInstance) {
		super(caseInstance, ButtonEntity.INSTANCE);
	}
	
	protected ButtonInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	// Attributes
	
	public final AttributeValue<ButtonInstance, java.lang.String> trigger
		= createAttributeValue(ButtonEntity.trigger);
	
	// Relations
	
	public final RelationValue<ButtonInstance, TextInstance> caption
		= createRelationValue(ButtonEntity.caption);

	// Reverse relations

}