package app.designer;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.value.RelationValue;

import app.designer.entity.SubFlowDesignEntity;

public class SubFlowDesign 
	extends FlowNodeBaseDesign 
	implements Instance {

	public SubFlowDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public SubFlowDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, SubFlowDesignEntity.INSTANCE, id);
	}
	
	protected SubFlowDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<SubFlowDesign, FlowDesign> flow
		= createRelationValue(SubFlowDesignEntity.flow);
		
	public FlowDesign getFlow() {
		return flow.get();
	}
	
	public void setFlow(FlowDesign newValue) {
		flow.set(newValue);
	}

	// Reverse relations

}
