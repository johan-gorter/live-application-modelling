package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class RelationDesignEntity extends SimpleEntity {

	public static final RelationDesignEntity INSTANCE = new RelationDesignEntity();
	
	// Attributes
	
	public static final Attribute<RelationDesign, java.lang.Boolean, java.lang.Boolean> owner 
		= new SimpleAttribute<RelationDesign, java.lang.Boolean, java.lang.Boolean>(
			"owner", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<RelationDesign, java.lang.Boolean> get(RelationDesign instance) {
				return instance.owner;
			}
		};
	
	public static final Attribute<RelationDesign, java.lang.Boolean, java.lang.Boolean> autoCreate 
		= new SimpleAttribute<RelationDesign, java.lang.Boolean, java.lang.Boolean>(
			"autoCreate", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<RelationDesign, java.lang.Boolean> get(RelationDesign instance) {
				return instance.autoCreate;
			}
		};
	
	public static final Attribute<RelationDesign, java.lang.Boolean, java.lang.Boolean> reverseMultivalue 
		= new SimpleAttribute<RelationDesign, java.lang.Boolean, java.lang.Boolean>(
			"reverseMultivalue", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<RelationDesign, java.lang.Boolean> get(RelationDesign instance) {
				return instance.reverseMultivalue;
			}
		};
	
	public static final Attribute<RelationDesign, java.lang.String, java.lang.String> reverseName 
		= new SimpleAttribute<RelationDesign, java.lang.String, java.lang.String>(
			"reverseName", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<RelationDesign, java.lang.String> get(RelationDesign instance) {
				return instance.reverseName;
			}
		};
	
	// Relations
	
	public static final Relation<RelationDesign, EntityDesign, EntityDesign> to
		= new SimpleRelation<RelationDesign, EntityDesign, EntityDesign>(
			"to", INSTANCE, EntityDesignEntity.INSTANCE, EntityDesign.class, EntityDesignEntity.reverseRelations
		) {
	
			@Override
			public ReadOnlyRelationValue<RelationDesign, EntityDesign> get(
					RelationDesign instance) {
				return instance.to;
			}
		};
	
	// Reverse relations
	
	public static final Relation<RelationDesign, EntityDesign, EntityDesign> entity
		= new SimpleRelation<RelationDesign, EntityDesign, EntityDesign>(
			"entity", INSTANCE, RelationDesignEntity.INSTANCE, EntityDesign.class, EntityDesignEntity.relations
		) {
	
			@Override
			public ReadOnlyRelationValue<RelationDesign, EntityDesign> get(
					RelationDesign instance) {
				return instance.entity;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<RelationDesign, List<SelectDesign>, SelectDesign> relationInselects
		= new SimpleRelation<RelationDesign, List<SelectDesign>, SelectDesign>(
			"relationInselects", INSTANCE, RelationDesignEntity.INSTANCE, SelectDesign.class, SelectDesignEntity.relation
		) {
	
			@Override
			public ReadOnlyRelationValues<RelationDesign, SelectDesign> get(
					RelationDesign instance) {
				return instance.relationInselects;
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
		relationInselects,
	};

	private RelationDesignEntity() {
		super("RelationDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new RelationDesign(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return AttributeBaseDesignEntity.INSTANCE;
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
