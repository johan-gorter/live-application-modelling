package lbe.designerbootstrap;

import lbe.designerbootstrap.Bootstrapper.RelationType;
import app.designer.AttributeBaseDesign;
import app.designer.AttributeDesign;
import app.designer.ButtonDesign;
import app.designer.CompositePageFragmentDesign;
import app.designer.ConstantStringDesign;
import app.designer.ConstantTextDesign;
import app.designer.DomainEntryDesign;
import app.designer.EntityDesign;
import app.designer.EventDesign;
import app.designer.FieldDesign;
import app.designer.FlowDesign;
import app.designer.FlowEdgeDesign;
import app.designer.FlowNodeBaseDesign;
import app.designer.FlowSourceDesign;
import app.designer.FormattedValueDesign;
import app.designer.HeaderDesign;
import app.designer.LinkDesign;
import app.designer.PageCompositionDesign;
import app.designer.PageDesign;
import app.designer.PageFragmentDesign;
import app.designer.RelationDesign;
import app.designer.SelectDesign;
import app.designer.SubFlowDesign;
import app.designer.TemplatedTextDesign;
import app.designer.TextDesign;
import custom.designer.ApplicationDesignCustomization;

public abstract class BootstrapperUtil {

	protected static ApplicationDesignCustomization applicationDesign;
	
	protected static ButtonDesign createButton(EventDesign event, TextDesign caption) {
		ButtonDesign result = new ButtonDesign(applicationDesign);
		result.event.set(event);
		result.caption.set(caption);
		return result;
	}

	protected static LinkDesign createLink(EventDesign event, TextDesign caption) {
		LinkDesign result = new LinkDesign(applicationDesign);
		result.event.set(event);
		result.caption.set(caption);
		return result;
	}

	protected static void createContainerItem(CompositePageFragmentDesign containerDesign, PageFragmentDesign element) {
		PageCompositionDesign item = new PageCompositionDesign(applicationDesign);
		item.pageFragment.set(element);
		containerDesign.items.add(item);
	}

	protected static EntityDesign createEntity(String name, EntityDesign extendsFrom) {
		EntityDesign result = new EntityDesign(applicationDesign);
		result.name.set(name);
		result.extendsFrom.set(extendsFrom);
		applicationDesign.entities.add(result);
		return result;
	}

	protected static AttributeDesign createAttribute(EntityDesign entity, String name, Class<?> className) {
		AttributeDesign attribute = new AttributeDesign(applicationDesign);
		attribute.name.set(name);
		attribute.className.set(className.getName());
		entity.attributes.add(attribute);
		return attribute;
	}

	protected static RelationDesign createRelation(EntityDesign from, String name, RelationType relationType, String reverseName, EntityDesign to) {
		RelationDesign relation = new RelationDesign(applicationDesign);
		from.relations.add(relation);
		relation.to.set(to);
		relation.name.set(name);
		relation.reverseName.set(reverseName);
		relation.owner.set(relationType==RelationType.OneToManyAggregation || relationType==RelationType.OneToZeroOrOneAggregation || relationType==RelationType.OneToOneAggregation);
		relation.autoCreate.set(relationType==RelationType.OneToOneAggregation);
		relation.multivalue.set(relationType==RelationType.OneToMany || relationType==RelationType.OneToManyAggregation || relationType==RelationType.ManyToMany);
		relation.reverseMultivalue.set(relationType==RelationType.ManyToMany || relationType==RelationType.ManyToZeroOrOne);
		return relation;
	}

	protected static DomainEntryDesign createDomainEntry(String name, String untranslatedConstantText) {
		DomainEntryDesign entry = new DomainEntryDesign(applicationDesign);
		entry.name.set(name);
		entry.display.set(createConstantText(untranslatedConstantText));
		return entry;
	}
	
	protected static ConstantTextDesign createConstantText(String untranslated) {
		ConstantTextDesign result = new ConstantTextDesign(applicationDesign);
		result.untranslated.set(untranslated);
		return result;
	}
	
