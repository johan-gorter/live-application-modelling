package org.instantlogic.designer.flow.entity;

public class EntityPage extends org.instantlogic.interaction.flow.Page {

	public static final EntityPage INSTANCE = new EntityPage();


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.Design> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.AttributeDesign>> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.EntityDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.AttributeDesign>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.EntityDesignEntity.attributes, d0);
		return d1;
	}

	
	private static org.instantlogic.interaction.page.CompositePageFragment CONTENT = 
        new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(new org.instantlogic.interaction.page.PageFragment[]{
            new org.instantlogic.interaction.page.impl.SimpleLink(org.instantlogic.designer.event.HomeEvent.INSTANCE, new org.instantlogic.fabric.text.ConstantText("Home")),
            new org.instantlogic.interaction.page.impl.SimpleLink(org.instantlogic.designer.event.ExploreInstanceEvent.INSTANCE, new org.instantlogic.fabric.text.ConstantText("Open in case explorer")),
            new org.instantlogic.interaction.page.impl.SimpleField(org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name),
            new org.instantlogic.interaction.page.TextPageFragment(new org.instantlogic.fabric.text.ConstantText("Attributes")),
            new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(createDeduction1(), new org.instantlogic.interaction.page.PageFragment[]{
                new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(new org.instantlogic.interaction.page.PageFragment[]{
                    new org.instantlogic.interaction.page.impl.SimpleLink(org.instantlogic.designer.event.AttributeDetailsEvent.INSTANCE, new org.instantlogic.fabric.text.TemplatedText().add(createDeduction0()))
                }).withPresentation("row")
            })
        }); 
	
	@Override
	public org.instantlogic.interaction.page.CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "Entity";
	}
	
}
