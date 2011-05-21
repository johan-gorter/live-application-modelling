package lbemodel;

import lbe.model.CaseModel;
import lbe.model.FlowModel;
import lbe.model.InteractionModel;
import lbemodel.flow.InsureFlow;

public class CarinsuranceInteractionModel extends InteractionModel {

	public static final CarinsuranceInteractionModel INSTANCE = new CarinsuranceInteractionModel();
	
	@Override
	public CaseModel getCaseModel() {
		return CarinsuranceCaseModel.INSTANCE;
	}
	
	private static final FlowModel[] exposedFlows = new FlowModel[] {InsureFlow.INSTANCE};

	@Override
	public FlowModel[] getExposedFlows() {
		return exposedFlows;
	}

}
