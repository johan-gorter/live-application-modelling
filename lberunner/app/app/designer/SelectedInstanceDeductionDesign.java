package app.designer;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.RelationValue;

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
		
	public EntityDesign getInstanceEntity() {
		return entity.get();
	}
	
	public void setEntity(EntityDesign newValue) {
		entity.set(newValue);
	}

	// Reverse relations

}
