package lbe.engine;

import java.util.ArrayList;
import java.util.List;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.model.Entity;
import lbe.model.flow.Flow;
import lbe.model.flow.FlowNodeBase;
import lbe.model.flow.Page;

public class FlowContext {

	private final CaseData caseData;
	private final String caseId;
	private FlowStack flowStack;

	public FlowContext(CaseData caseData, String caseId) {
		this.caseData = caseData;
		this.caseId = caseId;
	}
	
	public Page getPage() {
		return (Page) flowStack.getCurrentNode();
	}

	public CaseData getCaseData() {
		return caseData;
	}

	public String getCaseId() {
		return caseId;
	}

	public Instance getActiveInstance(Entity entity) {
		if (entity == caseData.getCaseInstance().getModel()) {
			return caseData.getCaseInstance();
		}
		Instance result = flowStack.getActiveInstance(entity);
		if (result!=null) {
			return result;
		}
		throw new RuntimeException("No active instance of entity "+entity.getName());
	}

	public String step(String trigger) {
		return flowStack.getFlow().step(flowStack.getCurrentNode(), trigger, this);
	}

	public FlowStack getFlowStack() {
		return flowStack;
	}

	public void setFlowStack(FlowStack flowStack) {
		this.flowStack = flowStack;
	}

	public void popFlowContext() {
		flowStack = flowStack.getParent();
		if (flowStack==null) {
			throw new RuntimeException("End of startflow reached");
		}
	}
}
