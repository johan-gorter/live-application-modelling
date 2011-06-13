package app.designerbootstrap.data.instance;

import java.util.List;

import app.designerbootstrap.data.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class EntityInstance 
	extends ConceptInstance 
	implements Instance {

	public EntityInstance(CaseInstance caseInstance) {
		super(caseInstance, EntityEntity.INSTANCE);
	}
	
	protected EntityInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<EntityInstance, EntityInstance> extendsFrom
		= createRelationValue(EntityEntity.extendsFrom);
	
	public final RelationValues<EntityInstance, AttributeInstance> attributes
		= createRelationValues(EntityEntity.attributes);
	
	public final RelationValues<EntityInstance, RelationInstance> relations
		= createRelationValues(EntityEntity.relations);

	// Reverse relations
	
	public final ReadOnlyRelationValues<EntityInstance, EntityInstance> extensions
		= createReverseRelationValues(EntityEntity.extensions);
	
	public final ReadOnlyRelationValue<EntityInstance, ApplicationInstance> application
		= createReverseRelationValue(EntityEntity.application);
	
	public final ReadOnlyRelationValue<EntityInstance, ApplicationInstance> caseEntityInApplication
		= createReverseRelationValue(EntityEntity.caseEntityInApplication);
	
	public final ReadOnlyRelationValues<EntityInstance, RelationInstance> reverseRelations
		= createReverseRelationValues(EntityEntity.reverseRelations);

}
