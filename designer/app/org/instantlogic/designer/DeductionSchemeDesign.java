package org.instantlogic.designer;



public class DeductionSchemeDesign extends AbstractDeductionSchemeDesign {

	public DeductionDesign deduceSelectedInstance(EntityDesign entity) {
		SelectedInstanceDeductionDesign selectedInstanceDeductionDesign = new SelectedInstanceDeductionDesign();
		
		addToDeductions(selectedInstanceDeductionDesign);
		setOutput(selectedInstanceDeductionDesign);
		
		selectedInstanceDeductionDesign.setOfEntity(entity);
		selectedInstanceDeductionDesign.setJavaClassName(entity.getApplication().getRootPackageName()+"."+entity.getTechnicalNameCapitalized());
		return selectedInstanceDeductionDesign;
	}

	public DeductionDesign deduceAttribute(AttributeDesign attribute) {
		return deduceAttribute(attribute, null);
	}

	public DeductionDesign deduceAttribute(AttributeDesign attribute, DeductionDesign instanceDeduction) {
		if (instanceDeduction==null) {
			instanceDeduction = deduceSelectedInstance(attribute.getBelongsToEntity());
		}
		String className = attribute.getDataType().getJavaClassName();
		AttributeDeductionDesign attributeDeductionDesign = new AttributeDeductionDesign();
		
		addToDeductions(attributeDeductionDesign);
		setOutput(attributeDeductionDesign);
		
		attributeDeductionDesign.addToInputs(instanceDeduction);
		attributeDeductionDesign.setAttribute(attribute);
		if (attribute.getDataType().getMultivalue()==Boolean.TRUE) {
			attributeDeductionDesign.setJavaClassName("org.instantlogic.fabric.value.Multi<"+className+">");
		} else {
			attributeDeductionDesign.setJavaClassName(className);	
		}
		return attributeDeductionDesign;
		
	}

	public DeductionDesign deduceRelation(RelationDesign relation, DeductionDesign instance) {
		if (instance==null) {
			instance = deduceSelectedInstance(relation.getFrom());
		}
		return deduceAttribute(relation, instance);
	}

	public DeductionDesign deduceRelation(RelationDesign relation) {
		return deduceRelation(relation, null);
	}
	
	public <V> DeductionDesign deduceConstant(Class<V> className, V value) {
		ConstantDeductionDesign constantDeductionDesign = new ConstantDeductionDesign();

		addToDeductions(constantDeductionDesign);
		setOutput(constantDeductionDesign);
		
		constantDeductionDesign.setJavaClassName(className.getName());
		constantDeductionDesign.setValue(value);
		return constantDeductionDesign;
	}
	
	public DeductionDesign deduceCustom(Class<?> deductionClass, Class<?> resultClass) {
		return deduceCustom(deductionClass.getName(), resultClass.getName());
	}

	public DeductionDesign deduceCustom(String javaClassName, String resultClassName) {
		DeductionDesign result = new DeductionDesign();

		addToDeductions(result);
		setOutput(result);
		
		result.setCustomization(javaClassName);
		result.setJavaClassName(resultClassName);
		return result;
	}
	
	public DeductionDesign deduceHasValue(DeductionDesign input) {
		HasValueDeductionDesign result = new HasValueDeductionDesign();

		addToDeductions(result);
		setOutput(result);
		
		result.addToInputs(input);
		result.setJavaClassName("java.lang.Boolean");
		return result;
	}

	
	public DeductionDesign deduceReverseRelation(RelationDesign relation, DeductionDesign instance) {
		String className = relation.getFrom().getApplication().getRootPackageName()+"."+relation.getFrom().getTechnicalNameCapitalized();
		ReverseRelationDeductionDesign result = new ReverseRelationDeductionDesign();
		
		addToDeductions(result);
		setOutput(result);
		
		result.addToInputs(instance);
		result.setRelation(relation);
		if (relation.getReverseMultivalue()==Boolean.TRUE) {
			result.setJavaClassName("org.instantlogic.fabric.value.Multi<"+className+">");
		} else {
			result.setJavaClassName(className);	
		}
		return result; 
	}
}
