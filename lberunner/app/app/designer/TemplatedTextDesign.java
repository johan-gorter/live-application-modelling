package app.designer;

import java.util.List;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.value.RelationValues;

import app.designer.entity.TemplatedTextDesignEntity;

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
