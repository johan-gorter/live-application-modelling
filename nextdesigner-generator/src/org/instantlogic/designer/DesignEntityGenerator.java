package org.instantlogic.designer;

import org.instantlogic.designer.deduction.JavaIdentifierDeduction;
import org.instantlogic.designer.deduction.TechnicalNameDeduction;


public class DesignEntityGenerator extends EntityDesign {

    public static final DesignEntityGenerator ENTITY = new DesignEntityGenerator();
    
    private DesignEntityGenerator() {
    	DesignerApplicationGenerator.APPLICATION.addToEntities(this);
    	setIsCustomized(true);
        setName("Design");
    }

    // Attributes
    public static final AttributeDesign name = addAttribute(ENTITY, "name", java.lang.String.class);
    public static final AttributeDesign javaIdentifier = addAttribute(ENTITY, "javaIdentifier", java.lang.String.class);
    public static final AttributeDesign technicalName = addAttribute(ENTITY, "technicalName", java.lang.String.class);
    public static final AttributeDesign isCustomized = addAttribute(ENTITY, "isCustomized", java.lang.Boolean.class);

    // Relations

    @Override
    public void init() {
    	super.init();
    	
		javaIdentifier.setReadOnly(true);
		javaIdentifier.setRule(new DeductionSchemeDesign().deduceCustom(JavaIdentifierDeduction.class, String.class).getScheme());

		technicalName.setReadOnly(true);
		technicalName.setRule(new DeductionSchemeDesign().deduceCustom(TechnicalNameDeduction.class, String.class).getScheme());
    }
}