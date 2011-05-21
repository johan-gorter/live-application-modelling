package lbemodel.flow.insure;

import lbe.model.ContainerModel;
import lbe.model.PageElementModelBase;
import lbe.model.PageModel;
import lbemodel.button.NextButton;

public class DriverPage extends PageModel {

	public static final DriverPage INSTANCE = new DriverPage();
	
	@Override
	public String getName() {
		return "Driver";
	}
	
	private PageElementModelBase[] ROOTS = new PageElementModelBase[]{
			NextButton.INSTANCE
	}; 
		
	@Override
	public PageElementModelBase[] getRootContainers() {
		return ROOTS;
	}

}
