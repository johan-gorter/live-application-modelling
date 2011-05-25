package lbemodel.flow.insure;

import lbe.model.ContainerModel;
import lbe.model.PageElementModelBase;
import lbe.model.PageModel;
import lbemodel.button.NextButton;
import lbemodel.container.DriverContainer;

public class DriverPage extends PageModel {

	public static final DriverPage INSTANCE = new DriverPage();
	
	private static final PageElementModelBase[] ROOTS = new PageElementModelBase[]{
		DriverContainer.INSTANCE,
		NextButton.INSTANCE
	}; 
	
	@Override
	public String getName() {
		return "Driver";
	}
	
	@Override
	public PageElementModelBase[] getRootContainers() {
		return ROOTS;
	}

}
