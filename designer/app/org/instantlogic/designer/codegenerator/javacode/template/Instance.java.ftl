package ${rootPackageName};


public<#if isCustomized> abstract</#if> class <#if isCustomized>Abstract</#if>${technicalNameCapitalized} extends <#if extendsFrom??>${extendsFrom}<#else>org.instantlogic.fabric.Instance</#if> { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return ${rootPackageName}.entity.${technicalNameCapitalized}Entity.INSTANCE;
	}

	// Attributes
	<#list attributes as attribute>
	
	private final org.instantlogic.fabric.value.<#if attribute.readonly>ReadOnly</#if>AttributeValue<#if attribute.multivalue>s</#if><${technicalNameCapitalized}, ${attribute.itemClassName}> ${attribute.javaIdentifier}
		= create<#if attribute.readonly>ReadOnly</#if>AttributeValue<#if attribute.multivalue>s</#if>(${rootPackageName}.entity.${technicalNameCapitalized}Entity.${attribute.javaIdentifier});
	
	public ${attribute.className} get${attribute.technicalName?cap_first}() {
		return ${attribute.javaIdentifier}.getValue();
	}

	public org.instantlogic.fabric.value.<#if attribute.readonly>ReadOnly</#if>AttributeValue<#if attribute.multivalue>s</#if><${technicalNameCapitalized}, ${attribute.itemClassName}> get${attribute.technicalName?cap_first}AttributeValue() {
		return ${attribute.javaIdentifier};
	}

	<#if !attribute.readonly && !attribute.multivalue>	
	public ${technicalNameCapitalized} set${attribute.technicalName?cap_first}(${attribute.className} newValue) {
		${attribute.javaIdentifier}.setValue(newValue);
		return (${technicalNameCapitalized})this;
	}
	
	</#if>
	<#if !attribute.readonly && attribute.multivalue>	
	public ${technicalNameCapitalized} addTo${attribute.technicalName?cap_first}(${attribute.itemClassName} item) {
		${attribute.javaIdentifier}.addValue(item);
		return (${technicalNameCapitalized})this;
	}
	
	public ${technicalNameCapitalized} addTo${attribute.technicalName?cap_first}(${attribute.itemClassName} item, int index) {
		${attribute.javaIdentifier}.insertValue(item, index);
		return (${technicalNameCapitalized})this;
	}
	
	public ${technicalNameCapitalized} removeFrom${attribute.technicalName?cap_first}(${attribute.itemClassName} item) {
		${attribute.javaIdentifier}.removeValue(item);
		return (${technicalNameCapitalized})this;
	}
	
	public ${technicalNameCapitalized} removeFrom${attribute.technicalName?cap_first}(int index) {
		${attribute.javaIdentifier}.removeValue(index);
		return (${technicalNameCapitalized})this;
	}
	
	</#if>
	</#list>
	
	// Relations
	<#list relations as relation>
	
	private final org.instantlogic.fabric.value.<#if relation.readonly>ReadOnly</#if>RelationValue<#if relation.multivalue>s</#if><${technicalNameCapitalized}, ${relation.item}> ${relation.javaIdentifier}
		= create<#if relation.readonly>ReadOnly</#if>RelationValue<#if relation.multivalue>s</#if>(${rootPackageName}.entity.${technicalNameCapitalized}Entity.${relation.javaIdentifier});
		
	public org.instantlogic.fabric.value.<#if relation.readonly>ReadOnly</#if>RelationValue<#if relation.multivalue>s</#if><${technicalNameCapitalized}, ${relation.item}> get${relation.technicalName?cap_first}RelationValue() {
		return ${relation.javaIdentifier};
	}

	public ${relation.to} get${relation.technicalName?cap_first}() {
		return ${relation.javaIdentifier}.getValue();
	}
	
	<#if !relation.readonly && !relation.multivalue>	
	public ${technicalNameCapitalized} set${relation.technicalName?cap_first}(${relation.to} newValue) {
		${relation.javaIdentifier}.setValue(newValue);
		return (${technicalNameCapitalized})this;
	}

	</#if>
	<#if !relation.readonly && relation.multivalue>	
	public ${technicalNameCapitalized} addTo${relation.technicalName?cap_first}(${relation.item} item) {
		${relation.javaIdentifier}.addValue(item);
		return (${technicalNameCapitalized})this;
	}
	
	public ${technicalNameCapitalized} addTo${relation.technicalName?cap_first}(${relation.item} item, int index) {
		${relation.javaIdentifier}.insertValue(item, index);
		return (${technicalNameCapitalized})this;
	}
	
	public ${technicalNameCapitalized} removeFrom${relation.technicalName?cap_first}(${relation.item} item) {
		${relation.javaIdentifier}.removeValue(item);
		return (${technicalNameCapitalized})this;
	}
	
	public ${technicalNameCapitalized} removeFrom${relation.technicalName?cap_first}(int index) {
		${relation.javaIdentifier}.removeValue(index);
		return (${technicalNameCapitalized})this;
	}
	
	</#if>
	</#list>

	// Reverse relations
	<#list reverseRelations as relation>
	
	private final org.instantlogic.fabric.value.RelationValue<#if relation.multivalue>s</#if><${technicalNameCapitalized}, ${relation.item}> ${relation.javaIdentifier}
		= createReverseRelationValue<#if relation.multivalue>s</#if>(${rootPackageName}.entity.${technicalNameCapitalized}Entity.${relation.javaIdentifier});

	public org.instantlogic.fabric.value.RelationValue<#if relation.multivalue>s</#if><${technicalNameCapitalized}, ${relation.item}> get${relation.technicalName?cap_first}RelationValue() {
		return ${relation.javaIdentifier};
	}

	public ${relation.to} get${relation.technicalName?cap_first}() {
		return ${relation.javaIdentifier}.getValue();
	}

    <#if relation.multivalue>
    public ${technicalNameCapitalized} addTo${relation.technicalName?cap_first}(${relation.item} item) {
        ${relation.javaIdentifier}.addValue(item);
        return (${technicalNameCapitalized})this;
    }

    public ${technicalNameCapitalized} removeFrom${relation.technicalName?cap_first}(${relation.item} item) {
        ${relation.javaIdentifier}.removeValue(item);
        return (${technicalNameCapitalized})this;
    }
    <#else>
    public ${technicalNameCapitalized} set${relation.technicalName?cap_first}(${relation.to} newValue) {
        ${relation.javaIdentifier}.setValue(newValue);
        return (${technicalNameCapitalized})this;
    }
    </#if>

	</#list>

}
