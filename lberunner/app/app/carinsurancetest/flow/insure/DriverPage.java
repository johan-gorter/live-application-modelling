package app.carinsurancetest.flow.insure;

import app.carinsurancetest.flow.*;
import app.carinsurancetest.container.*;
import app.carinsurancetest.button.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;

public class DriverPage extends Page {

	public static final DriverPage INSTANCE = new DriverPage();
	
	@Override
	public Container getRootContainer() {
		return DriverContainer.INSTANCE;
	}; 
	
	@Override
	public String getName() {
		return "Driver";
	}
	
}
