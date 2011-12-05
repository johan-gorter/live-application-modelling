package app.designer;

import java.util.List;

import app.designer.*;
import app.designer.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class EventDesign 
	extends Concept 
	implements Instance {

	public EventDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public EventDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, EventDesignEntity.INSTANCE, id);
	}
	
	protected EventDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValues<EventDesign, EntityDesign> parameters
		= createRelationValues(EventDesignEntity.parameters);

	// Reverse relations
	
	public final ReadOnlyRelationValue<EventDesign, ApplicationDesign> application
		= createReverseRelationValue(EventDesignEntity.application);
	
	public final ReadOnlyRelationValues<EventDesign, LinkDesign> firesFromButtons
		= createReverseRelationValues(EventDesignEntity.firesFromButtons);
	
	public final ReadOnlyRelationValues<EventDesign, FlowSourceDesign> startEventInSources
		= createReverseRelationValues(EventDesignEntity.startEventInSources);
	
	public final ReadOnlyRelationValues<EventDesign, FlowSourceDesign> endEventInSources
		= createReverseRelationValues(EventDesignEntity.endEventInSources);
	
	public final ReadOnlyRelationValues<EventDesign, FlowEdgeDesign> startEventInEdges
		= createReverseRelationValues(EventDesignEntity.startEventInEdges);
	
	public final ReadOnlyRelationValues<EventDesign, FlowEdgeDesign> endEventInEdges
		= createReverseRelationValues(EventDesignEntity.endEventInEdges);

}
