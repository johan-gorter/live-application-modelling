<#macro text_macro text>
new org.instantlogic.fabric.text.TextTemplate(<#t>
<#list text.untranslated as st>
	<#if st.type=="constant">
        "${st.constant}"<#t>
	</#if>
	<#if st.type=="formattedValue">
		createDeduction${st.deductionIndex}()<#t>
	</#if>
	<#if st_has_next>,</#if><#t>
</#list>
</#macro>