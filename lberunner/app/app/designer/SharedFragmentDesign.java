package app.designer;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.RelationValue;

import app.designer.entity.SharedFragmentDesignEntity;

public class SharedFragmentDesign 
	extends PageFragmentDesign 
	implements Instance {

	public SharedFragmentDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public SharedFragmentDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, SharedFragmentDesignEntity.INSTANCE, id);
	}
	
	protected SharedFragmentDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<SharedFragmentDesign, PageFragmentHolderDesign> holder
		= createRelationValue(SharedFragmentDesignEntity.holder);
		
	public PageFragmentHolderDesign getHolder() {
		return holder.get();
	}
	
	public void setHolder(PageFragmentHolderDesign newValue) {
		holder.set(newValue);
	}

	// Reverse relations

}
