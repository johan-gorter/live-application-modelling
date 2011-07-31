<#list containers as container>

	private static final Container ${container.constName} = new SimpleContainer("${container.name}"
		<#list children as element>
		, <#if element.type=="Field">
		new SimpleField(${element.entity}Entity.${element.attribute})<#if element.required>.setRequired()</#if><#if element.readOnly>.setReadOnly()</#if>
		<#elseif element.type=="ConstantText">
		new ConstantText("${element.untranslated}")
		<#elseif element.type=="Button">
		new SimpleButton("${element.name}", ${element.caption})
		<#else>
		${element.name}
		</#if>
		</#list>
	};

</#list>
