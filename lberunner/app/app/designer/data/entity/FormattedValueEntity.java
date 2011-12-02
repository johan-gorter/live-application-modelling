package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class FormattedValueEntity extends SimpleEntity {

	public static final FormattedValueEntity INSTANCE = new FormattedValueEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<FormattedValueInstance, AttributeBaseInstance, AttributeBaseInstance> value
		= new SimpleRelation<FormattedValueInstance, AttributeBaseInstance, AttributeBaseInstance>(
			"value", INSTANCE, AttributeBaseEntity.INSTANCE, AttributeBaseInstance.class, AttributeBaseEntity.valueInTemplatedText
		) {
	
			@Override
			public ReadOnlyRelationValue<FormattedValueInstance, AttributeBaseInstance> get(
					FormattedValueInstance instance) {
				return instance.value;
			}
		};
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		value,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private FormattedValueEntity() {
		super("FormattedValue");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new FormattedValueInstance(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return StringProducerEntity.INSTANCE;
	}
	
	@Override
	public Attribute<? extends Instance, ? extends Object, ? extends Object>[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public Relation<? extends Instance, ? extends Object, ? extends Instance>[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public Relation<? extends Instance, ? extends Object, ? extends Instance>[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}
}
