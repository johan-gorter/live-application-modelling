package app.designer.flow.main;

import lbe.model.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import app.designer.data.entity.*;

public class PageToolboxContainer extends CompositePageFragment {

	public static PageToolboxContainer INSTANCE = new PageToolboxContainer();
	
	private PageToolboxContainer() {}
	
	private static final PageFragment[] CHILDREN = new PageFragment[] {
	};

	@Override
	public String getName() {
		return "PageToolbox";
	}

	@Override
	public PageFragment[] getChildren() {
		return CHILDREN;
	}
}
