package ${rootPackageName}.entity;
<#include "Text.java.ftl">
<#include "DeductionScheme.java.ftl">

public class ${name}Entity extends org.instantlogic.fabric.model.Entity<${rootPackageName}.${name}> {

	public static final ${name}Entity INSTANCE = new ${name}Entity();
	
	protected ${name}Entity() {
	}

	<#if extendsFrom??>
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return ${rootPackageName}.entity.${extendsFrom}Entity.INSTANCE;
	}
	</#if>

	@Override
	public ${rootPackageName}.${name} createInstance() {
		return new ${rootPackageName}.${name}();
	}
	
	@Override
	public Class<${rootPackageName}.${name}> getInstanceClass() {
		return ${rootPackageName}.${name}.class;
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
	
	public static final org.instantlogic.fabric.model.Attribute<${rootPackageName}.${name}, ${attribute.className}, ${attribute.itemClassName}> ${attribute.name} 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<${rootPackageName}.${name}, ${attribute.className}, ${attribute.itemClassName}>(
			"${attribute.name}", INSTANCE, ${attribute.itemClassName}.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<#if attribute.multivalue>s</#if><${rootPackageName}.${name}, ${attribute.itemClassName}> get(${rootPackageName}.${name} instance) {
				return instance.get${attribute.name?cap_first}Attribute();
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

			private org.instantlogic.fabric.deduction.Deduction<${attribute.itemClassName}> RULE = createDeduction${attribute.ruleDeductionIndex}();
			@Override
			public org.instantlogic.fabric.deduction.Deduction<${attribute.itemClassName}> getRule() {
				return RULE;
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
	
	public static final org.instantlogic.fabric.model.Relation<${rootPackageName}.${name}, ${relation.to}, ${rootPackageName}.${relation.item}> ${relation.name}
		= new org.instantlogic.fabric.model.impl.SimpleRelation<${rootPackageName}.${name}, ${relation.to}, ${rootPackageName}.${relation.item}>(
			"${relation.name}", INSTANCE, ${rootPackageName}.entity.${relation.item}Entity.INSTANCE, ${rootPackageName}.${relation.item}.class, ${rootPackageName}.entity.${relation.item}Entity.${relation.reverseName}
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<#if relation.multivalue>s</#if><${rootPackageName}.${name}, ${rootPackageName}.${relation.item}> get(
					${rootPackageName}.${name} instance) {
				return instance.get${relation.name?cap_first}Relation();
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

			private org.instantlogic.fabric.deduction.Deduction<${relation.to}> RULE = createDeduction${relation.ruleDeductionIndex}();
			@Override
			public org.instantlogic.fabric.deduction.Deduction<${relation.to}> getRule() {
				return RULE;
			}
			</#if>
			
		};
	</#list>
	
	// Reverse relations
	<#list reverseRelations as relation>
	
	public static final org.instantlogic.fabric.model.Relation<${rootPackageName}.${name}, ${relation.to}, ${rootPackageName}.${relation.item}> ${relation.name}
		= new org.instantlogic.fabric.model.impl.SimpleRelation<${rootPackageName}.${name}, ${relation.to}, ${rootPackageName}.${relation.item}>(
			"${relation.name}", INSTANCE, ${rootPackageName}.entity.${relation.item}Entity.INSTANCE, ${rootPackageName}.${relation.item}.class, ${rootPackageName}.entity.${relation.item}Entity.${relation.reverseName}
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<#if relation.multivalue>s</#if><${rootPackageName}.${name}, ${rootPackageName}.${relation.item}> get(
					${rootPackageName}.${name} instance) {
				return instance.get${relation.name?cap_first}Relation();
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
		${attribute.name},
		</#list>
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		<#list relations as relation>
		${relation.name},
		</#list>
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		<#list reverseRelations as relation>
		${relation.name},
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
