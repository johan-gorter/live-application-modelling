package lbe.model;

import lbe.instance.CaseInstance;
import lbe.model.flow.Flow;


public abstract class Application {
	
	public abstract Class<? extends CaseInstance> getCaseInstanceClass();
	
	public abstract String getName();
	
	public abstract Entity getCaseModel();
	
	public abstract Flow[] getExposedFlows();

	public Flow getExposedFlow(String startFlowName) {
		for (Flow flowModel: getExposedFlows()) {
			if (flowModel.getName().equals(startFlowName)) {
				return flowModel;
			}
		}
		throw new RuntimeException("Exposed flow not found. Name: "+startFlowName);
	}
	
}
