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

public class ButtonInstance 
	extends PageFragmentInstance 
	implements Instance {

	public ButtonInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public ButtonInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, ButtonEntity.INSTANCE, id);
	}
	
	protected ButtonInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<ButtonInstance, java.lang.String> trigger
		= createAttributeValue(ButtonEntity.trigger);
	
	// Relations
	
	public final RelationValue<ButtonInstance, TextInstance> caption
		= createRelationValue(ButtonEntity.caption);

	// Reverse relations

}
