package lbemodel.entity;

import lbe.instance.AttributeValue;
import lbe.model.AttributeModel;
import lbe.model.EntityModel;
import lbe.model.RelationModel;
import lbemodel.entity.carinsurancecase.DriverRelation;
import lbemodel.entity.driver.CarUseAttribute;
import lbemodel.entity.driver.DateOfBirthAttribute;
import lbemodel.entity.driver.DisqualifiedAttribute;
import lbemodel.entity.driver.MileageAttribute;
import lbemodel.entity.driver.NoClaimsDiscountAttribute;
import lbemodel.entity.driver.YearsDriverslicenseAttribute;
import lbemodel.entity.driver.YearsInsuredAttribute;
import lbemodel.entity.driver.ZipCodeAttribute;


public class DriverEntity extends EntityModel{

	public static final DriverEntity INSTANCE = new DriverEntity();
	private static final RelationModel[] RELATIONS = new RelationModel[]{};
	
	public static class CaseRelation extends RelationModel<DriverInstance, CarinsuranceCaseInstance> {

		public static final RelationModel<DriverInstance, CarinsuranceCaseInstance> INSTANCE = new CaseRelation();

		@Override
		public EntityModel getTo() {
			return CarinsuranceCaseEntity.INSTANCE;
		}

		@Override
		public boolean isOwner() {
			return false;
		}

		@Override
		public boolean isMultivalue() {
			return false;
		}

		@Override
		public RelationModel<CarinsuranceCaseInstance, DriverInstance> getReverseRelation() {
			return DriverRelation.INSTANCE;
		}

		@Override
		public CarinsuranceCaseInstance createTo(DriverInstance from) {
			return null;
		}

		@Override
		public EntityModel getEntity() {
			return DriverEntity.INSTANCE;
		}

		@Override
		public AttributeValue<DriverInstance, CarinsuranceCaseInstance> get(
				DriverInstance instance) {
			return instance.carinsuranceCase;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	private static final RelationModel[] REVERSE_RELATIONS = new RelationModel[]{DriverRelation.INSTANCE};

	private static final AttributeModel[] attributes = new AttributeModel[]{
		CarUseAttribute.INSTANCE,
		DateOfBirthAttribute.INSTANCE,
		DisqualifiedAttribute.INSTANCE,
		MileageAttribute.INSTANCE,
		NoClaimsDiscountAttribute.INSTANCE,
		YearsDriverslicenseAttribute.INSTANCE,
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
