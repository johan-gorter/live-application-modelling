package app.designerbootstrap.data.instance;

import app.designerbootstrap.data.entity.AttributeEntity;
import app.designerbootstrap.data.entity.ConceptEntity;
import app.designerbootstrap.data.entity.RelationEntity;
import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.impl.SimpleInstance;
import lbe.instance.value.AttributeValue;
import lbe.instance.value.ReadOnlyRelationValue;
import lbe.instance.value.RelationValue;
import lbe.model.Entity;

public class AttributeInstance extends ConceptInstance {

	public AttributeInstance(CaseInstance caseInstance) {
		super(caseInstance, AttributeEntity.INSTANCE);
	}
	
	protected AttributeInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	public final ReadOnlyRelationValue<AttributeInstance, EntityInstance> entity
		= createReverseRelationValue(AttributeEntity.entity);
	
	public final AttributeValue<AttributeInstance, String> className 
		= createAttributeValue(AttributeEntity.className);

	public final AttributeValue<AttributeInstance, Boolean> multivalue
		= createAttributeValue(AttributeEntity.multivalue);
	
}
