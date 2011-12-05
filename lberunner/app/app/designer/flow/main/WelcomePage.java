package app.designer.flow.main;

import app.designer.event.*;
import app.designer.flow.*;
import app.designer.entity.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class WelcomePage extends Page {

	public static final WelcomePage INSTANCE = new WelcomePage();
	
	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(new PageFragment[]{
            new ConstantText("Welcome to the Designer"),
            new SimpleCompositePageFragment(new PageFragment[]{
                new SimpleCompositePageFragment(new PageFragment[]{
                    new ConstantText("Entities"),
                    new SimpleCompositePageFragment(ApplicationDesignEntity.entities, new PageFragment[]{
                        new SimpleLink(EntityDetailsEvent.INSTANCE, new TemplatedText().add(ConceptEntity.name))
                    })
                }).withPresentation("column"),
                new SimpleCompositePageFragment(new PageFragment[]{
                    new ConstantText("Flows"),
                    new SimpleCompositePageFragment(ApplicationDesignEntity.flows, new PageFragment[]{
                        new SimpleLink(FlowDetailsEvent.INSTANCE, new TemplatedText().add(ConceptEntity.name))
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
