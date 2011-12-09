package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class SelectedInstanceDeductionDesignEntity extends SimpleEntity {

	public static final SelectedInstanceDeductionDesignEntity INSTANCE = new SelectedInstanceDeductionDesignEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<SelectedInstanceDeductionDesign, EntityDesign, EntityDesign> entity
		= new SimpleRelation<SelectedInstanceDeductionDesign, EntityDesign, EntityDesign>(
			"entity", INSTANCE, EntityDesignEntity.INSTANCE, EntityDesign.class, EntityDesignEntity.entityInDeductions
		) {
	
			@Override
			public ReadOnlyRelationValue<SelectedInstanceDeductionDesign, EntityDesign> get(
					SelectedInstanceDeductionDesign instance) {
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

	private SelectedInstanceDeductionDesignEntity() {
		super("SelectedInstanceDeductionDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new SelectedInstanceDeductionDesign(caseInstance, id);
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
