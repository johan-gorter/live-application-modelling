package app.designer.entity;

import java.util.List;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.model.Relation;
import org.instantlogic.core.model.impl.SimpleEntity;
import org.instantlogic.core.model.impl.SimpleRelation;
import org.instantlogic.core.value.ReadOnlyRelationValue;
import org.instantlogic.core.value.ReadOnlyRelationValues;

import app.designer.FlowDesign;
import app.designer.FlowEdgeDesign;
import app.designer.FlowNodeBaseDesign;
import app.designer.FlowSourceDesign;

public class FlowNodeBaseDesignEntity extends SimpleEntity {

	public static final FlowNodeBaseDesignEntity INSTANCE = new FlowNodeBaseDesignEntity();
	
	// Attributes
	
	// Relations
	
	// Reverse relations
	
	public static final Relation<FlowNodeBaseDesign, FlowDesign, FlowDesign> owner
		= new SimpleRelation<FlowNodeBaseDesign, FlowDesign, FlowDesign>(
			"owner", INSTANCE, FlowNodeBaseDesignEntity.INSTANCE, FlowDesign.class, FlowDesignEntity.nodes
		) {
	
			@Override
			public ReadOnlyRelationValue<FlowNodeBaseDesign, FlowDesign> get(
					FlowNodeBaseDesign instance) {
				return instance.owner;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<FlowNodeBaseDesign, List<FlowSourceDesign>, FlowSourceDesign> incomingSources
		= new SimpleRelation<FlowNodeBaseDesign, List<FlowSourceDesign>, FlowSourceDesign>(
			"incomingSources", INSTANCE, FlowNodeBaseDesignEntity.INSTANCE, FlowSourceDesign.class, FlowSourceDesignEntity.endNode
		) {
	
			@Override
			public ReadOnlyRelationValues<FlowNodeBaseDesign, FlowSourceDesign> get(
					FlowNodeBaseDesign instance) {
				return instance.incomingSources;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<FlowNodeBaseDesign, List<FlowEdgeDesign>, FlowEdgeDesign> outgoingEdges
		= new SimpleRelation<FlowNodeBaseDesign, List<FlowEdgeDesign>, FlowEdgeDesign>(
			"outgoingEdges", INSTANCE, FlowNodeBaseDesignEntity.INSTANCE, FlowEdgeDesign.class, FlowEdgeDesignEntity.startNode
		) {
	
			@Override
			public ReadOnlyRelationValues<FlowNodeBaseDesign, FlowEdgeDesign> get(
					FlowNodeBaseDesign instance) {
				return instance.outgoingEdges;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<FlowNodeBaseDesign, List<FlowEdgeDesign>, FlowEdgeDesign> incomingEdges
		= new SimpleRelation<FlowNodeBaseDesign, List<FlowEdgeDesign>, FlowEdgeDesign>(
			"incomingEdges", INSTANCE, FlowNodeBaseDesignEntity.INSTANCE, FlowEdgeDesign.class, FlowEdgeDesignEntity.endNode
		) {
	
			@Override
			public ReadOnlyRelationValues<FlowNodeBaseDesign, FlowEdgeDesign> get(
					FlowNodeBaseDesign instance) {
				return instance.incomingEdges;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		owner,
		incomingSources,
		outgoingEdges,
		incomingEdges,
	};

	private FlowNodeBaseDesignEntity() {
		super("FlowNodeBaseDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new FlowNodeBaseDesign(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return DesignEntity.INSTANCE;
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
