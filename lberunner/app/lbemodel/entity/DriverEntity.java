package lbemodel.entity;

import lbe.model.AttributeModel;
import lbe.model.EntityModel;
import lbe.model.RelationModel;
import lbemodel.entity.carinsurancecase.DriverRelation;
import lbemodel.entity.driver.CarUseAttribute;
import lbemodel.entity.driver.DateOfBirthAttribute;
import lbemodel.entity.driver.DisqualifiedAttribute;
import lbemodel.entity.driver.MileageAttribute;
import lbemodel.entity.driver.NoClaimsDiscountAttribute;
import lbemodel.entity.driver.YearsDriverslicense;
import lbemodel.entity.driver.YearsInsuredAttribute;
import lbemodel.entity.driver.ZipCodeAttribute;


public class DriverEntity extends EntityModel{

	public static final DriverEntity INSTANCE = new DriverEntity();
	private static final RelationModel[] RELATIONS = new RelationModel[]{};
	private static final RelationModel[] REVERSE_RELATIONS = new RelationModel[]{DriverRelation.INSTANCE};

	private static final AttributeModel[] attributes = new AttributeModel[]{
		CarUseAttribute.INSTANCE,
		DateOfBirthAttribute.INSTANCE,
		DisqualifiedAttribute.INSTANCE,
		MileageAttribute.INSTANCE,
		NoClaimsDiscountAttribute.INSTANCE,
		YearsDriverslicense.INSTANCE,
		YearsInsuredAttribute.INSTANCE,
		ZipCodeAttribute.INSTANCE
	};

	@Override
	public AttributeModel[] getAttributes() {
		return attributes;
	}

	@Override
	public String getName() {
		return "Driver";
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
