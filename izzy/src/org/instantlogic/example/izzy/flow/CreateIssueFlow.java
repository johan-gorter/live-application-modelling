package org.instantlogic.example.izzy.flow;

import org.instantlogic.example.izzy.Issue;
import org.instantlogic.example.izzy.Project;
import org.instantlogic.example.izzy.entity.ProjectEntity;
import org.instantlogic.example.izzy.event.IssueDetailsEvent;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class CreateIssueFlow extends AbstractCreateIssueFlow {
	
	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		Issue issue = new Issue();
		Project project = context.getSelectedInstance(ProjectEntity.INSTANCE);
		project.addToIssues(issue);
		issue.setHeadline("Headline-"+issue.getMetadata().getInstanceId());
		return new FlowEventOccurrence(IssueDetailsEvent.INSTANCE, issue);
	}
}
