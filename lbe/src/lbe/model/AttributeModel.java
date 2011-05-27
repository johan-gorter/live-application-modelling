package lbe.model;

import lbe.deduction.Deduction;
import lbe.instance.AttributeValue;
import lbe.instance.Instance;
import lbe.page.PageElement.Domain;
import lbe.page.RenderContext;

public abstract class AttributeModel<I extends Instance, Value extends Object> extends ModelBase {

	public static final String DATATYPE_DATE = "date";
	public static final String DATATYPE_INTEGER = "integer";
	public static final String DATATYPE_BOOLEAN = "boolean";
	public static final String DATATYPE_TEXT = "text";
	public static final String DATATYPE_ENTITY = "entity";
	
	public abstract EntityModel getEntity();
	
	public abstract String getDatatype();

	public abstract String getQuestion(RenderContext context);

	public String getExplain(RenderContext context) {
		return null;
	}

	public boolean isMultivalue() {
		return false;
	}

	public boolean isReadOnly() {
		return false;
	}

	public Domain[] getDomain(RenderContext context) {
		return null;
	}
	
	public Deduction<Value> getDeduction() {
		return null;
	}
	
	public Value calculateValue(I instance) {
		Deduction<Value> deduction = getDeduction();
		if (deduction!=null) {
			return deduction.deduct(instance);
		}
		return null;
	}
	
	public abstract AttributeValue<I, Value> get(I instance);

}
