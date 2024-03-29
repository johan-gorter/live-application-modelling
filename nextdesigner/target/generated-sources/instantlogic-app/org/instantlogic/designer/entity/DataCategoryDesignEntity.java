package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DataCategoryDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DataCategoryDesign> {

	public static final DataCategoryDesignEntity INSTANCE = new DataCategoryDesignEntity();
	

	
	@Override
	public org.instantlogic.designer.DataCategoryDesign createInstance() {
		return new org.instantlogic.designer.DataCategoryDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DataCategoryDesign> getInstanceClass() {
		return org.instantlogic.designer.DataCategoryDesign.class;
	}
	
	@Override
	public String getName() {
		return "DataCategoryDesign";
	}

	// Deductions

	
	// Attributes
	
	// Relations
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Validation[] VALIDATIONS = new org.instantlogic.fabric.model.Validation[]{
	};
	

	@Override
	public org.instantlogic.fabric.model.Attribute[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}
	@Override
	public org.instantlogic.fabric.model.Validation[] getLocalValidations() {
		return VALIDATIONS;
	}
	
	@Override
	public java.util.Map<String, org.instantlogic.designer.DataCategoryDesign> getStaticInstances() {
		return org.instantlogic.designer.DataCategoryDesign.getStaticDataCategoryDesignInstances();
	}
}
