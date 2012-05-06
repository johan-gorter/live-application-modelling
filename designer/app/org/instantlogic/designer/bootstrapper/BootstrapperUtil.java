package org.instantlogic.designer.bootstrapper;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.AttributeDeductionDesign;
import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.CastInstanceDeductionDesign;
import org.instantlogic.designer.CompositeTemplateDesign;
import org.instantlogic.designer.ConstantDeductionDesign;
import org.instantlogic.designer.ConstantStringDesign;
import org.instantlogic.designer.ConstantTextDesign;
import org.instantlogic.designer.DeductionDesign;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DomainEntryDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.EntityDesign.RelationType;
import org.instantlogic.designer.EventDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FlowEdgeDesign;
import org.instantlogic.designer.FlowNodeBaseDesign;
import org.instantlogic.designer.FlowSourceDesign;
import org.instantlogic.designer.FormattedValueDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.SelectedInstanceDeductionDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.TemplatedTextDesign;
import org.instantlogic.designer.TextDesign;
import org.instantlogic.designer.WidgetTemplateDesign;
import org.instantlogic.designer.WidgetText;
import org.instantlogic.designer.WidgetValue;
import org.instantlogic.fabric.deduction.ConstantDeduction;

public abstract class BootstrapperUtil {

	protected static ApplicationDesign applicationDesign;
	
	protected static WidgetTemplateDesign createButton(EventDesign event, TextDesign caption) {
		WidgetTemplateDesign result = new WidgetTemplateDesign();
		result.setEvent(event);
		WidgetText widgetCaption = new WidgetText();
		widgetCaption.setName("text");
		widgetCaption.setText(caption);
		result.addToTexts(widgetCaption);
		return result;
	}

	protected static WidgetTemplateDesign createLink(EventDesign event, TextDesign caption) {
		WidgetTemplateDesign result = new WidgetTemplateDesign();
		result.setEvent(event);
		WidgetText widgetCaption = new WidgetText();
		widgetCaption.setName("text");
		widgetCaption.setText(caption);
		result.addToTexts(widgetCaption);
		return result;
	}

	protected static EntityDesign createEntity(String name, EntityDesign extendsFrom) {
		EntityDesign result = new EntityDesign();
		result.setName(name);
		result.setExtendsFrom(extendsFrom);
		applicationDesign.addToEntities(result);
		return result;
	}

	protected static AttributeDesign createAttribute(EntityDesign entity, String name, String className) {
		AttributeDesign attribute = new AttributeDesign();
		attribute.setName(name);
		attribute.setClassName(className);
		entity.addToAttributes(attribute);
		return attribute;
	}

	protected static AttributeDesign createAttribute(EntityDesign entity, String name, Class<?> className) {
		return createAttribute(entity, name, className.getName());
	}

	protected static RelationDesign createRelation(EntityDesign from, String name, RelationType relationType, String reverseName, EntityDesign to) {
		RelationDesign relation = new RelationDesign();
		from.addToRelations(relation);
		relation.setTo(to);
		relation.setName(name);
		relation.setReverseName(reverseName);
		relation.setOwner(relationType==RelationType.OneToManyAggregation || relationType==RelationType.OneToZeroOrOneAggregation || relationType==RelationType.OneToOneAggregation);
		relation.setAutoCreate(relationType==RelationType.OneToOneAggregation);
		relation.setMultivalue(relationType==RelationType.OneToMany || relationType==RelationType.OneToManyAggregation || relationType==RelationType.ManyToMany);
		relation.setReverseMultivalue(relationType==RelationType.ManyToMany || relationType==RelationType.ManyToZeroOrOne);
		return relation;
	}

	protected static DomainEntryDesign createDomainEntry(String name, String untranslatedConstantText) {
		DomainEntryDesign entry = new DomainEntryDesign();
		entry.setName(name);
		entry.setDisplay(createConstantText(untranslatedConstantText));
		return entry;
	}
	
	protected static ConstantTextDesign createConstantText(String untranslated) {
		ConstantTextDesign result = new ConstantTextDesign();
		result.setUntranslated(untranslated);
		return result;
	}
	
	protected static WidgetTemplateDesign createText(String role, TextDesign text) {
		WidgetTemplateDesign result = new WidgetTemplateDesign();
		result.setWidgetTypeName("Text");
		WidgetValue widgetValue = new WidgetValue();
		widgetValue.setName("role");
		widgetValue.setDeduction(createConstantDeduction(String.class, role));
		result.addToValues(widgetValue);
		WidgetText widgetText = new WidgetText();
		widgetText.setName("text");
		widgetText.setText(text);
		result.addToTexts(widgetText);
		return result;
	}
	
