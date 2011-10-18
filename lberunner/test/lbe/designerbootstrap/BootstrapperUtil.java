package lbe.designerbootstrap;

import lbe.designerbootstrap.Bootstrapper.RelationType;
import app.designer.data.instance.ApplicationInstance;
import app.designer.data.instance.AttributeInstance;
import app.designer.data.instance.ButtonInstance;
import app.designer.data.instance.CompositePageFragmentInstance;
import app.designer.data.instance.ConstantTextInstance;
import app.designer.data.instance.DomainEntryInstance;
import app.designer.data.instance.EntityInstance;
import app.designer.data.instance.FieldInstance;
import app.designer.data.instance.FlowEdgeInstance;
import app.designer.data.instance.FlowInstance;
import app.designer.data.instance.FlowNodeBaseInstance;
import app.designer.data.instance.FlowSourceInstance;
import app.designer.data.instance.HeaderInstance;
import app.designer.data.instance.PageCompositionInstance;
import app.designer.data.instance.PageFragmentInstance;
import app.designer.data.instance.PageInstance;
import app.designer.data.instance.RelationInstance;
import app.designer.data.instance.SelectInstance;
import app.designer.data.instance.SubFlowInstance;
import app.designer.data.instance.TextInstance;

public abstract class BootstrapperUtil {

	protected static ApplicationInstance applicationInstance;
	
	protected static ButtonInstance createButton(String trigger, TextInstance caption) {
		ButtonInstance result = new ButtonInstance(applicationInstance);
		result.trigger.set(trigger);
		result.caption.set(caption);
		return result;
	}

	protected static void createContainerItem(CompositePageFragmentInstance containerInstance, PageFragmentInstance element) {
		PageCompositionInstance item = new PageCompositionInstance(applicationInstance);
		item.pageFragment.set(element);
		containerInstance.items.add(item);
	}

	protected static EntityInstance createEntity(String name, EntityInstance extendsFrom) {
		EntityInstance result = new EntityInstance(applicationInstance);
		result.name.set(name);
		result.extendsFrom.set(extendsFrom);
		applicationInstance.entities.add(result);
		return result;
	}

	protected static AttributeInstance createAttribute(EntityInstance entity, String name, Class<?> className) {
		AttributeInstance attribute = new AttributeInstance(applicationInstance);
		attribute.name.set(name);
		attribute.className.set(className.getName());
		entity.attributes.add(attribute);
		return attribute;
	}

	protected static RelationInstance createRelation(EntityInstance from, String name, RelationType relationType, String reverseName, EntityInstance to) {
		RelationInstance relation = new RelationInstance(applicationInstance);
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

	protected static DomainEntryInstance createDomainEntry(String name, String untranslatedConstantText) {
		DomainEntryInstance entry = new DomainEntryInstance(applicationInstance);
		entry.name.set(name);
		entry.display.set(createConstantText(untranslatedConstantText));
		return entry;
	}
	
	protected static ConstantTextInstance createConstantText(String untranslated) {
		ConstantTextInstance result = new ConstantTextInstance(applicationInstance);
		result.untranslated.set(untranslated);
		return result;
	}

	protected static CompositePageFragmentInstance createCompositePageFragment() {
		CompositePageFragmentInstance container = new CompositePageFragmentInstance(applicationInstance);
		return container;
	}

	protected static SelectInstance createSelect(RelationInstance relation) {
		SelectInstance select = new SelectInstance(applicationInstance);
		select.relation.set(relation);
		return select;
	}

	protected static HeaderInstance createHeader(TextInstance text) {
		HeaderInstance header = new HeaderInstance(applicationInstance);
		header.text.set(text);
		return header;
	}

	protected static FieldInstance createField(CompositePageFragmentInstance container, AttributeInstance attribute, boolean required) {
		FieldInstance field = new FieldInstance(applicationInstance);
		field.attribute.set(attribute);
		field.required.set(required);
		PageCompositionInstance item = new PageCompositionInstance(applicationInstance);
		container.items.add(item);
		item.pageFragment.set(field);
		return field;
	}

	protected static FlowInstance createFlow(String name) {
		FlowInstance flow = new FlowInstance(applicationInstance);
		flow.name.set(name);
		applicationInstance.flows.add(flow);
		return flow;
	}

	protected static void createEdge(FlowInstance flow, FlowNodeBaseInstance from, String exitName, FlowNodeBaseInstance to, String entryName) {
		FlowEdgeInstance edge = new FlowEdgeInstance(applicationInstance);
		edge.from.set(from);
		edge.exitName.set(exitName);
		edge.to.set(to);
		edge.entryName.set(entryName);
		flow.edges.add(edge);
	}

	protected static PageInstance createPage(FlowInstance flow, String name) {
		PageInstance page = new PageInstance(applicationInstance);
		page.name.set(name);
		flow.nodes.add(page);
		return page;
	}

	protected static FlowSourceInstance createStartSource(FlowInstance flow, String name) {
		FlowSourceInstance startSource = new FlowSourceInstance(applicationInstance);
		startSource.name.set(name);
		flow.sources.add(startSource);
		return startSource;
	}
	
	protected static SubFlowInstance createSubFlow(FlowInstance parentFlow, FlowInstance flow) {
		SubFlowInstance subFlow = new SubFlowInstance(applicationInstance);
		subFlow.name.set(flow.name.get());
		subFlow.flow.set(flow);
		parentFlow.nodes.add(subFlow);
		return subFlow;
	}
	
	
	protected static PageCompositionInstance addContent(CompositePageFragmentInstance compositePageFragment, PageFragmentInstance item) {
		PageCompositionInstance result = new PageCompositionInstance(applicationInstance);
		result.pageFragment.set(item);
		compositePageFragment.items.add(result);
		return result;
	}

}
