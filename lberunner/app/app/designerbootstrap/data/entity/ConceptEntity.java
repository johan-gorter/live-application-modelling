package app.designerbootstrap.data.entity;

import java.util.List;

import app.designerbootstrap.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class ConceptEntity extends SimpleEntity {

	public static final ConceptEntity INSTANCE = new ConceptEntity();
	
	// Attributes
	
	public static final Attribute<ConceptInstance, String, String> name 
		= new SimpleAttribute<ConceptInstance, String, String>(
			"name", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public AttributeValue<ConceptInstance, String> get(ConceptInstance instance) {
				return instance.name;
			}
		};
	
	// Relations
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		name,
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private ConceptEntity() {
		super("Concept");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new ConceptInstance(caseInstance);
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