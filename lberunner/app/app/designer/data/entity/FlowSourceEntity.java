package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class FlowSourceEntity extends SimpleEntity {

	public static final FlowSourceEntity INSTANCE = new FlowSourceEntity();
	
	// Attributes
	
	// Relations
	
	// Reverse relations
	
	public static final Relation<FlowSourceInstance, FlowInstance, FlowInstance> flow
		= new SimpleRelation<FlowSourceInstance, FlowInstance, FlowInstance>(
			"flow", INSTANCE, FlowSourceEntity.INSTANCE, FlowInstance.class, FlowEntity.sources
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowSourceInstance, FlowInstance> get(
					FlowSourceInstance instance) {
				return instance.flow;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		flow,
	};

	private FlowSourceEntity() {
		super("FlowSource");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new FlowSourceInstance(caseInstance, id);
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
