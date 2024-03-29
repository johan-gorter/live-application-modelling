package org.instantlogic.designer;



public class DeductionSchemeDesign extends AbstractDeductionSchemeDesign {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static DeductionSchemeDesign constant(Object value) {
		return new DeductionSchemeDesign().deduceConstant((Class)value.getClass(), value).getScheme();
	}
	
	public DeductionDesign deduceSelectedInstance(EntityDesign entity) {
		SelectedInstanceDeductionDesign selectedInstanceDeductionDesign = new SelectedInstanceDeductionDesign();
		
		addToDeductions(selectedInstanceDeductionDesign);
		setOutput(selectedInstanceDeductionDesign);
		
		selectedInstanceDeductionDesign.setOfEntity(entity);
		return selectedInstanceDeductionDesign;
	}

	public DeductionDesign deduceAttribute(AttributeDesign attribute) {
		return deduceAttribute(attribute, null);
	}

	public DeductionDesign deduceAttribute(AttributeDesign attribute, DeductionDesign instanceDeduction) {
		if (instanceDeduction==null) {
			instanceDeduction = deduceSelectedInstance(attribute.getBelongsToEntity());
		}
		AttributeDeductionDesign attributeDeductionDesign = new AttributeDeductionDesign();
		
		addToDeductions(attributeDeductionDesign);
		setOutput(attributeDeductionDesign);
		
		attributeDeductionDesign.addToInputs(instanceDeduction);
		attributeDeductionDesign.setAttribute(attribute);
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
		
		constantDeductionDesign.setValue(value);
		return constantDeductionDesign;
	}
	
	public DeductionDesign deduceCustom(Class<?> deductionClass, Class<?> resultClass, DeductionDesign... inputs) {
		return deduceCustom(deductionClass.getName(), resultClass.getName(), inputs);
	}

	public DeductionDesign deduceCustom(String javaClassName, String resultClassName, DeductionDesign... inputs) {
		CustomDeductionDesign result = new CustomDeductionDesign();

		addToDeductions(result);
		for (DeductionDesign input : inputs) {
			result.addToInputs(input);
		}
		setOutput(result);
		
		result.setImplementationClassName(javaClassName);
		result.getDataType().setJavaClassName(resultClassName);
		return result;
	}
	
	public DeductionDesign deduceHasValue(DeductionDesign input) {
		HasValueDeductionDesign result = new HasValueDeductionDesign();

		addToDeductions(result);
		setOutput(result);
		
		result.addToInputs(input);
		return result;
	}

	public DeductionDesign deduceAttributeHasValue(AttributeDesign attribute) {
		HasValueDeductionDesign result = new HasValueDeductionDesign();

		addToDeductions(result);
		DeductionDesign attributeDeduction = deduceAttribute(attribute);
		setOutput(result);
		
		result.addToInputs(attributeDeduction);
		return result;
	}
	
	public DeductionDesign deduceCastInstance(DeductionDesign input, EntityDesign to) {
		CastInstanceDeductionDesign result = new CastInstanceDeductionDesign();
		
		addToDeductions(result);
		setOutput(result);
		
		result.addToInputs(input);
		result.setToEntity(to);
		return result;
	}

	public DeductionDesign deduceEquals(DeductionDesign... inputs) {
		EqualsDeductionDesign result = new EqualsDeductionDesign();

		addToDeductions(result);
		setOutput(result);
		
		for (DeductionDesign input: inputs) {
			result.addToInputs(input);
		}
		return result;
	}
	
	public DeductionDesign deduceReverseRelation(RelationDesign relation, DeductionDesign instance) {
		ReverseRelationDeductionDesign result = new ReverseRelationDeductionDesign();
		
		addToDeductions(result);
		setOutput(result);
		
		result.addToInputs(instance);
		result.setRelation(relation);
		return result; 
	}
}
