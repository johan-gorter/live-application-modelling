package ${rootPackageName}.flow.${flowname?lower_case};
<#include "Content.java.ftl">
<#include "DeductionScheme.java.ftl">

public<#if isCustomized> abstract</#if> class <#if isCustomized>Abstract</#if>${technicalNameCapitalized}PlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final ${technicalNameCapitalized}PlaceTemplate INSTANCE = new ${technicalNameCapitalized}PlaceTemplate();

<#list deductionSchemes as scheme>
	<@deductionscheme_macro scheme=scheme />
</#list>
	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
<@content_macro content=content depth=2 />; 
	
	@Override
	public org.instantlogic.interaction.page.FragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "${name}";
    }
}