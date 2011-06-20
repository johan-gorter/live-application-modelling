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
	
	public static final Relation<PageElementBaseInstance, List<PageInstance>, PageInstance> rootElementInPages
		= new SimpleRelation<PageElementBaseInstance, List<PageInstance>, PageInstance>(
			"rootElementInPages", INSTANCE, PageElementBaseEntity.INSTANCE, PageInstance.class, PageEntity.rootElements
		) {
	
			@Override
			public ReadOnlyRelationValues<PageElementBaseInstance, PageInstance> get(
					PageElementBaseInstance instance) {
				return instance.rootElementInPages;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<PageElementBaseInstance, List<ContainerInstance>, ContainerInstance> containmentIn
		= new SimpleRelation<PageElementBaseInstance, List<ContainerInstance>, ContainerInstance>(
			"containmentIn", INSTANCE, PageElementBaseEntity.INSTANCE, ContainerInstance.class, ContainerEntity.elements
		) {
	
			@Override
			public ReadOnlyRelationValues<PageElementBaseInstance, ContainerInstance> get(
					PageElementBaseInstance instance) {
				return instance.containmentIn;
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
		rootElementInPages,
		containmentIn,
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
