package lbemodel;

import lbe.model.CaseModel;
import lbe.model.EntityModel;
import lbemodel.entity.DriverEntity;

public class CarinsuranceCaseModel extends CaseModel {

	public static final CarinsuranceCaseModel INSTANCE = new CarinsuranceCaseModel();

	private static final EntityModel[] entities = new EntityModel[]{DriverEntity.INSTANCE};

	@Override
	public EntityModel[] getEntities() {
		return entities;
	}
	
}
