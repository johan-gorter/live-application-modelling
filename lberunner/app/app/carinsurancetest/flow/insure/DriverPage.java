package app.carinsurancetest.flow.insure;

import app.carinsurancetest.flow.*;
import app.carinsurancetest.container.*;
import app.carinsurancetest.button.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.SimpleContainer;

public class DriverPage extends Page {

	public static final DriverPage INSTANCE = new DriverPage();
	
	private static final CompositePageFragment CONTENT = new SimpleContainer("x");
	
	@Override
	public CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "Driver";
	}
	
}
