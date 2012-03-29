<#macro text_macro text>
	<#if text.type=="constant">
    	new org.instantlogic.fabric.text.ConstantText("${text.untranslatedConstant}")<#t>
    </#if>
	<#if text.type=="templated">
    	new org.instantlogic.fabric.text.TemplatedText()<#t>
    	<#list text.stringProducers as sp>
    		<#if sp.type=="constant">
    			.add("${sp.constant}")<#t>
    		</#if>
    		<#if sp.type=="formattedValue">
    			.add(createDeduction${sp.deductionIndex}())<#t>
    		</#if>
    	</#list>
    </#if>
</#macro>