	protected static TemplatedTextDesign createTemplatedText() {
		TemplatedTextDesign result = new TemplatedTextDesign();
		return result;
	}
	
	protected static TemplatedTextDesign add(TemplatedTextDesign text, AttributeDesign attribute) {
		return add(text, createDeduction(attribute));
	}
	
	protected static TemplatedTextDesign add(TemplatedTextDesign text, DeductionSchemeDesign deduction) {
		FormattedValueDesign formattedValue = new FormattedValueDesign();
		formattedValue.setDeduction(deduction);
		text.addToUntranslated(formattedValue);
		return text;
	}
	
	protected static TemplatedTextDesign add(TemplatedTextDesign text, String constant) {
		ConstantStringDesign constantDesign = new ConstantStringDesign();
		constantDesign.setConstant(constant);
		text.addToUntranslated(constantDesign);
		return text;
	}

	protected static CompositeTemplateDesign createCompositeFragmentTemplate() {
		CompositeTemplateDesign container = new CompositeTemplateDesign();
		return container;
	}

	protected static CompositeTemplateDesign createSelect(DeductionSchemeDesign deduction) {
		CompositeTemplateDesign select = new CompositeTemplateDesign();
		select.addToSelections(deduction);
		return select;
	}
	
	protected static DeductionSchemeDesign createDeductionScheme(DeductionDesign output) {
		DeductionSchemeDesign result = new DeductionSchemeDesign();
		addDeductions(result, output);
		result.setOutput(output);
		return result;
	}
	
	
	private static void addDeductions(DeductionSchemeDesign result, DeductionDesign deduction) {
		if (result.getDeductions().asList().contains(deduction)) return;
		result.addToDeductions(deduction);
		for(DeductionDesign input: deduction.getInputs()) {
			addDeductions(result, input);
		}
	}

	protected static DeductionSchemeDesign createCastDeduction(EntityDesign entity, EntityDesign toEntity) {
		DeductionSchemeDesign scheme = new DeductionSchemeDesign();
		SelectedInstanceDeductionDesign selectedInstanceDeductionDesign = new SelectedInstanceDeductionDesign();
		selectedInstanceDeductionDesign.setOfEntity(entity);
		selectedInstanceDeductionDesign.setClassName(entity.getApplication().getRootPackageName()+"."+entity.getName());
		CastInstanceDeductionDesign castInstanceDeductionDesign = new CastInstanceDeductionDesign();
		castInstanceDeductionDesign.setToEntity(toEntity);
		castInstanceDeductionDesign.setClassName(entity.getApplication().getRootPackageName()+"."+toEntity.getName());
		castInstanceDeductionDesign.addToInputs(selectedInstanceDeductionDesign);
		scheme.addToDeductions(selectedInstanceDeductionDesign);
		scheme.addToDeductions(castInstanceDeductionDesign);
		scheme.setOutput(castInstanceDeductionDesign);
		return scheme;
	}

	// Deduction for an active instance
	protected static DeductionSchemeDesign createDeduction(EntityDesign entity) {
		DeductionSchemeDesign scheme = new DeductionSchemeDesign();
		SelectedInstanceDeductionDesign selectedInstanceDeductionDesign = new SelectedInstanceDeductionDesign();
		selectedInstanceDeductionDesign.setOfEntity(entity);
		selectedInstanceDeductionDesign.setClassName(entity.getApplication().getRootPackageName()+"."+entity.getName());
		scheme.addToDeductions(selectedInstanceDeductionDesign);
		scheme.setOutput(selectedInstanceDeductionDesign);
		return scheme;
	}

	// Deduction for an constant
	protected static <V> DeductionSchemeDesign createConstantDeduction(Class<V> className, V value) {
		DeductionSchemeDesign scheme = new DeductionSchemeDesign();
		ConstantDeductionDesign constantDeductionDesign = new ConstantDeductionDesign();
		constantDeductionDesign.setClassName(className.getName());
		constantDeductionDesign.setValue(value);
		scheme.addToDeductions(constantDeductionDesign);
		scheme.setOutput(constantDeductionDesign);
		return scheme;
	}
	
