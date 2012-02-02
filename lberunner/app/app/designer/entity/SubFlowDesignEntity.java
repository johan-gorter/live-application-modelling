package app.designer.entity;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.model.Relation;
import org.instantlogic.core.model.impl.SimpleEntity;
import org.instantlogic.core.model.impl.SimpleRelation;
import org.instantlogic.core.value.ReadOnlyRelationValue;

import app.designer.FlowDesign;
import app.designer.SubFlowDesign;

public class SubFlowDesignEntity extends SimpleEntity {

	public static final SubFlowDesignEntity INSTANCE = new SubFlowDesignEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<SubFlowDesign, FlowDesign, FlowDesign> flow
		= new SimpleRelation<SubFlowDesign, FlowDesign, FlowDesign>(
			"flow", INSTANCE, FlowDesignEntity.INSTANCE, FlowDesign.class, FlowDesignEntity.subFlowIn
		) {
	
			@Override
			public ReadOnlyRelationValue<SubFlowDesign, FlowDesign> get(
					SubFlowDesign instance) {
				return instance.flow;
			}
		};
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		flow,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private SubFlowDesignEntity() {
		super("SubFlowDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new SubFlowDesign(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return FlowNodeBaseDesignEntity.INSTANCE;
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
