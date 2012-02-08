package app.designer.entity;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.model.impl.SimpleEntity;
import org.instantlogic.fabric.model.impl.SimpleRelation;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;

import app.designer.AttributeDeductionDesign;
import app.designer.AttributeDesign;

public class AttributeDeductionDesignEntity extends SimpleEntity {

	public static final AttributeDeductionDesignEntity INSTANCE = new AttributeDeductionDesignEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<AttributeDeductionDesign, AttributeDesign, AttributeDesign> attribute
		= new SimpleRelation<AttributeDeductionDesign, AttributeDesign, AttributeDesign>(
			"attribute", INSTANCE, AttributeDesignEntity.INSTANCE, AttributeDesign.class, AttributeDesignEntity.attributeInDeductions
		) {
	
			@Override
			public ReadOnlyRelationValue<AttributeDeductionDesign, AttributeDesign> get(
					AttributeDeductionDesign instance) {
				return instance.attribute;
			}
		};
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		attribute,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private AttributeDeductionDesignEntity() {
		super("AttributeDeductionDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new AttributeDeductionDesign(caseInstance, id);
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
