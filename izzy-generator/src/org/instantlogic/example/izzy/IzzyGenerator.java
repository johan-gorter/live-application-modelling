package org.instantlogic.example.izzy;

import java.io.File;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.Design;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.EntityDesign.RelationType;
import org.instantlogic.designer.EventDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FlowEdgeDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.SelectionDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.designer.entity.DataCategoryDesignEntity;

public class IzzyGenerator extends Design {
	private static ApplicationDesign izzy;

	private static EntityDesign project;
	private static EntityDesign user;
	private static EntityDesign issue;
	private static EntityDesign comment;
	
	private static RelationDesign projectIssues;
	private static AttributeDesign issueHeadline;
	private static AttributeDesign issueNumber;
	
	private static EventDesign createIssueEvent;
	private static EventDesign issueDetailsEvent;

	private static PlaceTemplateDesign dashboardPlaceTemplate;
	private static PlaceTemplateDesign issueDetailsPlaceTemplate;

	private static FlowDesign mainFlow;
	private static FlowDesign issueFlow;
	private static FlowDesign createIssueFlow;
	private static AttributeDesign issueDescription;

	public static void main(String[] args) { 
		izzy = new ApplicationDesign();
		project = new EntityDesign("project").setApplication(izzy);
		project.addAttribute("last issue number", Integer.class)
			.setDefault(new DeductionSchemeDesign().deduceConstant(Integer.class, 0).getScheme());
		user = new EntityDesign("user").setApplication(izzy);
		user.addAttribute("username", DataCategoryDesignEntity.INSTANCE.text);
		issue = new EntityDesign("issue").setApplication(izzy);
		issueNumber = issue.addAttribute("number", Integer.class);
		issueHeadline = issue.addAttribute("headline", DataCategoryDesignEntity.INSTANCE.text);
		issueDescription = issue.addAttribute("description", DataCategoryDesignEntity.INSTANCE.text);
		issueDescription.getDataType().setMultiLine(true).setFormatted(true);
		comment = new EntityDesign("comment").setApplication(izzy);
		comment.addAttribute("text", DataCategoryDesignEntity.INSTANCE.text);
		comment.getDataType().setMultiLine(true).setFormatted(true);
		
		// Relations
		project.addRelation("users", RelationType.OneToManyAggregation, user).setReverseName("project");
		projectIssues = project.addRelation("issues", RelationType.OneToManyAggregation, issue).setReverseName("project");
		issue.addRelation("reporter", RelationType.ManyToZeroOrOne, user).setReverseName("reported issues");
		issue.addRelation("assignee", RelationType.ManyToZeroOrOne, user).setReverseName("assigned issues");
		issue.addRelation("comments", RelationType.OneToManyAggregation, comment).setReverseName("issue");
		comment.addRelation("by", RelationType.OneToZeroOrOne, user).setReverseName("comments");
		
		izzy.setCaseEntity(project);
		izzy.setName("izzy");
		izzy.setRootPackageName("org.instantlogic.example.izzy");
		izzy.getCaseEntity().registerApplication(izzy);
		
		createIssueEvent = new EventDesign("create issue").setApplication(izzy);
		issueDetailsEvent = new EventDesign("issue details").setApplication(izzy).addToParameters(issue);
		
		mainFlow = new FlowDesign("main").setApplication(izzy);
		issueFlow = new FlowDesign("issue").setApplication(izzy).addToParameters(issue);
		createIssueFlow = new FlowDesign("create issue").setApplication(izzy);
		createIssueFlow.setIsCustomized(true);

		createDashboardPlaceTemplate();
		createIssueDetailsPlaceTemplate();
		
		initMainFlow();
		initIssueFlow();

		// Application
		izzy.setSourcePath("../izzy/generated");
		izzy.setMainFlow(mainFlow);

		// Finished with the design, what to do next
		
		// Generate java code
		GeneratedClassModels classModelUpdates = izzy.getApplicationGenerator().getClassModelUpdates();
		ApplicationJavacodeGenerator.generate(classModelUpdates, new File(izzy.getSourcePath()));
		
		// Display the design in json format
		//OutputStreamWriter writer = new OutputStreamWriter(System.out);
		//new CasePersister().save(applicationInstance, writer);
		//writer.flush();
	}
	
