package app.designer.data.instance;

import java.util.List;

import app.designer.*;
import app.designer.data.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class RelationInstance 
	extends AttributeBaseInstance 
	implements Instance {

	public RelationInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public RelationInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, RelationEntity.INSTANCE, id);
	}
	
	protected RelationInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<RelationInstance, java.lang.Boolean> owner
		= createAttributeValue(RelationEntity.owner);
	
	public final AttributeValue<RelationInstance, java.lang.Boolean> autoCreate
		= createAttributeValue(RelationEntity.autoCreate);
	
	public final AttributeValue<RelationInstance, java.lang.Boolean> reverseMultivalue
		= createAttributeValue(RelationEntity.reverseMultivalue);
	
	public final AttributeValue<RelationInstance, java.lang.String> reverseName
		= createAttributeValue(RelationEntity.reverseName);
	
	// Relations
	
	public final RelationValue<RelationInstance, EntityInstance> to
		= createRelationValue(RelationEntity.to);

	// Reverse relations
	
	public final ReadOnlyRelationValue<RelationInstance, EntityInstance> entity
		= createReverseRelationValue(RelationEntity.entity);
	
	public final ReadOnlyRelationValues<RelationInstance, SelectInstance> relationInselects
		= createReverseRelationValues(RelationEntity.relationInselects);

}
