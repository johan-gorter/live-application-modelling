package org.instantlogic.designer;



public class EntityDesign extends AbstractEntityDesign { 

	public enum RelationType {
		OneToZeroOrOne, 
		OneToZeroOrOneAggregation, 
		OneToOneAggregation, 
		OneToMany, 
		OneToManyAggregation, 
		ManyToZeroOrOne, 
		ManyToMany
	}
	
	public AttributeDesign addAttribute(String name, Class<?> type) {
		return addAttribute(name, type.getName());
	}
	
	protected AttributeDesign addAttribute(String name, String className) {
		AttributeDesign result = new AttributeDesign();
		result.setName(name);
		result.setClassName(className);
		addToAttributes(result);
		return result;
	}
	
	protected RelationDesign addRelation(String name, RelationType relationType, EntityDesign to) {
		RelationDesign relation = new RelationDesign();
		addToRelations(relation);
		relation.setTo(to);
		relation.setName(name);
		relation.setOwner(relationType==RelationType.OneToManyAggregation || relationType==RelationType.OneToZeroOrOneAggregation || relationType==RelationType.OneToOneAggregation);
		relation.setAutoCreate(relationType==RelationType.OneToOneAggregation);
		relation.setMultivalue(relationType==RelationType.OneToMany || relationType==RelationType.OneToManyAggregation || relationType==RelationType.ManyToMany);
		relation.setReverseMultivalue(relationType==RelationType.ManyToMany || relationType==RelationType.ManyToZeroOrOne);
		return relation;
	}
	
	protected DeductionSchemeDesign createCustomDeduction(String customization, Class resultClass) {
		return createCustomDeduction(customization, resultClass.getName());
	}
	
	protected DeductionSchemeDesign createCustomDeduction(String customization, String resultClassName) {
		DeductionSchemeDesign scheme = new DeductionSchemeDesign();
		DeductionDesign customDeductionDesign = new DeductionDesign();
		customDeductionDesign.setCustomization(customization);
		customDeductionDesign.setClassName(resultClassName);
		scheme.addToDeductions(customDeductionDesign);
		scheme.setOutput(customDeductionDesign);
		return scheme;
	}
	
	protected DeductionDesign selectedInstanceDeduction(EntityDesign entity) {
		return new SelectedInstanceDeductionDesign()
				.setOfEntity(entity)
				.setClassName(entity.getApplication().getRootPackageName()+"."+entity.getName());
	}
	
	protected static DeductionSchemeDesign createDeductionScheme(DeductionDesign output) {
		DeductionSchemeDesign result = new DeductionSchemeDesign();
		addDeductions(result, output);
		result.setOutput(output);
		return result;
	}
	
	
	private static void addDeductions(DeductionSchemeDesign result, DeductionDesign deduction) {
		if (result.getDeductions().asList().contains(deduction)) return;
		result.addToDeductions(deduction);
		for(DeductionDesign input: deduction.getInputs()) {
			addDeductions(result, input);
		}
	}
	
	public void registerApplication(ApplicationDesign application) {
		if (application.getEntities().contains(this)) return;
		application.addToEntities(this);
		for (RelationDesign relation: getRelations()) {
			relation.getTo().registerApplication(application);
		}
	}
	
	/**
	 * Will be called once for every entity from ApplicationDesign.init
	 */
	public void init() {
	}
}