package lbemodel.entity.driver;

import lbe.instance.AttributeValue;
import lbe.instance.Instance;
import lbe.model.AttributeModel;
import lbe.model.EntityModel;
import lbe.page.RenderContext;
import lbemodel.entity.DriverEntity;


public class YearsDriverslicense extends AttributeModel{

	public static final YearsDriverslicense INSTANCE = new YearsDriverslicense();

	@Override
	public String getName() {
		return "YearsDriverslicense";
	}

	@Override
	public String getDatatype() {
		return DATATYPE_INTEGER;
	}

	@Override
	public String getQuestion(RenderContext context) {
		return "How many years have you held your drivers licence?";
	}
	
	@Override
	public String getExplain(RenderContext context) {
		return "Round the number of months down to entire years. e.g. if you own a drivers licence for 3 months round down to 0 years.";
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
