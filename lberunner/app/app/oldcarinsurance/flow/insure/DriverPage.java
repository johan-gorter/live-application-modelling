package app.oldcarinsurance.flow.insure;

import org.instantlogic.interaction.flow.Page;
import org.instantlogic.interaction.page.CompositeFragmentTemplate;
import org.instantlogic.interaction.page.PageFragment;

import app.oldcarinsurance.button.NextButton;
import app.oldcarinsurance.sharedPageFragment.DriverContainer;

public class DriverPage extends Page {

	public static final DriverPage INSTANCE = new DriverPage();
	
	private static final PageFragment[] ROOTS = new PageFragment[]{
		DriverContainer.INSTANCE,
		NextButton.INSTANCE
	}; 
	
	@Override
	public String getName() {
		return "Driver";
	}
	
	@Override
	public CompositeFragmentTemplate getRootContainer() {
		return DriverContainer.INSTANCE;
	}

}
