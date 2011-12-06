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

public class SharedTextDesign 
	extends TextDesign 
	implements Instance {

	public SharedTextDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public SharedTextDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, SharedTextDesignEntity.INSTANCE, id);
	}
	
	protected SharedTextDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations

	// Reverse relations

}
