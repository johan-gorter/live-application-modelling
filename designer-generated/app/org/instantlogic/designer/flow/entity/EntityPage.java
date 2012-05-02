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
                new org.instantlogic.interaction.page.CompositeFragmentTemplate(C1, createDeduction0(), new org.instantlogic.interaction.page.FragmentTemplate[]{
                    new org.instantlogic.interaction.page.ActionWidgetBehavior(L1, "Link", org.instantlogic.designer.event.AttributeDetailsEvent.INSTANCE)


                })
            })
        }); 
	
	@Override
	public org.instantlogic.interaction.page.CompositeFragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "Entity";
    }
}
