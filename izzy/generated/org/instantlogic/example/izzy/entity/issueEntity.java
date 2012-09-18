package org.instantlogic.example.izzy.entity;

public class IssueEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.example.izzy.Issue> {

	public static final IssueEntity INSTANCE = new IssueEntity();
	
	
	protected IssueEntity() {
	}


	@Override
	public org.instantlogic.example.izzy.Issue createInstance() {
		return new org.instantlogic.example.izzy.Issue();
	}
	
	@Override
	public Class<org.instantlogic.example.izzy.Issue> getInstanceClass() {
		return org.instantlogic.example.izzy.Issue.class;
	}
	
	@Override
	public String getName() {
		return "issue";
	}

	// Deductions
	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.example.izzy.Issue, java.lang.String, java.lang.String> description 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.example.izzy.Issue, java.lang.String, java.lang.String>(
			"description", INSTANCE, java.lang.String.class
		) {
			{
				dataType.put("category", "text");
				dataType.put("multiLine", true);
				dataType.put("formatted", true);
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.example.izzy.Issue, java.lang.String> get(org.instantlogic.example.izzy.Issue instance) {
				return instance.getDescriptionAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.example.izzy.Issue, java.lang.String, java.lang.String> headline 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.example.izzy.Issue, java.lang.String, java.lang.String>(
			"headline", INSTANCE, java.lang.String.class
		) {
			{
				dataType.put("category", "text");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.example.izzy.Issue, java.lang.String> get(org.instantlogic.example.izzy.Issue instance) {
				return instance.getHeadlineAttributeValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.example.izzy.Issue, java.lang.Integer, java.lang.Integer> number 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.example.izzy.Issue, java.lang.Integer, java.lang.Integer>(
			"number", INSTANCE, java.lang.Integer.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.example.izzy.Issue, java.lang.Integer> get(org.instantlogic.example.izzy.Issue instance) {
				return instance.getNumberAttributeValue();
			}
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.User, org.instantlogic.example.izzy.User> assignee
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.User, org.instantlogic.example.izzy.User>(
			"assignee", INSTANCE, org.instantlogic.example.izzy.entity.UserEntity.INSTANCE, org.instantlogic.example.izzy.User.class, 
			org.instantlogic.example.izzy.entity.UserEntity.assignedIssues
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.User> get(
					org.instantlogic.example.izzy.Issue instance) {
				return instance.getAssigneeRelationValue();
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.Issue, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Comment>, org.instantlogic.example.izzy.Comment> comments
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.Issue, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Comment>, org.instantlogic.example.izzy.Comment>(
			"comments", INSTANCE, org.instantlogic.example.izzy.entity.CommentEntity.INSTANCE, org.instantlogic.example.izzy.Comment.class, 
			org.instantlogic.example.izzy.entity.CommentEntity.issue
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.Comment> get(
					org.instantlogic.example.izzy.Issue instance) {
				return instance.getCommentsRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.User, org.instantlogic.example.izzy.User> reporter
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.User, org.instantlogic.example.izzy.User>(
			"reporter", INSTANCE, org.instantlogic.example.izzy.entity.UserEntity.INSTANCE, org.instantlogic.example.izzy.User.class, 
			org.instantlogic.example.izzy.entity.UserEntity.reportedIssues
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.User> get(
					org.instantlogic.example.izzy.Issue instance) {
				return instance.getReporterRelationValue();
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.Project, org.instantlogic.example.izzy.Project> project
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.Project, org.instantlogic.example.izzy.Project>(
			"project", INSTANCE, org.instantlogic.example.izzy.entity.ProjectEntity.INSTANCE, org.instantlogic.example.izzy.Project.class, org.instantlogic.example.izzy.entity.ProjectEntity.issues
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.Project> get(
					org.instantlogic.example.izzy.Issue instance) {
				return instance.getProjectRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		description,
		headline,
		number,
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
