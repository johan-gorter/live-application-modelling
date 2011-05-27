package lbemodel.entity.carinsurancecase;

import lbe.instance.AttributeValue;
import lbe.model.EntityModel;
import lbe.model.RelationModel;
import lbemodel.entity.CarinsuranceCaseEntity;
import lbemodel.entity.CarinsuranceCaseInstance;
import lbemodel.entity.DriverEntity;
import lbemodel.entity.DriverInstance;
import lbemodel.entity.DriverEntity.CaseRelation;

public final class DriverRelation extends RelationModel<CarinsuranceCaseInstance, DriverInstance> {

	public static final DriverRelation INSTANCE = new DriverRelation();
	
	private DriverRelation() {};
	
	@Override
	public EntityModel getEntity() {
		return CarinsuranceCaseEntity.INSTANCE;
	}
	
	@Override
	public EntityModel getTo() {
		return DriverEntity.INSTANCE;
	}

	@Override
	public boolean isOwner() {
		return true;
	}

	@Override
	public boolean isMultivalue() {
		return false;
	}

	@Override
	public String getName() {
		return "Driver";
	}

	@Override
	public DriverInstance createTo(CarinsuranceCaseInstance from) {
		DriverInstance driver = new DriverInstance(from.getCase());
		driver.carinsuranceCase.set(from);
		return driver;
	}

	@Override
	public RelationModel<DriverInstance, CarinsuranceCaseInstance> getReverseRelation() {
		return CaseRelation.INSTANCE;
	}

	@Override
	public AttributeValue<CarinsuranceCaseInstance, DriverInstance> get(
			CarinsuranceCaseInstance instance) {
		return instance.driver;
	}

}
