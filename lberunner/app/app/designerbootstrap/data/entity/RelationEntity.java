package app.designerbootstrap.data.entity;

import java.util.List;

import app.designerbootstrap.data.instance.*;
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
			"to", INSTANCE, RelationEntity.INSTANCE, EntityInstance.class, EntityEntity.reverseRelations
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

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		owner,
		reverseMultivalue,
		reverseName,
	};
	private static final Relation[] RELATIONS = new Relation[]{
		to,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		entity,
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
		return AttributeEntity.INSTANCE;
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