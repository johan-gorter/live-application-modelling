package lbe.designerbootstrap;


import java.util.Date;

import lbe.engine.CasePersister;
import lbe.engine.codegenerator.CodeGenerator;
import lbe.model.DomainEntry;
import lbe.model.pageelement.impl.ConstantText;
import app.carinsurancetest.data.instance.CarinsuranceCaseInstance;
import app.designer.data.instance.ApplicationInstance;
import app.designer.data.instance.AttributeInstance;
import app.designer.data.instance.ButtonInstance;
import app.designer.data.instance.ConstantTextInstance;
import app.designer.data.instance.ContainerInstance;
import app.designer.data.instance.ContainerItemInstance;
import app.designer.data.instance.DomainEntryInstance;
import app.designer.data.instance.EntityInstance;
import app.designer.data.instance.FieldInstance;
import app.designer.data.instance.FlowEdgeInstance;
import app.designer.data.instance.FlowInstance;
import app.designer.data.instance.FlowNodeBaseInstance;
import app.designer.data.instance.FlowSourceInstance;
import app.designer.data.instance.PageElementBaseInstance;
import app.designer.data.instance.PageInstance;
import app.designer.data.instance.RelationInstance;
import app.designer.data.instance.TextInstance;

public class Bootstrapper {

	public enum RelationType {
		OneToZeroOrOne, 
		OneToZeroOrOneAggregation, 
		OneToOneAggregation, 
		OneToMany, 
		OneToManyAggregation, 
		ManyToZeroOrOne, 
		ManyToMany
	}
	
	private static ApplicationInstance applicationInstance;
	
	public static void main(String[] args) {
		createCarinsurance();
//		createDesigner();
	}

	public static void createCarinsurance() {

		// Case
		applicationInstance = new ApplicationInstance();
		applicationInstance.name.set("CarInsuranceTest");
		
		// Data
		EntityInstance carinsuranceCase = createEntity("CarinsuranceCase", null);
		applicationInstance.caseEntity.set(carinsuranceCase);
		EntityInstance driver = createEntity("Driver", null);
		AttributeInstance dateOfBirth = createAttribute(driver, "dateOfBirth", Date.class);
		dateOfBirth.question.set(createConstantText("Date of birth"));
		AttributeInstance carUse = createAttribute(driver, "carUse", String.class);
		carUse.multivalue.set(true);
		carUse.domain.add(createDomainEntry("private", "Private"));
		carUse.domain.add(createDomainEntry("business", "Business"));
		carUse.question.set(createConstantText("How will the car be used?"));
		AttributeInstance disqualified = createAttribute(driver, "disqualified", Boolean.class);
		disqualified.question.set(createConstantText("Have you been disqualified in the last 5 years?"));
		AttributeInstance zipCode = createAttribute(driver, "zipCode", String.class);
		zipCode.question.set(createConstantText("ZIP code"));
		AttributeInstance yearsDriverslicense = createAttribute(driver, "yearsDriverslicense", Integer.class);
		yearsDriverslicense.question.set(createConstantText("How many years have you held your drivers licence?"));
		AttributeInstance yearsInsured = createAttribute(driver, "yearsInsured", Integer.class);
		yearsInsured.question.set(createConstantText("How many years have you been insured?"));
		AttributeInstance mileage = createAttribute(driver, "mileage", String.class);
		mileage.question.set(createConstantText("Annual mileage"));
		mileage.domain.add(createDomainEntry("k1", "< 7.500 km"));	
		mileage.domain.add(createDomainEntry("k2", "7.500 km - 12.000 km"));	
		mileage.domain.add(createDomainEntry("k1", "> 12.000 km"));	
		AttributeInstance noClaimsDiscount = createAttribute(driver, "noClaimsDiscount", Integer.class);
		noClaimsDiscount.question.set(createConstantText("Number of years 'no claims discount' entitlement?"));
		RelationInstance driverRelation = createRelation("driver", carinsuranceCase, RelationType.OneToOneAggregation, driver, "carinsuranceCase");

		// Containers
		ContainerInstance driverContainer = createContainer("Driver");
		driverContainer.relation.set(driverRelation);
		createField(driverContainer, dateOfBirth, true);
		createField(driverContainer, yearsInsured, true);
		createField(driverContainer, yearsDriverslicense, true);
		createField(driverContainer, noClaimsDiscount, true);
		createField(driverContainer, disqualified, true);
		createField(driverContainer, carUse, true);
		createField(driverContainer, mileage, true);
		createField(driverContainer, zipCode, true);
		
		// Flows
		FlowInstance insureFlow = createFlow("Insure");
		FlowSourceInstance insureStartSource = createStartSource(insureFlow, "start");
		PageInstance insureDriverPage = createPage(insureFlow, "Driver");
		insureDriverPage.rootContainer.set(driverContainer);
		createEdge(insureFlow, insureStartSource, insureDriverPage);
		applicationInstance.exposedFlows.add(insureFlow);
		
		// Finish up

		
		String json = CasePersister.gson.toJson(applicationInstance);
		applicationInstance = CasePersister.gson.fromJson(json, ApplicationInstance.class);
		json = CasePersister.gson.toJson(applicationInstance);
		System.out.println(json);
		
//		CodeGenerator.generateApplication(applicationInstance);
	}

