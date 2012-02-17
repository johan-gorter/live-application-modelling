package app.designer.flow.flow;

import org.instantlogic.fabric.deduction.AttributeDeduction;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.deduction.SelectedInstanceDeduction;
import org.instantlogic.fabric.text.ConstantText;
import org.instantlogic.fabric.text.TemplatedText;
import org.instantlogic.interaction.flow.Page;
import org.instantlogic.interaction.page.CompositePageFragment;
import org.instantlogic.interaction.page.PageFragment;
import org.instantlogic.interaction.page.impl.SimpleCompositePageFragment;
import org.instantlogic.interaction.page.impl.SimpleField;
import org.instantlogic.interaction.page.impl.SimpleLink;

import app.designer.Design;
import app.designer.FlowDesign;
import app.designer.FlowNodeBaseDesign;
import app.designer.entity.DesignEntity;
import app.designer.entity.FlowDesignEntity;
import app.designer.event.ExploreInstanceEvent;
import app.designer.event.FlowNodeDetailsEvent;
import app.designer.event.HomeEvent;

public class FlowPage extends Page {

	public static final FlowPage INSTANCE = new FlowPage();


	private static Deduction<java.lang.String> createDeduction0() {
		  	Deduction<Design> d0 = SelectedInstanceDeduction.create(DesignEntity.INSTANCE);
		  	Deduction<java.lang.String> d1 = AttributeDeduction.create(DesignEntity.name, d0);
		return d1;
	}


	private static Deduction<java.util.List<FlowNodeBaseDesign>> createDeduction1() {
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
