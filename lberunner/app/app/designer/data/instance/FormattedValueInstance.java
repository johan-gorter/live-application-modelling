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

public class FormattedValueInstance 
	extends StringProducerInstance 
	implements Instance {

	public FormattedValueInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public FormattedValueInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, FormattedValueEntity.INSTANCE, id);
	}
	
	protected FormattedValueInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<FormattedValueInstance, AttributeBaseInstance> value
		= createRelationValue(FormattedValueEntity.value);

	// Reverse relations

}
