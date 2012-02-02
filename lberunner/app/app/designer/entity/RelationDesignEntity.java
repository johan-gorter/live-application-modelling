package app.designer.entity;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.model.Relation;
import org.instantlogic.core.model.impl.SimpleAttribute;
import org.instantlogic.core.model.impl.SimpleEntity;
import org.instantlogic.core.model.impl.SimpleRelation;
import org.instantlogic.core.value.ReadOnlyAttributeValue;
import org.instantlogic.core.value.ReadOnlyRelationValue;

import app.designer.EntityDesign;
import app.designer.RelationDesign;

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
	
	public static final Relation<RelationDesign, EntityDesign, EntityDesign> from
		= new SimpleRelation<RelationDesign, EntityDesign, EntityDesign>(
			"from", INSTANCE, RelationDesignEntity.INSTANCE, EntityDesign.class, EntityDesignEntity.relations
		) {
	
			@Override
			public ReadOnlyRelationValue<RelationDesign, EntityDesign> get(
					RelationDesign instance) {
				return instance.from;
			}
	
			public boolean isReverse() {
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
		from,
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
		return AttributeDesignEntity.INSTANCE;
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
