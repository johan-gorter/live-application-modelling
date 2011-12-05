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

public class TextHolder 
	extends Concept 
	implements Instance {

	public TextHolder(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public TextHolder(CaseInstance caseInstance, long id) {
		super(caseInstance, TextHolderEntity.INSTANCE, id);
	}
	
	protected TextHolder(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<TextHolder, TextDesign> text
		= createRelationValue(TextHolderEntity.text);

	// Reverse relations
	
	public final ReadOnlyRelationValue<TextHolder, Shared> shared
		= createReverseRelationValue(TextHolderEntity.shared);
	
	public final ReadOnlyRelationValues<TextHolder, SharedTextDesign> usages
		= createReverseRelationValues(TextHolderEntity.usages);

}
