package app.designer.flow.flow;

import app.designer.event.*;
import app.designer.flow.*;
import app.designer.entity.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class FlowPage extends Page {

	public static final FlowPage INSTANCE = new FlowPage();
	
	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(new PageFragment[]{
            new SimpleLink(HomeEvent.INSTANCE, new ConstantText("Home")),
            new SimpleLink(ExploreInstanceEvent.INSTANCE, new ConstantText("Open in case explorer")),
            new SimpleField(ConceptEntity.INSTANCE, ConceptEntity.name),
            new ConstantText("Nodes"),
            new SimpleCompositePageFragment(FlowDesignEntity.nodes, new PageFragment[]{
                new SimpleLink(FlowNodeDetailsEvent.INSTANCE, new TemplatedText().add(ConceptEntity.name))
            })
        }); 
	
	@Override
	public CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "Flow";
	}
	
}
