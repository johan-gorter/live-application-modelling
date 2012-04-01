package org.instantlogic.designer.sharedpagefragment;

public class PageFragmentEditorPageFragment extends org.instantlogic.interaction.page.impl.SimpleSharedPageFragment {
	
	public static PageFragmentEditorPageFragment INSTANCE = new PageFragmentEditorPageFragment();
	
	protected PageFragmentEditorPageFragment() {
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.PageFragmentDesign> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.PageFragmentDesign> d0 
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
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FieldDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FieldDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.AttributeDesign> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FieldDesignEntity.attribute, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FieldDesign> createDeduction3() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.PageFragmentDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.PageFragmentDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FieldDesign> d1 
		  		= org.instantlogic.fabric.deduction.CastInstanceDeduction.create(org.instantlogic.designer.entity.FieldDesignEntity.INSTANCE, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.PageFragmentDesign> createDeduction4() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.PageCompositionDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.PageCompositionDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.PageFragmentDesign> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.PageCompositionDesignEntity.pageFragment, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PageCompositionDesign>> createDeduction5() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.CompositePageFragmentDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.CompositePageFragmentDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PageCompositionDesign>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.CompositePageFragmentDesignEntity.items, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.CompositePageFragmentDesign> createDeduction6() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.PageFragmentDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.PageFragmentDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.CompositePageFragmentDesign> d1 
		  		= org.instantlogic.fabric.deduction.CastInstanceDeduction.create(org.instantlogic.designer.entity.CompositePageFragmentDesignEntity.INSTANCE, d0);
		return d1;
	}

	
	public static final org.instantlogic.interaction.page.PageFragment SHARED_INSTANCE = 
        new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(new org.instantlogic.interaction.page.PageFragment[]{
            new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(new org.instantlogic.interaction.page.PageFragment[]{
                new org.instantlogic.interaction.page.impl.SimpleLink(org.instantlogic.designer.event.PageFragmentDetailsEvent.INSTANCE, new org.instantlogic.fabric.text.TemplatedText().add(createDeduction0())),
                new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(createDeduction3(), new org.instantlogic.interaction.page.PageFragment[]{
                    new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(createDeduction2(), new org.instantlogic.interaction.page.PageFragment[]{
                        new org.instantlogic.interaction.page.impl.SimpleLink(org.instantlogic.designer.event.AttributeDetailsEvent.INSTANCE, new org.instantlogic.fabric.text.TemplatedText().add(createDeduction1()))
                    })
                })
            }).withPresentation("pageFragmentEditorHeader NoAnimation"),
            new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(new org.instantlogic.interaction.page.PageFragment[]{
                new org.instantlogic.designer.pagefragment.PreviewPageFragmentCustomization()
            }).withPresentation("pageFragmentEditorPreview"),
            new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(createDeduction6(), new org.instantlogic.interaction.page.PageFragment[]{
                new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(new org.instantlogic.interaction.page.PageFragment[]{
                    new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(createDeduction5(), new org.instantlogic.interaction.page.PageFragment[]{
                        new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(createDeduction4(), new org.instantlogic.interaction.page.PageFragment[]{
                                org.instantlogic.designer.sharedpagefragment.PageFragmentEditorPageFragment.INSTANCE

                        })
                    })
                }).withPresentation("pageFragmentEditorContent")
            })
        }).withPresentation("pageFragmentEditor"); 
	

	@Override
	protected org.instantlogic.interaction.page.PageFragment getDelegate() {
		return SHARED_INSTANCE;
	}
}
