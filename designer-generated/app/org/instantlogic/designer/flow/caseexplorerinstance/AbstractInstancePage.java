package org.instantlogic.designer.flow.caseexplorerinstance;

public abstract class AbstractInstancePage extends org.instantlogic.interaction.flow.Place {

	public static final InstancePage INSTANCE = new InstancePage();

	
	private static org.instantlogic.interaction.page.CompositeFragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.CompositeFragmentTemplate("C1", null, new org.instantlogic.interaction.page.FragmentTemplate[]{
        }); 
	
	@Override
	public org.instantlogic.interaction.page.CompositeFragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "Instance";
    }
}
