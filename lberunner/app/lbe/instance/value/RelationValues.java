package lbe.instance.value;

import java.util.List;

import lbe.instance.Instance;
import lbe.model.Attribute;
import lbe.model.Relation;

public interface RelationValues<I extends Instance, Item extends Instance> 
	extends AttributeValues<I, Item>, RelationValue<I, List<Item>>, ReadOnlyRelationValues<I, Item>
{

}
