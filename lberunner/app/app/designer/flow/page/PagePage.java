package app.designer.flow.page;

import org.instantlogic.fabric.deduction.AttributeDeduction;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.deduction.SelectedInstanceDeduction;
import org.instantlogic.fabric.text.ConstantText;
import org.instantlogic.interaction.flow.Page;
import org.instantlogic.interaction.page.CompositePageFragment;
import org.instantlogic.interaction.page.PageFragment;
import org.instantlogic.interaction.page.impl.SimpleButton;
import org.instantlogic.interaction.page.impl.SimpleCompositePageFragment;
import org.instantlogic.interaction.page.impl.SimpleField;
import org.instantlogic.interaction.page.impl.SimpleLink;

import app.designer.CompositePageFragmentDesign;
import app.designer.PageDesign;
import app.designer.entity.DesignEntity;
import app.designer.entity.PageDesignEntity;
import app.designer.event.AddFieldEvent;
import app.designer.event.ExploreInstanceEvent;
import app.designer.event.FlowDetailsEvent;
import app.designer.event.HomeEvent;
import app.designer.sharedpagefragment.PageFragmentEditorPageFragment;

public class PagePage extends Page {

	public static final PagePage INSTANCE = new PagePage();


	private static Deduction<?> createDeduction0() {
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
