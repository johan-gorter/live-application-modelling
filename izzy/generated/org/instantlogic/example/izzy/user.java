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
	
	private final org.instantlogic.fabric.value.RelationValues<User, Issue> assignedIssues
		= createReverseRelationValues(org.instantlogic.example.izzy.entity.UserEntity.assignedIssues);

	public org.instantlogic.fabric.value.RelationValues<User, Issue> getAssignedIssuesRelationValue() {
		return assignedIssues;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue> getAssignedIssues() {
		return assignedIssues.getValue();
	}

    public User addToAssignedIssues(Issue item) {
        assignedIssues.addValue(item);
        return (User)this;
    }

    public User removeFromAssignedIssues(Issue item) {
        assignedIssues.removeValue(item);
        return (User)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<User, Comment> comments
		= createReverseRelationValue(org.instantlogic.example.izzy.entity.UserEntity.comments);

	public org.instantlogic.fabric.value.RelationValue<User, Comment> getCommentsRelationValue() {
		return comments;
	}

	public org.instantlogic.example.izzy.Comment getComments() {
		return comments.getValue();
	}

    public User setComments(org.instantlogic.example.izzy.Comment newValue) {
        comments.setValue(newValue);
        return (User)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<User, Project> project
		= createReverseRelationValue(org.instantlogic.example.izzy.entity.UserEntity.project);

	public org.instantlogic.fabric.value.RelationValue<User, Project> getProjectRelationValue() {
		return project;
	}

	public org.instantlogic.example.izzy.Project getProject() {
		return project.getValue();
	}

    public User setProject(org.instantlogic.example.izzy.Project newValue) {
        project.setValue(newValue);
        return (User)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<User, Issue> reportedIssues
		= createReverseRelationValues(org.instantlogic.example.izzy.entity.UserEntity.reportedIssues);

	public org.instantlogic.fabric.value.RelationValues<User, Issue> getReportedIssuesRelationValue() {
		return reportedIssues;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue> getReportedIssues() {
		return reportedIssues.getValue();
	}

    public User addToReportedIssues(Issue item) {
        reportedIssues.addValue(item);
        return (User)this;
    }

    public User removeFromReportedIssues(Issue item) {
        reportedIssues.removeValue(item);
        return (User)this;
    }


}
