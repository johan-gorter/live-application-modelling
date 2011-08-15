package app.${appname}.flow.${flowname?lower_case};
<#include "Content.java.ftl">

import app.${appname}.flow.*;
import app.${appname}.data.entity.*;
import app.${appname}.container.*;
import app.${appname}.button.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class ${name}Page extends Page {

	public static final ${name}Page INSTANCE = new ${name}Page();
	
	
	private static CompositePageFragment CONTENT = 
<@content_macro content=content depth=2 />; 
	
	@Override
	public CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "${name}";
	}
	
}
