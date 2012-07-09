package org.instantlogic.example.izzy;


public class issue extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.example.izzy.entity.issueEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<issue, java.lang.String> description
		= createAttributeValue(org.instantlogic.example.izzy.entity.issueEntity.description);
	
	public java.lang.String getDescription() {
		return description.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<issue, java.lang.String> getDescriptionAttributeValue() {
		return description;
	}

	public issue setDescription(java.lang.String newValue) {
		description.setValue(newValue);
		return (issue)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<issue, java.lang.String> headline
		= createAttributeValue(org.instantlogic.example.izzy.entity.issueEntity.headline);
	
	public java.lang.String getHeadline() {
		return headline.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<issue, java.lang.String> getHeadlineAttributeValue() {
		return headline;
	}

	public issue setHeadline(java.lang.String newValue) {
		headline.setValue(newValue);
		return (issue)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<issue, user> assignee
		= createRelationValue(org.instantlogic.example.izzy.entity.issueEntity.assignee);
		
	public org.instantlogic.fabric.value.RelationValue<issue, user> getAssigneeRelationValue() {
		return assignee;
	}

	public org.instantlogic.example.izzy.user getAssignee() {
		return assignee.getValue();
	}
	
	public issue setAssignee(org.instantlogic.example.izzy.user newValue) {
		assignee.setValue(newValue);
		return (issue)this;
	}

	
	private final org.instantlogic.fabric.value.RelationValues<issue, comment> comments
		= createRelationValues(org.instantlogic.example.izzy.entity.issueEntity.comments);
		
	public org.instantlogic.fabric.value.RelationValues<issue, comment> getCommentsRelationValue() {
		return comments;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.comment> getComments() {
		return comments.getValue();
	}
	
	public issue addToComments(comment item) {
		comments.addValue(item);
		return (issue)this;
	}
	
	public issue addToComments(comment item, int index) {
		comments.insertValue(item, index);
		return (issue)this;
	}
	
	public issue removeFromComments(comment item) {
		comments.removeValue(item);
		return (issue)this;
	}
	
	public issue removeFromComments(int index) {
		comments.removeValue(index);
		return (issue)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValue<issue, user> reporter
		= createRelationValue(org.instantlogic.example.izzy.entity.issueEntity.reporter);
		
	public org.instantlogic.fabric.value.RelationValue<issue, user> getReporterRelationValue() {
		return reporter;
	}

	public org.instantlogic.example.izzy.user getReporter() {
		return reporter.getValue();
	}
	
	public issue setReporter(org.instantlogic.example.izzy.user newValue) {
		reporter.setValue(newValue);
		return (issue)this;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<issue, project> project
		= createReverseRelationValue(org.instantlogic.example.izzy.entity.issueEntity.project);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<issue, project> getProjectRelationValue() {
		return project;
	}

	public org.instantlogic.example.izzy.project getProject() {
		return project.getValue();
	}


}
