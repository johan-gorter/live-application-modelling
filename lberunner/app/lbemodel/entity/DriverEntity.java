package lbemodel.entity;

import lbe.model.AttributeModel;
import lbe.model.EntityModel;
import lbemodel.entity.driver.AgeAttribute;


public class DriverEntity extends EntityModel{

	public static final DriverEntity INSTANCE = new DriverEntity();

	private static final AttributeModel[] attributes = new AttributeModel[]{AgeAttribute.INSTANCE};

	@Override
	public AttributeModel[] getAttributes() {
		return attributes;
	}

	@Override
	public String getName() {
		return "Driver";
	}
}
