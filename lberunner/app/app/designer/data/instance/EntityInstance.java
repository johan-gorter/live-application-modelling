package app.designer.data.instance;

import java.util.List;

import app.designer.*;
import app.designer.data.entity.*;
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
		this(caseInstance, 0);
	}
	
	public EntityInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, EntityEntity.INSTANCE, id);
	}
	
	protected EntityInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
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
	
	public final ReadOnlyRelationValue<EntityInstance, ApplicationInstance> application
		= createReverseRelationValue(EntityEntity.application);
	
	public final ReadOnlyRelationValue<EntityInstance, ApplicationInstance> caseEntityInApplication
		= createReverseRelationValue(EntityEntity.caseEntityInApplication);
	
	public final ReadOnlyRelationValues<EntityInstance, EntityInstance> extensions
		= createReverseRelationValues(EntityEntity.extensions);
	
	public final ReadOnlyRelationValues<EntityInstance, RelationInstance> reverseRelations
		= createReverseRelationValues(EntityEntity.reverseRelations);
	
	public final ReadOnlyRelationValues<EntityInstance, EventInstance> parameterInEvent
		= createReverseRelationValues(EntityEntity.parameterInEvent);
	
	public final ReadOnlyRelationValues<EntityInstance, FlowInstance> parameterInFlows
		= createReverseRelationValues(EntityEntity.parameterInFlows);

}
