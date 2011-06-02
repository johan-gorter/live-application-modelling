package lbe.instance.value;

import lbe.instance.Instance;
import lbe.model.Attribute;
import lbe.model.Relation;

// Value: List<Instance> or Instance
public interface ReadOnlyRelationValue<I extends Instance, Value extends Object> extends ReadOnlyAttributeValue<I, Value> {

}
