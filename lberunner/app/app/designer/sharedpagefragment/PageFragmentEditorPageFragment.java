package app.designer.sharedpagefragment;

import org.instantlogic.fabric.deduction.AttributeDeduction;
import org.instantlogic.fabric.deduction.CastInstanceDeduction;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.deduction.SelectedInstanceDeduction;
import org.instantlogic.fabric.text.TemplatedText;
import org.instantlogic.interaction.page.PageFragment;
import org.instantlogic.interaction.page.impl.SimpleCompositePageFragment;
import org.instantlogic.interaction.page.impl.SimpleLink;
import org.instantlogic.interaction.page.impl.SimpleSharedPageFragment;

import app.designer.AttributeDesign;
import app.designer.CompositePageFragmentDesign;
import app.designer.Design;
import app.designer.FieldDesign;
import app.designer.PageCompositionDesign;
import app.designer.PageFragmentDesign;
import app.designer.entity.CompositePageFragmentDesignEntity;
import app.designer.entity.DesignEntity;
import app.designer.entity.FieldDesignEntity;
import app.designer.entity.PageCompositionDesignEntity;
import app.designer.entity.PageFragmentDesignEntity;
import app.designer.event.AttributeDetailsEvent;
import app.designer.event.PageFragmentDetailsEvent;

public class PageFragmentEditorPageFragment extends SimpleSharedPageFragment {
	
	public static PageFragmentEditorPageFragment INSTANCE = new PageFragmentEditorPageFragment();
	
	protected PageFragmentEditorPageFragment() {
	}


	private static Deduction<PageFragmentDesign> createDeduction0() {
		  	Deduction<PageFragmentDesign> d0 = SelectedInstanceDeduction.create(PageFragmentDesignEntity.INSTANCE);
		return d0;
	}


	private static Deduction<java.lang.String> createDeduction1() {
		  	Deduction<Design> d0 = SelectedInstanceDeduction.create(DesignEntity.INSTANCE);
		  	Deduction<java.lang.String> d1 = AttributeDeduction.create(DesignEntity.name, d0);
		return d1;
	}


	private static Deduction<AttributeDesign> createDeduction2() {
		  	Deduction<FieldDesign> d0 = SelectedInstanceDeduction.create(FieldDesignEntity.INSTANCE);
		  	Deduction<AttributeDesign> d1 = AttributeDeduction.create(FieldDesignEntity.attribute, d0);
		return d1;
	}


	private static Deduction<FieldDesign> createDeduction3() {
		  	Deduction<PageFragmentDesign> d0 = SelectedInstanceDeduction.create(PageFragmentDesignEntity.INSTANCE);
		  	Deduction<FieldDesign> d1 = CastInstanceDeduction.create(FieldDesignEntity.INSTANCE, d0);
		return d1;
	}


	private static Deduction<PageFragmentDesign> createDeduction4() {
		  	Deduction<PageCompositionDesign> d0 = SelectedInstanceDeduction.create(PageCompositionDesignEntity.INSTANCE);
		  	Deduction<PageFragmentDesign> d1 = AttributeDeduction.create(PageCompositionDesignEntity.pageFragment, d0);
		return d1;
	}


	private static Deduction<java.util.List<PageCompositionDesign>> createDeduction5() {
		  	Deduction<CompositePageFragmentDesign> d0 = SelectedInstanceDeduction.create(CompositePageFragmentDesignEntity.INSTANCE);
		  	Deduction<java.util.List<PageCompositionDesign>> d1 = AttributeDeduction.create(CompositePageFragmentDesignEntity.items, d0);
		return d1;
	}


	private static Deduction<CompositePageFragmentDesign> createDeduction6() {
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
