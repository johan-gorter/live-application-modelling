package org.instantlogic.designer.flow.flow;

public class FlowPage extends org.instantlogic.interaction.flow.Page {

	public static final FlowPage INSTANCE = new FlowPage();


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.Design> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowNodeBaseDesign>> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FlowDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowNodeBaseDesign>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FlowDesignEntity.nodes, d0);
		return d1;
	}

	
	private static org.instantlogic.interaction.page.CompositePageFragment CONTENT = 
        new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(new org.instantlogic.interaction.page.PageFragment[]{
            new org.instantlogic.interaction.page.impl.SimpleLink(org.instantlogic.designer.event.HomeEvent.INSTANCE, new org.instantlogic.fabric.text.ConstantText("Home")),
            new org.instantlogic.interaction.page.impl.SimpleLink(org.instantlogic.designer.event.ExploreInstanceEvent.INSTANCE, new org.instantlogic.fabric.text.ConstantText("Open in case explorer")),
            new org.instantlogic.interaction.page.impl.SimpleField(DesignEntity.INSTANCE, DesignEntity.name),
            new org.instantlogic.interaction.page.TextPageFragment(new org.instantlogic.fabric.text.ConstantText("Nodes")),
            new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(createDeduction1(), new org.instantlogic.interaction.page.PageFragment[]{
                new org.instantlogic.interaction.page.impl.SimpleLink(org.instantlogic.designer.event.FlowNodeDetailsEvent.INSTANCE, new org.instantlogic.fabric.text.TemplatedText().add(createDeduction0()))
            })
        }); 
	
	@Override
	public org.instantlogic.interaction.page.CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "Flow";
	}
	
}
