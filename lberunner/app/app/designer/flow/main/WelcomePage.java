package app.designer.flow.main;

import org.instantlogic.core.deduction.AttributeDeduction;
import org.instantlogic.core.deduction.Deduction;
import org.instantlogic.core.deduction.SelectedInstanceDeduction;
import org.instantlogic.core.text.ConstantText;
import org.instantlogic.core.text.TemplatedText;
import org.instantlogic.interaction.flow.Page;
import org.instantlogic.interaction.page.CompositePageFragment;
import org.instantlogic.interaction.page.PageFragment;
import org.instantlogic.interaction.page.impl.SimpleCompositePageFragment;
import org.instantlogic.interaction.page.impl.SimpleLink;

import app.designer.ApplicationDesign;
import app.designer.Design;
import app.designer.EntityDesign;
import app.designer.FlowDesign;
import app.designer.entity.ApplicationDesignEntity;
import app.designer.entity.DesignEntity;
import app.designer.event.EntityDetailsEvent;
import app.designer.event.FlowDetailsEvent;

public class WelcomePage extends Page {

	public static final WelcomePage INSTANCE = new WelcomePage();


	private static Deduction<?> createDeduction0() {
		Deduction<Design> d0 = SelectedInstanceDeduction.create(DesignEntity.INSTANCE);
		Deduction<java.lang.String> d1 = AttributeDeduction.create(DesignEntity.name, d0);
		return d1;
	}


	private static Deduction<?> createDeduction1() {
		Deduction<ApplicationDesign> d0 = SelectedInstanceDeduction.create(ApplicationDesignEntity.INSTANCE);
		Deduction<java.util.List<EntityDesign>> d1 = AttributeDeduction.create(ApplicationDesignEntity.entities, d0);
		return d1;
	}


	private static Deduction<?> createDeduction2() {
		Deduction<Design> d0 = SelectedInstanceDeduction.create(DesignEntity.INSTANCE);
		Deduction<java.lang.String> d1 = AttributeDeduction.create(DesignEntity.name, d0);
		return d1;
	}


	private static Deduction<?> createDeduction3() {
		Deduction<ApplicationDesign> d0 = SelectedInstanceDeduction.create(ApplicationDesignEntity.INSTANCE);
		Deduction<java.util.List<FlowDesign>> d1 = AttributeDeduction.create(ApplicationDesignEntity.flows, d0);
		return d1;
	}

	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(new PageFragment[]{
            new ConstantText("Welcome to the Designer"),
            new SimpleCompositePageFragment(new PageFragment[]{
                new SimpleCompositePageFragment(new PageFragment[]{
                    new ConstantText("Entities"),
                    new SimpleCompositePageFragment(createDeduction1(), new PageFragment[]{
                        new SimpleCompositePageFragment(new PageFragment[]{
                            new SimpleLink(EntityDetailsEvent.INSTANCE, new TemplatedText().add(createDeduction0()))
                        }).withPresentation("row")
                    })
                }).withPresentation("column"),
                new SimpleCompositePageFragment(new PageFragment[]{
                    new ConstantText("Flows"),
                    new SimpleCompositePageFragment(createDeduction3(), new PageFragment[]{
                        new SimpleCompositePageFragment(new PageFragment[]{
                            new SimpleLink(FlowDetailsEvent.INSTANCE, new TemplatedText().add(createDeduction2()))
                        }).withPresentation("row")
                    })
                }).withPresentation("column")
            }).withPresentation("four-columns")
        }); 
	
	@Override
	public CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "Welcome";
	}
	
}
