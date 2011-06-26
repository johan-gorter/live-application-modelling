package app.designer.flow.main;

import app.designer.flow.*;
import app.designer.container.*;
import app.designer.button.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;

public class WelcomePage extends Page {

	public static final WelcomePage INSTANCE = new WelcomePage();
	
	@Override
	public Container getRootContainer() {
		return WelcomeContainer.INSTANCE;
	}; 
	
	@Override
	public String getName() {
		return "Welcome";
	}
	
}
