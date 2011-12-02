package lbe.designerbootstrap;

import lbe.designerbootstrap.Bootstrapper.RelationType;
import app.designer.data.instance.AttributeInstance;
import app.designer.data.instance.CompositePageFragmentInstance;
import app.designer.data.instance.EntityInstance;
import app.designer.data.instance.EventInstance;
import app.designer.data.instance.FlowInstance;
import app.designer.data.instance.FlowSourceInstance;
import app.designer.data.instance.PageFragmentHolderInstance;
import app.designer.data.instance.PageInstance;
import app.designer.data.instance.RelationInstance;
import app.designer.data.instance.SelectInstance;
import app.designer.data.instance.SharedFragmentInstance;
import app.designer.data.instance.SubFlowInstance;
import app.designer.data.instance.TextInstance;
import custom.designer.ApplicationInstanceCustomization;

public class DesignerBootstrapper extends BootstrapperUtil {

	public static ApplicationInstanceCustomization createDesigner() {

		// Case
		applicationInstance = new ApplicationInstanceCustomization();
		applicationInstance.name.set("Designer");
//		applicationInstance.name.set("NextDesigner");
		
		// Entities
		
		// Application
		EntityInstance application = createEntity("Application", null);
		application.customization.set("custom.designer.ApplicationInstanceCustomization");
		createAttribute(application, "name", String.class);
		applicationInstance.caseEntity.set(application);
		createAttribute(application, "customization", String.class);
		
		// Concept
		EntityInstance concept = createEntity("Concept", null);
		AttributeInstance name = createAttribute(concept, "name", String.class);
		AttributeInstance valid = createAttribute(concept, "valid", Boolean.class);
		valid.readOnly.set(true);
		valid.customization.set("custom.designer.ValidAttributeCustomization");
		
		createAttribute(concept, "customization", String.class);
		
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
		AttributeInstance presentation = createAttribute(pageFragment, "presentation", String.class);
		EntityInstance compositePageFragment = createEntity("CompositePageFragment", pageFragment);
		EntityInstance select = createEntity("Select", compositePageFragment);
		EntityInstance header = createEntity("Header", compositePageFragment);
		EntityInstance sharedPageFragment = createEntity("SharedFragment", pageFragment);
		EntityInstance field = createEntity("Field", pageFragment);
		createAttribute(field, "required", Boolean.class); // TODO: this validation goes to the domain
		createAttribute(field, "readOnly", Boolean.class);
		EntityInstance link = createEntity("Link", pageFragment);
		EntityInstance button = createEntity("Button", link);
		EntityInstance pageComposition = createEntity("PageComposition", null);
		
		// Text
		EntityInstance text = createEntity("Text", pageFragment);
		EntityInstance constantText = createEntity("ConstantText", text);
		createAttribute(constantText, "untranslated", String.class);
		EntityInstance templatedText = createEntity("TemplatedText", text);
		EntityInstance stringProducer = createEntity("StringProducer", null);
		EntityInstance constantString = createEntity("ConstantString", stringProducer);
		createAttribute(constantString, "constant", String.class);
		EntityInstance formattedValue = createEntity("FormattedValue", stringProducer);
		EntityInstance sharedText = createEntity("SharedText", text);
		// TODO: translations

		// Flow nodes & Flow
		EntityInstance event = createEntity("Event", concept);
		EntityInstance flowEdge = createEntity("FlowEdge", null);
		EntityInstance flowNodeBase = createEntity("FlowNodeBase", concept);
		EntityInstance flowSource = createEntity("FlowSource", null);
		EntityInstance page = createEntity("Page", flowNodeBase);
		EntityInstance subFlow = createEntity("SubFlow", flowNodeBase);
		EntityInstance flow = createEntity("Flow", concept);
		
		// Relations
		
		// Application
		RelationInstance entities = createRelation(application, "entities", RelationType.OneToManyAggregation, "application", entity);
		createRelation(application, "caseEntity", RelationType.OneToZeroOrOne, "caseEntityInApplication", entity);
		RelationInstance flows = createRelation(application, "flows", RelationType.OneToManyAggregation, "application", flow);
		createRelation(application, "events", RelationType.OneToManyAggregation, "application", event);
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
		
		// Text
		createRelation(templatedText, "untranslated", RelationType.OneToManyAggregation, "untranslatedInTemplate", stringProducer);
		createRelation(formattedValue, "value", RelationType.OneToZeroOrOne, "valueInTemplatedText", attributeBase); //TODO: deduction

		// Shared
		createRelation(application, "shared", RelationType.OneToOneAggregation, "application", shared);
		createRelation(shared, "pageFragments", RelationType.OneToManyAggregation, "shared", pageFragmentHolder);
		createRelation(sharedPageFragment, "holder", RelationType.ManyToZeroOrOne, "usages", pageFragmentHolder);
		createRelation(pageFragmentHolder, "pageFragment", RelationType.OneToOneAggregation, "holder", pageFragment);
		createRelation(shared, "texts", RelationType.OneToManyAggregation, "shared", textHolder);
		createRelation(sharedText, "holder", RelationType.ManyToZeroOrOne, "usages", textHolder);
		createRelation(textHolder, "text", RelationType.OneToOneAggregation, "holder", text);
		
		// Page elements
		RelationInstance content = createRelation(page, "content", RelationType.OneToOneAggregation, "contentOfPage", compositePageFragment);
		createRelation(compositePageFragment, "items", RelationType.OneToManyAggregation, "itemIn", pageComposition);
		createRelation(pageComposition, "pageFragment", RelationType.OneToZeroOrOneAggregation, "composedIn", pageFragment);
		createRelation(field, "attribute", RelationType.ManyToZeroOrOne, "fields", attribute);
		createRelation(select, "relation", RelationType.ManyToZeroOrOne, "relationInselects", relation);
		createRelation(header, "text", RelationType.OneToOneAggregation, "textOnHeader", text);
		createRelation(link, "caption", RelationType.OneToOneAggregation, "captionOnButton", text);
		createRelation(link, "event", RelationType.ManyToZeroOrOne, "firesFromButtons", event);
		
		// Flow
		createRelation(event, "parameters", RelationType.ManyToMany, "parameterInEvent", entity);
		
		createRelation(flow, "sources", RelationType.OneToManyAggregation, "owner", flowSource);
		RelationInstance nodes = createRelation(flow, "nodes", RelationType.OneToManyAggregation, "owner", flowNodeBase);
		createRelation(flow, "edges", RelationType.OneToManyAggregation, "owner", flowEdge);
		createRelation(flow, "parameters", RelationType.ManyToMany, "parameterInFlows", entity);

		createRelation(flowSource, "startEvent", RelationType.ManyToZeroOrOne, "startEventInSources", event);
		createRelation(flowSource, "endNode", RelationType.ManyToZeroOrOne, "incomingSources", flowNodeBase);
		createRelation(flowSource, "endEvent", RelationType.ManyToZeroOrOne, "endEventInSources", event);
		
		createRelation(flowEdge, "startNode", RelationType.ManyToZeroOrOne, "outgoingEdges", flowNodeBase);
		createRelation(flowEdge, "startEvent", RelationType.ManyToZeroOrOne, "startEventInEdges", event);
		createRelation(flowEdge, "endNode", RelationType.ManyToZeroOrOne, "incomingEdges", flowNodeBase);
		createRelation(flowEdge, "endEvent", RelationType.ManyToZeroOrOne, "endEventInEdges", event);
		
		createRelation(subFlow, "flow", RelationType.OneToZeroOrOne, "subFlowIn", flow);
		
		// Interaction
		
		// Events
		EventInstance home = createEvent("Home");
		EventInstance flowDetails = createEvent("FlowDetails", flow);
		EventInstance flowNodeDetails = createEvent("FlowNodeDetails", flowNodeBase);
		EventInstance pageDetails = createEvent("PageDetails", page);
		EventInstance fieldDetails = createEvent("FieldDetails", field);
		EventInstance addField = createEvent("AddField");
		EventInstance entityDetails = createEvent("EntityDetails", flow);
		EventInstance exploreInstance = createEvent("ExploreInstance");
		exploreInstance.customization.set("custom.designer.caseexplorer.ExploreInstanceEventCustomization");
		
		// Flows
		FlowInstance mainFlow = createFlow("Main");
		FlowInstance flowFlow = createFlow("Flow");
		flowFlow.parameters.add(flow);
		FlowInstance pageFlow = createFlow("Page");
		pageFlow.parameters.add(page);
		FlowInstance addFieldFlow = createFlow("AddField");
		addFieldFlow.customization.set("custom.designer.AddFieldFlowCustomization");
		FlowInstance fieldFlow = createFlow("Field");
		fieldFlow.parameters.add(field);
		FlowInstance flowNodeFlow = createFlow("FlowNode");
		flowNodeFlow.parameters.add(flowNodeBase);
		flowNodeFlow.customization.set("custom.designer.FlowNodeFlowCustomization");
		FlowInstance caseExplorerFlow = createFlow("CaseExplorer");
		FlowInstance caseExplorerInstanceFlow = createFlow("CaseExplorerInstance");
		caseExplorerInstanceFlow.customization.set("custom.designer.caseexplorer.CaseExplorerInstanceFlowCustomization");
		// Main
		PageInstance welcomePage = createPage(mainFlow, "Welcome");
		FlowSourceInstance mainStart = createSource(mainFlow, null, welcomePage, null);
		SubFlowInstance flowSubFlow = createSubFlow(mainFlow, flowFlow);
		SubFlowInstance caseExplorerSubFlow = createSubFlow(mainFlow, caseExplorerFlow);
		createEdge(mainFlow, welcomePage, flowDetails, flowSubFlow, flowDetails);
		createEdge(mainFlow, flowSubFlow, flowDetails, flowSubFlow, flowDetails);//recursive
		createEdge(mainFlow, flowSubFlow, home, welcomePage, null);
		createEdge(mainFlow, flowSubFlow, exploreInstance, caseExplorerSubFlow, exploreInstance);
		// Flow
		PageInstance flowPage = createPage(flowFlow, "Flow");
		FlowSourceInstance flowDetailsSource = createSource(flowFlow, flowDetails, flowPage, null);
		SubFlowInstance flowNodeSubFlow = createSubFlow(flowFlow, flowNodeFlow);
		SubFlowInstance pageSubFlow = createSubFlow(flowFlow, pageFlow);
		createEdge(flowFlow, flowPage, flowNodeDetails, flowNodeSubFlow, null);
		createEdge(flowFlow, flowNodeSubFlow, pageDetails, pageSubFlow, null);
		// Page
		PageInstance pagePage = createPage(pageFlow, "Page");
		SubFlowInstance fieldSubFlow = createSubFlow(pageFlow, fieldFlow);
		SubFlowInstance addFieldSubFlow = createSubFlow(pageFlow, addFieldFlow);
		createSource(pageFlow, pageDetails, pagePage, null);
		createEdge(pageFlow, pagePage, addField, addFieldSubFlow, addField);
		createEdge(pageFlow, addFieldSubFlow, fieldDetails, fieldSubFlow, fieldDetails);
		// Field
		PageInstance fieldPage = createPage(fieldFlow, "Field");
		createSource(fieldFlow, fieldDetails, fieldPage, null);
		// CaseExplorer
		SubFlowInstance caseExplorerInstanceSubFlow = createSubFlow(caseExplorerFlow, caseExplorerInstanceFlow);
		FlowSourceInstance exploreInstanceSource = createSource(caseExplorerFlow, exploreInstance, caseExplorerInstanceSubFlow, exploreInstance);
		createEdge(caseExplorerFlow, caseExplorerInstanceSubFlow, exploreInstance, caseExplorerInstanceSubFlow, exploreInstance); // This edge is the reason for this wrapping flow
		// CaseExplorerInstance
		PageInstance instancePage = createPage(caseExplorerInstanceFlow, "Instance");
		instancePage.customization.set("custom.designer.caseexplorer.InstancePageCustomization");
		FlowSourceInstance instanceExploreInstanceSource = createSource(caseExplorerInstanceFlow, exploreInstance, instancePage, null);
		
		// Shared
		CompositePageFragmentInstance pageFragmentEditor = createCompositePageFragment();
		addContent(pageFragmentEditor, add(createTemplatedText(), "PageFragment"));
		createField(pageFragmentEditor, presentation, false);
		PageFragmentHolderInstance pageFragmentEditorHolder = new PageFragmentHolderInstance(applicationInstance);
		pageFragmentEditorHolder.pageFragment.set(pageFragmentEditor);
		applicationInstance.shared.get().pageFragments.add(pageFragmentEditorHolder);
		
		// Pages
		// Welcome page
		addContent(welcomePage.content.get(), createConstantText("Welcome to the Designer"));
		CompositePageFragmentInstance columns = createCompositePageFragment();
		columns.presentation.set("four-columns");
		addContent(welcomePage.content.get(), columns);
		CompositePageFragmentInstance column1 = createCompositePageFragment();
		column1.presentation.set("column");
		addContent(columns, column1);
		addContent(column1, createConstantText("Entities"));
		SelectInstance entitiesSelect = createSelect(entities);
		addContent(entitiesSelect, createLink(entityDetails, add(createTemplatedText(), name)));
		addContent(column1, entitiesSelect);

		CompositePageFragmentInstance column2 = createCompositePageFragment();
		column2.presentation.set("column");
		addContent(columns, column2);
		addContent(column2, createConstantText("Flows"));
		SelectInstance flowsSelect = createSelect(flows);
		addContent(flowsSelect, createLink(flowDetails, add(createTemplatedText(), name)));
		addContent(column2, flowsSelect);
		// Flow page
		createField(flowPage.content.get(), name, false);
		addContent(flowPage.content.get(), createConstantText("Nodes"));
		SelectInstance nodesSelect = createSelect(nodes);
		addContent(nodesSelect, createLink(flowNodeDetails, add(createTemplatedText(), name)));
		addContent(flowPage.content.get(), nodesSelect);
		addContent(flowPage.content.get(), createButton(exploreInstance, createConstantText("Open in case explorer")));
		addContent(flowPage.content.get(), createButton(home, createConstantText("Home")));
		// Page page
		createField(pagePage.content.get(), name, false);
		SelectInstance selectContent = createSelect(content);
		SharedFragmentInstance editorReference = new SharedFragmentInstance(applicationInstance);
		editorReference.holder.set(pageFragmentEditorHolder);
		addContent(selectContent, editorReference);
		addContent(pagePage.content.get(), selectContent);
		addContent(pagePage.content.get(), createButton(addField, createConstantText("Add field")));
		addContent(pagePage.content.get(), createButton(exploreInstance, createConstantText("Open in case explorer")));
		addContent(pagePage.content.get(), createButton(home, createConstantText("Home")));
		// Finish up
		
		applicationInstance.exposedFlows.add(mainFlow);
		
		return applicationInstance;
	}
}