	protected static DeductionSchemeDesign createCustomDeduction(String customization, Class resultClass) {
		return createCustomDeduction(customization, resultClass.getName());
	}
	
	protected static DeductionSchemeDesign createCustomDeduction(String customization, String resultClassName) {
		DeductionSchemeDesign scheme = new DeductionSchemeDesign();
		DeductionDesign customDeductionDesign = new DeductionDesign();
		customDeductionDesign.setCustomization(customization);
		customDeductionDesign.setClassName(resultClassName);
		scheme.addToDeductions(customDeductionDesign);
		scheme.setOutput(customDeductionDesign);
		return scheme;
	}
	
	// Deduction for an attribute/relation
	protected static DeductionSchemeDesign createDeduction(AttributeDesign attribute) {
		String className = attribute.getClassName();
		EntityDesign source = attribute.getBelongsToEntity();
		if (attribute instanceof RelationDesign) {
			// We should come up with a solution that makes this unnecessary
			RelationDesign relation = (RelationDesign)attribute;
			className = relation.getTo().getApplication().getRootPackageName()+"."+relation.getTo().getName();
			source = relation.getFrom();
		}
		DeductionSchemeDesign scheme = new DeductionSchemeDesign();
		SelectedInstanceDeductionDesign selectedInstanceDeductionDesign = new SelectedInstanceDeductionDesign();
		selectedInstanceDeductionDesign.setOfEntity(source);
		selectedInstanceDeductionDesign.setClassName(source.getApplication().getRootPackageName()+"."+source.getName());
		AttributeDeductionDesign attributeDeductionDesign = new AttributeDeductionDesign();
		attributeDeductionDesign.setAttribute(attribute);
		attributeDeductionDesign.addToInputs(selectedInstanceDeductionDesign);
		if (attribute.getMultivalue()==Boolean.TRUE) {
			attributeDeductionDesign.setClassName("org.instantlogic.fabric.value.Multi<"+className+">");
		} else {
			attributeDeductionDesign.setClassName(className);	
		}
		scheme.addToDeductions(selectedInstanceDeductionDesign);
		scheme.addToDeductions(attributeDeductionDesign);
		scheme.setOutput(attributeDeductionDesign);
		return scheme;
	}

	protected static WidgetTemplateDesign createField(CompositeTemplateDesign container, AttributeDesign attribute) {
		WidgetTemplateDesign field = new WidgetTemplateDesign();
//TODO		field.setAttribute(attribute);
		container.addToChildren(field);
		return field;
	}

	protected static FlowDesign createFlow(String name) {
		FlowDesign flow = new FlowDesign();
		flow.setName(name);
		applicationDesign.addToFlows(flow);
		return flow;
	}

	protected static void createEdge(FlowDesign flow, FlowNodeBaseDesign startNode, EventDesign startEvent, FlowNodeBaseDesign endNode, EventDesign endEvent) {
		FlowEdgeDesign edge = new FlowEdgeDesign();
		edge.setStartNode(startNode);
		edge.setStartEvent(startEvent);
		edge.setEndNode(endNode);
		edge.setEndEvent(endEvent);
		flow.addToEdges(edge);
	}

	protected static PlaceTemplateDesign createPage(FlowDesign flow, String name) {
		PlaceTemplateDesign page = new PlaceTemplateDesign();
		page.setName(name);
		flow.addToNodes(page);
		return page;
	}

	protected static FlowSourceDesign createSource(FlowDesign flow, EventDesign startEvent, FlowNodeBaseDesign endNode, EventDesign endEvent) {
		FlowSourceDesign source = new FlowSourceDesign();
		source.setStartEvent(startEvent);
		source.setEndNode(endNode);
		source.setEndEvent(endEvent);
		flow.addToSources(source);
		return source;
	}
	
	protected static SubFlowDesign createSubFlow(FlowDesign parentFlow, FlowDesign flow) {
		SubFlowDesign subFlow = new SubFlowDesign();
		subFlow.setName(flow.getName());
		subFlow.setFlow(flow);
		parentFlow.addToNodes(subFlow);
		return subFlow;
	}
	
	protected static EventDesign createEvent(String name, EntityDesign... parameters) {
		EventDesign result = new EventDesign();
		result.setName(name);
		for(EntityDesign parameter: parameters) {
			result.addToParameters(parameter);			
		}
		applicationDesign.addToEvents(result);
		return result;
	}

}
