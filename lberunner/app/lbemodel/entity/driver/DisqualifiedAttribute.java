package lbemodel.entity.driver;

import lbe.instance.AttributeValue;
import lbe.instance.Instance;
import lbe.model.AttributeModel;
import lbe.model.EntityModel;
import lbe.page.RenderContext;
import lbemodel.entity.DriverEntity;
import lbemodel.entity.DriverInstance;

public class DisqualifiedAttribute extends AttributeModel<DriverInstance, Boolean> {

	public static final DisqualifiedAttribute INSTANCE = new DisqualifiedAttribute();

	@Override
	public String getDatatype() {
		return DATATYPE_BOOLEAN;
	}

	@Override
	public String getQuestion(RenderContext context) {
		return "Have you been disqualified in the last 5 years?";
	}

	@Override
	public String getName() {
		return "Disqualified";
	}
	
	@Override
	public EntityModel getEntity() {
		return DriverEntity.INSTANCE;
	}

	@Override
	public AttributeValue<DriverInstance, Boolean> get(DriverInstance instance) {
		return instance.disqualified;
	}
}
