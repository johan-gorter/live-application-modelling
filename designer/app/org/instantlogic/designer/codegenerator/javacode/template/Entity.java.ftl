package ${rootPackageName}.entity;
<#include "Text.java.ftl">
<#include "DeductionScheme.java.ftl">

public class ${technicalNameCapitalized}Entity extends org.instantlogic.fabric.model.Entity<${rootPackageName}.${technicalNameCapitalized}> {

	public static final ${technicalNameCapitalized}Entity INSTANCE = new ${technicalNameCapitalized}Entity();
	
	protected ${technicalNameCapitalized}Entity() {
	}

	<#if extendsFrom??>
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return ${rootPackageName}.entity.${extendsFrom}Entity.INSTANCE;
	}
	</#if>

	@Override
	public ${rootPackageName}.${technicalNameCapitalized} createInstance() {
		return new ${rootPackageName}.${technicalNameCapitalized}();
	}
	
	@Override
	public Class<${rootPackageName}.${technicalNameCapitalized}> getInstanceClass() {
		return ${rootPackageName}.${technicalNameCapitalized}.class;
	}
	
	@Override
	public String getName() {
		return "${name}";
	}

	// Deductions
	<#list deductionSchemes as scheme>
		<@deductionscheme_macro scheme=scheme />
	</#list>
	
	// Attributes
	<#list attributes as attribute>
	
	public static final org.instantlogic.fabric.model.Attribute<${rootPackageName}.${technicalNameCapitalized}, ${attribute.className}, ${attribute.itemClassName}> ${attribute.javaIdentifier} 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<${rootPackageName}.${technicalNameCapitalized}, ${attribute.className}, ${attribute.itemClassName}>(
			"${attribute.name}", INSTANCE, ${attribute.itemClassName}.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<#if attribute.multivalue>s</#if><${rootPackageName}.${technicalNameCapitalized}, ${attribute.itemClassName}> get(${rootPackageName}.${technicalNameCapitalized} instance) {
				return instance.get${attribute.technicalName?cap_first}AttributeValue();
			}
			<#if attribute.multivalue>
	
			public boolean isMultivalue() {
				return true;
			}
			</#if>
			<#if attribute.question??>
			
			private final Text question = <@text_macro text=attribute.question />;
			@Override
			public Text getQuestion() {
				return question;
			}
			</#if>
			<#if attribute.readonly>
			
			public boolean isReadOnly() {
				return true;
			};
			</#if>
			<#if attribute.ruleDeductionIndex??>

			private org.instantlogic.fabric.deduction.Deduction<${attribute.itemClassName}> rule;
			@Override
			public org.instantlogic.fabric.deduction.Deduction<${attribute.itemClassName}> getRule() {
				if (rule==null) {
					rule = createDeduction${attribute.ruleDeductionIndex}();
				}
				return rule;
			}
			</#if>
			<#if attribute.domain??>
			
			private final DomainEntry[] domain = new DomainEntry[] {
				<#list attribute.domain as entry>
				new DomainEntry("${entry.name}", <@text_macro text=entry.display />),
				</#list>
			};

			@Override
			public DomainEntry[] getDomain() {
				return domain;
			};
			</#if>
		};
	</#list>
	
	// Relations
	<#list relations as relation>
	
	public static final org.instantlogic.fabric.model.Relation<${rootPackageName}.${technicalNameCapitalized}, ${relation.to}, ${rootPackageName}.${relation.item}> ${relation.javaIdentifier}
		= new org.instantlogic.fabric.model.impl.SimpleRelation<${rootPackageName}.${technicalNameCapitalized}, ${relation.to}, ${rootPackageName}.${relation.item}>(
			"${relation.technicalName}", INSTANCE, ${rootPackageName}.entity.${relation.item}Entity.INSTANCE, ${rootPackageName}.${relation.item}.class, ${rootPackageName}.entity.${relation.item}Entity.${relation.reverseJavaIdentifier}
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<#if relation.multivalue>s</#if><${rootPackageName}.${technicalNameCapitalized}, ${rootPackageName}.${relation.item}> get(
					${rootPackageName}.${technicalNameCapitalized} instance) {
				return instance.get${relation.technicalName?cap_first}RelationValue();
			}
			<#if relation.owner>
	
			public boolean isOwner() {
				return true;
			}
			</#if>
			<#if relation.autoCreate>
	
			public boolean isAutoCreate() {
				return true;
			}
			</#if>
			<#if relation.multivalue>
	
			public boolean isMultivalue() {
				return true;
			}
			</#if>
			<#if relation.readonly>
	
			public boolean isReadOnly() {
				return true;
			}
			</#if>
			<#if relation.ruleDeductionIndex??>

			private org.instantlogic.fabric.deduction.Deduction<${relation.to}> rule;
			@Override
			public org.instantlogic.fabric.deduction.Deduction<${relation.to}> getRule() {
				if (rule==null) {
					rule  = createDeduction${relation.ruleDeductionIndex}();
				}
				return rule;
			}
			</#if>
			
		};
	</#list>
	
	// Reverse relations
	<#list reverseRelations as relation>
	
	public static final org.instantlogic.fabric.model.Relation<${rootPackageName}.${technicalNameCapitalized}, ${relation.to}, ${rootPackageName}.${relation.item}> ${relation.javaIdentifier}
		= new org.instantlogic.fabric.model.impl.SimpleRelation<${rootPackageName}.${technicalNameCapitalized}, ${relation.to}, ${rootPackageName}.${relation.item}>(
			"${relation.technicalName}", INSTANCE, ${rootPackageName}.entity.${relation.item}Entity.INSTANCE, ${rootPackageName}.${relation.item}.class, ${rootPackageName}.entity.${relation.item}Entity.${relation.reverseJavaIdentifier}
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<#if relation.multivalue>s</#if><${rootPackageName}.${technicalNameCapitalized}, ${rootPackageName}.${relation.item}> get(
					${rootPackageName}.${technicalNameCapitalized} instance) {
				return instance.get${relation.technicalName?cap_first}RelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
			<#if relation.multivalue>
	
			public boolean isMultivalue() {
				return true;
			}
			</#if>
		};
	</#list>

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		<#list attributes as attribute>
		${attribute.javaIdentifier},
		</#list>
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		<#list relations as relation>
		${relation.javaIdentifier},
		</#list>
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		<#list reverseRelations as relation>
		${relation.javaIdentifier},
		</#list>
	};

	@Override
	public org.instantlogic.fabric.model.Attribute[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}
}
