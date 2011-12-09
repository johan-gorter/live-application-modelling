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

public class SelectedInstanceDeductionDesign 
	extends DeductionDesign 
	implements Instance {

	public SelectedInstanceDeductionDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public SelectedInstanceDeductionDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, SelectedInstanceDeductionDesignEntity.INSTANCE, id);
	}
	
	protected SelectedInstanceDeductionDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<SelectedInstanceDeductionDesign, EntityDesign> entity
		= createRelationValue(SelectedInstanceDeductionDesignEntity.entity);
		
	public EntityDesign getEntity() {
		return entity.get();
	}
	
	public void setEntity(EntityDesign newValue) {
		entity.set(newValue);
	}

	// Reverse relations

}
