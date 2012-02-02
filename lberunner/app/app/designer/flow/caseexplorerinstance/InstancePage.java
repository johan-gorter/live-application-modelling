package app.designer.flow.caseexplorerinstance;

import org.instantlogic.interaction.flow.Page;
import org.instantlogic.interaction.page.CompositePageFragment;
import org.instantlogic.interaction.page.PageFragment;
import org.instantlogic.interaction.page.impl.SimpleCompositePageFragment;

public class InstancePage extends Page {

	public static final InstancePage INSTANCE = new custom.designer.caseexplorer.InstancePageCustomization();

	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(new PageFragment[]{
        }); 
	
	@Override
	public CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "Instance";
	}
	
}
