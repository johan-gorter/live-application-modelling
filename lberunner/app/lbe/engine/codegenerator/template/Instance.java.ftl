package app.${appname};

import java.util.List;

import app.${appname}.*;
import app.${appname}.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class ${name} 
	extends <#if caseEntity>SimpleCaseInstance<#else><#if extendsFrom??>${extendsFrom}<#else>SimpleInstance</#if></#if> 
	implements Instance {

	<#if caseEntity>
	public ${name}() {
		super(${name}Entity.INSTANCE, ${applicationName}Application.INSTANCE);
	}
	<#else>
	public ${name}(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public ${name}(CaseInstance caseInstance, long id) {
		super(caseInstance, ${name}Entity.INSTANCE, id);
	}
	
	protected ${name}(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}
	</#if>

	// Attributes
	<#list attributes as attribute>
	
	public final <#if attribute.readonly>ReadOnly</#if>AttributeValue<#if attribute.multivalue>s</#if><${name}, ${attribute.itemClassName}> ${attribute.name}
		= create<#if attribute.readonly>ReadOnly</#if>AttributeValue<#if attribute.multivalue>s</#if>(${name}Entity.${attribute.name});
	
	public ${attribute.className} get${attribute.name?cap_first}() {
		return ${attribute.name}.get();
	}

	<#if !attribute.readonly>	
	public void set${attribute.name?cap_first}(${attribute.className} newValue) {
		${attribute.name}.set(newValue);
	}
	</#if>
	</#list>
	
	// Relations
	<#list relations as relation>
	
	public final <#if relation.readonly>ReadOnly</#if>RelationValue<#if relation.multivalue>s</#if><${name}, ${relation.item}> ${relation.name}
		= create<#if relation.readonly>ReadOnly</#if>RelationValue<#if relation.multivalue>s</#if>(${name}Entity.${relation.name});
		
	public ${relation.to} get${relation.name?cap_first}() {
		return ${relation.name}.get();
	}
	
	<#if !relation.readonly>	
	public void set${relation.name?cap_first}(${relation.to} newValue) {
		${relation.name}.set(newValue);
	}
	</#if>
	</#list>

	// Reverse relations
	<#list reverseRelations as relation>
	
	public final ReadOnlyRelationValue<#if relation.multivalue>s</#if><${name}, ${relation.item}> ${relation.name}
		= createReverseRelationValue<#if relation.multivalue>s</#if>(${name}Entity.${relation.name});

	public ${relation.to} get${relation.name?cap_first}() {
		return ${relation.name}.get();
	}

	</#list>

}
