package app.designer;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.value.AttributeValue;
import org.instantlogic.core.value.ReadOnlyRelationValue;
import org.instantlogic.core.value.RelationValue;

import app.designer.entity.RelationDesignEntity;

public class RelationDesign 
	extends AttributeDesign 
	implements Instance {

	public RelationDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public RelationDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, RelationDesignEntity.INSTANCE, id);
	}
	
	protected RelationDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<RelationDesign, java.lang.Boolean> owner
		= createAttributeValue(RelationDesignEntity.owner);
	
	public java.lang.Boolean getOwner() {
		return owner.get();
	}

	public void setOwner(java.lang.Boolean newValue) {
		owner.set(newValue);
	}
	
	public final AttributeValue<RelationDesign, java.lang.Boolean> autoCreate
		= createAttributeValue(RelationDesignEntity.autoCreate);
	
	public java.lang.Boolean getAutoCreate() {
		return autoCreate.get();
	}

	public void setAutoCreate(java.lang.Boolean newValue) {
		autoCreate.set(newValue);
	}
	
	public final AttributeValue<RelationDesign, java.lang.Boolean> reverseMultivalue
		= createAttributeValue(RelationDesignEntity.reverseMultivalue);
	
	public java.lang.Boolean getReverseMultivalue() {
		return reverseMultivalue.get();
	}

	public void setReverseMultivalue(java.lang.Boolean newValue) {
		reverseMultivalue.set(newValue);
	}
	
	public final AttributeValue<RelationDesign, java.lang.String> reverseName
		= createAttributeValue(RelationDesignEntity.reverseName);
	
	public java.lang.String getReverseName() {
		return reverseName.get();
	}

	public void setReverseName(java.lang.String newValue) {
		reverseName.set(newValue);
	}
	
	// Relations
	
	public final RelationValue<RelationDesign, EntityDesign> to
		= createRelationValue(RelationDesignEntity.to);
		
	public EntityDesign getTo() {
		return to.get();
	}
	
	public void setTo(EntityDesign newValue) {
		to.set(newValue);
	}

	// Reverse relations
	
	public final ReadOnlyRelationValue<RelationDesign, EntityDesign> from
		= createReverseRelationValue(RelationDesignEntity.from);

	public EntityDesign getFrom() {
		return from.get();
	}


}
