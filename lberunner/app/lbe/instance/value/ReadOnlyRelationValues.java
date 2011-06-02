package lbe.instance.value;

import java.util.List;

import lbe.instance.Instance;
import lbe.model.Attribute;
import lbe.model.Relation;

// Value: List<Instance> or Instance
public interface ReadOnlyRelationValues<I extends Instance, To extends Instance> 
	extends ReadOnlyAttributeValues<I, To>,  ReadOnlyRelationValue<I, List<To>>{
	
	@Override
	public Attribute<I, List<To>> getModel();

}
