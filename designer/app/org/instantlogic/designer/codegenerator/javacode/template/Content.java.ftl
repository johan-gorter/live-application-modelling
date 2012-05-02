<#include "Text.java.ftl">
<#macro content_macro content depth>
  <#list 1..depth as i>    </#list><#t>
  <#if content.category=="SharedFragment">
    ${rootPackageName}.sharedpagefragment.${content.name}PageFragment.INSTANCE
  <#elseif content.category=="Composite">
    new <#if content.customization??>${content.customization}<#else>org.instantlogic.interaction.page.CompositeFragmentTemplate</#if>("${content.id}", <#t>
    <#if content.deductionIndex??>createDeduction${content.deductionIndex}(), </#if><#t>
    new org.instantlogic.interaction.page.FragmentTemplate[]{<#lt>
    <#list content.children as childContent>
      <@content_macro content=childContent depth=depth+1 />
      <#if childContent_has_next>,</#if><#lt>
    </#list>
    <#list 1..depth as i>    </#list><#t>
    })<#t>
  <#elseif content.category=="Widget">
    new org.instantlogic.interaction.page.WidgetFragmentTemplate("${content.id}", "${content.widgetName}")<#t>
    <#if content.event??>
      .setEvent(${content.event}Event.INSTANCE)
    </#if>
    <#if content.attribute??>
      .setField(${rootPackageName}.entity.${content.entity}Entity.INSTANCE, ${rootPackageName}.entity.${content.entity}Entity.${content.attribute})
    </#if>
    <#list content.staticWidgetData?keys as key>
      .set("${key}","${staticWidgetData[key]}")
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