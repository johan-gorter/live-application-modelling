package lbe.engine;

import lbe.instance.Instance;
import lbe.instance.value.ReadOnlyAttributeValue;
import lbe.model.Attribute;
import lbe.model.Entity;

public abstract class DeductionContext {

	public abstract Instance getSelectedInstance(Entity entity);
	
	// Convenience methods
	
	public <I extends Instance, Value extends Object> Value getValue(Entity entity, Attribute<I, Value, ? extends Object> attribute) {
		return getAttributeValue(entity, attribute).get();
	}
	
	@SuppressWarnings("unchecked")
	public <I extends Instance, Value extends Object> ReadOnlyAttributeValue<I, Value> getAttributeValue(Entity entity, Attribute<I, Value, ? extends Object> attribute) {
		I instance = (I) getSelectedInstance(entity);
		if (instance==null) {
			throw new RuntimeException("No selected instance of type "+entity+" in scope while evaluating attribute "+attribute.getName());
		}
		return attribute.get(instance);
	}

}
