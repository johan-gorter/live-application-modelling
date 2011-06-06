package app.designerbootstrap.data.instance;

import app.carinsurance.entity.DriverEntity;
import app.carinsurance.entity.DriverInstance;
import app.designerbootstrap.data.entity.ConceptEntity;
import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.impl.SimpleInstance;
import lbe.instance.value.AttributeValue;
import lbe.instance.value.impl.AttributeValueImpl;
import lbe.model.Attribute;
import lbe.model.Entity;

public class ConceptInstance extends SimpleInstance {

	public ConceptInstance(CaseInstance caseInstance) {
		this(caseInstance, ConceptEntity.INSTANCE);
	}
	
	protected ConceptInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	public final AttributeValue<ConceptInstance, String> name 
		= createAttributeValue(ConceptEntity.name);

}
