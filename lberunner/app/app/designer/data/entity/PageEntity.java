package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class PageEntity extends SimpleEntity {

	public static final PageEntity INSTANCE = new PageEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<PageInstance, ContainerInstance, ContainerInstance> rootContainer
		= new SimpleRelation<PageInstance, ContainerInstance, ContainerInstance>(
			"rootContainer", INSTANCE, ContainerEntity.INSTANCE, ContainerInstance.class, ContainerEntity.rootContainerInPage
		) {
	
			@Override
			public ReadOnlyRelationValue<PageInstance, ContainerInstance> get(
					PageInstance instance) {
				return instance.rootContainer;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
		};
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		rootContainer,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private PageEntity() {
		super("Page");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new PageInstance(caseInstance);
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
