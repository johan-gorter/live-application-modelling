package org.instantlogic.example.izzy;


public class User extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.example.izzy.entity.UserEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<User, java.lang.String> username
		= createAttributeValue(org.instantlogic.example.izzy.entity.UserEntity.username);
	
	public java.lang.String getUsername() {
		return username.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<User, java.lang.String> getUsernameAttributeValue() {
		return username;
	}

	public User setUsername(java.lang.String newValue) {
		username.setValue(newValue);
		return (User)this;
	}
	
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<User, Issue> assignedIssues
		= createReverseRelationValues(org.instantlogic.example.izzy.entity.UserEntity.assignedIssues);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<User, Issue> getAssignedIssuesRelationValue() {
		return assignedIssues;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue> getAssignedIssues() {
		return assignedIssues.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<User, Comment> comments
		= createReverseRelationValue(org.instantlogic.example.izzy.entity.UserEntity.comments);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<User, Comment> getCommentsRelationValue() {
		return comments;
	}

	public org.instantlogic.example.izzy.Comment getComments() {
		return comments.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<User, Project> project
		= createReverseRelationValue(org.instantlogic.example.izzy.entity.UserEntity.project);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<User, Project> getProjectRelationValue() {
		return project;
	}

	public org.instantlogic.example.izzy.Project getProject() {
		return project.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<User, Issue> reportedIssues
		= createReverseRelationValues(org.instantlogic.example.izzy.entity.UserEntity.reportedIssues);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<User, Issue> getReportedIssuesRelationValue() {
		return reportedIssues;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue> getReportedIssues() {
		return reportedIssues.getValue();
	}


}
