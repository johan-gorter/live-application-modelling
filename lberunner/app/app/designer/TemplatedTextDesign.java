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

public class TemplatedTextDesign 
	extends TextDesign 
	implements Instance {

	public TemplatedTextDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public TemplatedTextDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, TemplatedTextDesignEntity.INSTANCE, id);
	}
	
	protected TemplatedTextDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValues<TemplatedTextDesign, StringProducerDesign> untranslated
		= createRelationValues(TemplatedTextDesignEntity.untranslated);
		
	public List<StringProducerDesign> getUntranslated() {
		return untranslated.get();
	}
	
	public void setUntranslated(List<StringProducerDesign> newValue) {
		untranslated.set(newValue);
	}

	// Reverse relations

}