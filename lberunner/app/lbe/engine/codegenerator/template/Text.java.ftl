<#macro text_macro text>
	<#if text.type=="constant">
    	new ConstantText("${text.untranslatedConstant}")<#t>
    </#if>
	<#if text.type=="templated">
    	new TemplatedText()<#t>
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