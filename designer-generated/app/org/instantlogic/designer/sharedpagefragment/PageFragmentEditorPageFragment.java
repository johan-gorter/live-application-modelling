package org.instantlogic.designer.sharedpagefragment;

public class PageFragmentEditorPageFragment extends org.instantlogic.interaction.page.impl.SimpleSharedPageFragment {
	
	public static PageFragmentEditorPageFragment INSTANCE = new PageFragmentEditorPageFragment();
	
	protected PageFragmentEditorPageFragment() {
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.PageFragmentDesignEntity.INSTANCE);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.Design> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.AttributeDesign> createDeduction2() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.WidgetTemplateDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FieldDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.AttributeDesign> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FieldDesignEntity.attribute, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.WidgetTemplateDesign> createDeduction3() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.PageFragmentDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.WidgetTemplateDesign> d1 
		  		= org.instantlogic.fabric.deduction.CastInstanceDeduction.create(org.instantlogic.designer.entity.FieldDesignEntity.INSTANCE, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> createDeduction4() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.PageCompositionDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.PageCompositionDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.PageCompositionDesignEntity.pageFragment, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PageCompositionDesign>> createDeduction5() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.CompositeTemplateDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.CompositeFragmentTemplateDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PageCompositionDesign>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.CompositeFragmentTemplateDesignEntity.items, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.CompositeTemplateDesign> createDeduction6() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.PageFragmentDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.CompositeTemplateDesign> d1 
		  		= org.instantlogic.fabric.deduction.CastInstanceDeduction.create(org.instantlogic.designer.entity.CompositeFragmentTemplateDesignEntity.INSTANCE, d0);
		return d1;
	}

	
	public static final org.instantlogic.interaction.page.PageFragment SHARED_INSTANCE = 
        new org.instantlogic.interaction.page.CompositeFragmentTemplate(C1, createDeduction0(), new org.instantlogic.interaction.page.FragmentTemplate[]{
            new org.instantlogic.interaction.page.CompositeFragmentTemplate(C1, createDeduction0(), new org.instantlogic.interaction.page.FragmentTemplate[]{
                new org.instantlogic.interaction.page.ActionWidgetBehavior(L1, "Link", org.instantlogic.designer.event.PageFragmentDetailsEvent.INSTANCE)

,
                new org.instantlogic.interaction.page.CompositeFragmentTemplate(S1, createDeduction3(), new org.instantlogic.interaction.page.FragmentTemplate[]{
                    new org.instantlogic.interaction.page.CompositeFragmentTemplate(S1, createDeduction2(), new org.instantlogic.interaction.page.FragmentTemplate[]{
                        new org.instantlogic.interaction.page.ActionWidgetBehavior(L1, "Link", org.instantlogic.designer.event.AttributeDetailsEvent.INSTANCE)


                    })
                })
            }),
            new org.instantlogic.interaction.page.CompositeFragmentTemplate(C1, createDeduction0(), new org.instantlogic.interaction.page.FragmentTemplate[]{
                new org.instantlogic.interaction.page.CompositeFragmentTemplate(C1, createDeduction0(), new org.instantlogic.interaction.page.FragmentTemplate[]{
                })
            }),
            new org.instantlogic.interaction.page.CompositeFragmentTemplate(S1, createDeduction6(), new org.instantlogic.interaction.page.FragmentTemplate[]{
                new org.instantlogic.interaction.page.CompositeFragmentTemplate(C1, createDeduction0(), new org.instantlogic.interaction.page.FragmentTemplate[]{
                    new org.instantlogic.interaction.page.CompositeFragmentTemplate(S1, createDeduction5(), new org.instantlogic.interaction.page.FragmentTemplate[]{
                        new org.instantlogic.interaction.page.CompositeFragmentTemplate(S1, createDeduction4(), new org.instantlogic.interaction.page.FragmentTemplate[]{
                            


                        })
                    })
                })
            })
        }); 
	

	@Override
	protected org.instantlogic.interaction.page.PageFragment getDelegate() {
		return SHARED_INSTANCE;
	}
}
