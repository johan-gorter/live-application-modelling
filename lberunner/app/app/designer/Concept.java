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

public class Concept 
	extends SimpleInstance 
	implements Instance {

	public Concept(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public Concept(CaseInstance caseInstance, long id) {
		super(caseInstance, ConceptEntity.INSTANCE, id);
	}
	
	protected Concept(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<Concept, java.lang.String> name
		= createAttributeValue(ConceptEntity.name);
	
	public java.lang.String getName() {
		return name.get();
	}

	public void setName(java.lang.String newValue) {
		name.set(newValue);
	}
	
	public final ReadOnlyAttributeValue<Concept, java.lang.Boolean> valid
		= createReadOnlyAttributeValue(ConceptEntity.valid);
	
	public java.lang.Boolean getValid() {
		return valid.get();
	}

	
	public final AttributeValue<Concept, java.lang.String> customization
		= createAttributeValue(ConceptEntity.customization);
	
	public java.lang.String getCustomization() {
		return customization.get();
	}

	public void setCustomization(java.lang.String newValue) {
		customization.set(newValue);
	}
	
	// Relations

	// Reverse relations

}
