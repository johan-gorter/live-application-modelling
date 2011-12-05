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

public class TextDesign 
	extends PageFragmentDesign 
	implements Instance {

	public TextDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public TextDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, TextDesignEntity.INSTANCE, id);
	}
	
	protected TextDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValue<TextDesign, AttributeDesign> questionOnAttribute
		= createReverseRelationValue(TextDesignEntity.questionOnAttribute);
	
	public final ReadOnlyRelationValue<TextDesign, AttributeDesign> explanationOnAttribute
		= createReverseRelationValue(TextDesignEntity.explanationOnAttribute);
	
	public final ReadOnlyRelationValue<TextDesign, DomainEntryDesign> displayOnDomainEntry
		= createReverseRelationValue(TextDesignEntity.displayOnDomainEntry);
	
	public final ReadOnlyRelationValue<TextDesign, TextHolder> holder
		= createReverseRelationValue(TextDesignEntity.holder);
	
	public final ReadOnlyRelationValue<TextDesign, Header> textOnHeader
		= createReverseRelationValue(TextDesignEntity.textOnHeader);
	
	public final ReadOnlyRelationValue<TextDesign, LinkDesign> captionOnButton
		= createReverseRelationValue(TextDesignEntity.captionOnButton);

}
