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

public class TextInstance 
	extends PageElementBaseInstance 
	implements Instance {

	public TextInstance(CaseInstance caseInstance) {
		super(caseInstance, TextEntity.INSTANCE);
	}
	
	protected TextInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValue<TextInstance, AttributeInstance> questionOnAttribute
		= createReverseRelationValue(TextEntity.questionOnAttribute);
	
	public final ReadOnlyRelationValue<TextInstance, AttributeInstance> explanationOnAttribute
		= createReverseRelationValue(TextEntity.explanationOnAttribute);
	
	public final ReadOnlyRelationValue<TextInstance, DomainEntryInstance> displayOnDomainEntry
		= createReverseRelationValue(TextEntity.displayOnDomainEntry);

}
