package app.designer.flow.entity;

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

import app.designer.AttributeDesign;
import app.designer.Design;
import app.designer.EntityDesign;
import app.designer.entity.DesignEntity;
import app.designer.entity.EntityDesignEntity;
import app.designer.event.AttributeDetailsEvent;
import app.designer.event.ExploreInstanceEvent;
import app.designer.event.HomeEvent;

public class EntityPage extends Page {

	public static final EntityPage INSTANCE = new EntityPage();


	private static Deduction<?> createDeduction0() {
		Deduction<Design> d0 = SelectedInstanceDeduction.create(DesignEntity.INSTANCE);
		Deduction<java.lang.String> d1 = AttributeDeduction.create(DesignEntity.name, d0);
		return d1;
	}


	private static Deduction<?> createDeduction1() {
		Deduction<EntityDesign> d0 = SelectedInstanceDeduction.create(EntityDesignEntity.INSTANCE);
		Deduction<java.util.List<AttributeDesign>> d1 = AttributeDeduction.create(EntityDesignEntity.attributes, d0);
		return d1;
	}

	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(new PageFragment[]{
            new SimpleLink(HomeEvent.INSTANCE, new ConstantText("Home")),
            new SimpleLink(ExploreInstanceEvent.INSTANCE, new ConstantText("Open in case explorer")),
            new SimpleField(DesignEntity.INSTANCE, DesignEntity.name),
            new ConstantText("Attributes"),
            new SimpleCompositePageFragment(createDeduction1(), new PageFragment[]{
                new SimpleCompositePageFragment(new PageFragment[]{
                    new SimpleLink(AttributeDetailsEvent.INSTANCE, new TemplatedText().add(createDeduction0()))
                }).withPresentation("row")
            })
        }); 
	
	@Override
	public CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "Entity";
	}
	
}
