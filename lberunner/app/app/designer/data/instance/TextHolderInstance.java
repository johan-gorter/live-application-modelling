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

public class TextHolderInstance 
	extends ConceptInstance 
	implements Instance {

	public TextHolderInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public TextHolderInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, TextHolderEntity.INSTANCE, id);
	}
	
	protected TextHolderInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<TextHolderInstance, TextInstance> text
		= createRelationValue(TextHolderEntity.text);

	// Reverse relations
	
	public final ReadOnlyRelationValue<TextHolderInstance, SharedInstance> shared
		= createReverseRelationValue(TextHolderEntity.shared);
	
	public final ReadOnlyRelationValues<TextHolderInstance, SharedTextInstance> usages
		= createReverseRelationValues(TextHolderEntity.usages);

}
