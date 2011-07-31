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

public class TextInstance 
	extends PageFragmentInstance 
	implements Instance {

	public TextInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public TextInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, TextEntity.INSTANCE, id);
	}
	
	protected TextInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
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
	
	public final ReadOnlyRelationValue<TextInstance, TextHolderInstance> holder
		= createReverseRelationValue(TextEntity.holder);
	
	public final ReadOnlyRelationValue<TextInstance, HeaderInstance> textOnHeader
		= createReverseRelationValue(TextEntity.textOnHeader);
	
	public final ReadOnlyRelationValue<TextInstance, ButtonInstance> captionOnButton
		= createReverseRelationValue(TextEntity.captionOnButton);

}
