package org.instantlogic.designer;

import java.io.File;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.designer.flow.MainFlowGenerator;


public class DesignerApplicationGenerator extends ApplicationDesign {

    public static DesignerApplicationGenerator APPLICATION = new DesignerApplicationGenerator();
    
    public DesignerApplicationGenerator() {
        APPLICATION = this;
        setName("Designer");
        setRootPackageName("org.instantlogic.designer");
        setSourcePath("../nextdesigner/generated");
        setCaseEntity(ApplicationDesignEntityGenerator.ENTITY);
        setMainFlow(MainFlowGenerator.FLOW);

        init();
    }
    
    public static void main(String[] args) throws Exception {
        GeneratedClassModels classModelUpdates = APPLICATION.getApplicationGenerator().getClassModelUpdates();
        ApplicationJavacodeGenerator.generate(classModelUpdates, new File(APPLICATION.getSourcePath()));
    }
    
}