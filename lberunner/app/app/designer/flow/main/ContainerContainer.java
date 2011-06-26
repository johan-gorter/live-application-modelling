package app.designer.flow.main;

import lbe.model.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import app.designer.data.entity.*;

public class ContainerContainer extends Container {

	public static ContainerContainer INSTANCE = new ContainerContainer();
	
	private ContainerContainer() {}
	
	private static final PageElementBase[] CHILDREN = new PageElementBase[] {
	};

	@Override
	public String getName() {
		return "Container";
	}

	@Override
	public PageElementBase[] getChildren() {
		return CHILDREN;
	}
}
