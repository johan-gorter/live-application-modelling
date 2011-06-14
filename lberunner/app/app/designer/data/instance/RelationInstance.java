package app.designer.data.instance;

import java.util.List;

import app.designer.data.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class RelationInstance 
	extends AttributeInstance 
	implements Instance {

	public RelationInstance(CaseInstance caseInstance) {
		super(caseInstance, RelationEntity.INSTANCE);
	}
	
	protected RelationInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	// Attributes
	
	public final AttributeValue<RelationInstance, java.lang.Boolean> owner
		= createAttributeValue(RelationEntity.owner);
	
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

}
