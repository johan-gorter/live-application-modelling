package org.instantlogic.example.izzy;


public class Project extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.example.izzy.entity.ProjectEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<Project, Issue> issues
		= createRelationValues(org.instantlogic.example.izzy.entity.ProjectEntity.issues);
		
	public org.instantlogic.fabric.value.RelationValues<Project, Issue> getIssuesRelationValue() {
		return issues;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue> getIssues() {
		return issues.getValue();
	}
	
	public Project addToIssues(Issue item) {
		issues.addValue(item);
		return (Project)this;
	}
	
	public Project addToIssues(Issue item, int index) {
		issues.insertValue(item, index);
		return (Project)this;
	}
	
	public Project removeFromIssues(Issue item) {
		issues.removeValue(item);
		return (Project)this;
	}
	
	public Project removeFromIssues(int index) {
		issues.removeValue(index);
		return (Project)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<Project, User> users
		= createRelationValues(org.instantlogic.example.izzy.entity.ProjectEntity.users);
		
	public org.instantlogic.fabric.value.RelationValues<Project, User> getUsersRelationValue() {
		return users;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.User> getUsers() {
		return users.getValue();
	}
	
	public Project addToUsers(User item) {
		users.addValue(item);
		return (Project)this;
	}
	
	public Project addToUsers(User item, int index) {
		users.insertValue(item, index);
		return (Project)this;
	}
	
	public Project removeFromUsers(User item) {
		users.removeValue(item);
		return (Project)this;
	}
	
	public Project removeFromUsers(int index) {
		users.removeValue(index);
		return (Project)this;
	}
	

	// Reverse relations

}