	// Flows

	private static void initIssueFlow() {
		new FlowEdgeDesign()
			.setOwner(issueFlow)
			.setEvent(issueDetailsEvent)
			.setEndNode(issueDetailsPlaceTemplate);
	}

	private static void initMainFlow() {
		SubFlowDesign mainFlowIssueSubFlow = mainFlow.addSubFlow(issueFlow);
		SubFlowDesign mainFlowCreateIssueSubFlow = mainFlow.addSubFlow(createIssueFlow);
		new FlowEdgeDesign()
			.setOwner(mainFlow)
			.setStartNode(dashboardPlaceTemplate)
			.setEvent(issueDetailsEvent)
			.setEndNode(mainFlowIssueSubFlow);
		new FlowEdgeDesign()
			.setOwner(mainFlow)
			.setStartNode(dashboardPlaceTemplate)
			.setEvent(createIssueEvent)
			.setEndNode(mainFlowCreateIssueSubFlow);
	}
	
	// Place templates

	private static void createIssueDetailsPlaceTemplate() {
		DeductionSchemeDesign number, headline;
		FragmentTemplateDesign headlineInput;
		issueDetailsPlaceTemplate = new PlaceTemplateDesign("issueDetails")
			.setOwner(issueFlow)
			.setContent(new FragmentTemplateDesign("Page")
				.setChildren("mainContent", 
					new FragmentTemplateDesign("Paragraph")
						.setText("text", new TextTemplateDesign().addToUntranslated(
							new StringTemplateDesign().setDeduction(number = new DeductionSchemeDesign()))),
					new FragmentTemplateDesign("Paragraph")
						.setText("text", new TextTemplateDesign().addToUntranslated(
							new StringTemplateDesign().setDeduction(headline = new DeductionSchemeDesign()))),
					headlineInput = new FragmentTemplateDesign("Input")
				)
			);
		number.deduceAttribute(issueNumber);
		headline.deduceAttribute(issueHeadline);
		headlineInput.setEntity(issue).setAttribute(issueHeadline);
	}

	private static void createDashboardPlaceTemplate() {
		DeductionSchemeDesign issues, number, headline;
		FragmentTemplateDesign detailsLink, createButton;
		dashboardPlaceTemplate = new PlaceTemplateDesign("dashboard")
			.setOwner(mainFlow)
			.setContent(
				new FragmentTemplateDesign("Page")
					.setChildren("mainContent",
						new FragmentTemplateDesign("Table")
							.setChildren("columns", 
								new FragmentTemplateDesign("Column"),
								new FragmentTemplateDesign("Column")
									.setText("header", createConstantText("Headline"))
							)
							.setChildren("rows",
								new SelectionDesign().setSelection(issues = new DeductionSchemeDesign()).addToChildren(
									new FragmentTemplateDesign("Row")
										.setChildren("cells",
											detailsLink = new FragmentTemplateDesign("Link")
												.setChildren("content", 
													new FragmentTemplateDesign("Cell")
														.setChildren("content",
															new FragmentTemplateDesign("Paragraph")
																.setText("text", new TextTemplateDesign().addToUntranslated(
																		new StringTemplateDesign().setDeduction(number = new DeductionSchemeDesign())))
														),
													new FragmentTemplateDesign("Cell")
														.setChildren("content",
															new FragmentTemplateDesign("Paragraph")
																.setText("text", new TextTemplateDesign().addToUntranslated(
																		new StringTemplateDesign().setDeduction(headline = new DeductionSchemeDesign())))
														)
												)
										)
								)
							),
						createButton = new FragmentTemplateDesign("Button")
							.setText("text", new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setConstantText("Create issue")))
					)
			);
		issues.deduceAttribute(projectIssues);
		number.deduceAttribute(issueNumber);
		headline.deduceAttribute(issueHeadline);
		detailsLink.setEvent(issueDetailsEvent);
		createButton.setEvent(createIssueEvent);
	}
}
