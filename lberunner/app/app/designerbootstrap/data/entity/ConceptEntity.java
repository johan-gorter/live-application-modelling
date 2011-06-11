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
	
	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		name
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
