package app.designer.flow.main;

import app.designer.flow.*;
import app.designer.container.*;
import app.designer.button.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;

public class ContainerPage extends Page {

	public static final ContainerPage INSTANCE = new ContainerPage();
	
	private static final PageElementBase[] ROOT_ELEMENTS = new PageElementBase[]{
	}; 
	
	@Override
	public String getName() {
		return "Container";
	}
	
	@Override
	public PageElementBase[] getRootElements() {
		return ROOT_ELEMENTS;
	}
}
