package org.instantlogic.interaction.page.impl;

import lbe.engine.RenderContext;

import org.instantlogic.core.deduction.Deduction;
import org.instantlogic.core.text.Text;
import org.instantlogic.interaction.page.CompositePageFragment;
import org.instantlogic.interaction.page.PageFragment;

public class SimpleCompositePageFragment extends CompositePageFragment {

	private final PageFragment[] children;
	private final Deduction<?> select;
	private final Text display;

	public SimpleCompositePageFragment(PageFragment[] children) {
		this(null, null, children);
	}
	
	public SimpleCompositePageFragment(Deduction<?> relation, PageFragment[] children) {
		this(relation, null, children);
	}
	
	public SimpleCompositePageFragment(Text display, PageFragment[] children) {
		this(null, display, children);
	}
	
	/**
	 * Creates a new SimpleCompositePageFragment
	 * @param select The optional deduction which results in a single instance or multiple instances, often a relation.
	 * @param display The optional header to display
	 * @param children The children in the hierarchy.
	 */
	public SimpleCompositePageFragment(Deduction<?> select, Text display, PageFragment[] children) {
		this.select = select;
		this.display = display;
		this.children = children;
		
	}
	
	@Override
	public PageFragment[] getChildren(RenderContext context) {
		return children;
	}
	
	@Override
	public Deduction<?> getSelect() {
		return this.select;
	}
	
	@Override
	public Text getDisplay() {
		return this.display;
	}
}
