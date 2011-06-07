package app.designerbootstrap.data.instance;

import lbe.instance.CaseInstance;
import lbe.instance.impl.SimpleInstance;
import lbe.instance.value.AttributeValue;
import lbe.instance.value.RelationValue;
import lbe.instance.value.RelationValues;
import lbe.model.Entity;
import app.designerbootstrap.data.entity.ConceptEntity;

public class ConceptInstance extends SimpleInstance {

	public ConceptInstance(CaseInstance caseInstance) {
		this(caseInstance, ConceptEntity.INSTANCE);
	}
	
	protected ConceptInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}
	
	public final RelationValue<ConceptInstance, ConceptInstance> extendsFrom
		= createRelationValue(ConceptEntity.extendsFrom);

	public final RelationValues<ConceptInstance, ConceptInstance> extensions
		= createRelationValues(ConceptEntity.extensions);

	public final AttributeValue<ConceptInstance, String> name 
		= createAttributeValue(ConceptEntity.name);

}
