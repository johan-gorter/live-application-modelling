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
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		presentationStyles,
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private ContainerItemEntity() {
		super("ContainerItem");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new ContainerItemInstance(caseInstance);
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
