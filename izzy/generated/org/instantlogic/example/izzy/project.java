package org.instantlogic.example.izzy;


public class project extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.example.izzy.entity.projectEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<project, issue> issues
		= createRelationValues(org.instantlogic.example.izzy.entity.projectEntity.issues);
		
	public org.instantlogic.fabric.value.RelationValues<project, issue> getIssuesRelationValue() {
		return issues;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.issue> getIssues() {
		return issues.getValue();
	}
	
	public project addToIssues(issue item) {
		issues.addValue(item);
		return (project)this;
	}
	
	public project addToIssues(issue item, int index) {
		issues.insertValue(item, index);
		return (project)this;
	}
	
	public project removeFromIssues(issue item) {
		issues.removeValue(item);
		return (project)this;
	}
	
	public project removeFromIssues(int index) {
		issues.removeValue(index);
		return (project)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<project, user> users
		= createRelationValues(org.instantlogic.example.izzy.entity.projectEntity.users);
		
	public org.instantlogic.fabric.value.RelationValues<project, user> getUsersRelationValue() {
		return users;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.user> getUsers() {
		return users.getValue();
	}
	
	public project addToUsers(user item) {
		users.addValue(item);
		return (project)this;
	}
	
	public project addToUsers(user item, int index) {
		users.insertValue(item, index);
		return (project)this;
	}
	
	public project removeFromUsers(user item) {
		users.removeValue(item);
		return (project)this;
	}
	
	public project removeFromUsers(int index) {
		users.removeValue(index);
		return (project)this;
	}
	

	// Reverse relations

}
