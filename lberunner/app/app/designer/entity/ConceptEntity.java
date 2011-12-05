package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class ConceptEntity extends SimpleEntity {

	public static final ConceptEntity INSTANCE = new ConceptEntity();
	
	// Attributes
	
	public static final Attribute<Concept, java.lang.String, java.lang.String> name 
		= new SimpleAttribute<Concept, java.lang.String, java.lang.String>(
			"name", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Concept, java.lang.String> get(Concept instance) {
				return instance.name;
			}
		};
	
	public static final Attribute<Concept, java.lang.Boolean, java.lang.Boolean> valid 
		= new custom.designer.ValidAttributeCustomization(
			"valid", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Concept, java.lang.Boolean> get(Concept instance) {
				return instance.valid;
			}
			
			public boolean isReadOnly() {
				return true;
			};
		};
	
	public static final Attribute<Concept, java.lang.String, java.lang.String> customization 
		= new SimpleAttribute<Concept, java.lang.String, java.lang.String>(
			"customization", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Concept, java.lang.String> get(Concept instance) {
				return instance.customization;
			}
		};
	
	// Relations
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		name,
		valid,
		customization,
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private ConceptEntity() {
		super("Concept");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new Concept(caseInstance, id);
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
