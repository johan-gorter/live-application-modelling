package org.instantlogic.designer.flow.page;

public class PagePage extends org.instantlogic.interaction.flow.Page {

	public static final PagePage INSTANCE = new PagePage();


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.CompositePageFragmentDesign> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.PageDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.PageDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.CompositePageFragmentDesign> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.PageDesignEntity.content, d0);
		return d1;
	}

	
	private static org.instantlogic.interaction.page.CompositePageFragment CONTENT = 
        new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(new org.instantlogic.interaction.page.PageFragment[]{
            new org.instantlogic.interaction.page.impl.SimpleLink(org.instantlogic.designer.event.HomeEvent.INSTANCE, new org.instantlogic.fabric.text.ConstantText("Home")),
            new org.instantlogic.interaction.page.impl.SimpleLink(org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE, new org.instantlogic.fabric.text.ConstantText("Flow")),
            new org.instantlogic.interaction.page.impl.SimpleLink(org.instantlogic.designer.event.ExploreInstanceEvent.INSTANCE, new org.instantlogic.fabric.text.ConstantText("Open in case explorer")),
            new org.instantlogic.interaction.page.impl.SimpleField(org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name),
            new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(createDeduction0(), new org.instantlogic.interaction.page.PageFragment[]{
                    org.instantlogic.designer.sharedpagefragment.PageFragmentEditorPageFragment.INSTANCE

            }),
            new org.instantlogic.interaction.page.impl.SimpleButton(org.instantlogic.designer.event.AddFieldEvent.INSTANCE, new org.instantlogic.fabric.text.ConstantText("Add field"))
        }); 
	
	@Override
	public org.instantlogic.interaction.page.CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "Page";
	}
	
}
