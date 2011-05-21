package lbemodel.entity.driver;

import lbe.model.AttributeModel;


public class AgeAttribute extends AttributeModel{

	public static final AgeAttribute INSTANCE = new AgeAttribute();

	@Override
	public String getName() {
		return "Age";
	}

}
