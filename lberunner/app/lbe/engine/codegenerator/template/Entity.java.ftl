package app.${appname}.entity;
<#include "Text.java.ftl">
<#include "DeductionScheme.java.ftl">

import java.util.List;

import app.${appname}.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import lbe.model.deduction.*;

public class ${name}Entity extends SimpleEntity {

	public static final ${name}Entity INSTANCE = new ${name}Entity();

	// Deductions
	<#list deductionSchemes as scheme>
		<@deductionscheme_macro scheme=scheme />
	</#list>
	
	// Attributes
	<#list attributes as attribute>
	
	public static final Attribute<${name}, ${attribute.className}, ${attribute.itemClassName}> ${attribute.name} 
		= new <#if attribute.customization??>${attribute.customization}<#else>SimpleAttribute<${name}, ${attribute.className}, ${attribute.itemClassName}></#if>(
			"${attribute.name}", INSTANCE, ${attribute.itemClassName}.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<#if attribute.multivalue>s</#if><${name}, ${attribute.itemClassName}> get(${name} instance) {
				return instance.${attribute.name};
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
	
	public static final Relation<${name}, ${relation.to}, ${relation.item}> ${relation.name}
		= new SimpleRelation<${name}, ${relation.to}, ${relation.item}>(
			"${relation.name}", INSTANCE, ${relation.item}Entity.INSTANCE, ${relation.item}.class, ${relation.item}Entity.${relation.reverseName}
		) {
	
			@Override
			public ReadOnlyRelationValue<#if relation.multivalue>s</#if><${name}, ${relation.item}> get(
					${name} instance) {
				return instance.${relation.name};
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
	
			public boolean isReadonly() {
				return true;
			}
			</#if>
			<#if relation.ruleDeductionIndex??>

			private Deduction<Stand> RULE = createDeduction${relation.ruleDeductionIndex}();
			@Override
			public Deduction<Stand> getRule() {
				return RULE;
			}
			</#if>
			
		};
	</#list>
	
	// Reverse relations
	<#list reverseRelations as relation>
	
	public static final Relation<${name}, ${relation.to}, ${relation.item}> ${relation.name}
		= new SimpleRelation<${name}, ${relation.to}, ${relation.item}>(
			"${relation.name}", INSTANCE, ${name}Entity.INSTANCE, ${relation.item}.class, ${relation.item}Entity.${relation.reverseName}
		) {
	
			@Override
			public ReadOnlyRelationValue<#if relation.multivalue>s</#if><${name}, ${relation.item}> get(
					${name} instance) {
				return instance.${relation.name};
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

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		<#list attributes as attribute>
		${attribute.name},
		</#list>
	};
	private static final Relation[] RELATIONS = new Relation[]{
		<#list relations as relation>
		${relation.name},
		</#list>
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		<#list reverseRelations as relation>
		${relation.name},
		</#list>
	};

	private ${name}Entity() {
		super("${name}");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		<#if customization??>
		return new ${customization}(<#if !caseEntity>caseInstance, id</#if>);
		<#else>
		return new ${name}(<#if !caseEntity>caseInstance, id</#if>);
		</#if>
	}
	<#if extendsFrom??>
	
	@Override
	public Entity extendsEntity() {
		return ${extendsFrom}Entity.INSTANCE;
	}
	</#if>
	
	@Override
	public Attribute<? extends Instance, ? extends Object, ? extends Object>[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public Relation<? extends Instance, ? extends Object, ? extends Instance>[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public Relation<? extends Instance, ? extends Object, ? extends Instance>[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}
}
