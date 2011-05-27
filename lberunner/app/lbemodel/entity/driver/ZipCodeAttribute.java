package lbemodel.entity.driver;

import lbe.instance.AttributeValue;
import lbe.instance.Instance;
import lbe.model.AttributeModel;
import lbe.model.EntityModel;
import lbe.page.RenderContext;
import lbemodel.entity.DriverEntity;
import lbemodel.entity.DriverInstance;

public class ZipCodeAttribute extends AttributeModel<DriverInstance, String> {

	public static ZipCodeAttribute INSTANCE = new ZipCodeAttribute();
	
	@Override
	public String getDatatype() {
		return DATATYPE_TEXT;
	}

	@Override
	public String getQuestion(RenderContext context) {
		return "ZIP code";
	}

	@Override
	public String getName() {
		return "ZipCode";
	}
	
	@Override
	public EntityModel getEntity() {
		return DriverEntity.INSTANCE;
	}

	@Override
	public AttributeValue<DriverInstance, String> get(DriverInstance instance) {
		return instance.zipCode;
	}

}
