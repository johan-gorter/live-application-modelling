package app.designerbootstrap.data.instance;

import app.designerbootstrap.data.entity.AttributeEntity;
import app.designerbootstrap.data.entity.RelationEntity;
import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.impl.SimpleInstance;
import lbe.instance.value.AttributeValue;
import lbe.model.Entity;

public class AttributeInstance extends ConceptInstance {

	public AttributeInstance(CaseInstance caseInstance) {
		super(caseInstance, AttributeEntity.INSTANCE);
	}
	
	protected AttributeInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	public final AttributeValue<AttributeInstance, Boolean> multivalue
		= createAttributeValue(AttributeEntity.multivalue);

	
}
