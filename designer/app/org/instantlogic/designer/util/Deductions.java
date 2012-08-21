package org.instantlogic.designer.util;

import org.instantlogic.designer.AttributeDeductionDesign;
import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.ConstantDeductionDesign;
import org.instantlogic.designer.DeductionDesign;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.ReverseRelationDeductionDesign;
import org.instantlogic.designer.SelectedInstanceDeductionDesign;

/**
 * Utilities for creating Deduction(Scheme)Designs
 */
public final class Deductions {

	public static <V> DeductionDesign constant(Class<V> className, V value) {
		ConstantDeductionDesign constantDeductionDesign = new ConstantDeductionDesign();
		constantDeductionDesign.setClassName(className.getName());
		constantDeductionDesign.setValue(value);
		return constantDeductionDesign;
	}
	
	public static DeductionDesign selectedInstance(EntityDesign entity) {
		SelectedInstanceDeductionDesign selectedInstanceDeductionDesign = new SelectedInstanceDeductionDesign();
		selectedInstanceDeductionDesign.setOfEntity(entity);
		selectedInstanceDeductionDesign.setClassName(entity.getApplication().getRootPackageName()+"."+entity.getTechnicalNameCapitalized());
		return selectedInstanceDeductionDesign;
	}
	
	public static DeductionDesign relation(RelationDesign relation, DeductionDesign instance) {
		return attribute(relation, instance);
	}
	
	public static DeductionDesign attribute(AttributeDesign attribute, DeductionDesign instance) {
		String className = attribute.getJavaClassName();
		if (attribute instanceof RelationDesign) {
			// We should come up with a solution that makes this unnecessary
			RelationDesign relation = (RelationDesign)attribute;
			className = relation.getTo().getApplication().getRootPackageName()+"."+relation.getTo().getTechnicalNameCapitalized();
		}
		AttributeDeductionDesign attributeDeductionDesign = new AttributeDeductionDesign();
		attributeDeductionDesign.addToInputs(instance);
		attributeDeductionDesign.setAttribute(attribute);
		if (attribute.getMultivalue()==Boolean.TRUE) {
			attributeDeductionDesign.setClassName("org.instantlogic.fabric.value.Multi<"+className+">");
		} else {
			attributeDeductionDesign.setClassName(className);	
		}
		return attributeDeductionDesign;
	}

	public static DeductionDesign reverseRelation(RelationDesign relation, DeductionDesign instance) {
		String className = relation.getFrom().getApplication().getRootPackageName()+"."+relation.getFrom().getTechnicalNameCapitalized();
		ReverseRelationDeductionDesign deduction = new ReverseRelationDeductionDesign();
		deduction.addToInputs(instance);
		deduction.setRelation(relation);
		if (relation.getReverseMultivalue()==Boolean.TRUE) {
			deduction.setClassName("org.instantlogic.fabric.value.Multi<"+className+">");
		} else {
			deduction.setClassName(className);	
		}
		return deduction; 
	}
	
	
	public static DeductionSchemeDesign toScheme(DeductionDesign deduction) {
		DeductionSchemeDesign scheme = new DeductionSchemeDesign();
		scheme.setOutput(deduction);
		addToScheme(scheme, deduction);
		return scheme;
	}

	private static void addToScheme(DeductionSchemeDesign scheme, DeductionDesign deduction) {
		scheme.addToDeductions(deduction);
		for (DeductionDesign input : deduction.getInputs()) {
			addToScheme(scheme, input);
		}
	}
}
