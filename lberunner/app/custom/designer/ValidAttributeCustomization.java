package custom.designer;

import lbe.model.Entity;
import lbe.model.deduction.Deduction;
import lbe.model.impl.SimpleAttribute;
import app.designer.Design;

public abstract class ValidAttributeCustomization extends SimpleAttribute<Design, Boolean, Boolean> {

	public ValidAttributeCustomization(String name, Entity entity,
			Class<Boolean> valueClass) {
		super(name, entity, valueClass);
	}
	
	@Override
	public Deduction<Boolean> getDeduction() {
		// TODO Auto-generated method stub
		return super.getDeduction();
	}

}
