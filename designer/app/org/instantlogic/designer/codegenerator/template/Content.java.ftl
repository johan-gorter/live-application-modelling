<#include "Text.java.ftl">
<#macro content_macro content depth>
  <#list 1..depth as i>    </#list><#t>
  <#if content.type=="SharedFragment">
    ${content.name}PageFragment.INSTANCE
  <#elseif content.type=="Field">
    new SimpleField(${content.entity}Entity.INSTANCE, ${content.entity}Entity.${content.attribute})<#t>
    <#if content.required>.setRequired()</#if><#t>
    <#if content.readOnly>.setReadOnly()</#if><#t>
  <#elseif content.type=="ConstantText">
	<@text_macro text=content.text /><#t>
  <#elseif content.type=="TemplatedText">
	<@text_macro text=content.text /><#t>
  <#elseif content.type=="Button">
    new SimpleButton(<#if content.event??>${content.event}Event.INSTANCE<#else>null</#if>, <@text_macro text=content.text />)<#t>
  <#elseif content.type=="Link">
    new SimpleLink(<#if content.event??>${content.event}Event.INSTANCE<#else>null</#if>, <@text_macro text=content.text />)<#t>
  <#elseif content.type=="CompositePageFragment" || content.type=="Select" || content.type=="Header">
    new <#if content.customization??>${content.customization}<#else>SimpleCompositePageFragment</#if>(<#t>
    <#if content.type=="Select">createDeduction${content.deductionIndex}(), </#if><#t>
    <#if content.type=="Header"><@text_macro text=content.text />, </#if><#t>
    new PageFragment[]{<#lt>
	<#list content.children as childContent>
	  <@content_macro content=childContent depth=depth+1 />
	  <#if childContent_has_next>,</#if><#lt>
	</#list>
	<#list 1..depth as i>    </#list><#t>
	})<#t>
	<#else>
	new <#if content.customization??>${content.customization}<#else>SimpleCompositePageFragment</#if>()<#t>
	</#if>
	<#if content.presentation??>.withPresentation("${content.presentation}")</#if><#t>
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