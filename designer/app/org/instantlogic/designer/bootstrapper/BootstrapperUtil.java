package org.instantlogic.designer.bootstrapper;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.AttributeDeductionDesign;
import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.ButtonDesign;
import org.instantlogic.designer.CastInstanceDeductionDesign;
import org.instantlogic.designer.CompositePageFragmentDesign;
import org.instantlogic.designer.ConstantStringDesign;
import org.instantlogic.designer.ConstantTextDesign;
import org.instantlogic.designer.DeductionDesign;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DomainEntryDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.EventDesign;
import org.instantlogic.designer.FieldDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FlowEdgeDesign;
import org.instantlogic.designer.FlowNodeBaseDesign;
import org.instantlogic.designer.FlowSourceDesign;
import org.instantlogic.designer.FormattedValueDesign;
import org.instantlogic.designer.HeaderDesign;
import org.instantlogic.designer.LinkDesign;
import org.instantlogic.designer.PageCompositionDesign;
import org.instantlogic.designer.PageDesign;
import org.instantlogic.designer.PageFragmentDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.SelectDesign;
import org.instantlogic.designer.SelectedInstanceDeductionDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.TemplatedTextDesign;
import org.instantlogic.designer.TextDesign;
import org.instantlogic.designer.bootstrapper.Bootstrapper.RelationType;

public abstract class BootstrapperUtil {

	protected static ApplicationDesign applicationDesign;
	
	protected static ButtonDesign createButton(EventDesign event, TextDesign caption) {
		ButtonDesign result = new ButtonDesign();
		result.setEvent(event);
		result.setCaption(caption);
		return result;
	}

	protected static LinkDesign createLink(EventDesign event, TextDesign caption) {
		LinkDesign result = new LinkDesign();
		result.setEvent(event);
		result.setCaption(caption);
		return result;
	}

	protected static void createContainerItem(CompositePageFragmentDesign containerDesign, PageFragmentDesign element) {
		PageCompositionDesign item = new PageCompositionDesign();
		item.setPageFragment(element);
		containerDesign.addToItems(item);
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

	protected static CompositePageFragmentDesign createCompositePageFragment() {
		CompositePageFragmentDesign container = new CompositePageFragmentDesign();
		return container;
	}

	protected static SelectDesign createSelect(DeductionSchemeDesign deduction) {
		SelectDesign select = new SelectDesign();
		select.setDeduction(deduction);
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
		selectedInstanceDeductionDesign.setClassName(entity.getName());
		CastInstanceDeductionDesign castInstanceDeductionDesign = new CastInstanceDeductionDesign();
		castInstanceDeductionDesign.setToEntity(toEntity);
		castInstanceDeductionDesign.setClassName(toEntity.getName());
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
		selectedInstanceDeductionDesign.setClassName(entity.getName());
		scheme.addToDeductions(selectedInstanceDeductionDesign);
		scheme.setOutput(selectedInstanceDeductionDesign);
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
			className = relation.getTo().getName();
			source = relation.getFrom();
		}
		DeductionSchemeDesign scheme = new DeductionSchemeDesign();
		SelectedInstanceDeductionDesign selectedInstanceDeductionDesign = new SelectedInstanceDeductionDesign();
		selectedInstanceDeductionDesign.setOfEntity(source);
		selectedInstanceDeductionDesign.setClassName(source.getName());
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
	

	protected static HeaderDesign createHeader(TextDesign text) {
		HeaderDesign header = new HeaderDesign();
		header.setText(text);
		return header;
	}

	protected static FieldDesign createField(CompositePageFragmentDesign container, AttributeDesign attribute, boolean required) {
		FieldDesign field = new FieldDesign();
		field.setAttribute(attribute);
		field.setRequired(required);
		PageCompositionDesign item = new PageCompositionDesign();
		container.addToItems(item);
		item.setPageFragment(field);
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

	protected static PageDesign createPage(FlowDesign flow, String name) {
		PageDesign page = new PageDesign();
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
	
	
	protected static PageCompositionDesign addContent(CompositePageFragmentDesign compositePageFragment, PageFragmentDesign item) {
		PageCompositionDesign result = new PageCompositionDesign();
		result.setPageFragment(item);
		compositePageFragment.addToItems(result);
		return result;
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
