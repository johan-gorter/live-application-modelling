package app.designer.entity;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.model.impl.SimpleEntity;
import org.instantlogic.fabric.model.impl.SimpleRelation;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;

import app.designer.DeductionSchemeDesign;
import app.designer.SelectDesign;
import lbe.model.deduction.*;

public class SelectDesignEntity extends SimpleEntity {

	public static final SelectDesignEntity INSTANCE = new SelectDesignEntity();

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final Relation<SelectDesign, DeductionSchemeDesign, DeductionSchemeDesign> deduction
		= new SimpleRelation<SelectDesign, DeductionSchemeDesign, DeductionSchemeDesign>(
			"deduction", INSTANCE, DeductionSchemeDesignEntity.INSTANCE, DeductionSchemeDesign.class, DeductionSchemeDesignEntity.select
		) {
	
			@Override
			public ReadOnlyRelationValue<SelectDesign, DeductionSchemeDesign> get(
					SelectDesign instance) {
				return instance.deduction;
			}
	
			public boolean isOwner() {
				return true;
			}
			
		};
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		deduction,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private SelectDesignEntity() {
		super("SelectDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new SelectDesign(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return CompositePageFragmentDesignEntity.INSTANCE;
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
