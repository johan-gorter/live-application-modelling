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

public class DesignEntity extends SimpleEntity {

	public static final DesignEntity INSTANCE = new DesignEntity();

	// Deductions

	private static Deduction<java.lang.String> createDeduction0() {
		    Deduction<java.lang.String> d0 = new custom.designer.JavaNameCustomization();
		return d0;
	}

	
	// Attributes
	
	public static final Attribute<Design, java.lang.String, java.lang.String> name 
		= new SimpleAttribute<Design, java.lang.String, java.lang.String>(
			"name", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Design, java.lang.String> get(Design instance) {
				return instance.name;
			}
		};
	
	public static final Attribute<Design, java.lang.Boolean, java.lang.Boolean> valid 
		= new custom.designer.ValidAttributeCustomization(
			"valid", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Design, java.lang.Boolean> get(Design instance) {
				return instance.valid;
			}
			
			public boolean isReadOnly() {
				return true;
			};
		};
	
	public static final Attribute<Design, java.lang.String, java.lang.String> javaName 
		= new SimpleAttribute<Design, java.lang.String, java.lang.String>(
			"javaName", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Design, java.lang.String> get(Design instance) {
				return instance.javaName;
			}
			
			public boolean isReadOnly() {
				return true;
			};
		};
	
	public static final Attribute<Design, java.lang.String, java.lang.String> customization 
		= new SimpleAttribute<Design, java.lang.String, java.lang.String>(
			"customization", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Design, java.lang.String> get(Design instance) {
				return instance.customization;
			}
		};
	
	// Relations
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		name,
		valid,
		javaName,
		customization,
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private DesignEntity() {
		super("Design");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new Design(caseInstance, id);
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
