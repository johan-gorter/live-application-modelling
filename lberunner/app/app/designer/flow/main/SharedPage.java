package app.designer.flow.main;

import app.designer.flow.*;
import app.designer.data.entity.*;
import app.designer.container.*;
import app.designer.button.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class SharedPage extends Page {

	public static final SharedPage INSTANCE = new SharedPage();
	
	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(new PageFragment[]{
        }); 
	
	@Override
	public CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "Shared";
	}
	
}