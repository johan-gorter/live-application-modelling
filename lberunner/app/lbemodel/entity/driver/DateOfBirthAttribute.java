package lbemodel.entity.driver;

import java.util.Date;
import java.util.GregorianCalendar;

import lbe.deduction.Deduction;
import lbe.deduction.base.ConstantDeduction;
import lbe.instance.AttributeValue;
import lbe.instance.Instance;
import lbe.model.AttributeModel;
import lbe.model.EntityModel;
import lbe.page.RenderContext;
import lbemodel.entity.DriverInstance;
import lbemodel.entity.DriverEntity;


public class DateOfBirthAttribute extends AttributeModel<DriverInstance, Date> {

	public static final DateOfBirthAttribute INSTANCE = new DateOfBirthAttribute();

	@Override
	public String getName() {
		return "DateOfBirth";
	}

	@Override
	public String getDatatype() {
		return DATATYPE_DATE;
	}

	@Override
	public String getQuestion(RenderContext context) {
		return "Date of birth";
	}
	
	@Override
	public Deduction getDeduction() {
		return new ConstantDeduction<Date>(new GregorianCalendar(1980,0,1).getTime());
	}

	@Override
	public EntityModel getEntity() {
		return DriverEntity.INSTANCE;
	}

	@Override
	public AttributeValue<DriverInstance, Date> get(DriverInstance instance) {
		return instance.dateOfBirth;
	}
}
