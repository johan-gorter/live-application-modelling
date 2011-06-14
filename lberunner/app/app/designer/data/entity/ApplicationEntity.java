package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class ApplicationEntity extends SimpleEntity {

	public static final ApplicationEntity INSTANCE = new ApplicationEntity();
	
	// Attributes
	
	public static final Attribute<ApplicationInstance, java.lang.String, java.lang.String> name 
		= new SimpleAttribute<ApplicationInstance, java.lang.String, java.lang.String>(
			"name", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<ApplicationInstance, java.lang.String> get(ApplicationInstance instance) {
				return instance.name;
			}
		};
	
	// Relations
	
	public static final Relation<ApplicationInstance, List<EntityInstance>, EntityInstance> entities
		= new SimpleRelation<ApplicationInstance, List<EntityInstance>, EntityInstance>(
			"entities", INSTANCE, ApplicationEntity.INSTANCE, EntityInstance.class, EntityEntity.application
		) {
	
			@Override
			public ReadOnlyRelationValues<ApplicationInstance, EntityInstance> get(
					ApplicationInstance instance) {
				return instance.entities;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<ApplicationInstance, EntityInstance, EntityInstance> caseEntity
		= new SimpleRelation<ApplicationInstance, EntityInstance, EntityInstance>(
			"caseEntity", INSTANCE, ApplicationEntity.INSTANCE, EntityInstance.class, EntityEntity.caseEntityInApplication
		) {
	
			@Override
			public ReadOnlyRelationValue<ApplicationInstance, EntityInstance> get(
					ApplicationInstance instance) {
				return instance.caseEntity;
			}
		};
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		name,
	};
	private static final Relation[] RELATIONS = new Relation[]{
		entities,
		caseEntity,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private ApplicationEntity() {
		super("Application");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new ApplicationInstance();
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
