package app.designer.entity;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.model.impl.SimpleAttribute;
import org.instantlogic.fabric.model.impl.SimpleEntity;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;

import app.designer.ConstantStringDesign;
import lbe.model.deduction.*;

public class ConstantStringDesignEntity extends SimpleEntity {

	public static final ConstantStringDesignEntity INSTANCE = new ConstantStringDesignEntity();

	// Deductions
	
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
