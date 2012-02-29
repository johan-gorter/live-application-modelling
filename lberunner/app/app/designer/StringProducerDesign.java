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

public class StringProducerDesign 
	extends SimpleInstance 
	implements Instance {

	public StringProducerDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public StringProducerDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, StringProducerDesignEntity.INSTANCE, id);
	}
	
	protected StringProducerDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValue<StringProducerDesign, TemplatedTextDesign> untranslatedInTemplate
		= createReverseRelationValue(StringProducerDesignEntity.untranslatedInTemplate);

	public TemplatedTextDesign getUntranslatedInTemplate() {
		return untranslatedInTemplate.get();
	}


}
