package app.designerbootstrap.data.instance;

import app.designerbootstrap.data.entity.AttributeEntity;
import app.designerbootstrap.data.entity.RelationEntity;
import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.impl.SimpleInstance;
import lbe.instance.value.AttributeValue;
import lbe.instance.value.ReadOnlyRelationValue;
import lbe.instance.value.RelationValue;
import lbe.model.Entity;

public class RelationInstance extends AttributeInstance {

	public final ReadOnlyRelationValue<RelationInstance, EntityInstance> entity
		= createReverseRelationValue(RelationEntity.entity);
	
	public final RelationValue<RelationInstance, EntityInstance> to
		= createRelationValue(RelationEntity.to);

	public final AttributeValue<RelationInstance, Boolean> owner
		= createAttributeValue(RelationEntity.owner);

	public final AttributeValue<RelationInstance, String> reverseName
		= createAttributeValue(RelationEntity.reverseName);

	public final AttributeValue<RelationInstance, Boolean> reverseMultivalue
		= createAttributeValue(RelationEntity.reverseMultivalue);


	public RelationInstance(CaseInstance caseInstance) {
		super(caseInstance, RelationEntity.INSTANCE);
	}

}
