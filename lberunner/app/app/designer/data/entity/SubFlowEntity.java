package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class SubFlowEntity extends SimpleEntity {

	public static final SubFlowEntity INSTANCE = new SubFlowEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<SubFlowInstance, FlowInstance, FlowInstance> flow
		= new SimpleRelation<SubFlowInstance, FlowInstance, FlowInstance>(
			"flow", INSTANCE, FlowEntity.INSTANCE, FlowInstance.class, FlowEntity.subFlowIn
		) {
	
			@Override
			public ReadOnlyRelationValue<SubFlowInstance, FlowInstance> get(
					SubFlowInstance instance) {
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

	private SubFlowEntity() {
		super("SubFlow");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new SubFlowInstance(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return FlowNodeBaseEntity.INSTANCE;
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
