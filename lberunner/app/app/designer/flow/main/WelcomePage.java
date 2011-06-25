package app.designer.flow.main;

import app.designer.flow.*;
import app.designer.container.*;
import app.designer.button.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;

public class WelcomePage extends Page {

	public static final WelcomePage INSTANCE = new WelcomePage();
	
	private static final PageElementBase[] ROOT_ELEMENTS = new PageElementBase[]{
	}; 
	
	@Override
	public String getName() {
		return "Welcome";
	}
	
	@Override
	public PageElementBase[] getRootElements() {
		return ROOT_ELEMENTS;
	}
}
