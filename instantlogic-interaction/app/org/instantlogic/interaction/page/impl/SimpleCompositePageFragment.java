package org.instantlogic.interaction.page.impl;

import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.text.Text;
import org.instantlogic.interaction.page.CompositePageFragment;
import org.instantlogic.interaction.page.PlaceFragmentTemplate;
import org.instantlogic.interaction.util.RenderContext;

public class SimpleCompositePageFragment extends CompositePageFragment {

	private final PlaceFragmentTemplate[] children;
	private final Deduction<?> select;
	private final Text display;

	public SimpleCompositePageFragment(PlaceFragmentTemplate[] children) {
		this(null, null, children);
	}
	
	public SimpleCompositePageFragment(Deduction<?> relation, PlaceFragmentTemplate[] children) {
		this(relation, null, children);
	}
	
	public SimpleCompositePageFragment(Text display, PlaceFragmentTemplate[] children) {
		this(null, display, children);
	}
	
	/**
	 * Creates a new SimpleCompositePageFragment
	 * @param select The optional deduction which results in a single instance or multiple instances, often a relation.
	 * @param display The optional header to display
	 * @param children The children in the hierarchy.
	 */
	public SimpleCompositePageFragment(Deduction<?> select, Text display, PlaceFragmentTemplate[] children) {
		this.select = select;
		this.display = display;
		this.children = children;
		
	}
	
	@Override
	public PlaceFragmentTemplate[] getChildren(RenderContext context) {
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
