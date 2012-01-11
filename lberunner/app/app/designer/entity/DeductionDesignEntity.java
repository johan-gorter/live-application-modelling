package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class DeductionDesignEntity extends SimpleEntity {

	public static final DeductionDesignEntity INSTANCE = new DeductionDesignEntity();
	
	// Attributes
	
	public static final Attribute<DeductionDesign, java.lang.Boolean, java.lang.Boolean> multivalue 
		= new SimpleAttribute<DeductionDesign, java.lang.Boolean, java.lang.Boolean>(
			"multivalue", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<DeductionDesign, java.lang.Boolean> get(DeductionDesign instance) {
				return instance.multivalue;
			}
		};
	
	public static final Attribute<DeductionDesign, java.lang.String, java.lang.String> className 
		= new SimpleAttribute<DeductionDesign, java.lang.String, java.lang.String>(
			"className", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<DeductionDesign, java.lang.String> get(DeductionDesign instance) {
				return instance.className;
			}
		};
	
	public static final Attribute<DeductionDesign, java.lang.String, java.lang.String> customization 
		= new SimpleAttribute<DeductionDesign, java.lang.String, java.lang.String>(
			"customization", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<DeductionDesign, java.lang.String> get(DeductionDesign instance) {
				return instance.customization;
			}
		};
	
	// Relations
	
	public static final Relation<DeductionDesign, List<DeductionDesign>, DeductionDesign> inputs
		= new SimpleRelation<DeductionDesign, List<DeductionDesign>, DeductionDesign>(
			"inputs", INSTANCE, DeductionDesignEntity.INSTANCE, DeductionDesign.class, DeductionDesignEntity.outputs
		) {
	
			@Override
			public ReadOnlyRelationValues<DeductionDesign, DeductionDesign> get(
					DeductionDesign instance) {
				return instance.inputs;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<DeductionDesign, DeductionSchemeDesign, DeductionSchemeDesign> scheme
		= new SimpleRelation<DeductionDesign, DeductionSchemeDesign, DeductionSchemeDesign>(
			"scheme", INSTANCE, DeductionDesignEntity.INSTANCE, DeductionSchemeDesign.class, DeductionSchemeDesignEntity.deductions
		) {
	
			@Override
			public ReadOnlyRelationValue<DeductionDesign, DeductionSchemeDesign> get(
					DeductionDesign instance) {
				return instance.scheme;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<DeductionDesign, DeductionSchemeDesign, DeductionSchemeDesign> schemeOutput
		= new SimpleRelation<DeductionDesign, DeductionSchemeDesign, DeductionSchemeDesign>(
			"schemeOutput", INSTANCE, DeductionDesignEntity.INSTANCE, DeductionSchemeDesign.class, DeductionSchemeDesignEntity.output
		) {
	
			@Override
			public ReadOnlyRelationValue<DeductionDesign, DeductionSchemeDesign> get(
					DeductionDesign instance) {
				return instance.schemeOutput;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<DeductionDesign, List<DeductionDesign>, DeductionDesign> outputs
		= new SimpleRelation<DeductionDesign, List<DeductionDesign>, DeductionDesign>(
			"outputs", INSTANCE, DeductionDesignEntity.INSTANCE, DeductionDesign.class, DeductionDesignEntity.inputs
		) {
	
			@Override
			public ReadOnlyRelationValues<DeductionDesign, DeductionDesign> get(
					DeductionDesign instance) {
				return instance.outputs;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		multivalue,
		className,
		customization,
	};
	private static final Relation[] RELATIONS = new Relation[]{
		inputs,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		scheme,
		schemeOutput,
		outputs,
	};

	private DeductionDesignEntity() {
		super("DeductionDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new DeductionDesign(caseInstance, id);
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
