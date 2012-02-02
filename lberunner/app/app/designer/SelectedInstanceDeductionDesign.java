package app.designer;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.value.RelationValue;

import app.designer.entity.SelectedInstanceDeductionDesignEntity;

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
