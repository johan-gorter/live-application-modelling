package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class PageElementBaseEntity extends SimpleEntity {

	public static final PageElementBaseEntity INSTANCE = new PageElementBaseEntity();
	
	// Attributes
	
	// Relations
	
	// Reverse relations
	
	public static final Relation<PageElementBaseInstance, ContainerItemInstance, ContainerItemInstance> containerItem
		= new SimpleRelation<PageElementBaseInstance, ContainerItemInstance, ContainerItemInstance>(
			"containerItem", INSTANCE, PageElementBaseEntity.INSTANCE, ContainerItemInstance.class, ContainerItemEntity.element
		) {
	
			@Override
			public ReadOnlyRelationValue<PageElementBaseInstance, ContainerItemInstance> get(
					PageElementBaseInstance instance) {
				return instance.containerItem;
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
		containerItem,
	};

	private PageElementBaseEntity() {
		super("PageElementBase");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new PageElementBaseInstance(caseInstance);
	}
	
	@Override
	public Entity extendsEntity() {
		return ConceptEntity.INSTANCE;
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
