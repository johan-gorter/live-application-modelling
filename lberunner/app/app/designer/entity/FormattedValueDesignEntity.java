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
import app.designer.FormattedValueDesign;
import lbe.model.deduction.*;

public class FormattedValueDesignEntity extends SimpleEntity {

	public static final FormattedValueDesignEntity INSTANCE = new FormattedValueDesignEntity();

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final Relation<FormattedValueDesign, DeductionSchemeDesign, DeductionSchemeDesign> deduction
		= new SimpleRelation<FormattedValueDesign, DeductionSchemeDesign, DeductionSchemeDesign>(
			"deduction", INSTANCE, DeductionSchemeDesignEntity.INSTANCE, DeductionSchemeDesign.class, DeductionSchemeDesignEntity.templatedText
		) {
	
			@Override
			public ReadOnlyRelationValue<FormattedValueDesign, DeductionSchemeDesign> get(
					FormattedValueDesign instance) {
				return instance.deduction;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
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

	private FormattedValueDesignEntity() {
		super("FormattedValueDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new FormattedValueDesign(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return StringProducerDesignEntity.INSTANCE;
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
