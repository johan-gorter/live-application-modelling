package ${rootPackageName};


public<#if isCustomized> abstract</#if> class <#if isCustomized>Abstract</#if>${name} extends <#if extendsFrom??>${extendsFrom}<#else>org.instantlogic.fabric.Instance</#if> { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return ${rootPackageName}.entity.${name}Entity.INSTANCE;
	}

	// Attributes
	<#list attributes as attribute>
	
	private final org.instantlogic.fabric.value.<#if attribute.readonly>ReadOnly</#if>AttributeValue<#if attribute.multivalue>s</#if><${name}, ${attribute.itemClassName}> ${attribute.name}
		= create<#if attribute.readonly>ReadOnly</#if>AttributeValue<#if attribute.multivalue>s</#if>(${rootPackageName}.entity.${name}Entity.${attribute.name});
	
	public ${attribute.className} get${attribute.name?cap_first}() {
		return ${attribute.name}.getValue();
	}

	public org.instantlogic.fabric.value.<#if attribute.readonly>ReadOnly</#if>AttributeValue<#if attribute.multivalue>s</#if><${name}, ${attribute.itemClassName}> get${attribute.name?cap_first}AttributeValue() {
		return ${attribute.name};
	}

	<#if !attribute.readonly && !attribute.multivalue>	
	public ${name} set${attribute.name?cap_first}(${attribute.className} newValue) {
		${attribute.name}.setValue(newValue);
		return (${name})this;
	}
	
	</#if>
	<#if !attribute.readonly && attribute.multivalue>	
	public ${name} addTo${attribute.name?cap_first}(${attribute.className} item) {
		${attribute.name}.addValue(item);
		return (${name})this;
	}
	
	public ${name} addTo${attribute.name?cap_first}(${attribute.className} item, int index) {
		${attribute.name}.insertValue(item, index);
		return (${name})this;
	}
	
	public ${name} removeFrom${attribute.name?cap_first}(${attribute.className} item) {
		${attribute.name}.removeValue(item);
		return (${name})this;
	}
	
	public ${name} removeFrom${attribute.name?cap_first}(int index) {
		${attribute.name}.removeValue(index);
		return (${name})this;
	}
	
	</#if>
	</#list>
	
	// Relations
	<#list relations as relation>
	
	private final org.instantlogic.fabric.value.<#if relation.readonly>ReadOnly</#if>RelationValue<#if relation.multivalue>s</#if><${name}, ${relation.item}> ${relation.name}
		= create<#if relation.readonly>ReadOnly</#if>RelationValue<#if relation.multivalue>s</#if>(${rootPackageName}.entity.${name}Entity.${relation.name});
		
	public org.instantlogic.fabric.value.<#if relation.readonly>ReadOnly</#if>RelationValue<#if relation.multivalue>s</#if><${name}, ${relation.item}> get${relation.name?cap_first}RelationValue() {
		return ${relation.name};
	}

	public ${relation.to} get${relation.name?cap_first}() {
		return ${relation.name}.getValue();
	}
	
	<#if !relation.readonly && !relation.multivalue>	
	public ${name} set${relation.name?cap_first}(${relation.to} newValue) {
		${relation.name}.setValue(newValue);
		return (${name})this;
	}

	</#if>
	<#if !relation.readonly && relation.multivalue>	
	public ${name} addTo${relation.name?cap_first}(${relation.item} item) {
		${relation.name}.addValue(item);
		return (${name})this;
	}
	
	public ${name} addTo${relation.name?cap_first}(${relation.item} item, int index) {
		${relation.name}.insertValue(item, index);
		return (${name})this;
	}
	
	public ${name} removeFrom${relation.name?cap_first}(${relation.item} item) {
		${relation.name}.removeValue(item);
		return (${name})this;
	}
	
	public ${name} removeFrom${relation.name?cap_first}(int index) {
		${relation.name}.removeValue(index);
		return (${name})this;
	}
	
	</#if>
	</#list>

	// Reverse relations
	<#list reverseRelations as relation>
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<#if relation.multivalue>s</#if><${name}, ${relation.item}> ${relation.name}
		= createReverseRelationValue<#if relation.multivalue>s</#if>(${rootPackageName}.entity.${name}Entity.${relation.name});

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<#if relation.multivalue>s</#if><${name}, ${relation.item}> get${relation.name?cap_first}RelationValue() {
		return ${relation.name};
	}

	public ${relation.to} get${relation.name?cap_first}() {
		return ${relation.name}.getValue();
	}

	</#list>

}
