package org.instantlogic.example.izzy.entity;

public class commentEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.example.izzy.comment> {

	public static final commentEntity INSTANCE = new commentEntity();
	
	protected commentEntity() {
	}


	@Override
	public org.instantlogic.example.izzy.comment createInstance() {
		return new org.instantlogic.example.izzy.comment();
	}
	
	@Override
	public Class<org.instantlogic.example.izzy.comment> getInstanceClass() {
		return org.instantlogic.example.izzy.comment.class;
	}
	
	@Override
	public String getName() {
		return "comment";
	}

	// Deductions
	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.example.izzy.comment, java.lang.String, java.lang.String> text 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.example.izzy.comment, java.lang.String, java.lang.String>(
			"text", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.example.izzy.comment, java.lang.String> get(org.instantlogic.example.izzy.comment instance) {
				return instance.getTextAttributeValue();
			}
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.comment, org.instantlogic.example.izzy.user, org.instantlogic.example.izzy.user> by
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.comment, org.instantlogic.example.izzy.user, org.instantlogic.example.izzy.user>(
			"by", INSTANCE, org.instantlogic.example.izzy.entity.userEntity.INSTANCE, org.instantlogic.example.izzy.user.class, org.instantlogic.example.izzy.entity.userEntity.comments
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.example.izzy.comment, org.instantlogic.example.izzy.user> get(
					org.instantlogic.example.izzy.comment instance) {
				return instance.getByRelationValue();
			}
			
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.comment, org.instantlogic.example.izzy.issue, org.instantlogic.example.izzy.issue> issue
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.comment, org.instantlogic.example.izzy.issue, org.instantlogic.example.izzy.issue>(
			"issue", INSTANCE, org.instantlogic.example.izzy.entity.issueEntity.INSTANCE, org.instantlogic.example.izzy.issue.class, org.instantlogic.example.izzy.entity.issueEntity.comments
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.example.izzy.comment, org.instantlogic.example.izzy.issue> get(
					org.instantlogic.example.izzy.comment instance) {
				return instance.getIssueRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		text,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		by,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		issue,
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
