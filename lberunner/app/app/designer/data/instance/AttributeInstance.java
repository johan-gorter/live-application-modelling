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

public class AttributeInstance 
	extends AttributeBaseInstance 
	implements Instance {

	public AttributeInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public AttributeInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, AttributeEntity.INSTANCE, id);
	}
	
	protected AttributeInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
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
