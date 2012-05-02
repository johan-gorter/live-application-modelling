package org.instantlogic.designer;


public class DesignerApplicationGenerator extends ApplicationDesign {

    public static final DesignerApplicationGenerator APPLICATION = new DesignerApplicationGenerator();
    
    public DesignerApplicationGenerator() {
        setName("Designer");
        setRootPackageName("org.instantlogic.designer");
        setSourcePath("/prive/live-business-engineering/designer-generated/app");
        setCaseEntity(ApplicationDesignEntityGenerator.ENTITY);
        init();
    }
}