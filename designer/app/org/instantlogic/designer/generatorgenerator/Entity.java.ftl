package ${application.rootPackageName};

<#macro relationType relation>
  <#if relation.owner?? && relation.owner>
    <#if relation.autoCreate?? && relation.autoCreate>
      OneToOneAggregation<#t>
    <#else>
      <#if relation.multivalue>
        OneToManyAggregation<#t>
      <#else>
        OneToZeroOrOneAggregation<#t>
      </#if>
    </#if>
  <#else>
    <#if relation.multivalue?? && relation.multivalue>
      <#if relation.reverseMultivalue?? && relation.reverseMultivalue>
        ManyToMany<#t>
      <#else>
        OneToMany<#t>
      </#if>
    <#else>
      <#if relation.reverseMultivalue?? && relation.reverseMultivalue>
        ManyToZeroOrOne<#t>
      <#else>
        OneToZeroOrOne<#t>
      </#if>
    </#if>
  </#if>
</#macro>

public class ${name}EntityGenerator extends EntityDesign {

    public static final ${name}EntityGenerator ENTITY = new ${name}EntityGenerator();
    
    public ${name}EntityGenerator() {
        setName("${name}");
<#if isCustomized??>
  <#if isCustomized>
        setIsCustomized(true);
  </#if>
</#if>
    }

    // Attributes
<#list attributes as attribute>
    public final AttributeDesign ${attribute.name} = addAttribute("${attribute.name}", ${attribute.className}.class);
</#list>

    // Attributes
<#list relations as relation>
    public final RelationDesign ${relation.name} = addRelation("${relation.name}", RelationType.<@relationType relation=relation />, ${relation.to.name}EntityGenerator.ENTITY)
            .setReverseName("${relation.reverseName}");
</#list>

}