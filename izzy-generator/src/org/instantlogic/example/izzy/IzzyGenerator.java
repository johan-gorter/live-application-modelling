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

	public static void main(String[] args) {
		ApplicationDesign izzy = new ApplicationDesign();
		// Entities/attributes
		EntityDesign project = new EntityDesign("project");
		EntityDesign user = new EntityDesign("user");
		user.addAttribute("username", String.class);
		EntityDesign issue = new EntityDesign("issue");
		AttributeDesign issueHeadline = issue.addAttribute("headline", String.class);
		issue.addAttribute("description", String.class);
		EntityDesign comment = new EntityDesign("comment");
		comment.addAttribute("text", String.class);
		
		// Relations
		project.addRelation("users", RelationType.OneToManyAggregation, user).setReverseName("project");
		RelationDesign projectIssues = project.addRelation("issues", RelationType.OneToManyAggregation, issue).setReverseName("project");
		issue.addRelation("reporter", RelationType.ManyToZeroOrOne, user).setReverseName("reported issues");
		issue.addRelation("assignee", RelationType.ManyToZeroOrOne, user).setReverseName("assigned issues");
		issue.addRelation("comments", RelationType.OneToManyAggregation, comment).setReverseName("issue");
		comment.addRelation("by", RelationType.OneToZeroOrOne, user).setReverseName("comments");
		
		izzy.setCaseEntity(project);
		izzy.setName("izzy");
		izzy.setRootPackageName("org.instantlogic.example.izzy");
		izzy.getCaseEntity().registerApplication(izzy);
		
		// Events
		EventDesign createIssueEvent = new EventDesign("create issue");
		EventDesign issueDetailsEvent = new EventDesign("issue details").addToParameters(issue);
		
		// Places
		PlaceTemplateDesign dashboardPlaceTemplate = new PlaceTemplateDesign("dashboard")
			.setContent(
				new FragmentTemplateDesign("Page")
					.setChildren("mainContent",
						new FragmentTemplateDesign("Table")
							.setChildren("columns", 
								new FragmentTemplateDesign("Column")
									.setText("header", createConstantText("Headline"))
							)
							.setChildren("rows",
								new SelectionDesign().setSelection(createDeduction(projectIssues)).addToChildren(
									new FragmentTemplateDesign("Row")
										.setChildren("cells",
											new FragmentTemplateDesign("Cell")
												.setChildren("content",
													new FragmentTemplateDesign("Link")
														.setText("text", new TemplatedTextDesign().addToUntranslated(new FormattedValueDesign().setDeduction(createDeduction(issueHeadline))))
														.setEvent(issueDetailsEvent)
												)
										)
								)
							),
						new FragmentTemplateDesign("Button")
							.setText("text", new ConstantTextDesign().setUntranslated("Create issue"))
							.setEvent(createIssueEvent)
					)
			);
		PlaceTemplateDesign issueDetailsPlaceTemplate = new PlaceTemplateDesign("issueDetails")
			.setContent(new FragmentTemplateDesign("Page")
				.setChildren(
					"mainContent", 
					new FragmentTemplateDesign("Paragraph")
						.setText("text", new TemplatedTextDesign().addToUntranslated(new FormattedValueDesign().setDeduction(createDeduction(issueHeadline)))))
			);
		
		// Flows
		FlowDesign mainFlow = new FlowDesign("main");
		FlowDesign issueFlow = new FlowDesign("issue")
			.addToParameters(issue);
		FlowDesign createIssueFlow = new FlowDesign("create issue");
		createIssueFlow.setIsCustomized(true);

		// Main flow
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
		
		// Issue flow
		issueFlow.addToNodes(issueDetailsPlaceTemplate);
		issueFlow.addToEdges(new FlowEdgeDesign()
			.setStartEvent(issueDetailsEvent)
			.setEndNode(issueDetailsPlaceTemplate));

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
}
