package lbe.instance.impl;

import java.util.List;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.value.AttributeValue;
import lbe.instance.value.AttributeValues;
import lbe.instance.value.ReadOnlyRelationValue;
import lbe.instance.value.ReadOnlyRelationValues;
import lbe.instance.value.RelationValue;
import lbe.instance.value.RelationValues;
import lbe.instance.value.impl.AttributeValueImpl;
import lbe.instance.value.impl.AttributeValuesImpl;
import lbe.instance.value.impl.RelationValueImpl;
import lbe.instance.value.impl.RelationValuesImpl;
import lbe.instance.value.impl.ReverseRelationValueImpl;
import lbe.instance.value.impl.ReverseRelationValuesImpl;
import lbe.model.Attribute;
import lbe.model.Entity;
import lbe.model.Relation;

public class SimpleInstance implements Instance {

	private final CaseInstance caseInstance;
	
	private final long id;
	
	private final Entity model;
	
	public SimpleInstance(CaseInstance caseInstance, Entity model) {
		this.caseInstance = caseInstance;
		if (caseInstance!=null) {
			this.id = caseInstance.nextId();
		} else {
			this.id = 0; // This means we are the caseInstance
		}
		this.model = model;
	}

	public CaseInstance getCase() {
		return caseInstance;
	}
	
	public long getInstanceId() {
		return id;
	}

	@Override
	public Entity getModel() {
		return model;
	}

	protected<I extends Instance, Value extends Object> AttributeValue<I, Value> createAttributeValue(Attribute<I, Value, Value> attribute) {
		return new AttributeValueImpl<I, Value>((I)this, attribute);
	}
	
	protected<I extends Instance, Value extends Object> AttributeValues<I, Value> createAttributeValues(Attribute<I, List<Value>, Value> attribute) {
		return new AttributeValuesImpl<I, Value>((I)this, attribute);
	}
	
	protected<I extends Instance, To extends Instance> RelationValue<I, To> createRelationValue(Relation<I, To, To> relation) {
		return new RelationValueImpl<I, To>((I)this, relation);
	}
	
	protected<I extends Instance, To extends Instance> RelationValues<I, To> createRelationValues(Relation<I, List<To>, To> relation) {
		return new RelationValuesImpl<I, To>((I)this, relation);
	}

	protected<I extends Instance, To extends Instance> ReadOnlyRelationValue<I, To> createReverseRelationValue(Relation<I, To, To> relation) {
		return new ReverseRelationValueImpl<I, To>((I)this, relation);
	}
	
	protected<I extends Instance, To extends Instance> ReadOnlyRelationValues<I, To> createReverseRelationValues(Relation<I, List<To>, To> relation) {
		return new ReverseRelationValuesImpl<I, To>((I)this, relation);
	}
}
