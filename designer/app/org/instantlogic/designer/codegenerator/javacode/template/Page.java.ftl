package ${rootPackageName}.flow.${flowname?lower_case};
<#include "Content.java.ftl">
<#include "DeductionScheme.java.ftl">

public<#if isCustomized> abstract</#if> class <#if isCustomized>Abstract</#if>${name}Page extends org.instantlogic.interaction.flow.Page {

	public static final ${name}Page INSTANCE = new ${name}Page();

<#list deductionSchemes as scheme>
	<@deductionscheme_macro scheme=scheme />
</#list>
	
	private static org.instantlogic.interaction.page.CompositePageFragment CONTENT = 
<@content_macro content=content depth=2 />; 
	
	@Override
	public org.instantlogic.interaction.page.CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "${name}";
    }
}
