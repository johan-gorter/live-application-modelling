package app.designer;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.value.RelationValue;

import app.designer.entity.CastInstanceDeductionDesignEntity;

public class CastInstanceDeductionDesign 
	extends DeductionDesign 
	implements Instance {

	public CastInstanceDeductionDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public CastInstanceDeductionDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, CastInstanceDeductionDesignEntity.INSTANCE, id);
	}
	
	protected CastInstanceDeductionDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<CastInstanceDeductionDesign, EntityDesign> entity
		= createRelationValue(CastInstanceDeductionDesignEntity.entity);
		
	public EntityDesign getEntity() {
		return entity.get();
	}
	
	public void setEntity(EntityDesign newValue) {
		entity.set(newValue);
	}

	// Reverse relations

}
