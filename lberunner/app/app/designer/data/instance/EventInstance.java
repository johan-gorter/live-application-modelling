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

public class EventInstance 
	extends ConceptInstance 
	implements Instance {

	public EventInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public EventInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, EventEntity.INSTANCE, id);
	}
	
	protected EventInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValues<EventInstance, EntityInstance> parameters
		= createRelationValues(EventEntity.parameters);

	// Reverse relations
	
	public final ReadOnlyRelationValue<EventInstance, ApplicationInstance> application
		= createReverseRelationValue(EventEntity.application);
	
	public final ReadOnlyRelationValues<EventInstance, ButtonInstance> firesFromButtons
		= createReverseRelationValues(EventEntity.firesFromButtons);
	
	public final ReadOnlyRelationValues<EventInstance, FlowSourceInstance> startEventInSources
		= createReverseRelationValues(EventEntity.startEventInSources);
	
	public final ReadOnlyRelationValues<EventInstance, FlowSourceInstance> endEventInSources
		= createReverseRelationValues(EventEntity.endEventInSources);
	
	public final ReadOnlyRelationValues<EventInstance, FlowEdgeInstance> startEventInEdges
		= createReverseRelationValues(EventEntity.startEventInEdges);
	
	public final ReadOnlyRelationValues<EventInstance, FlowEdgeInstance> endEventInEdges
		= createReverseRelationValues(EventEntity.endEventInEdges);

}
