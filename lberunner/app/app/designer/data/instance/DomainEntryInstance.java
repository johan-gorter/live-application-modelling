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

public class DomainEntryInstance 
	extends ConceptInstance 
	implements Instance {

	public DomainEntryInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public DomainEntryInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, DomainEntryEntity.INSTANCE, id);
	}
	
	protected DomainEntryInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<DomainEntryInstance, TextInstance> display
		= createRelationValue(DomainEntryEntity.display);

	// Reverse relations
	
	public final ReadOnlyRelationValue<DomainEntryInstance, AttributeInstance> attribute
		= createReverseRelationValue(DomainEntryEntity.attribute);

}
