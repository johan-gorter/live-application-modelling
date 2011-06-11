package app.designerbootstrap.data.instance;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.impl.SimpleInstance;
import lbe.instance.value.ReadOnlyRelationValue;
import lbe.instance.value.ReadOnlyRelationValues;
import lbe.instance.value.RelationValue;
import lbe.instance.value.RelationValues;
import lbe.instance.value.impl.RelationValueImpl;
import lbe.instance.value.impl.RelationValuesImpl;
import lbe.model.Entity;
import app.designerbootstrap.data.entity.ConceptEntity;
import app.designerbootstrap.data.entity.EntityEntity;

public class EntityInstance extends ConceptInstance {

	public EntityInstance(CaseInstance caseInstance) {
		super(caseInstance, EntityEntity.INSTANCE);
	}
	
	public final RelationValue<EntityInstance, EntityInstance> extendsFrom
		= createRelationValue(EntityEntity.extendsFrom);

	public final RelationValues<EntityInstance, AttributeInstance> attributes
		= createRelationValues(EntityEntity.attributes);
	
	public final RelationValues<EntityInstance, RelationInstance> relations
		= createRelationValues(EntityEntity.relations);

	public final ReadOnlyRelationValue<EntityInstance, ApplicationInstance> application
		= createReverseRelationValue(EntityEntity.application);

	public final ReadOnlyRelationValues<EntityInstance, RelationInstance> reverseRelations
		= createReverseRelationValues(EntityEntity.reverseRelations);

	public final ReadOnlyRelationValues<EntityInstance, EntityInstance> extensions
		= createReverseRelationValues(EntityEntity.extensions);

	public final ReadOnlyRelationValue<EntityInstance, ApplicationInstance> caseEntityInApplication
		= createReverseRelationValue(EntityEntity.caseEntityInApplication);

}
