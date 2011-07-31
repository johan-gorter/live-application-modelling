package lbe.model.pageelement.impl;

import lbe.model.pageelement.CompositePageFragment;
import lbe.model.pageelement.PageFragment;

public class SimpleContainer extends CompositePageFragment {

	private final PageFragment[] children;

	public SimpleContainer(PageFragment... children) {
		this.children = children;
	}
	
	@Override
	public PageFragment[] getChildren() {
		return children;
	}

}
