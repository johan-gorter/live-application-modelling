package org.instantlogic.designer.flow.field;

public class FieldPage extends org.instantlogic.interaction.flow.Page {

	public static final FieldPage INSTANCE = new FieldPage();


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.AttributeDesign> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.WidgetTemplateDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FieldDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.AttributeDesign> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FieldDesignEntity.attribute, d0);
		return d1;
	}

	
	private static org.instantlogic.interaction.page.CompositeFragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.CompositeFragmentTemplate(C1, createDeduction0(), new org.instantlogic.interaction.page.FragmentTemplate[]{
            new org.instantlogic.interaction.page.ActionWidgetBehavior(L1, "Link", org.instantlogic.designer.event.HomeEvent.INSTANCE)

,
            new org.instantlogic.interaction.page.ActionWidgetBehavior(L1, "Link", org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE)

,
            new org.instantlogic.interaction.page.ActionWidgetBehavior(L1, "Link", org.instantlogic.designer.event.PageDetailsEvent.INSTANCE)

,
            new org.instantlogic.interaction.page.ActionWidgetBehavior(L1, "Link", org.instantlogic.designer.event.ExploreInstanceEvent.INSTANCE)

,
            new org.instantlogic.interaction.page.ActionWidgetBehavior(F1, "Field", "{content.answerWidgetName}", org.instantlogic.designer.entity.FieldDesignEntity.INSTANCE, org.instantlogic.designer.entity.FieldDesignEntity.required)

,
            new org.instantlogic.interaction.page.ActionWidgetBehavior(F1, "Field", "{content.answerWidgetName}", org.instantlogic.designer.entity.FieldDesignEntity.INSTANCE, org.instantlogic.designer.entity.FieldDesignEntity.readOnly)

,
            new org.instantlogic.interaction.page.CompositeFragmentTemplate(S1, createDeduction0(), new org.instantlogic.interaction.page.FragmentTemplate[]{
                new org.instantlogic.interaction.page.ActionWidgetBehavior(F1, "Field", "{content.answerWidgetName}", org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name)

.setRequired(),
                new org.instantlogic.interaction.page.ActionWidgetBehavior(F1, "Field", "{content.answerWidgetName}", org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.className)

.setRequired()
            })
        }); 
	
	@Override
	public org.instantlogic.interaction.page.CompositeFragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "Field";
    }
}
