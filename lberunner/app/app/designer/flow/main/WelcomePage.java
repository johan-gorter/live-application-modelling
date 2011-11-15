package app.designer.flow.main;

import app.designer.flow.*;
import app.designer.data.entity.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class WelcomePage extends Page {

	public static final WelcomePage INSTANCE = new WelcomePage();
	
	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(new PageFragment[]{
            new ConstantText("Welcome to the Designer"),
            new ConstantText("Flows:"),
            new SimpleCompositePageFragment(ApplicationEntity.flows, new PageFragment[]{
                new SimpleField(ConceptEntity.INSTANCE, ConceptEntity.name),
                new SimpleButton("flowDetails", new ConstantText("Details"))
            })
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
