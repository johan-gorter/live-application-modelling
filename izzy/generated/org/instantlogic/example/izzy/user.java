package org.instantlogic.example.izzy;


public class user extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.example.izzy.entity.userEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<user, java.lang.String> username
		= createAttributeValue(org.instantlogic.example.izzy.entity.userEntity.username);
	
	public java.lang.String getUsername() {
		return username.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<user, java.lang.String> getUsernameAttributeValue() {
		return username;
	}

	public user setUsername(java.lang.String newValue) {
		username.setValue(newValue);
		return (user)this;
	}
	
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<user, issue> assigned issues
		= createReverseRelationValues(org.instantlogic.example.izzy.entity.userEntity.assigned issues);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<user, issue> getAssigned issuesRelationValue() {
		return assigned issues;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.issue> getAssigned issues() {
		return assigned issues.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<user, comment> comments
		= createReverseRelationValue(org.instantlogic.example.izzy.entity.userEntity.comments);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<user, comment> getCommentsRelationValue() {
		return comments;
	}

	public org.instantlogic.example.izzy.comment getComments() {
		return comments.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<user, project> project
		= createReverseRelationValue(org.instantlogic.example.izzy.entity.userEntity.project);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<user, project> getProjectRelationValue() {
		return project;
	}

	public org.instantlogic.example.izzy.project getProject() {
		return project.getValue();
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValues<user, issue> reported issues
		= createReverseRelationValues(org.instantlogic.example.izzy.entity.userEntity.reported issues);

	public org.instantlogic.fabric.value.ReadOnlyRelationValues<user, issue> getReported issuesRelationValue() {
		return reported issues;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.issue> getReported issues() {
		return reported issues.getValue();
	}


}
