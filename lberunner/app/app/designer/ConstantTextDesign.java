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

public class ConstantTextDesign 
	extends TextDesign 
	implements Instance {

	public ConstantTextDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public ConstantTextDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, ConstantTextDesignEntity.INSTANCE, id);
	}
	
	protected ConstantTextDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<ConstantTextDesign, java.lang.String> untranslated
		= createAttributeValue(ConstantTextDesignEntity.untranslated);
	
	public java.lang.String getUntranslated() {
		return untranslated.get();
	}

	
	// Relations

	// Reverse relations

}
