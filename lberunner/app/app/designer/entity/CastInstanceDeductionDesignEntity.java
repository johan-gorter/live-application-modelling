package app.designer.entity;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.model.impl.SimpleEntity;
import org.instantlogic.fabric.model.impl.SimpleRelation;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;

import app.designer.CastInstanceDeductionDesign;
import app.designer.EntityDesign;

public class CastInstanceDeductionDesignEntity extends SimpleEntity {

	public static final CastInstanceDeductionDesignEntity INSTANCE = new CastInstanceDeductionDesignEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<CastInstanceDeductionDesign, EntityDesign, EntityDesign> entity
		= new SimpleRelation<CastInstanceDeductionDesign, EntityDesign, EntityDesign>(
			"entity", INSTANCE, EntityDesignEntity.INSTANCE, EntityDesign.class, EntityDesignEntity.entityInCastDeductions
		) {
	
			@Override
			public ReadOnlyRelationValue<CastInstanceDeductionDesign, EntityDesign> get(
					CastInstanceDeductionDesign instance) {
				return instance.entity;
			}
		};
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		entity,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private CastInstanceDeductionDesignEntity() {
		super("CastInstanceDeductionDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new CastInstanceDeductionDesign(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return DeductionDesignEntity.INSTANCE;
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
