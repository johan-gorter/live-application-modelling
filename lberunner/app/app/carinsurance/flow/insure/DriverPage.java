package app.carinsurance.flow.insure;

import app.carinsurance.button.NextButton;
import app.carinsurance.container.DriverContainer;
import lbe.model.flow.Page;
import lbe.model.pageelement.CompositePageFragment;
import lbe.model.pageelement.PageFragment;

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
	public CompositePageFragment getRootContainer() {
		return DriverContainer.INSTANCE;
	}

}
