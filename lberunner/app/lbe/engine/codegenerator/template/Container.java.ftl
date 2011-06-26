package app.${appname}.${subpackageName!"container"};

import lbe.model.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import app.${appname}.data.entity.*;

public class ${name}Container extends Container {

	public static ${name}Container INSTANCE = new ${name}Container();
	
	private ${name}Container() {}
	
	private static final PageElementBase[] CHILDREN = new PageElementBase[] {
		<#list children as element>
		<#if element.type=="Field">
		new SimpleField(${element.entity}Entity.${element.attribute})<#if element.required>.setRequired()</#if><#if element.readOnly>.setReadOnly()</#if>,
		<#elseif element.type=="ConstantText">
		new ConstantText("${element.untranslated}"),
		<#elseif element.type=="Button">
		new SimpleButton("${element.name}", ${element.caption}),
		<#else>
		${element.name}${element.type}.INSTANCE,
		</#if>
		</#list>
	};

	@Override
	public String getName() {
		return "${name}";
	}
	<#if display??>

	private static final Text DISPLAY = ${display};
	@Override
	public Text getDisplay() {
		return DISPLAY;
	}
	</#if>

	@Override
	public PageElementBase[] getChildren() {
		return CHILDREN;
	}
	<#if relationName??>

	@Override
	public Relation getRelation() {
		return ${relationEntity}Entity.${relationName};
	}
	</#if>
}
