package app.designer.flow.flow;

import app.designer.*;
import app.designer.event.*;
import app.designer.flow.*;
import app.designer.entity.*;
import lbe.instance.*;
import lbe.model.flow.*;
import lbe.model.deduction.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class FlowPage extends Page {

	public static final FlowPage INSTANCE = new FlowPage();


	private static Deduction<?> createDeduction0() {
		Deduction<Design> d0 = SelectedInstanceDeduction.create(DesignEntity.INSTANCE);
		Deduction<java.lang.String> d1 = AttributeDeduction.create(DesignEntity.name, d0);
		return d1;
	}


	private static Deduction<?> createDeduction1() {
		Deduction<FlowDesign> d0 = SelectedInstanceDeduction.create(FlowDesignEntity.INSTANCE);
		Deduction<java.util.List<FlowNodeBaseDesign>> d1 = AttributeDeduction.create(FlowDesignEntity.nodes, d0);
		return d1;
	}

	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(new PageFragment[]{
            new SimpleLink(HomeEvent.INSTANCE, new ConstantText("Home")),
            new SimpleLink(ExploreInstanceEvent.INSTANCE, new ConstantText("Open in case explorer")),
            new SimpleField(DesignEntity.INSTANCE, DesignEntity.name),
            new ConstantText("Nodes"),
            new SimpleCompositePageFragment(createDeduction1(), new PageFragment[]{
                new SimpleLink(FlowNodeDetailsEvent.INSTANCE, new TemplatedText().add(createDeduction0()))
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
