package org.instantlogic.designer;

import java.io.File;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.designer.flow.MainFlowGenerator;


public class DesignerApplicationGenerator extends ApplicationDesign {

    public static final DesignerApplicationGenerator APPLICATION = new DesignerApplicationGenerator();
    
    public DesignerApplicationGenerator() {
        setName("Designer");
        setRootPackageName("org.instantlogic.designer");
        setSourcePath("/prive/live-business-engineering/nextdesigner/generated");
        setCaseEntity(ApplicationDesignEntityGenerator.ENTITY);
        addToExposedFlows(MainFlowGenerator.FLOW);

        //TODO: move to baseclass init
		((MainFlowGenerator)getExposedFlows().get(0)).registerApplication(this);
		for (FlowDesign flow: getFlows()) {
			((MainFlowGenerator)flow).init();
		}
		
        init();
    }
    
    public static void main(String[] args) throws Exception {
        GeneratedClassModels classModelUpdates = APPLICATION.getApplicationGenerator().getClassModelUpdates();
        ApplicationJavacodeGenerator.generate(classModelUpdates, new File(APPLICATION.getSourcePath()));
    }
    
}