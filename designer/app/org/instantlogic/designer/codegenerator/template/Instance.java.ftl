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

	public org.instantlogic.fabric.value.<#if attribute.readonly>ReadOnly</#if>AttributeValue<#if attribute.multivalue>s</#if><${name}, ${attribute.itemClassName}> get${attribute.name?cap_first}Attribute() {
		return ${attribute.name};
	}

	<#if !attribute.readonly && !attribute.multivalue>	
	public void set${attribute.name?cap_first}(${attribute.className} newValue) {
		${attribute.name}.setValue(newValue);
	}
	
	</#if>
	<#if !attribute.readonly && attribute.multivalue>	
	public void addTo${attribute.name?cap_first}(${attribute.className} item) {
		${attribute.name}.addValue(item);
	}
	
	public void addTo${attribute.name?cap_first}(${attribute.className} item, int index) {
		${attribute.name}.insertValue(item, index);
	}
	
	public void removeFrom${attribute.name?cap_first}(${attribute.className} item) {
		${attribute.name}.removeValue(item);
	}
	
	public void removeFrom${attribute.name?cap_first}(int index) {
		${attribute.name}.removeValue(index);
	}
	
	</#if>
	</#list>
	
	// Relations
	<#list relations as relation>
	
	private final org.instantlogic.fabric.value.<#if relation.readonly>ReadOnly</#if>RelationValue<#if relation.multivalue>s</#if><${name}, ${relation.item}> ${relation.name}
		= create<#if relation.readonly>ReadOnly</#if>RelationValue<#if relation.multivalue>s</#if>(${rootPackageName}.entity.${name}Entity.${relation.name});
		
	public org.instantlogic.fabric.value.<#if relation.readonly>ReadOnly</#if>RelationValue<#if relation.multivalue>s</#if><${name}, ${relation.item}> get${relation.name?cap_first}Relation() {
		return ${relation.name};
	}

	public ${relation.to} get${relation.name?cap_first}() {
		return ${relation.name}.get();
	}
	
	<#if !relation.readonly && !relation.multivalue>	
	public void set${relation.name?cap_first}(${relation.to} newValue) {
		${relation.name}.setValue(newValue);
	}

	</#if>
	<#if !relation.readonly && relation.multivalue>	
	public void addTo${relation.name?cap_first}(${relation.item} item) {
		${relation.name}.addValue(item);
	}
	
	public void addTo${relation.name?cap_first}(${relation.item} item, int index) {
		${relation.name}.insertValue(item, index);
	}
	
	public void removeFrom${relation.name?cap_first}(${relation.item} item) {
		${relation.name}.removeValue(item);
	}
	
	public void removeFrom${relation.name?cap_first}(int index) {
		${relation.name}.removeValue(index);
	}
	
	</#if>
	</#list>

	// Reverse relations
	<#list reverseRelations as relation>
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<#if relation.multivalue>s</#if><${name}, ${relation.item}> ${relation.name}
		= createReverseRelationValue<#if relation.multivalue>s</#if>(${rootPackageName}.entity.${name}Entity.${relation.name});

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<#if relation.multivalue>s</#if><${name}, ${relation.item}> get${relation.name?cap_first}Relation() {
		return ${relation.name};
	}

	public ${relation.to} get${relation.name?cap_first}() {
		return ${relation.name}.get();
	}

	</#list>

}
