package app.designer.entity;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.model.Relation;
import org.instantlogic.core.model.impl.SimpleAttribute;
import org.instantlogic.core.model.impl.SimpleEntity;
import org.instantlogic.core.value.ReadOnlyAttributeValue;

import app.designer.ConstantStringDesign;

public class ConstantStringDesignEntity extends SimpleEntity {

	public static final ConstantStringDesignEntity INSTANCE = new ConstantStringDesignEntity();
	
	// Attributes
	
	public static final Attribute<ConstantStringDesign, java.lang.String, java.lang.String> constant 
		= new SimpleAttribute<ConstantStringDesign, java.lang.String, java.lang.String>(
			"constant", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<ConstantStringDesign, java.lang.String> get(ConstantStringDesign instance) {
				return instance.constant;
			}
		};
	
	// Relations
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		constant,
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private ConstantStringDesignEntity() {
		super("ConstantStringDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new ConstantStringDesign(caseInstance, id);
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
