package ${rootPackageName}.sharedpagefragment;
<#include "Content.java.ftl">
<#include "DeductionScheme.java.ftl">

public<#if isCustomized> abstract</#if> class <#if isCustomized>Abstract</#if>${name}PageFragment extends org.instantlogic.interaction.page.SharedElement {
	
	
<#list deductionSchemes as scheme>
	<@deductionscheme_macro scheme=scheme />
</#list>
	
	public static final org.instantlogic.interaction.page.Element SHARED_INSTANCE = 
<@content_macro content=content depth=2 />; 

	public static ${name}PageFragment INSTANCE = new ${name}PageFragment();
	
	protected <#if isCustomized>Abstract</#if>${name}PageFragment() {
		super(SHARED_INSTANCE);
	}
	
}
