package app.carinsurance.flow.insure;

import app.carinsurance.button.NextButton;
import app.carinsurance.container.DriverContainer;
import lbe.model.flow.Page;
import lbe.model.pageelement.Container;
import lbe.model.pageelement.PageElementBase;

public class DriverPage extends Page {

	public static final DriverPage INSTANCE = new DriverPage();
	
	private static final PageElementBase[] ROOTS = new PageElementBase[]{
		DriverContainer.INSTANCE,
		NextButton.INSTANCE
	}; 
	
	@Override
	public String getName() {
		return "Driver";
	}
	
	@Override
	public Container getRootContainer() {
		return DriverContainer.INSTANCE;
	}

}
