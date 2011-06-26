package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class ContainerItemEntity extends SimpleEntity {

	public static final ContainerItemEntity INSTANCE = new ContainerItemEntity();
	
	// Attributes
	
	public static final Attribute<ContainerItemInstance, List<java.lang.String>, java.lang.String> presentationStyles 
		= new SimpleAttribute<ContainerItemInstance, List<java.lang.String>, java.lang.String>(
			"presentationStyles", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValues<ContainerItemInstance, java.lang.String> get(ContainerItemInstance instance) {
				return instance.presentationStyles;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	// Relations
	
	public static final Relation<ContainerItemInstance, PageElementBaseInstance, PageElementBaseInstance> element
		= new SimpleRelation<ContainerItemInstance, PageElementBaseInstance, PageElementBaseInstance>(
			"element", INSTANCE, PageElementBaseEntity.INSTANCE, PageElementBaseInstance.class, PageElementBaseEntity.containerItem
		) {
	
			@Override
			public ReadOnlyRelationValue<ContainerItemInstance, PageElementBaseInstance> get(
					ContainerItemInstance instance) {
				return instance.element;
			}
	
			public boolean isOwner() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<ContainerItemInstance, ContainerInstance, ContainerInstance> container
		= new SimpleRelation<ContainerItemInstance, ContainerInstance, ContainerInstance>(
			"container", INSTANCE, ContainerItemEntity.INSTANCE, ContainerInstance.class, ContainerEntity.items
		) {
	
			@Override
			public ReadOnlyRelationValue<ContainerItemInstance, ContainerInstance> get(
					ContainerItemInstance instance) {
				return instance.container;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		presentationStyles,
	};
	private static final Relation[] RELATIONS = new Relation[]{
		element,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		container,
	};

	private ContainerItemEntity() {
		super("ContainerItem");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new ContainerItemInstance(caseInstance);
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
