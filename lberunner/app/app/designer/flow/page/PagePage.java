package app.designer.flow.page;

import app.designer.event.*;
import app.designer.flow.*;
import app.designer.data.entity.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class PagePage extends Page {

	public static final PagePage INSTANCE = new PagePage();
	
	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(new PageFragment[]{
            new SimpleField(ConceptEntity.INSTANCE, ConceptEntity.name),
            new SimpleCompositePageFragment(PageEntity.content, new PageFragment[]{
                
            }),
            new SimpleButton(AddFieldEvent.INSTANCE, new ConstantText("Add field")),
            new SimpleButton(ExploreInstanceEvent.INSTANCE, new ConstantText("Open in case explorer")),
            new SimpleButton(HomeEvent.INSTANCE, new ConstantText("Home"))
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
