package custom.designer;

import lbe.instance.value.ReadOnlyAttributeValue;
import lbe.model.Attribute;
import lbe.model.Entity;
import lbe.model.deduction.Deduction;
import lbe.model.impl.SimpleAttribute;
import lbe.model.pageelement.Text;
import app.designer.data.instance.ConceptInstance;

public abstract class ValidAttributeCustomization extends SimpleAttribute<ConceptInstance, Boolean, Boolean> {

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
