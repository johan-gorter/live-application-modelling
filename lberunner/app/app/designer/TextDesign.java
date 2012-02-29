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

	public AttributeDesign getQuestionOnAttribute() {
		return questionOnAttribute.get();
	}

	
	public final ReadOnlyRelationValue<TextDesign, AttributeDesign> explanationOnAttribute
		= createReverseRelationValue(TextDesignEntity.explanationOnAttribute);

	public AttributeDesign getExplanationOnAttribute() {
		return explanationOnAttribute.get();
	}

	
	public final ReadOnlyRelationValue<TextDesign, DomainEntryDesign> displayOnDomainEntry
		= createReverseRelationValue(TextDesignEntity.displayOnDomainEntry);

	public DomainEntryDesign getDisplayOnDomainEntry() {
		return displayOnDomainEntry.get();
	}

	
	public final ReadOnlyRelationValue<TextDesign, HeaderDesign> textOnHeader
		= createReverseRelationValue(TextDesignEntity.textOnHeader);

	public HeaderDesign getTextOnHeader() {
		return textOnHeader.get();
	}

	
	public final ReadOnlyRelationValue<TextDesign, LinkDesign> captionOnButton
		= createReverseRelationValue(TextDesignEntity.captionOnButton);

	public LinkDesign getCaptionOnButton() {
		return captionOnButton.get();
	}


}
