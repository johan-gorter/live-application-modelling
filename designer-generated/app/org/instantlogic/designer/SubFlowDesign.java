package org.instantlogic.designer;


public class SubFlowDesign extends FlowNodeBaseDesign { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.SubFlowDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<SubFlowDesign, FlowDesign> flow
		= createRelationValue(org.instantlogic.designer.entity.SubFlowDesignEntity.flow);
		
	public org.instantlogic.fabric.value.RelationValue<SubFlowDesign, FlowDesign> getFlowRelationValue() {
		return flow;
	}

	public org.instantlogic.designer.FlowDesign getFlow() {
		return flow.getValue();
	}
	
	public SubFlowDesign setFlow(org.instantlogic.designer.FlowDesign newValue) {
		flow.setValue(newValue);
		return (SubFlowDesign)this;
	}


	// Reverse relations

}
