package app.designer.flow.main;

import app.designer.flow.*;
import app.designer.container.*;
import app.designer.button.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;

public class PageToolboxPage extends Page {

	public static final PageToolboxPage INSTANCE = new PageToolboxPage();
	
	@Override
	public CompositePageFragment getRootContainer() {
		return PageToolboxContainer.INSTANCE;
	}; 
	
	@Override
	public String getName() {
		return "PageToolbox";
	}
	
}
