package app.${appname}.data.entity;

import java.util.List;

import app.${appname}.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class ${name}Entity extends SimpleEntity {

	public static final ${name}Entity INSTANCE = new ${name}Entity();
	
	// Attributes
	<#list attributes as attribute>
	
	public static final Attribute<${name}Instance, String, String> ${attribute.name} 
		= new SimpleAttribute<${name}Instance, String, String>(
			"${attribute.name}", INSTANCE, ${attribute.className}.class
		) {
	
			@Override
			public AttributeValue<${name}Instance, String> get(${name}Instance instance) {
				return instance.${attribute.name};
			}
			<#if attribute.multivalue>
	
			public boolean isMultivalue() {
				return true;
			}
			</#if>
		};
	</#list>
	
	// Relations
	<#list relations as relation>
	
	public static final Relation<${name}Instance, ${relation.to}, ${relation.item}Instance> extendsFrom
		= new SimpleRelation<${name}Instance, ${relation.to}, ${relation.item}Instance>(
			"${relation.name}", INSTANCE, ${name}Entity.INSTANCE, ${relation.item}Instance.class, ${relation.item}Entity.${relation.reverseName}
		) {
	
			@Override
			public RelationValue<#if relation.multivalue>s</#if><${name}Instance, ${relation.item}Instance> get(
					${name}Instance instance) {
				return instance.${relation.name};
			}
			<#if relation.owner>
	
			public boolean isOwner() {
				return true;
			}
			</#if>
			<#if relation.multivalue>
	
			public boolean isMultivalue() {
				return true;
			}
			</#if>
			
			//TODO: readonly
		
		};
	</#list>
	
	// Reverse relations
	<#list reverseRelations as relation>
	
	public static final Relation<${name}Instance, ${relation.to}, ${relation.item}Instance> extendsFrom
		= new SimpleRelation<${name}Instance, ${relation.to}, ${relation.item}Instance>(
			"${relation.name}", INSTANCE, ${name}Entity.INSTANCE, ${relation.item}Instance.class, ${relation.item}Entity.${relation.reverseName}
		) {
	
			@Override
			public RelationValue<#if relation.multivalue>s</#if><${name}Instance, ${relation.item}Instance> get(
					${name}Instance instance) {
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
	public Instance createInstance(CaseInstance caseInstance) {
		return new ConceptInstance(caseInstance);
	}
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
