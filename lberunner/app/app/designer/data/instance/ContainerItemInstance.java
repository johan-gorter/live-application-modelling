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

public class ContainerItemInstance 
	extends PageElementBaseInstance 
	implements Instance {

	public ContainerItemInstance(CaseInstance caseInstance) {
		super(caseInstance, ContainerItemEntity.INSTANCE);
	}
	
	protected ContainerItemInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	// Attributes
	
	// Relations

	// Reverse relations

}
