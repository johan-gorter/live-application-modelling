package app.designer.entity;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.model.Relation;
import org.instantlogic.core.model.impl.SimpleEntity;
import org.instantlogic.core.model.impl.SimpleRelation;
import org.instantlogic.core.value.ReadOnlyRelationValue;

import app.designer.DeductionSchemeDesign;
import app.designer.SelectDesign;

public class SelectDesignEntity extends SimpleEntity {

	public static final SelectDesignEntity INSTANCE = new SelectDesignEntity();
	
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
