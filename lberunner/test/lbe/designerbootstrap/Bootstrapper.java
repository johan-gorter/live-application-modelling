package lbe.designerbootstrap;


import java.util.Date;

import lbe.engine.CasePersister;
import lbe.engine.codegenerator.CodeGenerator;
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
//		createCarinsurance();
		createDesigner();
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
		RelationInstance driverRelation = createRelation(carinsuranceCase, "driver", RelationType.OneToOneAggregation, "carinsuranceCase", driver);

		// PageFragments
		SelectInstance selectDriver = createSelect(driverRelation);
		HeaderInstance driverHeader = createHeader(createConstantText("Driver"));
		addContent(selectDriver, driverHeader);
		CompositePageFragmentInstance driverFields = createCompositePageFragment();
		addContent(driverHeader, driverFields);
		createField(driverFields, dateOfBirth, true);
		createField(driverFields, yearsInsured, true);
		createField(driverFields, yearsDriverslicense, true);
		createField(driverFields, noClaimsDiscount, true);
		createField(driverFields, disqualified, true);
		createField(driverFields, carUse, true);
		createField(driverFields, mileage, true);
		createField(driverFields, zipCode, true);
		
		// Flows
		FlowInstance insureFlow = createFlow("Insure");
		FlowSourceInstance insureStartSource = createStartSource(insureFlow, "start");
		PageInstance insureDriverPage = createPage(insureFlow, "Driver");
		insureDriverPage.content.set(driverFields);
		createEdge(insureFlow, insureStartSource, insureDriverPage);
		applicationInstance.exposedFlows.add(insureFlow);
		
		// Finish up
		
		String json = CasePersister.gson.toJson(applicationInstance);
		applicationInstance = CasePersister.gson.fromJson(json, ApplicationInstance.class);
		json = CasePersister.gson.toJson(applicationInstance);
		System.out.println(json);
		
		CodeGenerator.generateApplication(applicationInstance);
	}

	private static PageCompositionInstance addContent(CompositePageFragmentInstance compositePageFragment, PageFragmentInstance item) {
		PageCompositionInstance result = new PageCompositionInstance(applicationInstance);
		result.pageFragment.set(item);
		compositePageFragment.items.add(result);
		return result;
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
		createRelation(application, "flows", RelationType.OneToManyAggregation, "application", flow);
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
		
		// Toolbox
		
		// Flows
		
		FlowInstance mainFlow = createFlow("Main");
		FlowSourceInstance mainStart = createStartSource(mainFlow, "start");
		PageInstance welcomePage = createPage(mainFlow, "Welcome");
		PageInstance sharedPage = createPage(mainFlow, "Shared");
		PageInstance containerPage = createPage(mainFlow, "Container");
		createEdge(mainFlow, mainStart, welcomePage);
		createEdge(mainFlow, welcomePage, sharedPage);
		createEdge(mainFlow, sharedPage, containerPage);

		CompositePageFragmentInstance welcomePageContent = new CompositePageFragmentInstance(applicationInstance);
		welcomePage.content.set(welcomePageContent);
		ConstantTextInstance welcomeText = createConstantText("Welcome to the designer");
		createContainerItem(welcomePageContent, welcomeText);
		ButtonInstance sharedButton = createButton("shared", createConstantText("Shared items")); 
		createContainerItem(welcomePageContent, sharedButton);
		
		// Finish up
		
		applicationInstance.exposedFlows.add(mainFlow);

//		System.out.println(CasePersister.gson.toJson(applicationInstance));
		
		CodeGenerator.generateApplication(applicationInstance);
	}

	private static ButtonInstance createButton(String trigger, TextInstance caption) {
		ButtonInstance result = new ButtonInstance(applicationInstance);
		result.trigger.set(trigger);
		result.caption.set(caption);
		return result;
	}

	private static void createContainerItem(CompositePageFragmentInstance containerInstance, PageFragmentInstance element) {
		PageCompositionInstance item = new PageCompositionInstance(applicationInstance);
		item.pageFragment.set(element);
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

	private static RelationInstance createRelation(EntityInstance from, String name, RelationType relationType, String reverseName, EntityInstance to) {
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

	private static CompositePageFragmentInstance createCompositePageFragment() {
		CompositePageFragmentInstance container = new CompositePageFragmentInstance(applicationInstance);
		return container;
	}

	private static SelectInstance createSelect(RelationInstance relation) {
		SelectInstance select = new SelectInstance(applicationInstance);
		select.relation.set(relation);
		return select;
	}

	private static HeaderInstance createHeader(TextInstance text) {
		HeaderInstance header = new HeaderInstance(applicationInstance);
		header.text.set(text);
		return header;
	}

	private static FieldInstance createField(CompositePageFragmentInstance container, AttributeInstance attribute, boolean required) {
		FieldInstance field = new FieldInstance(applicationInstance);
		field.attribute.set(attribute);
		field.required.set(true);
		PageCompositionInstance item = new PageCompositionInstance(applicationInstance);
		container.items.add(item);
		item.pageFragment.set(field);
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
