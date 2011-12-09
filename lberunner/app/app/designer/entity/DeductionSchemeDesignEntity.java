package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class DeductionSchemeDesignEntity extends SimpleEntity {

	public static final DeductionSchemeDesignEntity INSTANCE = new DeductionSchemeDesignEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<DeductionSchemeDesign, List<DeductionDesign>, DeductionDesign> deductions
		= new SimpleRelation<DeductionSchemeDesign, List<DeductionDesign>, DeductionDesign>(
			"deductions", INSTANCE, DeductionDesignEntity.INSTANCE, DeductionDesign.class, DeductionDesignEntity.scheme
		) {
	
			@Override
			public ReadOnlyRelationValues<DeductionSchemeDesign, DeductionDesign> get(
					DeductionSchemeDesign instance) {
				return instance.deductions;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<DeductionSchemeDesign, DeductionDesign, DeductionDesign> output
		= new SimpleRelation<DeductionSchemeDesign, DeductionDesign, DeductionDesign>(
			"output", INSTANCE, DeductionDesignEntity.INSTANCE, DeductionDesign.class, DeductionDesignEntity.schemeOutput
		) {
	
			@Override
			public ReadOnlyRelationValue<DeductionSchemeDesign, DeductionDesign> get(
					DeductionSchemeDesign instance) {
				return instance.output;
			}
		};
	
	// Reverse relations
	
	public static final Relation<DeductionSchemeDesign, FormattedValueDesign, FormattedValueDesign> templatedText
		= new SimpleRelation<DeductionSchemeDesign, FormattedValueDesign, FormattedValueDesign>(
			"templatedText", INSTANCE, DeductionSchemeDesignEntity.INSTANCE, FormattedValueDesign.class, FormattedValueDesignEntity.deduction
		) {
	
			@Override
			public ReadOnlyRelationValue<DeductionSchemeDesign, FormattedValueDesign> get(
					DeductionSchemeDesign instance) {
				return instance.templatedText;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<DeductionSchemeDesign, SelectDesign, SelectDesign> select
		= new SimpleRelation<DeductionSchemeDesign, SelectDesign, SelectDesign>(
			"select", INSTANCE, DeductionSchemeDesignEntity.INSTANCE, SelectDesign.class, SelectDesignEntity.deduction
		) {
	
			@Override
			public ReadOnlyRelationValue<DeductionSchemeDesign, SelectDesign> get(
					DeductionSchemeDesign instance) {
				return instance.select;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		deductions,
		output,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		templatedText,
		select,
	};

	private DeductionSchemeDesignEntity() {
		super("DeductionSchemeDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new DeductionSchemeDesign(caseInstance, id);
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
