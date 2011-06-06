package app.designerbootstrap.data.instance;

import lbe.instance.Instance;
import lbe.instance.impl.SimpleCaseInstance;
import lbe.instance.value.RelationValue;
import lbe.instance.value.RelationValues;
import app.designerbootstrap.data.entity.ApplicationEntity;

public class ApplicationInstance extends SimpleCaseInstance implements Instance {

	public ApplicationInstance() {
		super(ApplicationEntity.INSTANCE);
	}
	
	public final RelationValues<ApplicationInstance, EntityInstance> entities
		= createRelationValues(ApplicationEntity.entities);

	public final RelationValue<ApplicationInstance, EntityInstance> caseEntity
		= createRelationValue(ApplicationEntity.caseEntity);


}
