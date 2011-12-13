package app.${appname}.sharedpagefragment;
<#include "Content.java.ftl">
<#include "DeductionScheme.java.ftl">

import app.${appname}.*;
import app.${appname}.event.*;
import app.${appname}.flow.*;
import app.${appname}.entity.*;
import app.${appname}.sharedpagefragment.*;
import lbe.instance.*;
import lbe.model.flow.*;
import lbe.model.deduction.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class ${name}PageFragment extends SimpleSharedPageFragment {
	
	public static ${name}PageFragment INSTANCE = new <#if customization??>${customization}<#else>${name}PageFragment</#if>();
	
	protected ${name}PageFragment() {
	}

<#list deductionSchemes as scheme>
	<@deductionscheme_macro scheme=scheme />
</#list>
	
	public static final PageFragment SHARED_INSTANCE = 
<@content_macro content=content depth=2 />; 
	

	@Override
	protected PageFragment getDelegate() {
		return SHARED_INSTANCE;
	}
}
