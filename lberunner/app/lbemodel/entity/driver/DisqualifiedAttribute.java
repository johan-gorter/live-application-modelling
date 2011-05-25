package lbemodel.entity.driver;

import lbe.instance.AttributeValue;
import lbe.instance.Instance;
import lbe.model.AttributeModel;
import lbe.model.EntityModel;
import lbe.page.RenderContext;
import lbemodel.entity.DriverEntity;

public class DisqualifiedAttribute extends AttributeModel{

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
	public AttributeValue get(Instance instance) {
		// TODO Auto-generated method stub
		return null;
	}
}
