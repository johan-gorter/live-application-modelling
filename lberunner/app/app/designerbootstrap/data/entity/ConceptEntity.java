package app.designerbootstrap.data.entity;

import app.carinsurance.entity.DriverInstance;
import app.designerbootstrap.data.instance.ConceptInstance;
import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.value.AttributeValue;
import lbe.model.Attribute;
import lbe.model.Relation;
import lbe.model.impl.SimpleAttribute;
import lbe.model.impl.SimpleEntity;
import lbe.model.pageelement.Text;
import lbe.model.pageelement.impl.ConstantText;

public class ConceptEntity extends SimpleEntity{

	public static final ConceptEntity INSTANCE = new ConceptEntity();
	
	
	public static final Attribute<ConceptInstance, String, String> name 
		= new SimpleAttribute<ConceptInstance, String, String>("name", INSTANCE, String.class) {
	
		@Override
		public AttributeValue<ConceptInstance, String> get(
				ConceptInstance instance) {
			return instance.name;
		}
	};
	
	private static final Attribute[] ATTRIBUTES = new Attribute[]{};
	private static final Relation[] RELATIONS = new Relation[]{};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{};
	
	private ConceptEntity() {
		super("Concept", ATTRIBUTES, RELATIONS, REVERSE_RELATIONS);
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new ConceptInstance(caseInstance);
	}

}
