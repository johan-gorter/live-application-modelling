package lbemodel.entity.driver;

import lbe.instance.AttributeValue;
import lbe.instance.Instance;
import lbe.model.AttributeModel;
import lbe.model.EntityModel;
import lbe.page.RenderContext;
import lbe.page.PageElement.Domain;
import lbemodel.entity.DriverEntity;

public class MileageAttribute extends AttributeModel{

	public static final MileageAttribute INSTANCE = new MileageAttribute();

	@Override
	public String getDatatype() {
		return DATATYPE_TEXT;
	}

	@Override
	public String getQuestion(RenderContext context) {
		return "Annual mileage";
	}

	@Override
	public String getName() {
		return "Mileage";
	}
	
	@Override
	public Domain[] getDomain(RenderContext context) {
		return new Domain[] {
				new Domain("k1","< 7.500 km"),	
				new Domain("k2","7.500 km - 12.000 km"),	
				new Domain("k3","> 12.000 km"),	
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
