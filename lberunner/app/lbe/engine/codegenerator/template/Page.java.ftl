package ${rootPackageName}.flow.${flowname?lower_case};
<#include "Content.java.ftl">
<#include "DeductionScheme.java.ftl">

import ${rootPackageName}.*;
import ${rootPackageName}.event.*;
import ${rootPackageName}.flow.*;
import ${rootPackageName}.entity.*;
import ${rootPackageName}.sharedpagefragment.*;
import lbe.instance.*;
import lbe.model.flow.*;
import lbe.model.deduction.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class ${name}Page extends Page {

	public static final ${name}Page INSTANCE = new <#if customization??>${customization}<#else>${name}Page</#if>();

<#list deductionSchemes as scheme>
	<@deductionscheme_macro scheme=scheme />
</#list>
	
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
