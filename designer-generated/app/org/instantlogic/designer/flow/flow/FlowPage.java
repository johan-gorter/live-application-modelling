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

	
	private static org.instantlogic.interaction.page.CompositeFragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.CompositeFragmentTemplate(C1, createDeduction0(), new org.instantlogic.interaction.page.FragmentTemplate[]{
            new org.instantlogic.interaction.page.ActionWidgetBehavior(L1, "Link", org.instantlogic.designer.event.HomeEvent.INSTANCE)

,
            new org.instantlogic.interaction.page.ActionWidgetBehavior(L1, "Link", org.instantlogic.designer.event.ExploreInstanceEvent.INSTANCE)

,
            new org.instantlogic.interaction.page.ActionWidgetBehavior(F1, "Field", "{content.answerWidgetName}", org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name)

,
            new org.instantlogic.interaction.page.WidgetFragmentTemplate(C1, "ConstantText")

,
            new org.instantlogic.interaction.page.CompositeFragmentTemplate(S1, createDeduction1(), new org.instantlogic.interaction.page.FragmentTemplate[]{
                new org.instantlogic.interaction.page.ActionWidgetBehavior(L1, "Link", org.instantlogic.designer.event.FlowNodeDetailsEvent.INSTANCE)


            })
        }); 
	
	@Override
	public org.instantlogic.interaction.page.CompositeFragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "Flow";
    }
}
