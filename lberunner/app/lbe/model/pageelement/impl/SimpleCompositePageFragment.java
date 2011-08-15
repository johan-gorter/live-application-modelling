package lbe.model.pageelement.impl;

import lbe.model.Relation;
import lbe.model.pageelement.CompositePageFragment;
import lbe.model.pageelement.PageFragment;
import lbe.model.pageelement.Text;

public class SimpleCompositePageFragment extends CompositePageFragment {

	private final PageFragment[] children;
	private final Relation relation;
	private final Text display;

	public SimpleCompositePageFragment(PageFragment[] children) {
		this(null, null, children);
	}
	
	public SimpleCompositePageFragment(Relation relation, PageFragment[] children) {
		this(relation, null, children);
	}
	
	public SimpleCompositePageFragment(Text display, PageFragment[] children) {
		this(null, display, children);
	}
	
	public SimpleCompositePageFragment(Relation relation, Text display, PageFragment[] children) {
		this.relation = relation;
		this.display = display;
		this.children = children;
		
	}
	
	@Override
	public PageFragment[] getChildren() {
		return children;
	}
	
	@Override
	public Relation getRelation() {
		return this.relation;
	}
	
	@Override
	public Text getDisplay() {
		return this.display;
	}
}
