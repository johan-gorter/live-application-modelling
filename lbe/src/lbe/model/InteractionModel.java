package lbe.model;

public abstract class InteractionModel {
	
	public abstract CaseModel getCaseModel();
	
	public abstract FlowModel[] getExposedFlows();

	public FlowModel getExposedFlow(String startFlowName) {
		for (FlowModel flowModel: getExposedFlows()) {
			if (flowModel.getName().equals(startFlowName)) {
				return flowModel;
			}
		}
		throw new RuntimeException("Exposed flow not found. Name: "+startFlowName);
	}
	
}
