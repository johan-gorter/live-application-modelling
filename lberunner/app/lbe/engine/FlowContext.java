package lbe.engine;

import java.util.List;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.Page;


public class FlowContext extends DeductionContext {

	private final CaseData caseData;
	private final String caseId;
	private FlowStack flowStack;
	
	// For debugging purposes
	private FlowNodeBase lastNode;
	private FlowEventOccurrence lastOccurrence;

	public FlowContext(CaseData caseData, String caseId) {
		this.caseData = caseData;
		this.caseId = caseId;
	}
	
	public Page getPage() {
		return (Page) flowStack.getCurrentNode();
	}
	
	public CaseInstance getCaseInstance() {
		return caseData.getCaseInstance();
	}

	public CaseData getCaseData() {
		return caseData;
	}

	public String getCaseId() {
		return caseId;
	}

	@Override
	public Instance getSelectedInstance(Entity entity) {
		if (entity == caseData.getCaseInstance().getModel()) {
			return caseData.getCaseInstance();
		}
		Instance result = flowStack.getSelectedInstance(entity);
		if (result!=null) {
			return result;
		}
		throw new RuntimeException("No active instance of entity "+entity.getName());
	}

	public FlowEventOccurrence step(FlowEventOccurrence occurrence) {
		return flowStack.getFlow().step(flowStack.getCurrentNode(), occurrence, this);
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
			throw new UnhandledOccurrenceException(lastNode, lastOccurrence);
		}
	}
	
	public void pushFlowContext(Flow flow) {
		flowStack = new FlowStack(flowStack, flow);
	}
	
	@Override
	public String toString() {
		return "Flowstack for case "+caseId+" "+flowStack;
	}

	@Override
	protected void addSelectedInstances(List<Instance> result) {
		flowStack.addSelectedInstances(result);
	}

	public void logOccurrence(FlowEventOccurrence occurrence) {
		this.lastNode = flowStack.getCurrentNode();
		this.lastOccurrence = occurrence;
	}
}
