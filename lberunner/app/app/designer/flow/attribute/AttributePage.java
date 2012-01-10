package app.designer.flow.attribute;

import app.designer.*;
import app.designer.event.*;
import app.designer.flow.*;
import app.designer.entity.*;
import app.designer.sharedpagefragment.*;
import lbe.instance.*;
import lbe.model.flow.*;
import lbe.model.deduction.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class AttributePage extends Page {

	public static final AttributePage INSTANCE = new AttributePage();

	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(new PageFragment[]{
        }); 
	
	@Override
	public CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "Attribute";
	}
	
}
