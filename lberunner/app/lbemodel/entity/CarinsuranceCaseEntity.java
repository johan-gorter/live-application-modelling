package lbemodel.entity;

import lbe.model.AttributeModel;
import lbe.model.EntityModel;
import lbe.model.RelationModel;
import lbemodel.entity.carinsurancecase.DriverRelation;

public class CarinsuranceCaseEntity extends EntityModel {

	public static final CarinsuranceCaseEntity INSTANCE = new CarinsuranceCaseEntity();
	
	private static final AttributeModel[] ATTRIBUTES = new AttributeModel[]{};
	private static final RelationModel[] RELATIONS = new RelationModel[]{DriverRelation.INSTANCE};
	private static final RelationModel[] REVERSE_RELATIONS = new RelationModel[]{};

	@Override
	public String getName() {
		return "CarinsuranceCase";
	}

	@Override
	public AttributeModel[] getAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public RelationModel[] getRelations() {
		return RELATIONS;
	}

	@Override
	public RelationModel[] getReverseRelations() {
		return REVERSE_RELATIONS;
	}
	
}
