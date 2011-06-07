package app.designerbootstrap.data.instance;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.impl.SimpleInstance;
import lbe.instance.value.RelationValue;
import lbe.instance.value.RelationValues;
import lbe.instance.value.impl.RelationValueImpl;
import lbe.instance.value.impl.RelationValuesImpl;
import lbe.model.Entity;
import app.designerbootstrap.data.entity.EntityEntity;

public class EntityInstance extends ConceptInstance {

	public EntityInstance(CaseInstance caseInstance) {
		super(caseInstance, EntityEntity.INSTANCE);
	}

	public final RelationValues<EntityInstance, AttributeInstance> attributes
		= createRelationValues(EntityEntity.attributes);
	
	public final RelationValues<EntityInstance, RelationInstance> relations
		= createRelationValues(EntityEntity.relations);

	public final RelationValue<EntityInstance, ApplicationInstance> application
		= createRelationValue(EntityEntity.application);

	public final RelationValue<EntityInstance, ApplicationInstance> caseEntityInApplication
		= createRelationValue(EntityEntity.caseEntityInApplication);

}
