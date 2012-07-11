package org.instantlogic.example.izzy.entity;

public class ProjectEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.example.izzy.Project> {

	public static final ProjectEntity INSTANCE = new ProjectEntity();
	
	protected ProjectEntity() {
	}


	@Override
	public org.instantlogic.example.izzy.Project createInstance() {
		return new org.instantlogic.example.izzy.Project();
	}
	
	@Override
	public Class<org.instantlogic.example.izzy.Project> getInstanceClass() {
		return org.instantlogic.example.izzy.Project.class;
	}
	
	@Override
	public String getName() {
		return "project";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.Project, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue>, org.instantlogic.example.izzy.Issue> issues
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.Project, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue>, org.instantlogic.example.izzy.Issue>(
			"issues", INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.Issue.class, org.instantlogic.example.izzy.entity.IssueEntity.project
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.example.izzy.Project, org.instantlogic.example.izzy.Issue> get(
					org.instantlogic.example.izzy.Project instance) {
				return instance.getIssuesRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.Project, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.User>, org.instantlogic.example.izzy.User> users
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.Project, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.User>, org.instantlogic.example.izzy.User>(
			"users", INSTANCE, org.instantlogic.example.izzy.entity.UserEntity.INSTANCE, org.instantlogic.example.izzy.User.class, org.instantlogic.example.izzy.entity.UserEntity.project
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.example.izzy.Project, org.instantlogic.example.izzy.User> get(
					org.instantlogic.example.izzy.Project instance) {
				return instance.getUsersRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		issues,
		users,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
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
