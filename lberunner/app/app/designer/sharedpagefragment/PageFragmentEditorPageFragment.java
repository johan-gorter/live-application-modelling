package app.designer.sharedpagefragment;

import app.designer.*;
import app.designer.event.*;
import app.designer.flow.*;
import app.designer.entity.*;
import app.designer.sharedpagefragment.*;
import lbe.instance.*;
import lbe.model.flow.*;
import lbe.model.deduction.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class PageFragmentEditorPageFragment extends SimpleSharedPageFragment {
	
	public static PageFragmentEditorPageFragment INSTANCE = new PageFragmentEditorPageFragment();
	
	protected PageFragmentEditorPageFragment() {
	}


	private static Deduction<?> createDeduction0() {
		Deduction<PageFragmentDesign> d0 = SelectedInstanceDeduction.create(PageFragmentDesignEntity.INSTANCE);
		return d0;
	}


	private static Deduction<?> createDeduction1() {
		Deduction<Design> d0 = SelectedInstanceDeduction.create(DesignEntity.INSTANCE);
		Deduction<java.lang.String> d1 = AttributeDeduction.create(DesignEntity.name, d0);
		return d1;
	}


	private static Deduction<?> createDeduction2() {
		Deduction<FieldDesign> d0 = SelectedInstanceDeduction.create(FieldDesignEntity.INSTANCE);
		Deduction<AttributeDesign> d1 = AttributeDeduction.create(FieldDesignEntity.attribute, d0);
		return d1;
	}


	private static Deduction<?> createDeduction3() {
		Deduction<PageFragmentDesign> d0 = SelectedInstanceDeduction.create(PageFragmentDesignEntity.INSTANCE);
		Deduction<FieldDesign> d1 = CastInstanceDeduction.create(FieldDesignEntity.INSTANCE, d0);
		return d1;
	}


	private static Deduction<?> createDeduction4() {
		Deduction<PageCompositionDesign> d0 = SelectedInstanceDeduction.create(PageCompositionDesignEntity.INSTANCE);
		Deduction<PageFragmentDesign> d1 = AttributeDeduction.create(PageCompositionDesignEntity.pageFragment, d0);
		return d1;
	}


	private static Deduction<?> createDeduction5() {
		Deduction<CompositePageFragmentDesign> d0 = SelectedInstanceDeduction.create(CompositePageFragmentDesignEntity.INSTANCE);
		Deduction<java.util.List<PageCompositionDesign>> d1 = AttributeDeduction.create(CompositePageFragmentDesignEntity.items, d0);
		return d1;
	}


	private static Deduction<?> createDeduction6() {
		Deduction<PageFragmentDesign> d0 = SelectedInstanceDeduction.create(PageFragmentDesignEntity.INSTANCE);
		Deduction<CompositePageFragmentDesign> d1 = CastInstanceDeduction.create(CompositePageFragmentDesignEntity.INSTANCE, d0);
		return d1;
	}

	
	public static final PageFragment SHARED_INSTANCE = 
        new SimpleCompositePageFragment(new PageFragment[]{
            new SimpleCompositePageFragment(new PageFragment[]{
                new SimpleLink(PageFragmentDetailsEvent.INSTANCE, new TemplatedText().add(createDeduction0())),
                new SimpleCompositePageFragment(createDeduction3(), new PageFragment[]{
                    new SimpleCompositePageFragment(createDeduction2(), new PageFragment[]{
                        new SimpleLink(AttributeDetailsEvent.INSTANCE, new TemplatedText().add(createDeduction1()))
                    })
                })
            }).withPresentation("pageFragmentEditorHeader NoAnimation"),
            new SimpleCompositePageFragment(new PageFragment[]{
                new custom.designer.PreviewPageFragmentCustomization()
            }).withPresentation("pageFragmentEditorPreview"),
            new SimpleCompositePageFragment(createDeduction6(), new PageFragment[]{
                new SimpleCompositePageFragment(new PageFragment[]{
                    new SimpleCompositePageFragment(createDeduction5(), new PageFragment[]{
                        new SimpleCompositePageFragment(createDeduction4(), new PageFragment[]{
                                PageFragmentEditorPageFragment.INSTANCE

                        })
                    })
                }).withPresentation("pageFragmentEditorContent")
            })
        }).withPresentation("pageFragmentEditor"); 
	

	@Override
	protected PageFragment getDelegate() {
		return SHARED_INSTANCE;
	}
}
