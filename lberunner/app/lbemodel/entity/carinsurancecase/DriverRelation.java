package lbemodel.entity.carinsurancecase;

import lbe.instance.AttributeValue;
import lbe.instance.Instance;
import lbe.model.EntityModel;
import lbe.model.RelationModel;
import lbe.page.RenderContext;
import lbemodel.entity.CarinsuranceCaseInstance;
import lbemodel.entity.CarinsuranceCaseEntity;
import lbemodel.entity.DriverInstance;
import lbemodel.entity.DriverEntity;

public final class DriverRelation extends RelationModel {

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
	public boolean isReverseMultivalue() {
		return false;
	}

	@Override
	public String getName() {
		return "Driver";
	}

	@Override
	public Instance createTo(Instance from) {
		DriverInstance driver = new DriverInstance();
		driver.getCarinsuranceCase().set((CarinsuranceCaseInstance) from);
		return driver;
	}

	@Override
	public AttributeValue get(Instance instance) {
		return ((CarinsuranceCaseInstance)instance).getDriver();
	}
}
