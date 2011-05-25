package lbemodel.entity.driver;

import lbe.instance.AttributeValue;
import lbe.instance.Instance;
import lbe.model.AttributeModel;
import lbe.model.EntityModel;
import lbe.page.RenderContext;
import lbemodel.entity.DriverEntity;


public class YearsInsuredAttribute extends AttributeModel{

	public static final YearsInsuredAttribute INSTANCE = new YearsInsuredAttribute();

	@Override
	public String getName() {
		return "YearsInsured";
	}

	@Override
	public String getDatatype() {
		return DATATYPE_INTEGER;
	}

	@Override
	public String getQuestion(RenderContext context) {
		return "How many years have you been insured?";
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
