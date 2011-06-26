package app.designer.flow.main;

import lbe.model.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import app.designer.data.entity.*;

public class PageToolboxContainer extends Container {

	public static PageToolboxContainer INSTANCE = new PageToolboxContainer();
	
	private PageToolboxContainer() {}
	
	private static final PageElementBase[] CHILDREN = new PageElementBase[] {
	};

	@Override
	public String getName() {
		return "PageToolbox";
	}

	@Override
	public PageElementBase[] getChildren() {
		return CHILDREN;
	}
}
