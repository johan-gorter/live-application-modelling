package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import lbe.model.deduction.*;

public class AttributeDeductionDesignEntity extends SimpleEntity {

	public static final AttributeDeductionDesignEntity INSTANCE = new AttributeDeductionDesignEntity();

	// Deductions
	
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