	public static void createDesigner() {

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
		createAttribute(concept, "name", String.class);
		
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
		
		// Page elements & Page
		EntityInstance toolbox = createEntity("Toolbox", null);
		EntityInstance pageElementBase = createEntity("PageElementBase", concept);
		EntityInstance container = createEntity("Container", pageElementBase);
		EntityInstance toolboxContainer = createEntity("ToolboxContainer", pageElementBase);
		EntityInstance field = createEntity("Field", pageElementBase);
		createAttribute(field, "required", Boolean.class);
		createAttribute(field, "readOnly", Boolean.class);
		EntityInstance button = createEntity("Button", pageElementBase);
		createAttribute(button, "trigger", String.class);
		EntityInstance containerItem = createEntity("ContainerItem", null);
		AttributeInstance presentationStyles = createAttribute(containerItem, "presentationStyles", String.class);
		presentationStyles.multivalue.set(true);
		
		// Text
		EntityInstance text = createEntity("Text", pageElementBase);
		EntityInstance constantText = createEntity("ConstantText", text);
		EntityInstance toolboxText = createEntity("ToolboxText", text);
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
		createRelation("entities", application, RelationType.OneToManyAggregation, entity, "application");
		createRelation("caseEntity", application, RelationType.OneToZeroOrOne, entity, "caseEntityInApplication");
		createRelation("flows", application, RelationType.OneToManyAggregation, flow, "application");
		createRelation("exposedFlows", application, RelationType.OneToMany, flow, "exposedFlowInApplication");

		// Data
		createRelation("extendsFrom", entity, RelationType.ManyToZeroOrOne, entity, "extensions");
		createRelation("attributes", entity, RelationType.OneToManyAggregation, attribute, "entity");
		createRelation("relations", entity, RelationType.OneToManyAggregation, relation, "entity");
		createRelation("to", relation, RelationType.ManyToZeroOrOne, entity, "reverseRelations");
		createRelation("question", attribute, RelationType.OneToZeroOrOneAggregation, text, "questionOnAttribute");
		createRelation("explanation", attribute, RelationType.OneToZeroOrOneAggregation, text, "explanationOnAttribute");
		createRelation("domain", attribute, RelationType.OneToManyAggregation, domainEntry, "attribute");
		createRelation("display", domainEntry, RelationType.OneToZeroOrOneAggregation, text, "displayOnDomainEntry");

		// Page elements
		createRelation("pageToolbox", application, RelationType.OneToOneAggregation, toolbox, "application");
		createRelation("containers", toolbox, RelationType.OneToManyAggregation, container, "toolbox");
		createRelation("texts", toolbox, RelationType.OneToManyAggregation, text, "toolbox");
		createRelation("rootContainer", page, RelationType.OneToOneAggregation, container, "rootContainerInPage");
		createRelation("items", container, RelationType.OneToManyAggregation, containerItem, "container");
		createRelation("element", containerItem, RelationType.OneToZeroOrOneAggregation, pageElementBase, "containerItem");
		createRelation("attribute", field, RelationType.ManyToZeroOrOne, attribute, "fields");
		createRelation("relation", container, RelationType.ManyToZeroOrOne, relation, "relationInContainers");
		createRelation("display", container, RelationType.OneToZeroOrOneAggregation, text, "displayOnContainer");
		createRelation("caption", button, RelationType.OneToOneAggregation, text, "captionOnButton");
		
		// Flow
		createRelation("sources", flow, RelationType.OneToManyAggregation, flowSource, "flow");
		createRelation("sinks", flow, RelationType.OneToManyAggregation, flowSink, "flow");
		createRelation("nodes", flow, RelationType.OneToManyAggregation, flowNodeBase, "flow");
		createRelation("edges", flow, RelationType.OneToManyAggregation, flowEdge, "flow");
		createRelation("from", flowEdge, RelationType.ManyToZeroOrOne, flowNodeBase, "outgoingEdges");
		createRelation("to", flowEdge, RelationType.ManyToZeroOrOne, flowNodeBase, "incomingEdges");
		
		// Toolbox
		
		// Flows
		
		FlowInstance mainFlow = createFlow("Main");
		FlowSourceInstance mainStart = createStartSource(mainFlow, "start");
		PageInstance welcomePage = createPage(mainFlow, "Welcome");
		PageInstance pageToolboxPage = createPage(mainFlow, "PageToolbox");
		PageInstance containerPage = createPage(mainFlow, "Container");
		createEdge(mainFlow, mainStart, welcomePage);
		createEdge(mainFlow, welcomePage, pageToolboxPage);
		createEdge(mainFlow, pageToolboxPage, containerPage);
		
		ConstantTextInstance welcomeText = createConstantText("Welcome to the designer");
		createContainerItem(welcomePage.rootContainer.get(), welcomeText);
		ButtonInstance pageToolboxButton = createButton("toolbox", createConstantText("Toolbox")); 
		createContainerItem(welcomePage.rootContainer.get(), pageToolboxButton);
		
		// Finish up
		
		applicationInstance.exposedFlows.add(mainFlow);

//		System.out.println(CasePersister.gson.toJson(applicationInstance));
		
		CodeGenerator.generateApplication(applicationInstance);
	}

