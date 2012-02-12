package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
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
