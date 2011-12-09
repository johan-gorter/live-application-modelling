package app.designer.flow.main;

import app.designer.*;
import app.designer.event.*;
import app.designer.flow.*;
import app.designer.entity.*;
import lbe.instance.*;
import lbe.model.flow.*;
import lbe.model.deduction.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

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
                        new SimpleLink(EntityDetailsEvent.INSTANCE, new TemplatedText().add(createDeduction0()))
                    })
                }).withPresentation("column"),
                new SimpleCompositePageFragment(new PageFragment[]{
                    new ConstantText("Flows"),
                    new SimpleCompositePageFragment(createDeduction3(), new PageFragment[]{
                        new SimpleLink(FlowDetailsEvent.INSTANCE, new TemplatedText().add(createDeduction2()))
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
