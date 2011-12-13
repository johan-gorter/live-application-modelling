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
		Deduction<PageFragmentDesign> d0 = SelectedInstanceDeduction.create(PageFragmentDesignEntity.INSTANCE);
		return d0;
	}


	private static Deduction<?> createDeduction2() {
		Deduction<PageFragmentDesign> d0 = SelectedInstanceDeduction.create(PageFragmentDesignEntity.INSTANCE);
		Deduction<FieldDesign> d1 = CastInstanceDeduction.create(FieldDesignEntity.INSTANCE, d0);
		return d1;
	}


	private static Deduction<?> createDeduction3() {
		Deduction<PageCompositionDesign> d0 = SelectedInstanceDeduction.create(PageCompositionDesignEntity.INSTANCE);
		Deduction<PageFragmentDesign> d1 = AttributeDeduction.create(PageCompositionDesignEntity.pageFragment, d0);
		return d1;
	}


	private static Deduction<?> createDeduction4() {
		Deduction<CompositePageFragmentDesign> d0 = SelectedInstanceDeduction.create(CompositePageFragmentDesignEntity.INSTANCE);
		Deduction<java.util.List<PageCompositionDesign>> d1 = AttributeDeduction.create(CompositePageFragmentDesignEntity.items, d0);
		return d1;
	}


	private static Deduction<?> createDeduction5() {
		Deduction<PageFragmentDesign> d0 = SelectedInstanceDeduction.create(PageFragmentDesignEntity.INSTANCE);
		Deduction<CompositePageFragmentDesign> d1 = CastInstanceDeduction.create(CompositePageFragmentDesignEntity.INSTANCE, d0);
		return d1;
	}

	
	public static final PageFragment SHARED_INSTANCE = 
        new SimpleCompositePageFragment(new PageFragment[]{
            new TemplatedText().add(createDeduction0()),
            new SimpleCompositePageFragment(createDeduction2(), new PageFragment[]{
                new SimpleLink(FieldDetailsEvent.INSTANCE, new TemplatedText().add(createDeduction1())),
                new custom.designer.PreviewPageFragmentCustomization()
            }),
            new SimpleCompositePageFragment(createDeduction5(), new PageFragment[]{
                new SimpleCompositePageFragment(new PageFragment[]{
                    new SimpleCompositePageFragment(createDeduction4(), new PageFragment[]{
                        new SimpleCompositePageFragment(createDeduction3(), new PageFragment[]{
                                PageFragmentEditorPageFragment.INSTANCE

                        })
                    })
                }).withPresentation("indented")
            })
        }); 
	

	@Override
	protected PageFragment getDelegate() {
		return SHARED_INSTANCE;
	}
}
