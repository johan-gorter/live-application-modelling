package org.instantlogic.designer.bootstrapper;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.CompositeTemplateDesign;
import org.instantlogic.designer.ConstantTextDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.EntityDesign.RelationType;
import org.instantlogic.designer.EventDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FlowSourceDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.WidgetChildList;
import org.instantlogic.designer.WidgetTemplateDesign;
import org.instantlogic.designer.WidgetText;
import org.instantlogic.designer.WidgetValue;

public class DesignerBootstrapper extends BootstrapperUtil {

	public static ApplicationDesign createDesigner() {

		// Case
		applicationDesign = new ApplicationDesign();
		applicationDesign.setName("Designer");
		
		applicationDesign.setRootPackageName("org.instantlogic.designer");
		applicationDesign.setSourcePath("/prive/live-business-engineering/designer-generated/app");
//		applicationDesign.setSourcePath("/temp/designer-generated/app");
		
		//applicationDesign.name.set("NextDesigner");
		
		// Entities
		
		// Application
		EntityDesign application = createEntity("ApplicationDesign", null);
		application.setIsCustomized(true);
		createAttribute(application, "name", String.class);
		createAttribute(application, "rootPackageName", String.class);
		createAttribute(application, "sourcePath", String.class);
		applicationDesign.setCaseEntity(application);
		createAttribute(application, "isCustomized", Boolean.class);
		
		// Concept
		EntityDesign design = createEntity("Design", null);
		AttributeDesign name = createAttribute(design, "name", String.class);
//		AttributeDesign valid = createAttribute(design, "valid", Boolean.class);
//		valid.readOnly.set(true);
//		valid.customization.set("custom.designer.ValidAttributeCustomization");
		AttributeDesign javaIdentifier = createAttribute(design, "javaIdentifier", String.class);
		javaIdentifier.setReadOnly(true);
		javaIdentifier.setRule(createCustomDeduction("org.instantlogic.designer.deduction.JavaIdentifierDeduction", "java.lang.String"));
		AttributeDesign technicalName = createAttribute(design, "technicalName", String.class);
		technicalName.setReadOnly(true);
		technicalName.setRule(createCustomDeduction("org.instantlogic.designer.deduction.TechnicalNameDeduction", "java.lang.String"));
		createAttribute(design, "isCustomized", Boolean.class);
		
		// Entity
		EntityDesign entityDesign = createEntity("EntityDesign", design);
		entityDesign.setIsCustomized(true);

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
		createAttribute(deductionDesign, "customization", String.class);
		EntityDesign constantDeductionDesign = createEntity("ConstantDeductionDesign", deductionDesign);
		createAttribute(constantDeductionDesign, "value", Object.class);
		EntityDesign selectedInstanceDeductionDesign = createEntity("SelectedInstanceDeductionDesign" , deductionDesign);
		EntityDesign castInstanceDeductionDesign = createEntity("CastInstanceDeductionDesign" , deductionDesign);
		EntityDesign attributeDeductionDesign = createEntity("AttributeDeductionDesign" , deductionDesign);
		EntityDesign reverseRelationDeductionDesign = createEntity("ReverseRelationDeductionDesign", deductionDesign);
		EntityDesign negationDeductionDesign = createEntity("NegationDeductionDesign", deductionDesign);
		EntityDesign sumDeductionDesign = createEntity("SumDeductionDesign", deductionDesign);
		
		// Shared
		EntityDesign sharedTemplateDefinitionDesign = createEntity("SharedFragmentTemplateDefinitionDesign", design);
		
		// Page elements & Page
		EntityDesign fragmentTemplateDesign = createEntity("FragmentTemplateDesign", design);
		EntityDesign compositeTemplateDesign = createEntity("CompositeTemplateDesign", fragmentTemplateDesign);
		EntityDesign widgetTemplateDesign = createEntity("WidgetTemplateDesign", fragmentTemplateDesign);
		createAttribute(widgetTemplateDesign, "widgetTypeName", String.class);
		EntityDesign sharedTemplateDesign = createEntity("SharedTemplateDesign", fragmentTemplateDesign);
		EntityDesign widgetValue = createEntity("WidgetValue", design);
		EntityDesign widgetText = createEntity("WidgetText", design);
		EntityDesign widgetChildList = createEntity("WidgetChildList", design);
		
		// Text
		EntityDesign textDesign = createEntity("TextDesign", design);
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
		EntityDesign placeTemplateDesign = createEntity("PlaceTemplateDesign", flowNodeBaseDesign);
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
		RelationDesign attributes = createRelation(entityDesign, "attributes", RelationType.OneToManyAggregation, "belongsToEntity", attributeDesign);
		createRelation(entityDesign, "relations", RelationType.OneToManyAggregation, "from", relationDesign);
		createRelation(relationDesign, "to", RelationType.ManyToZeroOrOne, "reverseRelations", entityDesign);
		createRelation(attributeDesign, "question", RelationType.OneToZeroOrOneAggregation, "questionOnAttribute", textDesign);
		createRelation(attributeDesign, "explanation", RelationType.OneToZeroOrOneAggregation, "explanationOnAttribute", textDesign);
		createRelation(attributeDesign, "domain", RelationType.OneToManyAggregation, "attribute", domainEntryDesign);
		createRelation(attributeDesign, "relevance", RelationType.OneToZeroOrOneAggregation, "relevanceOfAttribute", deductionSchemeDesign);
		createRelation(attributeDesign, "rule", RelationType.OneToZeroOrOneAggregation, "ruleOfAttribute", deductionSchemeDesign);
		createRelation(attributeDesign, "default", RelationType.OneToZeroOrOneAggregation, "defaultOfAttribute", deductionSchemeDesign);
		createRelation(domainEntryDesign, "display", RelationType.OneToZeroOrOneAggregation, "displayOnDomainEntry", textDesign);
		
		// Deduction
		createRelation(deductionSchemeDesign, "deductions", RelationType.OneToManyAggregation, "scheme", deductionDesign);
		createRelation(deductionSchemeDesign, "output", RelationType.OneToZeroOrOne, "schemeOutput", deductionDesign);
		createRelation(deductionDesign, "inputs", RelationType.ManyToMany, "outputs", deductionDesign);
		createRelation(attributeDeductionDesign, "attribute", RelationType.ManyToZeroOrOne, "attributeInDeductions", attributeDesign);
		createRelation(reverseRelationDeductionDesign, "relation", RelationType.ManyToZeroOrOne, "relationInDeductions", relationDesign);
		createRelation(selectedInstanceDeductionDesign, "ofEntity", RelationType.ManyToZeroOrOne, "entityInSelectedInstanceDeductions", entityDesign);
		createRelation(castInstanceDeductionDesign, "toEntity", RelationType.ManyToZeroOrOne, "entityInCastDeductions", entityDesign);
		
		// Text
		createRelation(templatedTextDesign, "untranslated", RelationType.OneToManyAggregation, "untranslatedInTemplate", stringProducerDesign);
		createRelation(formattedValueDesign, "deduction", RelationType.OneToOneAggregation, "templatedText", deductionSchemeDesign);

		// Shared
		createRelation(application, "sharedTemplates", RelationType.OneToManyAggregation, "application", sharedTemplateDefinitionDesign);
		createRelation(sharedTemplateDesign, "definition", RelationType.ManyToZeroOrOne, "usages", sharedTemplateDefinitionDesign);
		createRelation(sharedTemplateDefinitionDesign, "fragment", RelationType.OneToOneAggregation, "sharedTemplateDefinition", fragmentTemplateDesign);
		
		// Page elements
		RelationDesign content = createRelation(placeTemplateDesign, "content", RelationType.OneToZeroOrOneAggregation, "contentOfPage", fragmentTemplateDesign);
		RelationDesign items = createRelation(compositeTemplateDesign, "children", RelationType.OneToManyAggregation, "childOf", fragmentTemplateDesign);
		createRelation(compositeTemplateDesign, "selections", RelationType.OneToManyAggregation, "compositeTemplate", deductionSchemeDesign);

		RelationDesign fieldAttribute = createRelation(widgetTemplateDesign, "attribute", RelationType.ManyToZeroOrOne, "usedInField", attributeDesign);
		RelationDesign fieldEntity = createRelation(widgetTemplateDesign, "entity", RelationType.ManyToZeroOrOne, "usedInField", entityDesign);
		createRelation(widgetTemplateDesign, "event", RelationType.ManyToZeroOrOne, "triggeredByWidget", eventDesign);
		createRelation(widgetTemplateDesign, "values", RelationType.OneToManyAggregation, "widget", widgetValue);
		createRelation(widgetTemplateDesign, "texts", RelationType.OneToManyAggregation, "widget", widgetText);
		createRelation(widgetTemplateDesign, "childLists", RelationType.OneToManyAggregation, "widget", widgetChildList);
		createRelation(widgetValue, "deduction", RelationType.OneToOneAggregation, "valueForWidget", deductionSchemeDesign);
		createRelation(widgetText, "text", RelationType.OneToOneAggregation, "textForWidget", textDesign);
		createRelation(widgetChildList, "children", RelationType.OneToManyAggregation, "childrenForWidget", fragmentTemplateDesign);
		
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
		EventDesign pageDetails = createEvent("PageDetails", placeTemplateDesign);
//		EventDesign pageFragmentDetails = createEvent("PageFragmentDetails", fieldDesign);
//		EventDesign fieldDetails = createEvent("FieldDetails", fieldDesign);
//		EventDesign addField = createEvent("AddField");
//		EventDesign entityDetails = createEvent("EntityDetails", entityDesign);
//		EventDesign attributeDetails = createEvent("AttributeDetails", attributeDesign);
//		EventDesign attributeDetailsInEntity = createEvent("AttributeDetailsInEntity", entityDesign, attributeDesign);
//		EventDesign exploreInstance = createEvent("ExploreInstance");
		//exploreInstance.setIsCustomized(true);// customization.set("custom.designer.caseexplorer.ExploreInstanceEventCustomization");
		
		// Flows
		FlowDesign mainFlow = createFlow("Main");
//		FlowDesign entityFlow = createFlow("Entity");
//		entityFlow.addToParameters(entityDesign);
//		FlowDesign attributeFlow = createFlow("Attribute");
//		attributeFlow.addToParameters(attributeDesign);
//		FlowDesign flowFlow = createFlow("Flow");
//		flowFlow.addToParameters(flowDesign);
//		FlowDesign pageFlow = createFlow("Page");
//		pageFlow.addToParameters(placeTemplateDesign);
//		FlowDesign addFieldFlow = createFlow("AddField");
//		addFieldFlow.setIsCustomized(true); //setCustomization("custom.designer.AddFieldFlowCustomization");
//		FlowDesign fieldFlow = createFlow("Field");
//		fieldFlow.addToParameters(fieldDesign);
//		FlowDesign flowNodeFlow = createFlow("FlowNode");
//		flowNodeFlow.addToParameters(flowNodeBaseDesign);
//		flowNodeFlow.setIsCustomized(true); //customization.set("custom.designer.FlowNodeFlowCustomization");
//		FlowDesign caseExplorerFlow = createFlow("CaseExplorer");
//		FlowDesign caseExplorerInstanceFlow = createFlow("CaseExplorerInstance");
//		caseExplorerInstanceFlow.setIsCustomized(true); //customization.set("custom.designer.caseexplorer.CaseExplorerInstanceFlowCustomization");
		// Main
		PlaceTemplateDesign welcomePage = createPage(mainFlow, "Welcome");
		FlowSourceDesign mainStart = createSource(mainFlow, null, welcomePage, null);
//		SubFlowDesign entitySubFlow = createSubFlow(mainFlow, entityFlow);
//		SubFlowDesign flowSubFlow = createSubFlow(mainFlow, flowFlow);
//		SubFlowDesign caseExplorerSubFlow = createSubFlow(mainFlow, caseExplorerFlow);
//		createEdge(mainFlow, welcomePage, flowDetails, flowSubFlow, flowDetails);
//		createEdge(mainFlow, welcomePage, entityDetails, entitySubFlow, entityDetails);
//		createEdge(mainFlow, welcomePage, attributeDetailsInEntity, entitySubFlow, attributeDetailsInEntity);
//		createEdge(mainFlow, flowSubFlow, flowDetails, flowSubFlow, flowDetails);//recursive
//		createEdge(mainFlow, flowSubFlow, home, welcomePage, null);
//		createEdge(mainFlow, flowSubFlow, exploreInstance, caseExplorerSubFlow, exploreInstance);
//		createEdge(mainFlow, entitySubFlow, home, welcomePage, null);
//		createEdge(mainFlow, entitySubFlow, exploreInstance, caseExplorerSubFlow, exploreInstance);
//		// Entity
//		PlaceDesign entityPage = createPage(entityFlow, "Entity");
//		FlowSourceDesign entityDetailsSource = createSource(entityFlow, entityDetails, entityPage, null);
//		SubFlowDesign attributeSubFlow = createSubFlow(entityFlow, attributeFlow);
//		FlowSourceDesign attributeDetailsInEntitySource = createSource(entityFlow, attributeDetailsInEntity, attributeSubFlow, attributeDetails);
//		createEdge(entityFlow, entityPage, attributeDetails, attributeSubFlow, attributeDetails);
//		createEdge(entityFlow, attributeSubFlow, entityDetails, entityPage, null);
//		// Attribute
//		PlaceDesign attributePage = createPage(attributeFlow, "Attribute");
//		FlowSourceDesign attributeDetailsSource = createSource(attributeFlow, attributeDetails, attributePage, null);
//		// Flow
//		PlaceDesign flowPage = createPage(flowFlow, "Flow");
//		FlowSourceDesign flowDetailsSource = createSource(flowFlow, flowDetails, flowPage, null);
//		SubFlowDesign flowNodeSubFlow = createSubFlow(flowFlow, flowNodeFlow);
//		SubFlowDesign pageSubFlow = createSubFlow(flowFlow, pageFlow);
//		createEdge(flowFlow, flowPage, flowNodeDetails, flowNodeSubFlow, null);
//		createEdge(flowFlow, flowNodeSubFlow, pageDetails, pageSubFlow, null);
//		createEdge(flowFlow, pageSubFlow, flowDetails, flowPage, null);
//		// Page
//		PlaceDesign pagePage = createPage(pageFlow, "Page");
//		SubFlowDesign fieldSubFlow = createSubFlow(pageFlow, fieldFlow);
//		SubFlowDesign addFieldSubFlow = createSubFlow(pageFlow, addFieldFlow);
//		createSource(pageFlow, pageDetails, pagePage, null);
//		createEdge(pageFlow, pagePage, fieldDetails, fieldSubFlow, fieldDetails);
//		createEdge(pageFlow, pagePage, addField, addFieldSubFlow, addField);
//		createEdge(pageFlow, addFieldSubFlow, fieldDetails, fieldSubFlow, fieldDetails);
//		createEdge(pageFlow, fieldSubFlow, pageDetails, pagePage, null);
//		// Field
//		PlaceDesign fieldPage = createPage(fieldFlow, "Field");
//		createSource(fieldFlow, fieldDetails, fieldPage, null);
//		// CaseExplorer
//		SubFlowDesign caseExplorerInstanceSubFlow = createSubFlow(caseExplorerFlow, caseExplorerInstanceFlow);
//		FlowSourceDesign exploreInstanceSource = createSource(caseExplorerFlow, exploreInstance, caseExplorerInstanceSubFlow, exploreInstance);
//		createEdge(caseExplorerFlow, caseExplorerInstanceSubFlow, exploreInstance, caseExplorerInstanceSubFlow, exploreInstance); // This edge is the reason for this wrapping flow
//		// CaseExplorerDesign
//		PlaceDesign instancePage = createPage(caseExplorerInstanceFlow, "Instance");
//		instancePage.setIsCustomized(true); //customization.set("custom.designer.caseexplorer.InstancePageCustomization");
//		FlowSourceDesign instanceExploreInstanceSource = createSource(caseExplorerInstanceFlow, exploreInstance, instancePage, null);
//		
//		// Shared
//		CompositeFragmentTemplateDesign pageFragmentEditor = createCompositeFragmentTemplate();
//		pageFragmentEditor.setPresentation("pageFragmentEditor");
//		CompositeFragmentTemplateDesign pageFragmentEditorHeader = createCompositeFragmentTemplate();
//		pageFragmentEditorHeader.setPresentation("pageFragmentEditorHeader NoAnimation");
//		SelectDesign fieldSelect = createSelect(createCastDeduction(fragmentTemplateDesign, fieldDesign));
//		SelectDesign fieldAttributeSelect = createSelect(createDeduction(fieldAttribute));
//		addContent(fieldAttributeSelect, createLink(attributeDetails, add(createTemplatedText(), name)));
//		addContent(fieldSelect, fieldAttributeSelect);
//		addContent(pageFragmentEditorHeader, createLink(pageFragmentDetails, add(createTemplatedText(), createDeduction(fragmentTemplateDesign))));
//		addContent(pageFragmentEditorHeader, fieldSelect);
//		CompositeFragmentTemplateDesign previewHolderDesign = new CompositeFragmentTemplateDesign();
//		previewHolderDesign.setPresentation("pageFragmentEditorPreview");
//		CustomPageFragmentDesign previewDesign = new CustomPageFragmentDesign();
//		previewDesign.setImplementationClassName("org.instantlogic.designer.pagefragment.PreviewPageFragmentCustomization");
//		addContent(previewHolderDesign, previewDesign);
//		SelectDesign compositeSelect = createSelect(createCastDeduction(fragmentTemplateDesign, compositeFragmentTemplateDesign));
//		CompositeFragmentTemplateDesign indentedContent = createCompositeFragmentTemplate();
//		indentedContent.setPresentation("pageFragmentEditorContent");
//		SelectDesign itemsSelect = createSelect(createDeduction(items));
//		SelectDesign pageFragmentSelect = createSelect(createDeduction(pageFragment));
//		addContent(itemsSelect, pageFragmentSelect);
//		SharedFragmentDesign recursivePageFragmentEditor = new SharedFragmentDesign();
//		addContent(pageFragmentSelect, recursivePageFragmentEditor); // Careful: recursion
//		addContent(indentedContent, itemsSelect);
//		addContent(compositeSelect, indentedContent);
//
//		addContent(pageFragmentEditor, pageFragmentEditorHeader);
//		addContent(pageFragmentEditor, previewHolderDesign);
//		addContent(pageFragmentEditor, compositeSelect);
//		
//		PageFragmentHolderDesign pageFragmentEditorHolder = new PageFragmentHolderDesign();
//		pageFragmentEditorHolder.setPageFragment(pageFragmentEditor);
//		pageFragmentEditorHolder.setName("PageFragmentEditor");
//		applicationDesign.addToSharedPageFragments(pageFragmentEditorHolder);
//
//		recursivePageFragmentEditor.setPageFragmentHolder(pageFragmentEditorHolder);
//
		// Pages
		// Welcome page
		welcomePage.setContent(createPageWidget("Welcome", 
			createText("paragraph", createConstantText("Welcome to the Designer"))
		));
//		addContent(welcomePage.getContent(), createConstantText("Welcome to the Designer"));
//		CompositeFragmentTemplateDesign columns = createCompositeFragmentTemplate();
//		columns.setPresentation("four-columns");
//		addContent(welcomePage.getContent(), columns);
//		CompositeFragmentTemplateDesign column1 = createCompositeFragmentTemplate();
//		column1.setPresentation("column");
//		addContent(columns, column1);
//		addContent(column1, createConstantText("Entities"));
//		SelectDesign entitiesSelect = createSelect(createDeduction(entities));
//		addContent(entitiesSelect, putInRow(createLink(entityDetails, add(createTemplatedText(), name))));
//		addContent(column1, entitiesSelect);
//
//		CompositeFragmentTemplateDesign column2 = createCompositeFragmentTemplate();
//		column2.setPresentation("column");
//		addContent(columns, column2);
//		addContent(column2, createConstantText("Flows"));
//		SelectDesign flowsSelect = createSelect(createDeduction(flows));
//		addContent(flowsSelect, putInRow(createLink(flowDetails, add(createTemplatedText(), name))));
//		addContent(column2, flowsSelect);
//		// Entity page
//		addContent(entityPage.getContent(), createLink(home, createConstantText("Home")));
//		addContent(entityPage.getContent(), createLink(exploreInstance, createConstantText("Open in case explorer")));
//		createField(entityPage.getContent(), name, false);
//		addContent(entityPage.getContent(), createConstantText("Attributes"));
//		SelectDesign attributesSelect = createSelect(createDeduction(attributes));
//		addContent(attributesSelect, putInRow(createLink(attributeDetails, add(createTemplatedText(), name))));
//		addContent(entityPage.getContent(), attributesSelect);
//		// Flow page
//		addContent(flowPage.getContent(), createLink(home, createConstantText("Home")));
//		addContent(flowPage.getContent(), createLink(exploreInstance, createConstantText("Open in case explorer")));
//		createField(flowPage.getContent(), name, false);
//		addContent(flowPage.getContent(), createConstantText("Nodes"));
//		SelectDesign nodesSelect = createSelect(createDeduction(nodes));
//		addContent(nodesSelect, createLink(flowNodeDetails, add(createTemplatedText(), name)));
//		addContent(flowPage.getContent(), nodesSelect);
//		// Page page
//		addContent(pagePage.getContent(), createLink(home, createConstantText("Home")));
//		addContent(pagePage.getContent(), createLink(flowDetails, createConstantText("Flow")));
//		addContent(pagePage.getContent(), createLink(exploreInstance, createConstantText("Open in case explorer")));
//		createField(pagePage.getContent(), name, false);
//		SelectDesign selectContent = createSelect(createDeduction(content));
//		SharedFragmentDesign editorReference = new SharedFragmentDesign();
//		editorReference.setPageFragmentHolder(pageFragmentEditorHolder);
//		addContent(selectContent, editorReference);
//		addContent(pagePage.getContent(), selectContent);
//		addContent(pagePage.getContent(), createButton(addField, createConstantText("Add field")));
//		// Field page
//		addContent(fieldPage.getContent(), createLink(home, createConstantText("Home")));
//		addContent(fieldPage.getContent(), createLink(flowDetails, createConstantText("Flow")));
//		addContent(fieldPage.getContent(), createLink(pageDetails, createConstantText("Page")));
//		addContent(fieldPage.getContent(), createLink(exploreInstance, createConstantText("Open in case explorer")));
//		createField(fieldPage.getContent(), required, false);
//		createField(fieldPage.getContent(), readOnly, false);
//		SelectDesign attributeSelect = createSelect(createDeduction(fieldAttribute));
//		createField(attributeSelect, name, true);
//		createField(attributeSelect, className, true);
//		addContent(fieldPage.getContent(), attributeSelect);
		
		// Finish up
		
		applicationDesign.addToExposedFlows(mainFlow);
		
		return applicationDesign;
	}

