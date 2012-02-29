package app.designer.flow.page;

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

public class PagePage extends Page {

	public static final PagePage INSTANCE = new PagePage();


	private static Deduction<CompositePageFragmentDesign> createDeduction0() {
		  	Deduction<PageDesign> d0 = SelectedInstanceDeduction.create(PageDesignEntity.INSTANCE);
		  	Deduction<CompositePageFragmentDesign> d1 = AttributeDeduction.create(PageDesignEntity.content, d0);
		return d1;
	}

	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(new PageFragment[]{
            new SimpleLink(HomeEvent.INSTANCE, new ConstantText("Home")),
            new SimpleLink(FlowDetailsEvent.INSTANCE, new ConstantText("Flow")),
            new SimpleLink(ExploreInstanceEvent.INSTANCE, new ConstantText("Open in case explorer")),
            new SimpleField(DesignEntity.INSTANCE, DesignEntity.name),
            new SimpleCompositePageFragment(createDeduction0(), new PageFragment[]{
                    PageFragmentEditorPageFragment.INSTANCE

            }),
            new SimpleButton(AddFieldEvent.INSTANCE, new ConstantText("Add field"))
        }); 
	
	@Override
	public CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "Page";
	}
	
}
