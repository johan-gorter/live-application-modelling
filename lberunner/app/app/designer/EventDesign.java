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
	extends Design 
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
		
	public List<EntityDesign> getParameters() {
		return parameters.get();
	}
	
	public void setParameters(List<EntityDesign> newValue) {
		parameters.set(newValue);
	}

	// Reverse relations
	
	public final ReadOnlyRelationValue<EventDesign, ApplicationDesign> application
		= createReverseRelationValue(EventDesignEntity.application);

	public ApplicationDesign getApplication() {
		return application.get();
	}

	
	public final ReadOnlyRelationValues<EventDesign, LinkDesign> firesFromButtons
		= createReverseRelationValues(EventDesignEntity.firesFromButtons);

	public List<LinkDesign> getFiresFromButtons() {
		return firesFromButtons.get();
	}

	
	public final ReadOnlyRelationValues<EventDesign, FlowSourceDesign> startEventInSources
		= createReverseRelationValues(EventDesignEntity.startEventInSources);

	public List<FlowSourceDesign> getStartEventInSources() {
		return startEventInSources.get();
	}

	
	public final ReadOnlyRelationValues<EventDesign, FlowSourceDesign> endEventInSources
		= createReverseRelationValues(EventDesignEntity.endEventInSources);

	public List<FlowSourceDesign> getEndEventInSources() {
		return endEventInSources.get();
	}

	
	public final ReadOnlyRelationValues<EventDesign, FlowEdgeDesign> startEventInEdges
		= createReverseRelationValues(EventDesignEntity.startEventInEdges);

	public List<FlowEdgeDesign> getStartEventInEdges() {
		return startEventInEdges.get();
	}

	
	public final ReadOnlyRelationValues<EventDesign, FlowEdgeDesign> endEventInEdges
		= createReverseRelationValues(EventDesignEntity.endEventInEdges);

	public List<FlowEdgeDesign> getEndEventInEdges() {
		return endEventInEdges.get();
	}


}
