package app.designer.entity;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.model.impl.SimpleAttribute;
import org.instantlogic.fabric.model.impl.SimpleEntity;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;

import app.designer.ConstantTextDesign;
import lbe.model.deduction.*;

public class ConstantTextDesignEntity extends SimpleEntity {

	public static final ConstantTextDesignEntity INSTANCE = new ConstantTextDesignEntity();

	// Deductions
	
	// Attributes
	
	public static final Attribute<ConstantTextDesign, java.lang.String, java.lang.String> untranslated 
		= new SimpleAttribute<ConstantTextDesign, java.lang.String, java.lang.String>(
			"untranslated", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<ConstantTextDesign, java.lang.String> get(ConstantTextDesign instance) {
				return instance.untranslated;
			}
		};
	
	// Relations
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		untranslated,
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private ConstantTextDesignEntity() {
		super("ConstantTextDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new ConstantTextDesign(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return TextDesignEntity.INSTANCE;
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
