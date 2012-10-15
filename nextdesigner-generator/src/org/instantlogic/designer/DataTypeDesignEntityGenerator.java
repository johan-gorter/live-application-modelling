package org.instantlogic.designer;

import org.instantlogic.designer.deduction.DataTypeDataCategoryDeduction;
import org.instantlogic.designer.deduction.DataTypeDataCategoryOptionsDeduction;
import org.instantlogic.designer.deduction.DataTypeEntityDeduction;
import org.instantlogic.designer.deduction.DataTypeJavaClassNameDeduction;
import org.instantlogic.designer.deduction.DataTypeMultivalueDeduction;
import org.instantlogic.designer.entity.DataCategoryDesignEntity;

public class DataTypeDesignEntityGenerator extends EntityDesign {

    public static final DataTypeDesignEntityGenerator ENTITY = new DataTypeDesignEntityGenerator();
    
    private DataTypeDesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
        setName("DataTypeDesign");
    }
    
    public static final RelationDesign dataCategory = addRelation(ENTITY, "dataCategory", RelationType.OneToZeroOrOne, DataCategoryDesignEntityGenerator.ENTITY);

    public static final RelationDesign entity = addRelation(ENTITY, "entity", RelationType.OneToZeroOrOne, EntityDesignEntityGenerator.ENTITY);
    public static final AttributeDesign multivalue = addAttribute(ENTITY, "multivalue", java.lang.Boolean.class);
   
    // Classname of a single item
    public static final AttributeDesign javaClassName = addAttribute(ENTITY, "javaClassName", java.lang.String.class);
    
    // Only relevant when dataCategory == number
    public static final AttributeDesign percentage = addAttribute(ENTITY, "percentage", java.lang.Boolean.class);
    public static final AttributeDesign wholeNumber = addAttribute(ENTITY, "wholeNumber", java.lang.Boolean.class);
    public static final AttributeDesign exactRounding = addAttribute(ENTITY, "exactRounding", java.lang.Boolean.class);
    // Units?

    // Only relevant when dataCategory == text
    public static final AttributeDesign multiLine = addAttribute(ENTITY, "multiLine", java.lang.Boolean.class);
    public static final AttributeDesign formatted = addAttribute(ENTITY, "formatted", java.lang.Boolean.class);
    
    @Override
    public void init() {
        // static instances
        addToStaticInstances((StaticInstanceDesign) new StaticInstanceDesign().setDescription(createConstantText("Boolean")).setName("boolean"));
        
    	javaClassName.setDefault(new DeductionSchemeDesign().deduceCustom(DataTypeJavaClassNameDeduction.class, String.class).getScheme());
    	
    	entity.setWriteable(false);
    	entity.setRule(new DeductionSchemeDesign().deduceCustom(DataTypeEntityDeduction.class, EntityDesign.class).getScheme());
    	
    	dataCategory.setRule(new DeductionSchemeDesign().deduceCustom(DataTypeDataCategoryDeduction.class, DataCategoryDesign.class).getScheme());
    	dataCategory.setDefault(DeductionSchemeDesign.constant(DataCategoryDesignEntity.INSTANCE.text));
    	dataCategory.setOptions(new DeductionSchemeDesign().deduceCustom(DataTypeDataCategoryOptionsDeduction.class.getName(), "? extends Iterable").getScheme());
    	
    	multivalue.setRule(new DeductionSchemeDesign().deduceCustom(DataTypeMultivalueDeduction.class, Boolean.class).getScheme());
    	multivalue.setDefault(DeductionSchemeDesign.constant(false));

    	multiLine.newRelevance().deduceEquals(
    			multiLine.getRelevance().deduceAttribute(dataCategory), 
    			multiLine.getRelevance().deduceConstant(DataCategoryDesign.class, DataCategoryDesignEntity.INSTANCE.text));
    	formatted.newRelevance().deduceAttribute(multiLine);
    	// TODO: relevance for all attributes/relations
    }

}
