package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class FormattedValueDesignEntity extends SimpleEntity {

	public static final FormattedValueDesignEntity INSTANCE = new FormattedValueDesignEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<FormattedValueDesign, AttributeBase, AttributeBase> value
		= new SimpleRelation<FormattedValueDesign, AttributeBase, AttributeBase>(
			"value", INSTANCE, AttributeBaseEntity.INSTANCE, AttributeBase.class, AttributeBaseEntity.valueInTemplatedText
		) {
	
			@Override
			public ReadOnlyRelationValue<FormattedValueDesign, AttributeBase> get(
					FormattedValueDesign instance) {
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

	private FormattedValueDesignEntity() {
		super("FormattedValueDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new FormattedValueDesign(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return StringProducerDesignEntity.INSTANCE;
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
