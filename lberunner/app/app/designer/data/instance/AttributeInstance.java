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

public class AttributeInstance 
	extends AttributeBaseInstance 
	implements Instance {

	public AttributeInstance(CaseInstance caseInstance) {
		super(caseInstance, AttributeEntity.INSTANCE);
	}
	
	protected AttributeInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	// Attributes
	
	public final AttributeValue<AttributeInstance, java.lang.String> className
		= createAttributeValue(AttributeEntity.className);
	
	// Relations
	
	public final RelationValue<AttributeInstance, TextInstance> question
		= createRelationValue(AttributeEntity.question);
	
	public final RelationValue<AttributeInstance, TextInstance> explanation
		= createRelationValue(AttributeEntity.explanation);
	
	public final RelationValues<AttributeInstance, DomainEntryInstance> domain
		= createRelationValues(AttributeEntity.domain);

	// Reverse relations
	
	public final ReadOnlyRelationValue<AttributeInstance, EntityInstance> entity
		= createReverseRelationValue(AttributeEntity.entity);
	
	public final ReadOnlyRelationValues<AttributeInstance, FieldInstance> fields
		= createReverseRelationValues(AttributeEntity.fields);

}
