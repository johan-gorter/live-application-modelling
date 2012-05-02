package org.instantlogic.designer.flow.page;

public class PagePage extends org.instantlogic.interaction.flow.Page {

	public static final PagePage INSTANCE = new PagePage();


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.CompositeTemplateDesign> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.PlaceTemplateDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.PlaceDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.CompositeTemplateDesign> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.PlaceDesignEntity.content, d0);
		return d1;
	}

	
	private static org.instantlogic.interaction.page.CompositeFragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.CompositeFragmentTemplate(C1, createDeduction0(), new org.instantlogic.interaction.page.FragmentTemplate[]{
            new org.instantlogic.interaction.page.ActionWidgetBehavior(L1, "Link", org.instantlogic.designer.event.HomeEvent.INSTANCE)

,
            new org.instantlogic.interaction.page.ActionWidgetBehavior(L1, "Link", org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE)

,
            new org.instantlogic.interaction.page.ActionWidgetBehavior(L1, "Link", org.instantlogic.designer.event.ExploreInstanceEvent.INSTANCE)

,
            new org.instantlogic.interaction.page.ActionWidgetBehavior(F1, "Field", "{content.answerWidgetName}", org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name)

,
            new org.instantlogic.interaction.page.CompositeFragmentTemplate(S1, createDeduction0(), new org.instantlogic.interaction.page.FragmentTemplate[]{
                


            }),
            new org.instantlogic.interaction.page.ActionWidgetBehavior(B1, "Button", org.instantlogic.designer.event.AddFieldEvent.INSTANCE)


        }); 
	
	@Override
	public org.instantlogic.interaction.page.CompositeFragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "Page";
    }
}
