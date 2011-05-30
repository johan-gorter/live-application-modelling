package lbemodel;

import lbe.model.Entity;
import lbe.model.Flow;
import lbe.model.Interaction;
import lbemodel.entity.CarinsuranceCaseEntity;
import lbemodel.flow.InsureFlow;

public class CarinsuranceInteractionModel extends Interaction {

	public static final CarinsuranceInteractionModel INSTANCE = new CarinsuranceInteractionModel();
	
	@Override
	public Entity getCaseModel() {
		return CarinsuranceCaseEntity.INSTANCE;
	}
	
	private static final Flow[] exposedFlows = new Flow[] {InsureFlow.INSTANCE};

	@Override
	public Flow[] getExposedFlows() {
		return exposedFlows;
	}

}
