package lbe.designerbootstrap;

import lbe.designerbootstrap.Bootstrapper.RelationType;
import app.designer.data.instance.ApplicationInstance;
import app.designer.data.instance.AttributeInstance;
import app.designer.data.instance.EntityInstance;
import app.designer.data.instance.FlowInstance;
import app.designer.data.instance.FlowSourceInstance;
import app.designer.data.instance.PageInstance;
import app.designer.data.instance.RelationInstance;
import app.designer.data.instance.SelectInstance;

public class DesignerBootstrapper extends BootstrapperUtil {

	public static ApplicationInstance createDesigner() {

		// Case
		applicationInstance = new ApplicationInstance();
		applicationInstance.name.set("Designer");
		
		// Entities
		
		// Application
		EntityInstance application = createEntity("Application", null);
		createAttribute(application, "name", String.class);
		applicationInstance.caseEntity.set(application);
		
		// Concept
		EntityInstance concept = createEntity("Concept", null);
		AttributeInstance name = createAttribute(concept, "name", String.class);
		
		// Entity
		EntityInstance entity = createEntity("Entity", concept);

		// AttributeBase
		EntityInstance attributeBase = createEntity("AttributeBase", concept);
		createAttribute(attributeBase, "readOnly", Boolean.class);
		createAttribute(attributeBase, "multivalue", Boolean.class);
		
		// Attribute
		EntityInstance attribute = createEntity("Attribute", attributeBase);
		createAttribute(attribute, "className", String.class);
		
		// Domain
		EntityInstance domainEntry = createEntity("DomainEntry", concept);
		
		// Relation
		EntityInstance relation = createEntity("Relation", attributeBase);
		createAttribute(relation, "owner", Boolean.class);
		createAttribute(relation, "autoCreate", Boolean.class);
		createAttribute(relation, "reverseMultivalue", Boolean.class);
		createAttribute(relation, "reverseName", String.class);
		
		// Shared
		EntityInstance shared = createEntity("Shared", null);
		EntityInstance textHolder = createEntity("TextHolder", concept);
		EntityInstance pageFragmentHolder = createEntity("PageFragmentHolder", concept);
		
		// Page elements & Page
		EntityInstance pageFragment = createEntity("PageFragment", null);
		EntityInstance compositePageFragment = createEntity("CompositePageFragment", pageFragment);
		EntityInstance select = createEntity("Select", compositePageFragment);
		EntityInstance header = createEntity("Header", compositePageFragment);
		EntityInstance sharedPageFragment = createEntity("SharedFragment", pageFragment);
		EntityInstance field = createEntity("Field", pageFragment);
		createAttribute(field, "required", Boolean.class); // TODO: this validation goes to the domain
		createAttribute(field, "readOnly", Boolean.class);
		EntityInstance button = createEntity("Button", pageFragment);
		createAttribute(button, "trigger", String.class);
		EntityInstance pageComposition = createEntity("PageComposition", null);
		AttributeInstance presentationStyles = createAttribute(pageComposition, "presentationStyles", String.class);
		presentationStyles.multivalue.set(true);
		
		// Text
		EntityInstance text = createEntity("Text", pageFragment);
		EntityInstance constantText = createEntity("ConstantText", text);
		EntityInstance sharedText = createEntity("SharedText", text);
		createAttribute(constantText, "untranslated", String.class);
		// TODO: translations

		// Flow nodes & Flow
		EntityInstance flowEdge = createEntity("FlowEdge", null);
		EntityInstance flowNodeBase = createEntity("FlowNodeBase", concept);
		EntityInstance flowSource = createEntity("FlowSource", flowNodeBase);
		EntityInstance flowSink = createEntity("FlowSink", flowNodeBase);
		EntityInstance page = createEntity("Page", flowNodeBase);
		EntityInstance subFlow = createEntity("SubFlow", flowNodeBase);
		EntityInstance flow = createEntity("Flow", concept);
		
		// Relations
		
		// Application
		createRelation(application, "entities", RelationType.OneToManyAggregation, "application", entity);
		createRelation(application, "caseEntity", RelationType.OneToZeroOrOne, "caseEntityInApplication", entity);
		RelationInstance flows = createRelation(application, "flows", RelationType.OneToManyAggregation, "application", flow);
		createRelation(application, "exposedFlows", RelationType.OneToMany, "exposedFlowInApplication", flow);

		// Data
		createRelation(entity, "extendsFrom", RelationType.ManyToZeroOrOne, "extensions", entity);
		createRelation(entity, "attributes", RelationType.OneToManyAggregation, "entity", attribute);
		createRelation(entity, "relations", RelationType.OneToManyAggregation, "entity", relation);
		createRelation(relation, "to", RelationType.ManyToZeroOrOne, "reverseRelations", entity);
		createRelation(attribute, "question", RelationType.OneToZeroOrOneAggregation, "questionOnAttribute", text);
		createRelation(attribute, "explanation", RelationType.OneToZeroOrOneAggregation, "explanationOnAttribute", text);
		createRelation(attribute, "domain", RelationType.OneToManyAggregation, "attribute", domainEntry);
		createRelation(domainEntry, "display", RelationType.OneToZeroOrOneAggregation, "displayOnDomainEntry", text);

		// Shared
		createRelation(application, "shared", RelationType.OneToOneAggregation, "application", shared);
		createRelation(shared, "pageFragments", RelationType.OneToManyAggregation, "shared", pageFragmentHolder);
		createRelation(sharedPageFragment, "holder", RelationType.ManyToZeroOrOne, "usages", pageFragmentHolder);
		createRelation(pageFragmentHolder, "pageFragment", RelationType.OneToOneAggregation, "holder", pageFragment);
		createRelation(shared, "texts", RelationType.OneToManyAggregation, "shared", textHolder);
		createRelation(sharedText, "holder", RelationType.ManyToZeroOrOne, "usages", textHolder);
		createRelation(textHolder, "text", RelationType.OneToOneAggregation, "holder", text);
		
		// Page elements
		createRelation(page, "content", RelationType.OneToOneAggregation, "contentOfPage", compositePageFragment);
		createRelation(compositePageFragment, "items", RelationType.OneToManyAggregation, "container", pageComposition);
		createRelation(pageComposition, "pageFragment", RelationType.OneToZeroOrOneAggregation, "composedIn", pageFragment);
		createRelation(field, "attribute", RelationType.ManyToZeroOrOne, "fields", attribute);
		createRelation(select, "relation", RelationType.ManyToZeroOrOne, "relationInselects", relation);
		createRelation(header, "text", RelationType.OneToOneAggregation, "textOnHeader", text);
		createRelation(button, "caption", RelationType.OneToOneAggregation, "captionOnButton", text);
		
		// Flow
		createRelation(flow, "sources", RelationType.OneToManyAggregation, "flow", flowSource);
		createRelation(flow, "sinks", RelationType.OneToManyAggregation, "flow", flowSink);
		createRelation(flow, "nodes", RelationType.OneToManyAggregation, "flow", flowNodeBase);
		createRelation(flow, "edges", RelationType.OneToManyAggregation, "flow", flowEdge);
		createRelation(flowEdge, "from", RelationType.ManyToZeroOrOne, "outgoingEdges", flowNodeBase);
		createRelation(flowEdge, "to", RelationType.ManyToZeroOrOne, "incomingEdges", flowNodeBase);
		
		// Flows
		
		// Main
		FlowInstance mainFlow = createFlow("Main");
		FlowSourceInstance mainStart = createStartSource(mainFlow, "start");
		PageInstance welcomePage = createPage(mainFlow, "Welcome");
		PageInstance flowPage = createPage(mainFlow, "Flow");
		createEdge(mainFlow, mainStart, welcomePage);
		createEdge(mainFlow, welcomePage, flowPage);
		// Welcome page
		addContent(welcomePage.content.get(), createConstantText("Welcome to the Designer"));
		addContent(welcomePage.content.get(), createConstantText("Flows:"));
		SelectInstance flowsSelect = createSelect(flows);
		createField(flowsSelect, name, false);
		addContent(flowsSelect, createButton("flowDetails", createConstantText("Details")));
		addContent(welcomePage.content.get(), flowsSelect);
		// Flow page
		addContent(flowPage.content.get(), createConstantText("Flow"));
		createField(flowPage.content.get(), name, false);
		
		// Finish up
		
		applicationInstance.exposedFlows.add(mainFlow);
		
		return applicationInstance;
	}
}
