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

public class ConceptInstance 
	extends SimpleInstance 
	implements Instance {

	public ConceptInstance(CaseInstance caseInstance) {
		super(caseInstance, ConceptEntity.INSTANCE, 0);
	}
	
	protected ConceptInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model, 0);
	}

	// Attributes
	
	public final AttributeValue<ConceptInstance, java.lang.String> name
		= createAttributeValue(ConceptEntity.name);
	
	// Relations

	// Reverse relations

}
