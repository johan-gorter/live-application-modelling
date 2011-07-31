package app.designer.flow.main;

import lbe.model.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import app.designer.data.entity.*;

public class WelcomeContainer extends CompositePageFragment {

	public static WelcomeContainer INSTANCE = new WelcomeContainer();
	
	private WelcomeContainer() {}
	
	private static final PageFragment[] CHILDREN = new PageFragment[] {
		new ConstantText("Welcome to the designer"),
		new SimpleButton("shared", new ConstantText("Shared items")),
	};

	@Override
	public String getName() {
		return "Welcome";
	}

	@Override
	public PageFragment[] getChildren() {
		return CHILDREN;
	}
}
