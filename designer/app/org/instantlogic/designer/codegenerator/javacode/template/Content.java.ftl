<#include "Text.java.ftl">
<#macro content_macro content depth>
  <#list 1..depth as i>    </#list><#t>
  <#if content.category=="SharedFragment">
    ${rootPackageName}.sharedpagefragment.${content.name}PageFragment.INSTANCE
  <#elseif content.category=="Widget">
    new org.instantlogic.interaction.page.FragmentTemplate("${content.id}", "${content.fragmentTypeName}")<#t>
    <#if content.event??>
      .setEvent(${content.event}Event.INSTANCE)
    </#if>
    <#if content.attribute??>
      .setField(${rootPackageName}.entity.${content.entity}Entity.INSTANCE, ${rootPackageName}.entity.${content.entity}Entity.${content.attribute})
    </#if>
    <#list content.values?keys as key>
      <#nt>
      <#list 1..depth as i>    </#list><#t>
      .putValue("${key}", createDeduction${content.values[key]}())<#t>
    </#list>
    <#list content.texts?keys as key>
      <#nt>
      <#list 1..depth as i>    </#list><#t>
      .putText("${key}", <@text_macro text=content.texts[key] />)<#lt>
    </#list>
    <#list content.childLists?keys as key>
      <#nt>
      <#list 1..depth as i>    </#list><#t>
      .putChildren("${key}"<#t>
        <#list content.childLists[key] as childListChild>
          ,<#lt>
          <@content_macro content=childListChild depth=depth+2 />
        </#list>
      <#list 1..depth as i>    </#list><#t>
      )<#t>
    </#list>
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