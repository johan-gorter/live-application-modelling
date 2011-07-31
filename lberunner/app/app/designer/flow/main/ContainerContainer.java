package app.designer.flow.main;

import lbe.model.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import app.designer.data.entity.*;

public class ContainerContainer extends CompositePageFragment {

	public static ContainerContainer INSTANCE = new ContainerContainer();
	
	private ContainerContainer() {}
	
	private static final PageFragment[] CHILDREN = new PageFragment[] {
	};

	@Override
	public String getName() {
		return "Container";
	}

	@Override
	public PageFragment[] getChildren() {
		return CHILDREN;
	}
}
