package lbemodel.entity.driver;

import lbe.instance.AttributeValue;
import lbe.instance.Instance;
import lbe.model.AttributeModel;
import lbe.model.EntityModel;
import lbe.page.RenderContext;
import lbemodel.entity.DriverEntity;
import lbemodel.entity.DriverInstance;


public class NoClaimsDiscountAttribute extends AttributeModel<DriverInstance, Integer> {

	public static NoClaimsDiscountAttribute INSTANCE = new NoClaimsDiscountAttribute();
	
	@Override
	public String getDatatype() {
		return DATATYPE_INTEGER;
	}

	@Override
	public String getQuestion(RenderContext context) {
		return "No claims discount entitlement?";
	}

	@Override
	public String getName() {
		return "NoClaimsDiscount";
	}
	
	@Override
	public EntityModel getEntity() {
		return DriverEntity.INSTANCE;
	}

	@Override
	public AttributeValue<DriverInstance, Integer> get(DriverInstance instance) {
		return instance.noClaimsDiscount;
	}

}
