package org.instantlogic.designer.flow.field;

public class FieldPage extends org.instantlogic.interaction.flow.Page {

	public static final FieldPage INSTANCE = new FieldPage();


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.AttributeDesign> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FieldDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FieldDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.AttributeDesign> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FieldDesignEntity.attribute, d0);
		return d1;
	}

	
	private static org.instantlogic.interaction.page.CompositePageFragment CONTENT = 
        new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(new org.instantlogic.interaction.page.PageFragment[]{
            new org.instantlogic.interaction.page.impl.SimpleLink(org.instantlogic.designer.event.HomeEvent.INSTANCE, new org.instantlogic.fabric.text.ConstantText("Home")),
            new org.instantlogic.interaction.page.impl.SimpleLink(org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE, new org.instantlogic.fabric.text.ConstantText("Flow")),
            new org.instantlogic.interaction.page.impl.SimpleLink(org.instantlogic.designer.event.PageDetailsEvent.INSTANCE, new org.instantlogic.fabric.text.ConstantText("Page")),
            new org.instantlogic.interaction.page.impl.SimpleLink(org.instantlogic.designer.event.ExploreInstanceEvent.INSTANCE, new org.instantlogic.fabric.text.ConstantText("Open in case explorer")),
            new org.instantlogic.interaction.page.impl.SimpleField(org.instantlogic.designer.entity.FieldDesignEntity.INSTANCE, org.instantlogic.designer.entity.FieldDesignEntity.required),
            new org.instantlogic.interaction.page.impl.SimpleField(org.instantlogic.designer.entity.FieldDesignEntity.INSTANCE, org.instantlogic.designer.entity.FieldDesignEntity.readOnly),
            new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(createDeduction0(), new org.instantlogic.interaction.page.PageFragment[]{
                new org.instantlogic.interaction.page.impl.SimpleField(org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name).setRequired(),
                new org.instantlogic.interaction.page.impl.SimpleField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.className).setRequired()
            })
        }); 
	
	@Override
	public org.instantlogic.interaction.page.CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "Field";
	}
	
}
