package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class AttributeBaseDesignEntity extends SimpleEntity {

	public static final AttributeBaseDesignEntity INSTANCE = new AttributeBaseDesignEntity();
	
	// Attributes
	
	public static final Attribute<AttributeBaseDesign, java.lang.Boolean, java.lang.Boolean> readOnly 
		= new SimpleAttribute<AttributeBaseDesign, java.lang.Boolean, java.lang.Boolean>(
			"readOnly", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<AttributeBaseDesign, java.lang.Boolean> get(AttributeBaseDesign instance) {
				return instance.readOnly;
			}
		};
	
	public static final Attribute<AttributeBaseDesign, java.lang.Boolean, java.lang.Boolean> multivalue 
		= new SimpleAttribute<AttributeBaseDesign, java.lang.Boolean, java.lang.Boolean>(
			"multivalue", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<AttributeBaseDesign, java.lang.Boolean> get(AttributeBaseDesign instance) {
				return instance.multivalue;
			}
		};
	
	// Relations
	
	// Reverse relations
	
	public static final Relation<AttributeBaseDesign, FormattedValueDesign, FormattedValueDesign> valueInTemplatedText
		= new SimpleRelation<AttributeBaseDesign, FormattedValueDesign, FormattedValueDesign>(
			"valueInTemplatedText", INSTANCE, AttributeBaseDesignEntity.INSTANCE, FormattedValueDesign.class, FormattedValueDesignEntity.value
		) {
	
			@Override
			public ReadOnlyRelationValue<AttributeBaseDesign, FormattedValueDesign> get(
					AttributeBaseDesign instance) {
				return instance.valueInTemplatedText;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		readOnly,
		multivalue,
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		valueInTemplatedText,
	};

	private AttributeBaseDesignEntity() {
		super("AttributeBaseDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new AttributeBaseDesign(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return DesignEntity.INSTANCE;
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
