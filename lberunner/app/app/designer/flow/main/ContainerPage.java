package app.designer.flow.main;

import app.designer.flow.*;
import app.designer.container.*;
import app.designer.button.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;

public class ContainerPage extends Page {

	public static final ContainerPage INSTANCE = new ContainerPage();
	
	@Override
	public Container getRootContainer() {
		return ContainerContainer.INSTANCE;
	}; 
	
	@Override
	public String getName() {
		return "Container";
	}
	
}
