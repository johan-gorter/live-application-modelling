<#macro deductionscheme_macro scheme>

	private static Deduction<?> createDeduction${scheme.index}() {
		<#list scheme.deductions as deduction>
		Deduction<${deduction.resultType}> d${deduction.index} = ${deduction.type}.create(<#list deduction.parameters as parameters>${parameters}<#if parameters_has_next>, </#if></#list>);
		</#list>
		return d${scheme.lastDeductionIndex};
	}

</#macro>