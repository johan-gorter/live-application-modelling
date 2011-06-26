package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class ToolboxEntity extends SimpleEntity {

	public static final ToolboxEntity INSTANCE = new ToolboxEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<ToolboxInstance, List<ContainerInstance>, ContainerInstance> containers
		= new SimpleRelation<ToolboxInstance, List<ContainerInstance>, ContainerInstance>(
			"containers", INSTANCE, ContainerEntity.INSTANCE, ContainerInstance.class, ContainerEntity.toolbox
		) {
	
			@Override
			public ReadOnlyRelationValues<ToolboxInstance, ContainerInstance> get(
					ToolboxInstance instance) {
				return instance.containers;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<ToolboxInstance, List<TextInstance>, TextInstance> texts
		= new SimpleRelation<ToolboxInstance, List<TextInstance>, TextInstance>(
			"texts", INSTANCE, TextEntity.INSTANCE, TextInstance.class, TextEntity.toolbox
		) {
	
			@Override
			public ReadOnlyRelationValues<ToolboxInstance, TextInstance> get(
					ToolboxInstance instance) {
				return instance.texts;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<ToolboxInstance, ApplicationInstance, ApplicationInstance> application
		= new SimpleRelation<ToolboxInstance, ApplicationInstance, ApplicationInstance>(
			"application", INSTANCE, ToolboxEntity.INSTANCE, ApplicationInstance.class, ApplicationEntity.pageToolbox
		) {
	
			@Override
			public ReadOnlyRelationValue<ToolboxInstance, ApplicationInstance> get(
					ToolboxInstance instance) {
				return instance.application;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		containers,
		texts,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		application,
	};

	private ToolboxEntity() {
		super("Toolbox");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new ToolboxInstance(caseInstance);
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
