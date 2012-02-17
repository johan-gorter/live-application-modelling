package app.designer.flow.field;

import org.instantlogic.fabric.deduction.AttributeDeduction;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.deduction.SelectedInstanceDeduction;
import org.instantlogic.fabric.text.ConstantText;
import org.instantlogic.interaction.flow.Page;
import org.instantlogic.interaction.page.CompositePageFragment;
import org.instantlogic.interaction.page.PageFragment;
import org.instantlogic.interaction.page.impl.SimpleCompositePageFragment;
import org.instantlogic.interaction.page.impl.SimpleField;
import org.instantlogic.interaction.page.impl.SimpleLink;

import app.designer.AttributeDesign;
import app.designer.FieldDesign;
import app.designer.entity.AttributeDesignEntity;
import app.designer.entity.DesignEntity;
import app.designer.entity.FieldDesignEntity;
import app.designer.event.ExploreInstanceEvent;
import app.designer.event.FlowDetailsEvent;
import app.designer.event.HomeEvent;
import app.designer.event.PageDetailsEvent;

public class FieldPage extends Page {

	public static final FieldPage INSTANCE = new FieldPage();


	private static Deduction<AttributeDesign> createDeduction0() {
		  	Deduction<FieldDesign> d0 = SelectedInstanceDeduction.create(FieldDesignEntity.INSTANCE);
		  	Deduction<AttributeDesign> d1 = AttributeDeduction.create(FieldDesignEntity.attribute, d0);
		return d1;
	}

	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(new PageFragment[]{
            new SimpleLink(HomeEvent.INSTANCE, new ConstantText("Home")),
            new SimpleLink(FlowDetailsEvent.INSTANCE, new ConstantText("Flow")),
            new SimpleLink(PageDetailsEvent.INSTANCE, new ConstantText("Page")),
            new SimpleLink(ExploreInstanceEvent.INSTANCE, new ConstantText("Open in case explorer")),
            new SimpleField(FieldDesignEntity.INSTANCE, FieldDesignEntity.required),
            new SimpleField(FieldDesignEntity.INSTANCE, FieldDesignEntity.readOnly),
            new SimpleCompositePageFragment(createDeduction0(), new PageFragment[]{
                new SimpleField(DesignEntity.INSTANCE, DesignEntity.name).setRequired(),
                new SimpleField(AttributeDesignEntity.INSTANCE, AttributeDesignEntity.className).setRequired()
            })
        }); 
	
	@Override
	public CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "Field";
	}
	
}