	protected static TemplatedTextDesign createTemplatedText() {
		TemplatedTextDesign result = new TemplatedTextDesign(applicationDesign);
		return result;
	}
	
	protected static TemplatedTextDesign add(TemplatedTextDesign text, AttributeBaseDesign value) {
		FormattedValueDesign formattedValue = new FormattedValueDesign(applicationDesign);
		formattedValue.value.set(value);
		text.untranslated.add(formattedValue);
		return text;
	}
	
	protected static TemplatedTextDesign add(TemplatedTextDesign text, String constant) {
		ConstantStringDesign constantDesign = new ConstantStringDesign(applicationDesign);
		constantDesign.constant.set(constant);
		text.untranslated.add(constantDesign);
		return text;
	}

	protected static CompositePageFragmentDesign createCompositePageFragment() {
		CompositePageFragmentDesign container = new CompositePageFragmentDesign(applicationDesign);
		return container;
	}

	protected static SelectDesign createSelect(RelationDesign relation) {
		SelectDesign select = new SelectDesign(applicationDesign);
		select.relation.set(relation);
		return select;
	}

	protected static HeaderDesign createHeader(TextDesign text) {
		HeaderDesign header = new HeaderDesign(applicationDesign);
		header.text.set(text);
		return header;
	}

	protected static FieldDesign createField(CompositePageFragmentDesign container, AttributeDesign attribute, boolean required) {
		FieldDesign field = new FieldDesign(applicationDesign);
		field.attribute.set(attribute);
		field.required.set(required);
		PageCompositionDesign item = new PageCompositionDesign(applicationDesign);
		container.items.add(item);
		item.pageFragment.set(field);
		return field;
	}

	protected static FlowDesign createFlow(String name) {
		FlowDesign flow = new FlowDesign(applicationDesign);
		flow.name.set(name);
		applicationDesign.flows.add(flow);
		return flow;
	}

	protected static void createEdge(FlowDesign flow, FlowNodeBaseDesign startNode, EventDesign startEvent, FlowNodeBaseDesign endNode, EventDesign endEvent) {
		FlowEdgeDesign edge = new FlowEdgeDesign(applicationDesign);
		edge.startNode.set(startNode);
		edge.startEvent.set(startEvent);
		edge.endNode.set(endNode);
		edge.endEvent.set(endEvent);
		flow.edges.add(edge);
	}

	protected static PageDesign createPage(FlowDesign flow, String name) {
		PageDesign page = new PageDesign(applicationDesign);
		page.name.set(name);
		flow.nodes.add(page);
		return page;
	}

	protected static FlowSourceDesign createSource(FlowDesign flow, EventDesign startEvent, FlowNodeBaseDesign endNode, EventDesign endEvent) {
		FlowSourceDesign source = new FlowSourceDesign(applicationDesign);
		source.startEvent.set(startEvent);
		source.endNode.set(endNode);
		source.endEvent.set(endEvent);
		flow.sources.add(source);
		return source;
	}
	
	protected static SubFlowDesign createSubFlow(FlowDesign parentFlow, FlowDesign flow) {
		SubFlowDesign subFlow = new SubFlowDesign(applicationDesign);
		subFlow.name.set(flow.name.get());
		subFlow.flow.set(flow);
		parentFlow.nodes.add(subFlow);
		return subFlow;
	}
	
	
	protected static PageCompositionDesign addContent(CompositePageFragmentDesign compositePageFragment, PageFragmentDesign item) {
		PageCompositionDesign result = new PageCompositionDesign(applicationDesign);
		result.pageFragment.set(item);
		compositePageFragment.items.add(result);
		return result;
	}

	protected static EventDesign createEvent(String name, EntityDesign... parameters) {
		EventDesign result = new EventDesign(applicationDesign);
		result.name.set(name);
		for(EntityDesign parameter: parameters) {
			result.parameters.add(parameter);			
		}
		applicationDesign.events.add(result);
		return result;
	}

}
