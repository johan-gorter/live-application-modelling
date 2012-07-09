package org.instantlogic.example.izzy.entity;

public class projectEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.example.izzy.project> {

	public static final projectEntity INSTANCE = new projectEntity();
	
	protected projectEntity() {
	}


	@Override
	public org.instantlogic.example.izzy.project createInstance() {
		return new org.instantlogic.example.izzy.project();
	}
	
	@Override
	public Class<org.instantlogic.example.izzy.project> getInstanceClass() {
		return org.instantlogic.example.izzy.project.class;
	}
	
	@Override
	public String getName() {
		return "project";
	}

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.project, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.issue>, org.instantlogic.example.izzy.issue> issues
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.project, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.issue>, org.instantlogic.example.izzy.issue>(
			"issues", INSTANCE, org.instantlogic.example.izzy.entity.issueEntity.INSTANCE, org.instantlogic.example.izzy.issue.class, org.instantlogic.example.izzy.entity.issueEntity.project
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.example.izzy.project, org.instantlogic.example.izzy.issue> get(
					org.instantlogic.example.izzy.project instance) {
				return instance.getIssuesRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.project, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.user>, org.instantlogic.example.izzy.user> users
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.project, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.user>, org.instantlogic.example.izzy.user>(
			"users", INSTANCE, org.instantlogic.example.izzy.entity.userEntity.INSTANCE, org.instantlogic.example.izzy.user.class, org.instantlogic.example.izzy.entity.userEntity.project
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.example.izzy.project, org.instantlogic.example.izzy.user> get(
					org.instantlogic.example.izzy.project instance) {
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
