package app.designer.flow.caseexplorerinstance;

import app.designer.event.*;
import app.designer.flow.*;
import app.designer.entity.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class InstancePage extends Page {

	public static final InstancePage INSTANCE = new custom.designer.caseexplorer.InstancePageCustomization();
	
	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(new PageFragment[]{
        }); 
	
	@Override
	public CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "Instance";
	}
	
}
