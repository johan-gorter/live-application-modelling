package org.instantlogic.designer.util;

import org.instantlogic.designer.AttributeDeductionDesign;
import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.ConstantDeductionDesign;
import org.instantlogic.designer.DeductionDesign;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.HasValueDeductionDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.ReverseRelationDeductionDesign;
import org.instantlogic.designer.SelectedInstanceDeductionDesign;
import org.instantlogic.designer.deduction.DataTypeJavaClassNameDeduction;

/**
 * Utilities for creating Deduction(Scheme)Designs
 */
public final class Deductions {

	public static <V> DeductionDesign constant(Class<V> className, V value) {
		ConstantDeductionDesign constantDeductionDesign = new ConstantDeductionDesign();
		constantDeductionDesign.setJavaClassName(className.getName());
		constantDeductionDesign.setValue(value);
		return constantDeductionDesign;
	}
	
	public static DeductionDesign selectedInstance(EntityDesign entity) {
		SelectedInstanceDeductionDesign selectedInstanceDeductionDesign = new SelectedInstanceDeductionDesign();
		selectedInstanceDeductionDesign.setOfEntity(entity);
		selectedInstanceDeductionDesign.setJavaClassName(entity.getApplication().getRootPackageName()+"."+entity.getTechnicalNameCapitalized());
		return selectedInstanceDeductionDesign;
	}
	
	public static DeductionDesign relation(RelationDesign relation, DeductionDesign instance) {
		if (instance==null) {
			instance = selectedInstance(relation.getFrom());
		}
		return attribute(relation, instance);
	}

	public static DeductionDesign relation(RelationDesign relation) {
		return relation(relation, null);
	}
	
	public static DeductionDesign attribute(AttributeDesign attribute) {
		return attribute(attribute, null);
	}
	
	public static DeductionDesign attribute(AttributeDesign attribute, DeductionDesign instance) {
		if (instance==null) {
			instance = selectedInstance(attribute.getBelongsToEntity());
		}
		String className = attribute.getDataType().getJavaClassName();
		if (attribute instanceof RelationDesign) {
			// We should come up with a solution that makes this unnecessary
			RelationDesign relation = (RelationDesign)attribute;
			className = relation.getTo().getApplication().getRootPackageName()+"."+relation.getTo().getTechnicalNameCapitalized();
		}
		AttributeDeductionDesign attributeDeductionDesign = new AttributeDeductionDesign();
		attributeDeductionDesign.addToInputs(instance);
		attributeDeductionDesign.setAttribute(attribute);
		if (attribute.getDataType().getMultivalue()==Boolean.TRUE) {
			attributeDeductionDesign.setJavaClassName("org.instantlogic.fabric.value.Multi<"+className+">");
		} else {
			attributeDeductionDesign.setJavaClassName(className);	
		}
		return attributeDeductionDesign;
	}

	public static DeductionDesign hasValue(DeductionDesign input) {
		HasValueDeductionDesign deduction = new HasValueDeductionDesign();
		deduction.addToInputs(input);
		deduction.setJavaClassName("java.lang.Boolean");
		return deduction;
	}

	
	public static DeductionDesign reverseRelation(RelationDesign relation, DeductionDesign instance) {
		String className = relation.getFrom().getApplication().getRootPackageName()+"."+relation.getFrom().getTechnicalNameCapitalized();
		ReverseRelationDeductionDesign deduction = new ReverseRelationDeductionDesign();
		deduction.addToInputs(instance);
		deduction.setRelation(relation);
		if (relation.getReverseMultivalue()==Boolean.TRUE) {
			deduction.setJavaClassName("org.instantlogic.fabric.value.Multi<"+className+">");
		} else {
			deduction.setJavaClassName(className);	
		}
		return deduction; 
	}
	
	
	public static DeductionSchemeDesign toScheme(DeductionDesign deduction) {
		DeductionSchemeDesign scheme = new DeductionSchemeDesign();
		addToScheme(scheme, deduction);
		scheme.setOutput(deduction);
		return scheme;
	}

	private static void addToScheme(DeductionSchemeDesign scheme, DeductionDesign deduction) {
		scheme.addToDeductions(deduction);
		for (DeductionDesign input : deduction.getInputs()) {
			addToScheme(scheme, input);
		}
	}

	public static DeductionDesign custom(Class<DataTypeJavaClassNameDeduction> deductionClass, Class<?> resultClass) {
		return custom(deductionClass.getName(), resultClass.getName());
	}

	public static DeductionDesign custom(String javaClassName, String resultClassName) {
		DeductionDesign result = new DeductionDesign();
		result.setCustomization(javaClassName);
		result.setJavaClassName(resultClassName);
		return result;
	}
}
