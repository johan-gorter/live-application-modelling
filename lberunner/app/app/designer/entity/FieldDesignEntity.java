package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class FieldDesignEntity extends SimpleEntity {

	public static final FieldDesignEntity INSTANCE = new FieldDesignEntity();
	
	// Attributes
	
	public static final Attribute<FieldDesign, java.lang.Boolean, java.lang.Boolean> required 
		= new SimpleAttribute<FieldDesign, java.lang.Boolean, java.lang.Boolean>(
			"required", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<FieldDesign, java.lang.Boolean> get(FieldDesign instance) {
				return instance.required;
			}
		};
	
	public static final Attribute<FieldDesign, java.lang.Boolean, java.lang.Boolean> readOnly 
		= new SimpleAttribute<FieldDesign, java.lang.Boolean, java.lang.Boolean>(
			"readOnly", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<FieldDesign, java.lang.Boolean> get(FieldDesign instance) {
				return instance.readOnly;
			}
		};
	
	// Relations
	
	public static final Relation<FieldDesign, AttributeDesign, AttributeDesign> attribute
		= new SimpleRelation<FieldDesign, AttributeDesign, AttributeDesign>(
			"attribute", INSTANCE, AttributeDesignEntity.INSTANCE, AttributeDesign.class, AttributeDesignEntity.fields
		) {
	
			@Override
			public ReadOnlyRelationValue<FieldDesign, AttributeDesign> get(
					FieldDesign instance) {
				return instance.attribute;
			}
		};
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		required,
		readOnly,
	};
	private static final Relation[] RELATIONS = new Relation[]{
		attribute,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private FieldDesignEntity() {
		super("FieldDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new FieldDesign(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return PageFragmentDesignEntity.INSTANCE;
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
