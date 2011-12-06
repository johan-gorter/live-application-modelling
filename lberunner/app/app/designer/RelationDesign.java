package app.designer;

import java.util.List;

import app.designer.*;
import app.designer.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class RelationDesign 
	extends AttributeBaseDesign 
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
	
	public final ReadOnlyRelationValue<RelationDesign, EntityDesign> entity
		= createReverseRelationValue(RelationDesignEntity.entity);

	public EntityDesign getEntity() {
		return entity.get();
	}

	
	public final ReadOnlyRelationValues<RelationDesign, SelectDesign> relationInselects
		= createReverseRelationValues(RelationDesignEntity.relationInselects);

	public List<SelectDesign> getRelationInselects() {
		return relationInselects.get();
	}


}
