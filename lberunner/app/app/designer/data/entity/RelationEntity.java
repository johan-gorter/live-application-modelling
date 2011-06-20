package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class RelationEntity extends SimpleEntity {

	public static final RelationEntity INSTANCE = new RelationEntity();
	
	// Attributes
	
	public static final Attribute<RelationInstance, java.lang.Boolean, java.lang.Boolean> owner 
		= new SimpleAttribute<RelationInstance, java.lang.Boolean, java.lang.Boolean>(
			"owner", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<RelationInstance, java.lang.Boolean> get(RelationInstance instance) {
				return instance.owner;
			}
		};
	
	public static final Attribute<RelationInstance, java.lang.Boolean, java.lang.Boolean> autoCreate 
		= new SimpleAttribute<RelationInstance, java.lang.Boolean, java.lang.Boolean>(
			"autoCreate", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<RelationInstance, java.lang.Boolean> get(RelationInstance instance) {
				return instance.autoCreate;
			}
		};
	
	public static final Attribute<RelationInstance, java.lang.Boolean, java.lang.Boolean> reverseMultivalue 
		= new SimpleAttribute<RelationInstance, java.lang.Boolean, java.lang.Boolean>(
			"reverseMultivalue", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<RelationInstance, java.lang.Boolean> get(RelationInstance instance) {
				return instance.reverseMultivalue;
			}
		};
	
	public static final Attribute<RelationInstance, java.lang.String, java.lang.String> reverseName 
		= new SimpleAttribute<RelationInstance, java.lang.String, java.lang.String>(
			"reverseName", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<RelationInstance, java.lang.String> get(RelationInstance instance) {
				return instance.reverseName;
			}
		};
	
	// Relations
	
	public static final Relation<RelationInstance, EntityInstance, EntityInstance> to
		= new SimpleRelation<RelationInstance, EntityInstance, EntityInstance>(
			"to", INSTANCE, EntityEntity.INSTANCE, EntityInstance.class, EntityEntity.reverseRelations
		) {
	
			@Override
			public ReadOnlyRelationValue<RelationInstance, EntityInstance> get(
					RelationInstance instance) {
				return instance.to;
			}
		};
	
	// Reverse relations
	
	public static final Relation<RelationInstance, EntityInstance, EntityInstance> entity
		= new SimpleRelation<RelationInstance, EntityInstance, EntityInstance>(
			"entity", INSTANCE, RelationEntity.INSTANCE, EntityInstance.class, EntityEntity.relations
		) {
	
			@Override
			public ReadOnlyRelationValue<RelationInstance, EntityInstance> get(
					RelationInstance instance) {
				return instance.entity;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<RelationInstance, List<ContainerInstance>, ContainerInstance> relationInContainers
		= new SimpleRelation<RelationInstance, List<ContainerInstance>, ContainerInstance>(
			"relationInContainers", INSTANCE, RelationEntity.INSTANCE, ContainerInstance.class, ContainerEntity.relation
		) {
	
			@Override
			public ReadOnlyRelationValues<RelationInstance, ContainerInstance> get(
					RelationInstance instance) {
				return instance.relationInContainers;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		owner,
		autoCreate,
		reverseMultivalue,
		reverseName,
	};
	private static final Relation[] RELATIONS = new Relation[]{
		to,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		entity,
		relationInContainers,
	};

	private RelationEntity() {
		super("Relation");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new RelationInstance(caseInstance);
	}
	
	@Override
	public Entity extendsEntity() {
		return AttributeBaseEntity.INSTANCE;
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
