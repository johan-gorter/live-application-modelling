package app.designer.flow.attribute;

import org.instantlogic.interaction.flow.Page;
import org.instantlogic.interaction.page.CompositePageFragment;
import org.instantlogic.interaction.page.PageFragment;
import org.instantlogic.interaction.page.impl.SimpleCompositePageFragment;

public class AttributePage extends Page {

	public static final AttributePage INSTANCE = new AttributePage();

	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(new PageFragment[]{
        }); 
	
	@Override
	public CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "Attribute";
	}
	
}
