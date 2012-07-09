package org.instantlogic.example.izzy.entity;

public class userEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.example.izzy.user> {

	public static final userEntity INSTANCE = new userEntity();
	
	protected userEntity() {
	}


	@Override
	public org.instantlogic.example.izzy.user createInstance() {
		return new org.instantlogic.example.izzy.user();
	}
	
	@Override
	public Class<org.instantlogic.example.izzy.user> getInstanceClass() {
		return org.instantlogic.example.izzy.user.class;
	}
	
	@Override
	public String getName() {
		return "user";
	}

	// Deductions
	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.example.izzy.user, java.lang.String, java.lang.String> username 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.example.izzy.user, java.lang.String, java.lang.String>(
			"username", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.example.izzy.user, java.lang.String> get(org.instantlogic.example.izzy.user instance) {
				return instance.getUsernameAttributeValue();
			}
		};
	
	// Relations
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.user, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.issue>, org.instantlogic.example.izzy.issue> assigned issues
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.user, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.issue>, org.instantlogic.example.izzy.issue>(
			"assigned issues", INSTANCE, org.instantlogic.example.izzy.entity.issueEntity.INSTANCE, org.instantlogic.example.izzy.issue.class, org.instantlogic.example.izzy.entity.issueEntity.assignee
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.example.izzy.user, org.instantlogic.example.izzy.issue> get(
					org.instantlogic.example.izzy.user instance) {
				return instance.getAssigned issuesRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.user, org.instantlogic.example.izzy.comment, org.instantlogic.example.izzy.comment> comments
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.user, org.instantlogic.example.izzy.comment, org.instantlogic.example.izzy.comment>(
			"comments", INSTANCE, org.instantlogic.example.izzy.entity.commentEntity.INSTANCE, org.instantlogic.example.izzy.comment.class, org.instantlogic.example.izzy.entity.commentEntity.by
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.example.izzy.user, org.instantlogic.example.izzy.comment> get(
					org.instantlogic.example.izzy.user instance) {
				return instance.getCommentsRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.user, org.instantlogic.example.izzy.project, org.instantlogic.example.izzy.project> project
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.user, org.instantlogic.example.izzy.project, org.instantlogic.example.izzy.project>(
			"project", INSTANCE, org.instantlogic.example.izzy.entity.projectEntity.INSTANCE, org.instantlogic.example.izzy.project.class, org.instantlogic.example.izzy.entity.projectEntity.users
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.example.izzy.user, org.instantlogic.example.izzy.project> get(
					org.instantlogic.example.izzy.user instance) {
				return instance.getProjectRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.user, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.issue>, org.instantlogic.example.izzy.issue> reported issues
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.user, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.issue>, org.instantlogic.example.izzy.issue>(
			"reported issues", INSTANCE, org.instantlogic.example.izzy.entity.issueEntity.INSTANCE, org.instantlogic.example.izzy.issue.class, org.instantlogic.example.izzy.entity.issueEntity.reporter
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.example.izzy.user, org.instantlogic.example.izzy.issue> get(
					org.instantlogic.example.izzy.user instance) {
				return instance.getReported issuesRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		username,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		assigned issues,
		comments,
		project,
		reported issues,
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
