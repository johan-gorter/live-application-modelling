package org.instantlogic.example.izzy;


public class comment extends org.instantlogic.fabric.Instance { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.example.izzy.entity.commentEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<comment, java.lang.String> text
		= createAttributeValue(org.instantlogic.example.izzy.entity.commentEntity.text);
	
	public java.lang.String getText() {
		return text.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<comment, java.lang.String> getTextAttributeValue() {
		return text;
	}

	public comment setText(java.lang.String newValue) {
		text.setValue(newValue);
		return (comment)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<comment, user> by
		= createRelationValue(org.instantlogic.example.izzy.entity.commentEntity.by);
		
	public org.instantlogic.fabric.value.RelationValue<comment, user> getByRelationValue() {
		return by;
	}

	public org.instantlogic.example.izzy.user getBy() {
		return by.getValue();
	}
	
	public comment setBy(org.instantlogic.example.izzy.user newValue) {
		by.setValue(newValue);
		return (comment)this;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<comment, issue> issue
		= createReverseRelationValue(org.instantlogic.example.izzy.entity.commentEntity.issue);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<comment, issue> getIssueRelationValue() {
		return issue;
	}

	public org.instantlogic.example.izzy.issue getIssue() {
		return issue.getValue();
	}


}
