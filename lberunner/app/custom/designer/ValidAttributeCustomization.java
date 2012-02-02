package custom.designer;

import org.instantlogic.core.deduction.Deduction;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.model.impl.SimpleAttribute;

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
