package app.carinsurancetest.flow.insure;

import app.carinsurancetest.flow.*;
import app.carinsurancetest.container.*;
import app.carinsurancetest.button.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;

public class DriverPage extends Page {

	public static final DriverPage INSTANCE = new DriverPage();
	
	private static final PageElementBase[] ROOT_ELEMENTS = new PageElementBase[]{
		DriverContainer.INSTANCE,
	}; 
	
	@Override
	public String getName() {
		return "Driver";
	}
	
	@Override
	public PageElementBase[] getRootElements() {
		return ROOT_ELEMENTS;
	}
}
