package app.${appname}.flow.${flowname?lower_case};

import app.${appname}.flow.*;
import app.${appname}.container.*;
import app.${appname}.button.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;

public class ${name}Page extends Page {

	public static final ${name}Page INSTANCE = new ${name}Page();
	
	private static final PageElementBase[] ROOT_ELEMENTS = new PageElementBase[]{
	<#list rootElements as rootElement>
		${rootElement.name}${rootElement.type}.INSTANCE,
	</#list>
	}; 
	
	@Override
	public String getName() {
		return "${name}";
	}
	
	@Override
	public PageElementBase[] getRootElements() {
		return ROOT_ELEMENTS;
	}
}
