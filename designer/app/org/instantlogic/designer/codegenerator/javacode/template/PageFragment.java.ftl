package ${rootPackageName}.sharedpagefragment;
<#include "Content.java.ftl">
<#include "DeductionScheme.java.ftl">

public<#if isCustomized> abstract</#if> class <#if isCustomized>Abstract</#if>${name}PageFragment extends org.instantlogic.interaction.page.impl.SimpleSharedPageFragment {
	
	public static ${name}PageFragment INSTANCE = new ${name}PageFragment();
	
	protected ${name}PageFragment() {
	}

<#list deductionSchemes as scheme>
	<@deductionscheme_macro scheme=scheme />
</#list>
	
	public static final org.instantlogic.interaction.page.PageFragment SHARED_INSTANCE = 
<@content_macro content=content depth=2 />; 
	

	@Override
	protected org.instantlogic.interaction.page.PageFragment getDelegate() {
		return SHARED_INSTANCE;
	}
}
