package org.instantlogic.designer.flow.caseexplorerinstance;

public abstract class AbstractInstancePage extends org.instantlogic.interaction.flow.Page {

	public static final InstancePage INSTANCE = new InstancePage();

	
	private static org.instantlogic.interaction.page.CompositePageFragment CONTENT = 
        new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(new org.instantlogic.interaction.page.PageFragment[]{
        }); 
	
	@Override
	public org.instantlogic.interaction.page.CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "Instance";
	}
	
}