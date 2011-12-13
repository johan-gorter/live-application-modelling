package lbe.designerbootstrap;

import lbe.designerbootstrap.Bootstrapper.RelationType;
import app.designer.AttributeDesign;
import app.designer.CompositePageFragmentDesign;
import app.designer.EntityDesign;
import app.designer.EventDesign;
import app.designer.FlowDesign;
import app.designer.FlowSourceDesign;
import app.designer.HeaderDesign;
import app.designer.LinkDesign;
import app.designer.PageDesign;
import app.designer.PageFragmentDesign;
import app.designer.PageFragmentHolderDesign;
import app.designer.RelationDesign;
import app.designer.SelectDesign;
import app.designer.SharedFragmentDesign;
import app.designer.SubFlowDesign;
import custom.designer.ApplicationDesignCustomization;

public class DesignerBootstrapper extends BootstrapperUtil {

	public static ApplicationDesignCustomization createDesigner() {

		// Case
		applicationDesign = new ApplicationDesignCustomization();
		applicationDesign.name.set("Designer");
		//applicationDesign.name.set("NextDesigner");
		
		// Entities
		
		// Application
		EntityDesign application = createEntity("ApplicationDesign", null);
		application.customization.set("custom.designer.ApplicationDesignCustomization");
		createAttribute(application, "name", String.class);
		applicationDesign.caseEntity.set(application);
		createAttribute(application, "customization", String.class);
		
		// Concept
		EntityDesign design = createEntity("Design", null);
		AttributeDesign name = createAttribute(design, "name", String.class);
		AttributeDesign valid = createAttribute(design, "valid", Boolean.class);
		valid.readOnly.set(true);
		valid.customization.set("custom.designer.ValidAttributeCustomization");
		
		createAttribute(design, "customization", String.class);
		
		// Entity
		EntityDesign entityDesign = createEntity("EntityDesign", design);

		// Attribute
		EntityDesign attributeDesign = createEntity("AttributeDesign", design);
		createAttribute(attributeDesign, "readOnly", Boolean.class);
		createAttribute(attributeDesign, "multivalue", Boolean.class);
		AttributeDesign className = createAttribute(attributeDesign, "className", String.class);
		EntityDesign domainEntryDesign = createEntity("DomainEntryDesign", design);
		
		// Relation
		EntityDesign relationDesign = createEntity("RelationDesign", attributeDesign);
		createAttribute(relationDesign, "owner", Boolean.class);
		createAttribute(relationDesign, "autoCreate", Boolean.class);
		createAttribute(relationDesign, "reverseMultivalue", Boolean.class);
		createAttribute(relationDesign, "reverseName", String.class);
		
		// Deduction
		EntityDesign deductionSchemeDesign = createEntity("DeductionSchemeDesign", null);
		EntityDesign deductionDesign = createEntity("DeductionDesign", null);
		createAttribute(deductionDesign, "multivalue", Boolean.class);
		createAttribute(deductionDesign, "className", String.class); // in case of an entity, see relation entity
		EntityDesign selectedInstanceDeductionDesign = createEntity("SelectedInstanceDeductionDesign" , deductionDesign);
		EntityDesign castInstanceDeductionDesign = createEntity("CastInstanceDeductionDesign" , deductionDesign);
		EntityDesign attributeDeductionDesign = createEntity("AttributeDeductionDesign" , deductionDesign);
		
		// Shared
		EntityDesign pageFragmentHolder = createEntity("PageFragmentHolderDesign", design);
		
		// Page elements & Page
		EntityDesign pageFragmentDesign = createEntity("PageFragmentDesign", design);
		AttributeDesign presentation = createAttribute(pageFragmentDesign, "presentation", String.class);
		EntityDesign compositePageFragmentDesign = createEntity("CompositePageFragmentDesign", pageFragmentDesign);
		EntityDesign select = createEntity("SelectDesign", compositePageFragmentDesign);
		EntityDesign header = createEntity("HeaderDesign", compositePageFragmentDesign);
		EntityDesign sharedFragment = createEntity("SharedFragmentDesign", pageFragmentDesign);
		EntityDesign fieldDesign = createEntity("FieldDesign", pageFragmentDesign);
		AttributeDesign required = createAttribute(fieldDesign, "required", Boolean.class); // TODO: this validation goes to the domain
		AttributeDesign readOnly = createAttribute(fieldDesign, "readOnly", Boolean.class);
		EntityDesign linkDesign = createEntity("LinkDesign", pageFragmentDesign);
		EntityDesign buttonDesign = createEntity("ButtonDesign", linkDesign);
		EntityDesign pageComposition = createEntity("PageCompositionDesign", null);
		
		// Text
		EntityDesign textDesign = createEntity("TextDesign", pageFragmentDesign);
		EntityDesign constantTextDesign = createEntity("ConstantTextDesign", textDesign);
		createAttribute(constantTextDesign, "untranslated", String.class);
		EntityDesign templatedTextDesign = createEntity("TemplatedTextDesign", textDesign);
		EntityDesign stringProducerDesign = createEntity("StringProducerDesign", null);
		EntityDesign constantStringDesign = createEntity("ConstantStringDesign", stringProducerDesign);
		createAttribute(constantStringDesign, "constant", String.class);
		EntityDesign formattedValueDesign = createEntity("FormattedValueDesign", stringProducerDesign);
		EntityDesign sharedTextDesign = createEntity("SharedTextDesign", textDesign);
		// TODO: translations

		// Flow nodes & Flow
		EntityDesign eventDesign = createEntity("EventDesign", design);
		EntityDesign flowEdgeDesign = createEntity("FlowEdgeDesign", null);
		EntityDesign flowNodeBaseDesign = createEntity("FlowNodeBaseDesign", design);
		EntityDesign flowSourceDesign = createEntity("FlowSourceDesign", null);
		EntityDesign pageDesign = createEntity("PageDesign", flowNodeBaseDesign);
		EntityDesign subFlowDesign = createEntity("SubFlowDesign", flowNodeBaseDesign);
		EntityDesign flowDesign = createEntity("FlowDesign", design);
		
		// Relations
		
		// Application
		RelationDesign entities = createRelation(application, "entities", RelationType.OneToManyAggregation, "application", entityDesign);
		createRelation(application, "caseEntity", RelationType.OneToZeroOrOne, "caseEntityInApplication", entityDesign);
		RelationDesign flows = createRelation(application, "flows", RelationType.OneToManyAggregation, "application", flowDesign);
		createRelation(application, "events", RelationType.OneToManyAggregation, "application", eventDesign);
		createRelation(application, "exposedFlows", RelationType.OneToMany, "exposedFlowInApplication", flowDesign);

		// Data
		createRelation(entityDesign, "extendsFrom", RelationType.ManyToZeroOrOne, "extensions", entityDesign);
		createRelation(entityDesign, "attributes", RelationType.OneToManyAggregation, "entity", attributeDesign);
		createRelation(entityDesign, "relations", RelationType.OneToManyAggregation, "from", relationDesign);
		createRelation(relationDesign, "to", RelationType.ManyToZeroOrOne, "reverseRelations", entityDesign);
		createRelation(attributeDesign, "question", RelationType.OneToZeroOrOneAggregation, "questionOnAttribute", textDesign);
		createRelation(attributeDesign, "explanation", RelationType.OneToZeroOrOneAggregation, "explanationOnAttribute", textDesign);
		createRelation(attributeDesign, "domain", RelationType.OneToManyAggregation, "attribute", domainEntryDesign);
		createRelation(domainEntryDesign, "display", RelationType.OneToZeroOrOneAggregation, "displayOnDomainEntry", textDesign);
		
		// Deduction
		createRelation(deductionSchemeDesign, "deductions", RelationType.OneToManyAggregation, "scheme", deductionDesign);
		createRelation(deductionSchemeDesign, "output", RelationType.OneToZeroOrOne, "schemeOutput", deductionDesign);
		createRelation(deductionDesign, "inputs", RelationType.ManyToMany, "outputs", deductionDesign);
		createRelation(attributeDeductionDesign, "attribute", RelationType.ManyToZeroOrOne, "attributeInDeductions", attributeDesign);
		createRelation(selectedInstanceDeductionDesign, "entity", RelationType.ManyToZeroOrOne, "entityInSelectedInstanceDeductions", entityDesign);
		createRelation(castInstanceDeductionDesign, "entity", RelationType.ManyToZeroOrOne, "entityInCastDeductions", entityDesign);
		
		// Text
		createRelation(templatedTextDesign, "untranslated", RelationType.OneToManyAggregation, "untranslatedInTemplate", stringProducerDesign);
		createRelation(formattedValueDesign, "deduction", RelationType.OneToOneAggregation, "templatedText", deductionSchemeDesign);

		// Shared
		createRelation(application, "sharedPageFragments", RelationType.OneToManyAggregation, "shared", pageFragmentHolder);
		createRelation(sharedFragment, "holder", RelationType.ManyToZeroOrOne, "usages", pageFragmentHolder);
		createRelation(pageFragmentHolder, "pageFragment", RelationType.OneToOneAggregation, "holder", pageFragmentDesign);
		
		// Page elements
		RelationDesign content = createRelation(pageDesign, "content", RelationType.OneToOneAggregation, "contentOfPage", compositePageFragmentDesign);
		RelationDesign items = createRelation(compositePageFragmentDesign, "items", RelationType.OneToManyAggregation, "itemIn", pageComposition);
		RelationDesign pageFragment = createRelation(pageComposition, "pageFragment", RelationType.OneToZeroOrOneAggregation, "composedIn", pageFragmentDesign);
		RelationDesign fieldAttribute = createRelation(fieldDesign, "attribute", RelationType.ManyToZeroOrOne, "fields", attributeDesign);
		createRelation(select, "deduction", RelationType.OneToZeroOrOneAggregation, "select", deductionSchemeDesign);
		createRelation(header, "text", RelationType.OneToOneAggregation, "textOnHeader", textDesign);
		createRelation(linkDesign, "caption", RelationType.OneToOneAggregation, "captionOnButton", textDesign);
		createRelation(linkDesign, "event", RelationType.ManyToZeroOrOne, "firesFromButtons", eventDesign);
		
		// Flow
		createRelation(eventDesign, "parameters", RelationType.ManyToMany, "parameterInEvent", entityDesign);
		
		createRelation(flowDesign, "sources", RelationType.OneToManyAggregation, "owner", flowSourceDesign);
		RelationDesign nodes = createRelation(flowDesign, "nodes", RelationType.OneToManyAggregation, "owner", flowNodeBaseDesign);
		createRelation(flowDesign, "edges", RelationType.OneToManyAggregation, "owner", flowEdgeDesign);
		createRelation(flowDesign, "parameters", RelationType.ManyToMany, "parameterInFlows", entityDesign);

		createRelation(flowSourceDesign, "startEvent", RelationType.ManyToZeroOrOne, "startEventInSources", eventDesign);
		createRelation(flowSourceDesign, "endNode", RelationType.ManyToZeroOrOne, "incomingSources", flowNodeBaseDesign);
		createRelation(flowSourceDesign, "endEvent", RelationType.ManyToZeroOrOne, "endEventInSources", eventDesign);
		
		createRelation(flowEdgeDesign, "startNode", RelationType.ManyToZeroOrOne, "outgoingEdges", flowNodeBaseDesign);
		createRelation(flowEdgeDesign, "startEvent", RelationType.ManyToZeroOrOne, "startEventInEdges", eventDesign);
		createRelation(flowEdgeDesign, "endNode", RelationType.ManyToZeroOrOne, "incomingEdges", flowNodeBaseDesign);
		createRelation(flowEdgeDesign, "endEvent", RelationType.ManyToZeroOrOne, "endEventInEdges", eventDesign);
		
		createRelation(subFlowDesign, "flow", RelationType.OneToZeroOrOne, "subFlowIn", flowDesign);
		
		
		// Interaction
		
		// Events
		EventDesign home = createEvent("Home");
		EventDesign flowDetails = createEvent("FlowDetails", flowDesign);
		EventDesign flowNodeDetails = createEvent("FlowNodeDetails", flowNodeBaseDesign);
		EventDesign pageDetails = createEvent("PageDetails", pageDesign);
		EventDesign fieldDetails = createEvent("FieldDetails", fieldDesign);
		EventDesign addField = createEvent("AddField");
		EventDesign entityDetails = createEvent("EntityDetails", flowDesign);
		EventDesign exploreInstance = createEvent("ExploreInstance");
		exploreInstance.customization.set("custom.designer.caseexplorer.ExploreInstanceEventCustomization");
		
		// Flows
		FlowDesign mainFlow = createFlow("Main");
		FlowDesign flowFlow = createFlow("Flow");
		flowFlow.parameters.add(flowDesign);
		FlowDesign pageFlow = createFlow("Page");
		pageFlow.parameters.add(pageDesign);
		FlowDesign addFieldFlow = createFlow("AddField");
		addFieldFlow.customization.set("custom.designer.AddFieldFlowCustomization");
		FlowDesign fieldFlow = createFlow("Field");
		fieldFlow.parameters.add(fieldDesign);
		FlowDesign flowNodeFlow = createFlow("FlowNode");
		flowNodeFlow.parameters.add(flowNodeBaseDesign);
		flowNodeFlow.customization.set("custom.designer.FlowNodeFlowCustomization");
		FlowDesign caseExplorerFlow = createFlow("CaseExplorer");
		FlowDesign caseExplorerInstanceFlow = createFlow("CaseExplorerInstance");
		caseExplorerInstanceFlow.customization.set("custom.designer.caseexplorer.CaseExplorerInstanceFlowCustomization");
		// Main
		PageDesign welcomePage = createPage(mainFlow, "Welcome");
		FlowSourceDesign mainStart = createSource(mainFlow, null, welcomePage, null);
		SubFlowDesign flowSubFlow = createSubFlow(mainFlow, flowFlow);
		SubFlowDesign caseExplorerSubFlow = createSubFlow(mainFlow, caseExplorerFlow);
		createEdge(mainFlow, welcomePage, flowDetails, flowSubFlow, flowDetails);
		createEdge(mainFlow, flowSubFlow, flowDetails, flowSubFlow, flowDetails);//recursive
		createEdge(mainFlow, flowSubFlow, home, welcomePage, null);
		createEdge(mainFlow, flowSubFlow, exploreInstance, caseExplorerSubFlow, exploreInstance);
		// Flow
		PageDesign flowPage = createPage(flowFlow, "Flow");
		FlowSourceDesign flowDetailsSource = createSource(flowFlow, flowDetails, flowPage, null);
		SubFlowDesign flowNodeSubFlow = createSubFlow(flowFlow, flowNodeFlow);
		SubFlowDesign pageSubFlow = createSubFlow(flowFlow, pageFlow);
		createEdge(flowFlow, flowPage, flowNodeDetails, flowNodeSubFlow, null);
		createEdge(flowFlow, flowNodeSubFlow, pageDetails, pageSubFlow, null);
		createEdge(flowFlow, pageSubFlow, flowDetails, flowPage, null);
		// Page
		PageDesign pagePage = createPage(pageFlow, "Page");
		SubFlowDesign fieldSubFlow = createSubFlow(pageFlow, fieldFlow);
		SubFlowDesign addFieldSubFlow = createSubFlow(pageFlow, addFieldFlow);
		createSource(pageFlow, pageDetails, pagePage, null);
		createEdge(pageFlow, pagePage, fieldDetails, fieldSubFlow, fieldDetails);
		createEdge(pageFlow, pagePage, addField, addFieldSubFlow, addField);
		createEdge(pageFlow, addFieldSubFlow, fieldDetails, fieldSubFlow, fieldDetails);
		createEdge(pageFlow, fieldSubFlow, pageDetails, pagePage, null);
		// Field
		PageDesign fieldPage = createPage(fieldFlow, "Field");
		createSource(fieldFlow, fieldDetails, fieldPage, null);
		// CaseExplorer
		SubFlowDesign caseExplorerInstanceSubFlow = createSubFlow(caseExplorerFlow, caseExplorerInstanceFlow);
		FlowSourceDesign exploreInstanceSource = createSource(caseExplorerFlow, exploreInstance, caseExplorerInstanceSubFlow, exploreInstance);
		createEdge(caseExplorerFlow, caseExplorerInstanceSubFlow, exploreInstance, caseExplorerInstanceSubFlow, exploreInstance); // This edge is the reason for this wrapping flow
		// CaseExplorerDesign
		PageDesign instancePage = createPage(caseExplorerInstanceFlow, "Instance");
		instancePage.customization.set("custom.designer.caseexplorer.InstancePageCustomization");
		FlowSourceDesign instanceExploreInstanceSource = createSource(caseExplorerInstanceFlow, exploreInstance, instancePage, null);
		
		// Shared
		CompositePageFragmentDesign pageFragmentEditor = createCompositePageFragment();
		addContent(pageFragmentEditor, add(createTemplatedText(), createDeduction(pageFragmentDesign)));
		SelectDesign fieldSelect = createSelect(createCastDeduction(pageFragmentDesign, fieldDesign));
		addContent(fieldSelect, createLink(fieldDetails, add(createTemplatedText(), createDeduction(pageFragmentDesign))));
		PageFragmentDesign previewDesign = new PageFragmentDesign(applicationDesign);
		previewDesign.setCustomization("custom.designer.PreviewPageFragmentCustomization");
		addContent(fieldSelect, previewDesign);
		SelectDesign compositeSelect = createSelect(createCastDeduction(pageFragmentDesign, compositePageFragmentDesign));
		addContent(pageFragmentEditor, fieldSelect);
		addContent(pageFragmentEditor, compositeSelect);
		CompositePageFragmentDesign indentedContent = createCompositePageFragment();
		indentedContent.setPresentation("indented");
		addContent(compositeSelect, indentedContent);
		SelectDesign itemsSelect = createSelect(createDeduction(items));
		addContent(indentedContent, itemsSelect);
		SelectDesign pageFragmentSelect = createSelect(createDeduction(pageFragment));
		addContent(itemsSelect, pageFragmentSelect);
		SharedFragmentDesign recursivePageFragmentEditor = new SharedFragmentDesign(applicationDesign);
		addContent(pageFragmentSelect, recursivePageFragmentEditor); // Careful: recursion
		
		PageFragmentHolderDesign pageFragmentEditorHolder = new PageFragmentHolderDesign(applicationDesign);
		pageFragmentEditorHolder.pageFragment.set(pageFragmentEditor);
		pageFragmentEditorHolder.setName("PageFragmentEditor");
		applicationDesign.sharedPageFragments.add(pageFragmentEditorHolder);

		recursivePageFragmentEditor.setHolder(pageFragmentEditorHolder);

		// Pages
		// Welcome page
		addContent(welcomePage.content.get(), createConstantText("Welcome to the Designer"));
		CompositePageFragmentDesign columns = createCompositePageFragment();
		columns.presentation.set("four-columns");
		addContent(welcomePage.content.get(), columns);
		CompositePageFragmentDesign column1 = createCompositePageFragment();
		column1.presentation.set("column");
		addContent(columns, column1);
		addContent(column1, createConstantText("Entities"));
		SelectDesign entitiesSelect = createSelect(createDeduction(entities));
		addContent(entitiesSelect, createLink(entityDetails, add(createTemplatedText(), name)));
		addContent(column1, entitiesSelect);

		CompositePageFragmentDesign column2 = createCompositePageFragment();
		column2.presentation.set("column");
		addContent(columns, column2);
		addContent(column2, createConstantText("Flows"));
		SelectDesign flowsSelect = createSelect(createDeduction(flows));
		addContent(flowsSelect, createLink(flowDetails, add(createTemplatedText(), name)));
		addContent(column2, flowsSelect);
		// Flow page
		addContent(flowPage.content.get(), createLink(home, createConstantText("Home")));
		addContent(flowPage.content.get(), createLink(exploreInstance, createConstantText("Open in case explorer")));
		createField(flowPage.content.get(), name, false);
		addContent(flowPage.content.get(), createConstantText("Nodes"));
		SelectDesign nodesSelect = createSelect(createDeduction(nodes));
		addContent(nodesSelect, createLink(flowNodeDetails, add(createTemplatedText(), name)));
		addContent(flowPage.content.get(), nodesSelect);
		// Page page
		addContent(pagePage.content.get(), createLink(home, createConstantText("Home")));
		addContent(pagePage.content.get(), createLink(flowDetails, createConstantText("Flow")));
		addContent(pagePage.content.get(), createLink(exploreInstance, createConstantText("Open in case explorer")));
		createField(pagePage.content.get(), name, false);
		SelectDesign selectContent = createSelect(createDeduction(content));
		SharedFragmentDesign editorReference = new SharedFragmentDesign(applicationDesign);
		editorReference.holder.set(pageFragmentEditorHolder);
		addContent(selectContent, editorReference);
		addContent(pagePage.content.get(), selectContent);
		addContent(pagePage.content.get(), createButton(addField, createConstantText("Add field")));
		// Field page
		addContent(fieldPage.content.get(), createLink(home, createConstantText("Home")));
		addContent(fieldPage.content.get(), createLink(flowDetails, createConstantText("Flow")));
		addContent(fieldPage.content.get(), createLink(pageDetails, createConstantText("Page")));
		addContent(fieldPage.content.get(), createLink(exploreInstance, createConstantText("Open in case explorer")));
		createField(fieldPage.content.get(), required, false);
		createField(fieldPage.content.get(), readOnly, false);
		SelectDesign attributeSelect = createSelect(createDeduction(fieldAttribute));
		createField(attributeSelect, name, true);
		createField(attributeSelect, className, true);
		addContent(fieldPage.content.get(), attributeSelect);
		
		// Finish up
		
		applicationDesign.exposedFlows.add(mainFlow);
		
		return applicationDesign;
	}
}
