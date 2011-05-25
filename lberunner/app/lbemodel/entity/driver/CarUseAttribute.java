package lbemodel.entity.driver;

import lbe.instance.AttributeValue;
import lbe.instance.Instance;
import lbe.model.AttributeModel;
import lbe.model.EntityModel;
import lbe.page.RenderContext;
import lbe.page.PageElement.Domain;
import lbemodel.entity.DriverEntity;

public class CarUseAttribute extends AttributeModel{

	public static final CarUseAttribute INSTANCE = new CarUseAttribute();

	@Override
	public String getDatatype() {
		return DATATYPE_TEXT;
	}

	@Override
	public String getQuestion(RenderContext context) {
		return "How will the car be used?";
	}

	@Override
	public String getName() {
		return "CarUse";
	}
	
	@Override
	public boolean isMultivalue() {
		return true;
	}
	
	@Override
	public Domain[] getDomain(RenderContext context) {
		return new Domain[]{
				new Domain("private","Private"),
				new Domain("business","Business")
		};
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
