package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class ContainerEntity extends SimpleEntity {

	public static final ContainerEntity INSTANCE = new ContainerEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<ContainerInstance, List<PageElementBaseInstance>, PageElementBaseInstance> elements
		= new SimpleRelation<ContainerInstance, List<PageElementBaseInstance>, PageElementBaseInstance>(
			"elements", INSTANCE, PageElementBaseEntity.INSTANCE, PageElementBaseInstance.class, PageElementBaseEntity.containmentIn
		) {
	
			@Override
			public ReadOnlyRelationValues<ContainerInstance, PageElementBaseInstance> get(
					ContainerInstance instance) {
				return instance.elements;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<ContainerInstance, RelationInstance, RelationInstance> relation
		= new SimpleRelation<ContainerInstance, RelationInstance, RelationInstance>(
			"relation", INSTANCE, RelationEntity.INSTANCE, RelationInstance.class, RelationEntity.relationInContainers
		) {
	
			@Override
			public ReadOnlyRelationValue<ContainerInstance, RelationInstance> get(
					ContainerInstance instance) {
				return instance.relation;
			}
		};
	
	public static final Relation<ContainerInstance, TextInstance, TextInstance> display
		= new SimpleRelation<ContainerInstance, TextInstance, TextInstance>(
			"display", INSTANCE, TextEntity.INSTANCE, TextInstance.class, TextEntity.displayOnContainer
		) {
	
			@Override
			public ReadOnlyRelationValue<ContainerInstance, TextInstance> get(
					ContainerInstance instance) {
				return instance.display;
			}
	
			public boolean isOwner() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<ContainerInstance, PageToolboxInstance, PageToolboxInstance> pageToolbox
		= new SimpleRelation<ContainerInstance, PageToolboxInstance, PageToolboxInstance>(
			"pageToolbox", INSTANCE, ContainerEntity.INSTANCE, PageToolboxInstance.class, PageToolboxEntity.containers
		) {
	
			@Override
			public ReadOnlyRelationValue<ContainerInstance, PageToolboxInstance> get(
					ContainerInstance instance) {
				return instance.pageToolbox;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		elements,
		relation,
		display,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		pageToolbox,
	};

	private ContainerEntity() {
		super("Container");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new ContainerInstance(caseInstance);
	}
	
	@Override
	public Entity extendsEntity() {
		return PageElementBaseEntity.INSTANCE;
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