	private static WidgetTemplateDesign createPageWidget(String title, FragmentTemplateDesign... mainContentChildren) {
		WidgetTemplateDesign pageWidget = new WidgetTemplateDesign().setWidgetTypeName("Page");
		WidgetChildList mainContent = new WidgetChildList();
		mainContent.setName("mainContent");
		for (FragmentTemplateDesign child : mainContentChildren) {
			mainContent.addToChildren(child);
		}
		WidgetChildList headerContent = new WidgetChildList();
		headerContent.setName("headerContent");
		WidgetText headerText = new WidgetText().setText(new ConstantTextDesign().setUntranslated(title));
		headerText.setName("text");
		WidgetValue roleValue = new WidgetValue();
		roleValue.setName("role");
		roleValue.setDeduction(createConstantDeduction(String.class, "header"));
		headerContent.addToChildren(new WidgetTemplateDesign().setWidgetTypeName("text").addToValues(roleValue).addToTexts(headerText));
		pageWidget.addToChildLists(headerContent);
		pageWidget.addToChildLists(mainContent);
		return pageWidget;
	}

	private static FragmentTemplateDesign putInRow(FragmentTemplateDesign content) {
		CompositeTemplateDesign result = new CompositeTemplateDesign();
		result.addToChildren(content);
//		result.setPresentation("row");
		return result;
	}
}
