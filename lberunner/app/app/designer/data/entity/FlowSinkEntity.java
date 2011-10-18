package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class FlowSinkEntity extends SimpleEntity {

	public static final FlowSinkEntity INSTANCE = new FlowSinkEntity();
	
	// Attributes
	
	// Relations
	
	// Reverse relations
	
	public static final Relation<FlowSinkInstance, FlowInstance, FlowInstance> owner
		= new SimpleRelation<FlowSinkInstance, FlowInstance, FlowInstance>(
			"owner", INSTANCE, FlowSinkEntity.INSTANCE, FlowInstance.class, FlowEntity.sinks
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowSinkInstance, FlowInstance> get(
					FlowSinkInstance instance) {
				return instance.owner;
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
		owner,
	};

	private FlowSinkEntity() {
		super("FlowSink");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new FlowSinkInstance(caseInstance, id);
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