	private static ButtonInstance createButton(String trigger, TextInstance caption) {
		ButtonInstance result = new ButtonInstance(applicationInstance);
		result.trigger.set(trigger);
		result.name.set(trigger);
		result.caption.set(caption);
		return result;
	}

	private static void createContainerItem(ContainerInstance containerInstance, PageElementBaseInstance element) {
		ContainerItemInstance item = new ContainerItemInstance(applicationInstance);
		item.element.set(element);
		containerInstance.items.add(item);
	}

	private static EntityInstance createEntity(String name, EntityInstance extendsFrom) {
		EntityInstance result = new EntityInstance(applicationInstance);
		result.name.set(name);
		result.extendsFrom.set(extendsFrom);
		applicationInstance.entities.add(result);
		return result;
	}

	private static AttributeInstance createAttribute(EntityInstance entity, String name, Class<?> className) {
		AttributeInstance attribute = new AttributeInstance(applicationInstance);
		attribute.name.set(name);
		attribute.className.set(className.getName());
		entity.attributes.add(attribute);
		return attribute;
	}

	private static RelationInstance createRelation(String name, EntityInstance from, RelationType relationType, EntityInstance to, String reverseName) {
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

	private static DomainEntryInstance createDomainEntry(String name, String untranslatedConstantText) {
		DomainEntryInstance entry = new DomainEntryInstance(applicationInstance);
		entry.name.set(name);
		entry.display.set(createConstantText(untranslatedConstantText));
		return entry;
	}
	
	private static ConstantTextInstance createConstantText(String untranslated) {
		ConstantTextInstance result = new ConstantTextInstance(applicationInstance);
		result.untranslated.set(untranslated);
		return result;
	}

	private static ContainerInstance createContainer(String name) {
		ContainerInstance Container = new ContainerInstance(applicationInstance);
		Container.name.set(name);
		applicationInstance.pageToolbox.get().containers.add(Container);
		return Container;
	}

	private static FieldInstance createField(ContainerInstance container, AttributeInstance attribute, boolean required) {
		FieldInstance field = new FieldInstance(applicationInstance);
		field.attribute.set(attribute);
		field.required.set(true);
		ContainerItemInstance item = new ContainerItemInstance(applicationInstance);
		container.items.add(item);
		item.element.set(field);
		return field;
	}

	private static FlowInstance createFlow(String name) {
		FlowInstance flow = new FlowInstance(applicationInstance);
		flow.name.set(name);
		applicationInstance.flows.add(flow);
		return flow;
	}

	private static void createEdge(FlowInstance flow, FlowNodeBaseInstance from, FlowNodeBaseInstance to) {
		FlowEdgeInstance edge = new FlowEdgeInstance(applicationInstance);
		edge.from.set(from);
		edge.to.set(to);
		flow.edges.add(edge);
	}

	private static PageInstance createPage(FlowInstance flow, String name) {
		PageInstance page = new PageInstance(applicationInstance);
		page.name.set(name);
		flow.nodes.add(page);
		return page;
	}

	private static FlowSourceInstance createStartSource(FlowInstance flow, String name) {
		FlowSourceInstance insureStartSource = new FlowSourceInstance(applicationInstance);
		insureStartSource.name.set(name);
		flow.sources.add(insureStartSource);
		return insureStartSource;
	}
}
