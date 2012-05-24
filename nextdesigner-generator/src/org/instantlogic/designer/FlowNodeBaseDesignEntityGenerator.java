package org.instantlogic.designer;


public class FlowNodeBaseDesignEntityGenerator extends EntityDesign {

    public static final FlowNodeBaseDesignEntityGenerator ENTITY = new FlowNodeBaseDesignEntityGenerator();
    
    private FlowNodeBaseDesignEntityGenerator() {
        setName("FlowNodeBaseDesign");
        setExtendsFrom(DesignEntityGenerator.ENTITY);
    }

    // Attributes

    // Relations

}