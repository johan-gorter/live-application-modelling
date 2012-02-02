<#macro deductionscheme_macro scheme>

	private static Deduction<${scheme.lastResultType}> createDeduction${scheme.index}() {
		<#list scheme.deductions as deduction>
		  <#if deduction.customization??>
		    Deduction<${deduction.resultType}> d${deduction.index} = new ${deduction.customization}(<#list deduction.parameters as parameters>${parameters}<#if parameters_has_next>, </#if></#list>);
		  <#else>
		  	Deduction<${deduction.resultType}> d${deduction.index} = ${deduction.type}.create(<#list deduction.parameters as parameters>${parameters}<#if parameters_has_next>, </#if></#list>);
		  </#if>
		</#list>
		return d${scheme.lastDeductionIndex};
	}

</#macro>