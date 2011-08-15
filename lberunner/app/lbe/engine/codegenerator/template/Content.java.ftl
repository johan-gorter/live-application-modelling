<#include "Text.java.ftl">
<#macro content_macro content depth>
    <#list 1..depth as i>    </#list><#t>
	<#if content.type=="Field">
    new SimpleField(${content.entity}Entity.${content.attribute})<#t>
    <#if content.required>.setRequired()</#if><#t>
    <#if content.readOnly>.setReadOnly()</#if><#t>
	<#elseif content.type=="ConstantText">
	<@text_macro text=content.text /><#t>
	<#elseif content.type=="Button">
    new SimpleButton("${content.name}", ${content.caption})<#t>
	<#elseif content.type=="CompositePageFragment" || content.type=="Select" || content.type=="Header">
    new SimpleCompositePageFragment(<#t>
    <#if content.type=="Select">${content.relationEntity}Entity.${content.relationName}, </#if><#t>
    <#if content.type=="Header"><@text_macro text=content.text />, </#if><#t>
    new PageFragment[]{<#lt>
	<#list content.children as childContent>
	  <@content_macro content=childContent depth=depth+1 />
	  <#if childContent_has_next>,</#if><#lt>
	</#list>
	<#list 1..depth as i>    </#list><#t>
	})<#t>
	</#if>
</#macro>
<#--

	private static CompositePageFragment CONTENT = new SimpleCompositePageFragment(new PageFragment[]{
		new SimpleCompositePageFragment(CarinsuranceCaseEntity.driver, new PageFragment[]{
			new SimpleCompositePageFragment(new ConstantText("Driver"), new PageFragment[]{
				new SimpleField(DriverEntity.carUse)
			})
		})
	}); 

-->