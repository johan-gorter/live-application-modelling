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

public class ConceptInstance 
	extends SimpleInstance 
	implements Instance {

	public ConceptInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public ConceptInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, ConceptEntity.INSTANCE, id);
	}
	
	protected ConceptInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<ConceptInstance, java.lang.String> name
		= createAttributeValue(ConceptEntity.name);
	
	public java.lang.String getName() {
		return name.get();
	}

	
	public final AttributeValue<ConceptInstance, java.lang.String> customization
		= createAttributeValue(ConceptEntity.customization);
	
	public java.lang.String getCustomization() {
		return customization.get();
	}

	
	// Relations

	// Reverse relations

}
