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

public class FlowDesign 
	extends Design 
	implements Instance {

	public FlowDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public FlowDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, FlowDesignEntity.INSTANCE, id);
	}
	
	protected FlowDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValues<FlowDesign, FlowSourceDesign> sources
		= createRelationValues(FlowDesignEntity.sources);
		
	public List<FlowSourceDesign> getSources() {
		return sources.get();
	}
	
	public void setSources(List<FlowSourceDesign> newValue) {
		sources.set(newValue);
	}
	
	public final RelationValues<FlowDesign, FlowNodeBaseDesign> nodes
		= createRelationValues(FlowDesignEntity.nodes);
		
	public List<FlowNodeBaseDesign> getNodes() {
		return nodes.get();
	}
	
	public void setNodes(List<FlowNodeBaseDesign> newValue) {
		nodes.set(newValue);
	}
	
	public final RelationValues<FlowDesign, FlowEdgeDesign> edges
		= createRelationValues(FlowDesignEntity.edges);
		
	public List<FlowEdgeDesign> getEdges() {
		return edges.get();
	}
	
	public void setEdges(List<FlowEdgeDesign> newValue) {
		edges.set(newValue);
	}
	
	public final RelationValues<FlowDesign, EntityDesign> parameters
		= createRelationValues(FlowDesignEntity.parameters);
		
	public List<EntityDesign> getParameters() {
		return parameters.get();
	}
	
	public void setParameters(List<EntityDesign> newValue) {
		parameters.set(newValue);
	}

	// Reverse relations
	
	public final ReadOnlyRelationValue<FlowDesign, ApplicationDesign> application
		= createReverseRelationValue(FlowDesignEntity.application);

	public ApplicationDesign getApplication() {
		return application.get();
	}

	
	public final ReadOnlyRelationValue<FlowDesign, ApplicationDesign> exposedFlowInApplication
		= createReverseRelationValue(FlowDesignEntity.exposedFlowInApplication);

	public ApplicationDesign getExposedFlowInApplication() {
		return exposedFlowInApplication.get();
	}

	
	public final ReadOnlyRelationValue<FlowDesign, SubFlowDesign> subFlowIn
		= createReverseRelationValue(FlowDesignEntity.subFlowIn);

	public SubFlowDesign getSubFlowIn() {
		return subFlowIn.get();
	}


}
