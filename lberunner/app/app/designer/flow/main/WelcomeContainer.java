package app.designer.flow.main;

import lbe.model.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import app.designer.data.entity.*;

public class WelcomeContainer extends Container {

	public static WelcomeContainer INSTANCE = new WelcomeContainer();
	
	private WelcomeContainer() {}
	
	private static final PageElementBase[] CHILDREN = new PageElementBase[] {
		new ConstantText("Welcome to the designer"),
		new SimpleButton("toolbox", new ConstantText("Toolbox")),
	};

	@Override
	public String getName() {
		return "Welcome";
	}

	@Override
	public PageElementBase[] getChildren() {
		return CHILDREN;
	}
}
