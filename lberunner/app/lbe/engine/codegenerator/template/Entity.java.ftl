package app.${appname}.data.entity;

import java.util.List;

import app.${appname}.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class ${name}Entity extends SimpleEntity {

	public static final ${name}Entity INSTANCE = new ${name}Entity();
	
	//TODO from here
	
	public static final Attribute<ConceptInstance, String, String> name 
		= new SimpleAttribute<ConceptInstance, String, String>("name", INSTANCE, String.class) {
	
		@Override
		public AttributeValue<ConceptInstance, String> get(
				ConceptInstance instance) {
			return instance.name;
		}
	};
	
	public static final Relation<ConceptInstance, ConceptInstance, ConceptInstance> extendsFrom
		= new SimpleRelation<ConceptInstance, ConceptInstance, ConceptInstance>("extendsFrom", INSTANCE, ConceptEntity.INSTANCE, ConceptInstance.class, ConceptEntity.extensions) {
	
			@Override
			public RelationValue<ConceptInstance, ConceptInstance> get(
					ConceptInstance instance) {
				return instance.extendsFrom;
			}
		
		};

	public static final Relation<ConceptInstance, List<ConceptInstance>, ConceptInstance> extensions
		= new SimpleRelation<ConceptInstance, List<ConceptInstance>, ConceptInstance>("extensions", INSTANCE, ConceptEntity.INSTANCE, ConceptInstance.class, ConceptEntity.extendsFrom) {
	
			@Override
			public RelationValues<ConceptInstance, ConceptInstance> get(
					ConceptInstance instance) {
				return instance.extensions;
			}
			
			public boolean isMultivalue() {
				return true;
			};
		
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		name
	};
	private static final Relation[] RELATIONS = new Relation[]{
		extendsFrom
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		extensions
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
