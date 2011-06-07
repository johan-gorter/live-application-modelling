package app.designerbootstrap.data.instance;

import app.designerbootstrap.data.entity.RelationEntity;
import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.impl.SimpleInstance;
import lbe.instance.value.AttributeValue;
import lbe.instance.value.RelationValue;
import lbe.model.Entity;

public class RelationInstance extends AttributeInstance {

	public final RelationValue<RelationInstance, EntityInstance> to
		= createRelationValue(RelationEntity.to);

	public final AttributeValue<RelationInstance, Boolean> owner
		= createAttributeValue(RelationEntity.owner);

	public RelationInstance(CaseInstance caseInstance) {
		super(caseInstance, RelationEntity.INSTANCE);
	}

}
