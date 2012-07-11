package org.instantlogic.example.izzy;

import java.io.File;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.EntityDesign.RelationType;
import org.instantlogic.designer.ElementDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FlowEdgeDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;

public class IzzyGenerator {

	public static void main(String[] args) {
		// Entities/attributes
		EntityDesign project = new EntityDesign("project");
		EntityDesign user = new EntityDesign("user");
		user.addAttribute("username", String.class);
		EntityDesign issue = new EntityDesign("issue");
		issue.addAttribute("headline", String.class);
		issue.addAttribute("description", String.class);
		EntityDesign comment = new EntityDesign("comment");
		comment.addAttribute("text", String.class);
		
		// Relations
		project.addRelation("users", RelationType.OneToManyAggregation, user).setReverseName("project");
		project.addRelation("issues", RelationType.OneToManyAggregation, issue).setReverseName("project");
		issue.addRelation("reporter", RelationType.ManyToZeroOrOne, user).setReverseName("reported issues");
		issue.addRelation("assignee", RelationType.ManyToZeroOrOne, user).setReverseName("assigned issues");
		issue.addRelation("comments", RelationType.OneToManyAggregation, comment).setReverseName("issue");
		comment.addRelation("by", RelationType.OneToZeroOrOne, user).setReverseName("comments");
		
		// Places
		PlaceTemplateDesign dashboardPlaceTemplate = new PlaceTemplateDesign("dashboard");
		dashboardPlaceTemplate.setContent(
			new FragmentTemplateDesign("Page")
				.setChildren(
					"mainContent",
					new FragmentTemplateDesign("Button")
				)
		);
		// Flows
		FlowDesign mainFlow = new FlowDesign("main");
		FlowDesign issueFlow = new FlowDesign("issue");

		// Main flow
		SubFlowDesign mainFlowIssueSubFlow = mainFlow.addSubFlow(issueFlow);
		mainFlow.addToNodes(dashboardPlaceTemplate);
		
		mainFlow.addToEdges(new FlowEdgeDesign()
			.setStartNode(dashboardPlaceTemplate)
//			.setStartEvent(EntityDetailsEventGenerator.EVENT)
			.setEndNode(mainFlowIssueSubFlow));

		// Application
		ApplicationDesign izzy = new ApplicationDesign();
		izzy.setCaseEntity(project);
		izzy.setName("izzy");
		izzy.setRootPackageName("org.instantlogic.example.izzy");
		izzy.setSourcePath("../izzy/generated");
		izzy.setMainFlow(mainFlow);
		izzy.getMainFlow().registerApplication(izzy);
		izzy.getCaseEntity().registerApplication(izzy);

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
