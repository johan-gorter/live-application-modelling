package lbemodel.entity.driver;

import lbe.instance.AttributeValue;
import lbe.instance.Instance;
import lbe.model.AttributeModel;
import lbe.model.EntityModel;
import lbe.page.RenderContext;
import lbemodel.entity.DriverEntity;
import lbemodel.entity.DriverInstance;


public class YearsDriverslicenseAttribute extends AttributeModel<DriverInstance, Integer>{

	public static final YearsDriverslicenseAttribute INSTANCE = new YearsDriverslicenseAttribute();

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
	public AttributeValue<DriverInstance, Integer> get(DriverInstance instance) {
		return instance.yearsDriverslicense;
	}

}
