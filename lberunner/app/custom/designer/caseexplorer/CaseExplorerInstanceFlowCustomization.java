package custom.designer.caseexplorer;

import lbe.engine.FlowContext;
import lbe.engine.FlowStack;
import lbe.engine.PageCoordinates.Coordinate;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;

import app.designer.flow.CaseExplorerInstanceFlow;

/**
 * This special customization allows for 1 instance of any Entity to be used as a parameter for this flow 
 */
public class CaseExplorerInstanceFlowCustomization extends CaseExplorerInstanceFlow {

	@Override
	protected void acceptParameters(FlowContext context, Instance[] selectedInstances) {
		if (selectedInstances.length==0) {
			throw new RuntimeException("No instance was selected");
		}
		context.getFlowStack().pushSelectedInstance(selectedInstances[0]);
	}
	
	@Override
	protected void stackSelectedInstances(FlowStack stack, Coordinate current, CaseInstance caseInstance) {
		if (current.getActiveInstances().size()!=1) {
			throw new RuntimeException("Expected exactly 1 instance to be selected");
		}
		for (Long instanceId: current.getActiveInstances()) {
			Instance instance = caseInstance.getInstanceById(instanceId);
			if (instance==null) {
				throw new RuntimeException("Instance "+instanceId+" invalid");
			}
			stack.pushSelectedInstance(instance);
		}
	}
}
