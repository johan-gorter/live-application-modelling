package app.designerbootstrap.data.entity;

import java.util.List;

import app.carinsurance.entity.DriverInstance;
import app.designerbootstrap.data.instance.ConceptInstance;
import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.value.AttributeValue;
import lbe.instance.value.ReadOnlyAttributeValue;
import lbe.instance.value.RelationValue;
import lbe.instance.value.RelationValues;
import lbe.model.Attribute;
import lbe.model.Relation;
import lbe.model.impl.SimpleAttribute;
import lbe.model.impl.SimpleEntity;
import lbe.model.impl.SimpleRelation;
import lbe.model.pageelement.Text;
import lbe.model.pageelement.impl.ConstantText;

public class ConceptEntity extends SimpleEntity {

	public static final ConceptEntity INSTANCE = new ConceptEntity();
	
	
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
