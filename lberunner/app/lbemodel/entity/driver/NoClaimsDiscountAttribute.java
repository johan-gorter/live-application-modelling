package lbemodel.entity.driver;

import lbe.instance.AttributeValue;
import lbe.instance.Instance;
import lbe.model.AttributeModel;
import lbe.model.EntityModel;
import lbe.page.RenderContext;
import lbemodel.entity.DriverEntity;


public class NoClaimsDiscountAttribute extends AttributeModel {

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
	public AttributeValue get(Instance instance) {
		// TODO Auto-generated method stub
		return null;
	}
}
