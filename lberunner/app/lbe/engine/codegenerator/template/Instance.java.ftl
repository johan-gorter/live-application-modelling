package app.${appname}.data.instance;

import java.util.List;

import app.${appname}.data.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class ${name}Instance 
	extends <#if caseEntity>SimpleCaseInstance<#else><#if extendsFrom??>${extendsFrom}Instance<#else>SimpleInstance</#if></#if> 
	implements Instance {

	<#if caseEntity>
	public ${name}Instance() {
		super(${name}Entity.INSTANCE);
	}
	<#else>
	public ${name}Instance(CaseInstance caseInstance) {
		super(caseInstance, ${name}Entity.INSTANCE);
	}
	
	protected ${name}Instance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}
	</#if>

	// Attributes
	<#list attributes as attribute>
	
	public final <#if attribute.readonly>ReadOnly</#if>AttributeValue<#if attribute.multivalue>s</#if><${name}Instance, ${attribute.itemClassName}> ${attribute.name}
		= create<#if attribute.readonly>ReadOnly</#if>AttributeValue<#if attribute.multivalue>s</#if>(${name}Entity.${attribute.name});
	</#list>
	
	// Relations
	<#list relations as relation>
	
	public final <#if relation.readonly>ReadOnly</#if>RelationValue<#if relation.multivalue>s</#if><${name}Instance, ${relation.item}Instance> ${relation.name}
		= create<#if relation.readonly>ReadOnly</#if>RelationValue<#if relation.multivalue>s</#if>(${name}Entity.${relation.name});
	</#list>

	// Reverse relations
	<#list reverseRelations as relation>
	
	public final ReadOnlyRelationValue<#if relation.multivalue>s</#if><${name}Instance, ${relation.item}Instance> ${relation.name}
		= createReverseRelationValue<#if relation.multivalue>s</#if>(${name}Entity.${relation.name});
	</#list>

}
