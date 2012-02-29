package custom.designer;

import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.impl.SimpleAttribute;

import app.designer.Design;

public abstract class ValidAttributeCustomization extends SimpleAttribute<Design, Boolean, Boolean> {

	public ValidAttributeCustomization(String name, Entity entity,
			Class<Boolean> valueClass) {
		super(name, entity, valueClass);
	}
	
	@Override
	public Deduction<Boolean> getDefault() {
		// TODO Auto-generated method stub
		return super.getDefault();
	}

}
