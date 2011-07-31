package app.designer.flow.main;

import lbe.model.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import app.designer.data.entity.*;

public class SharedContainer extends CompositePageFragment {

	public static SharedContainer INSTANCE = new SharedContainer();
	
	private SharedContainer() {}
	
	private static final PageFragment[] CHILDREN = new PageFragment[] {
	};

	@Override
	public String getName() {
		return "Shared";
	}

	@Override
	public PageFragment[] getChildren() {
		return CHILDREN;
	}
}
