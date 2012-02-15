package ${rootPackageName};

public class ${name} extends <#if extendsFrom??>${extendsFrom}<#else>org.instantlogic.fabric.Instance<${name}></#if> { 

	@Override
	public org.instantlogic.fabric.model.Entity<${name}> getEntity() {
		return ${rootPackageName}.entity.${name}Entity.INSTANCE;
	}

	// Attributes
	<#list attributes as attribute>
	
	public final org.instantlogic.fabric.value.<#if attribute.readonly>ReadOnly</#if>AttributeValue<#if attribute.multivalue>s</#if><${name}, ${attribute.itemClassName}> ${attribute.name}
		= create<#if attribute.readonly>ReadOnly</#if>AttributeValue<#if attribute.multivalue>s</#if>(${rootPackageName}.entity.${name}Entity.${attribute.name});
	
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
	
	public final org.instantlogic.fabric.value.<#if relation.readonly>ReadOnly</#if>RelationValue<#if relation.multivalue>s</#if><${name}, ${relation.item}> ${relation.name}
		= create<#if relation.readonly>ReadOnly</#if>RelationValue<#if relation.multivalue>s</#if>(${rootPackageName}.entity.${name}Entity.${relation.name});
		
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
	
	public final org.instantlogic.fabric.value.ReadOnlyRelationValue<#if relation.multivalue>s</#if><${name}, ${relation.item}> ${relation.name}
		= createReverseRelationValue<#if relation.multivalue>s</#if>(${rootPackageName}.entity.${name}Entity.${relation.name});

	public ${relation.to} get${relation.name?cap_first}() {
		return ${relation.name}.get();
	}

	</#list>

}
