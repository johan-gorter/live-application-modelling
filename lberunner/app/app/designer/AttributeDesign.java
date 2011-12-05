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

public class AttributeDesign 
	extends AttributeBase 
	implements Instance {

	public AttributeDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public AttributeDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, AttributeDesignEntity.INSTANCE, id);
	}
	
	protected AttributeDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<AttributeDesign, java.lang.String> className
		= createAttributeValue(AttributeDesignEntity.className);
	
	public java.lang.String getClassName() {
		return className.get();
	}

	
	// Relations
	
	public final RelationValue<AttributeDesign, TextDesign> question
		= createRelationValue(AttributeDesignEntity.question);
	
	public final RelationValue<AttributeDesign, TextDesign> explanation
		= createRelationValue(AttributeDesignEntity.explanation);
	
	public final RelationValues<AttributeDesign, DomainEntryDesign> domain
		= createRelationValues(AttributeDesignEntity.domain);

	// Reverse relations
	
	public final ReadOnlyRelationValue<AttributeDesign, EntityDesign> entity
		= createReverseRelationValue(AttributeDesignEntity.entity);
	
	public final ReadOnlyRelationValues<AttributeDesign, FieldDesign> fields
		= createReverseRelationValues(AttributeDesignEntity.fields);

}
