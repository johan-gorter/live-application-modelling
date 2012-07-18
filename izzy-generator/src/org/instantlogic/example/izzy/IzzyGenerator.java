package org.instantlogic.example.izzy;

import java.io.File;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.ConstantTextDesign;
import org.instantlogic.designer.Design;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.EntityDesign.RelationType;
import org.instantlogic.designer.EventDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FlowEdgeDesign;
import org.instantlogic.designer.FormattedValueDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.SelectionDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.TemplatedTextDesign;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;

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
		project = new EntityDesign("project");
		project.addAttribute("last issue number", Integer.class).setDefault(createConstantDeduction(Integer.class, 0));
		user = new EntityDesign("user");
		user.addAttribute("username", String.class);
		issue = new EntityDesign("issue");
		issueNumber = issue.addAttribute("number", Integer.class);
		issueHeadline = issue.addAttribute("headline", String.class);
		issueDescription = issue.addAttribute("description", String.class);
		comment = new EntityDesign("comment");
		comment.addAttribute("text", String.class);
		
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
		
		createIssueEvent = new EventDesign("create issue");
		issueDetailsEvent = new EventDesign("issue details").addToParameters(issue);
		
		createDashboardPlaceTemplate();
		createIssueDetailsPlaceTemplate();
		
		mainFlow = new FlowDesign("main");
		issueFlow = new FlowDesign("issue").addToParameters(issue);
		createIssueFlow = new FlowDesign("create issue");
		createIssueFlow.setIsCustomized(true);

		initMainFlow();
		initIssueFlow();

		// Application
		izzy.setSourcePath("../izzy/generated");
		izzy
			.addToEvents(createIssueEvent)
			.addToEvents(issueDetailsEvent);
		izzy.setMainFlow(mainFlow);
		izzy.getMainFlow().registerApplication(izzy);

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
		issueFlow.addToNodes(issueDetailsPlaceTemplate);
		issueFlow.addToEdges(new FlowEdgeDesign()
			.setStartEvent(issueDetailsEvent)
			.setEndNode(issueDetailsPlaceTemplate));
	}

	private static void initMainFlow() {
		SubFlowDesign mainFlowIssueSubFlow = mainFlow.addSubFlow(issueFlow);
		SubFlowDesign mainFlowCreateIssueSubFlow = mainFlow.addSubFlow(createIssueFlow);
		mainFlow.addToNodes(dashboardPlaceTemplate);
		mainFlow.addToEdges(new FlowEdgeDesign()
			.setStartNode(dashboardPlaceTemplate)
			.setStartEvent(issueDetailsEvent)
			.setEndNode(mainFlowIssueSubFlow)
		);
		mainFlow.addToEdges(new FlowEdgeDesign()
			.setStartNode(dashboardPlaceTemplate)
			.setStartEvent(createIssueEvent)
			.setEndNode(mainFlowCreateIssueSubFlow)
		);
	}
	
	// Place templates

	private static void createIssueDetailsPlaceTemplate() {
		issueDetailsPlaceTemplate = new PlaceTemplateDesign("issueDetails")
			.setContent(new FragmentTemplateDesign("Page")
				.setChildren("mainContent", 
					new FragmentTemplateDesign("Paragraph")
						.setText("text", new TemplatedTextDesign().addToUntranslated(new FormattedValueDesign().setDeduction(createDeduction(issueNumber)))),
					new FragmentTemplateDesign("Paragraph")
						.setText("text", new TemplatedTextDesign().addToUntranslated(new FormattedValueDesign().setDeduction(createDeduction(issueHeadline))))
				)
			);
	}

	private static void createDashboardPlaceTemplate() {
		dashboardPlaceTemplate = new PlaceTemplateDesign("dashboard")
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
								new SelectionDesign().setSelection(createDeduction(projectIssues)).addToChildren(
									new FragmentTemplateDesign("Row")
										.setChildren("cells",
											new FragmentTemplateDesign("Link")
												.setEvent(issueDetailsEvent)
												.setChildren("content", 
													new FragmentTemplateDesign("Cell")
														.setChildren("content",
															new FragmentTemplateDesign("Paragraph")
																.setText("text", new TemplatedTextDesign().addToUntranslated(new FormattedValueDesign().setDeduction(createDeduction(issueNumber))))
														),
													new FragmentTemplateDesign("Cell")
														.setChildren("content",
															new FragmentTemplateDesign("Paragraph")
																.setText("text", new TemplatedTextDesign().addToUntranslated(new FormattedValueDesign().setDeduction(createDeduction(issueHeadline))))
														)
												)
										)
								)
							),
						new FragmentTemplateDesign("Button")
							.setText("text", new ConstantTextDesign().setUntranslated("Create issue"))
							.setEvent(createIssueEvent)
					)
			);
	}
}
