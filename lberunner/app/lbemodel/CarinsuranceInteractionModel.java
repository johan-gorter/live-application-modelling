package lbemodel;

import lbe.model.EntityModel;
import lbe.model.FlowModel;
import lbe.model.InteractionModel;
import lbemodel.entity.CarinsuranceCaseEntity;
import lbemodel.flow.InsureFlow;

public class CarinsuranceInteractionModel extends InteractionModel {

	public static final CarinsuranceInteractionModel INSTANCE = new CarinsuranceInteractionModel();
	
	@Override
	public EntityModel getCaseModel() {
		return CarinsuranceCaseEntity.INSTANCE;
	}
	
	private static final FlowModel[] exposedFlows = new FlowModel[] {InsureFlow.INSTANCE};

	@Override
	public FlowModel[] getExposedFlows() {
		return exposedFlows;
	}

}
