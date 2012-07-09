package org.instantlogic.example.izzy.entity;

public class issueEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.example.izzy.issue> {

	public static final issueEntity INSTANCE = new issueEntity();
	
	protected issueEntity() {
	}


	@Override
	public org.instantlogic.example.izzy.issue createInstance() {
		return new org.instantlogic.example.izzy.issue();
	}
	
	@Override
	public Class<org.instantlogic.example.izzy.issue> getInstanceClass() {
		return org.instantlogic.example.izzy.issue.class;
	}
	
	@Override
	public String getName() {
		return "issue";
	}

	// Deductions
	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.example.izzy.issue, java.lang.String, java.lang.String> description 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.example.izzy.issue, java.lang.String, java.lang.String>(
			"description", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.example.izzy.issue, java.lang.String> get(org.instantlogic.example.izzy.issue instance) {
				return instance.getDescriptionAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.example.izzy.issue, java.lang.String, java.lang.String> headline 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.example.izzy.issue, java.lang.String, java.lang.String>(
			"headline", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.example.izzy.issue, java.lang.String> get(org.instantlogic.example.izzy.issue instance) {
				return instance.getHeadlineAttributeValue();
			}
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.issue, org.instantlogic.example.izzy.user, org.instantlogic.example.izzy.user> assignee
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.issue, org.instantlogic.example.izzy.user, org.instantlogic.example.izzy.user>(
			"assignee", INSTANCE, org.instantlogic.example.izzy.entity.userEntity.INSTANCE, org.instantlogic.example.izzy.user.class, org.instantlogic.example.izzy.entity.userEntity.assigned issues
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.example.izzy.issue, org.instantlogic.example.izzy.user> get(
					org.instantlogic.example.izzy.issue instance) {
				return instance.getAssigneeRelationValue();
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.issue, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.comment>, org.instantlogic.example.izzy.comment> comments
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.issue, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.comment>, org.instantlogic.example.izzy.comment>(
			"comments", INSTANCE, org.instantlogic.example.izzy.entity.commentEntity.INSTANCE, org.instantlogic.example.izzy.comment.class, org.instantlogic.example.izzy.entity.commentEntity.issue
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.example.izzy.issue, org.instantlogic.example.izzy.comment> get(
					org.instantlogic.example.izzy.issue instance) {
				return instance.getCommentsRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.issue, org.instantlogic.example.izzy.user, org.instantlogic.example.izzy.user> reporter
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.issue, org.instantlogic.example.izzy.user, org.instantlogic.example.izzy.user>(
			"reporter", INSTANCE, org.instantlogic.example.izzy.entity.userEntity.INSTANCE, org.instantlogic.example.izzy.user.class, org.instantlogic.example.izzy.entity.userEntity.reported issues
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.example.izzy.issue, org.instantlogic.example.izzy.user> get(
					org.instantlogic.example.izzy.issue instance) {
				return instance.getReporterRelationValue();
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.issue, org.instantlogic.example.izzy.project, org.instantlogic.example.izzy.project> project
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.issue, org.instantlogic.example.izzy.project, org.instantlogic.example.izzy.project>(
			"project", INSTANCE, org.instantlogic.example.izzy.entity.projectEntity.INSTANCE, org.instantlogic.example.izzy.project.class, org.instantlogic.example.izzy.entity.projectEntity.issues
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.example.izzy.issue, org.instantlogic.example.izzy.project> get(
					org.instantlogic.example.izzy.issue instance) {
				return instance.getProjectRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		description,
		headline,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		assignee,
		comments,
		reporter,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		project,
	};

	@Override
	public org.instantlogic.fabric.model.Attribute[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}
}
