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

public class StringProducerInstance 
	extends SimpleInstance 
	implements Instance {

	public StringProducerInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public StringProducerInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, StringProducerEntity.INSTANCE, id);
	}
	
	protected StringProducerInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValue<StringProducerInstance, TemplatedTextInstance> untranslatedInTemplate
		= createReverseRelationValue(StringProducerEntity.untranslatedInTemplate);

}
