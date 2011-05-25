package lbemodel.entity.driver;

import lbe.instance.AttributeValue;
import lbe.instance.Instance;
import lbe.model.AttributeModel;
import lbe.model.EntityModel;
import lbe.page.RenderContext;
import lbemodel.entity.DriverEntity;

public class ZipCodeAttribute extends AttributeModel{

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
	public AttributeValue get(Instance instance) {
		// TODO Auto-generated method stub
		return null;
	}
}
