package lbemodel.flow.insure;

import lbe.model.flow.Page;
import lbe.model.pageelement.Container;
import lbe.model.pageelement.PageElementBase;
import lbemodel.button.NextButton;
import lbemodel.container.DriverContainer;

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
	public PageElementBase[] getRootContainers() {
		return ROOTS;
	}

}
