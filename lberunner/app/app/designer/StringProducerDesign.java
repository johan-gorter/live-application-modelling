package app.designer;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.impl.SimpleInstance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;

import app.designer.entity.StringProducerDesignEntity;

public class StringProducerDesign 
	extends SimpleInstance 
	implements Instance {

	public StringProducerDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public StringProducerDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, StringProducerDesignEntity.INSTANCE, id);
	}
	
	protected StringProducerDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValue<StringProducerDesign, TemplatedTextDesign> untranslatedInTemplate
		= createReverseRelationValue(StringProducerDesignEntity.untranslatedInTemplate);

	public TemplatedTextDesign getUntranslatedInTemplate() {
		return untranslatedInTemplate.get();
	}


}
