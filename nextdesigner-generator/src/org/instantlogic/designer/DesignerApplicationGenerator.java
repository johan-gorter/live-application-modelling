package org.instantlogic.designer;

import java.io.File;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;


public class DesignerApplicationGenerator extends ApplicationDesign {

    public static final DesignerApplicationGenerator APPLICATION = new DesignerApplicationGenerator();
    
    public DesignerApplicationGenerator() {
        setName("Designer");
        setRootPackageName("org.instantlogic.designer");
        setSourcePath("/prive/live-business-engineering/nextdesigner/generated");
        setCaseEntity(ApplicationDesignEntityGenerator.ENTITY);
        init();
    }
    
    public static void main(String[] args) throws Exception {
        ApplicationDesign applicationInstance = new DesignerApplicationGenerator();
        GeneratedClassModels classModelUpdates = applicationInstance.getApplicationGenerator().getClassModelUpdates();
        ApplicationJavacodeGenerator.generate(classModelUpdates, new File(applicationInstance.getSourcePath()));
    }
    
}