package app.designer.flow.flow;

import app.designer.flow.*;
import app.designer.data.entity.*;
import app.designer.container.*;
import app.designer.button.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class FlowPage extends Page {

	public static final FlowPage INSTANCE = new FlowPage();
	
	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(new PageFragment[]{
            new ConstantText("Flow"),
            new SimpleField(ConceptEntity.INSTANCE, ConceptEntity.name)
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
