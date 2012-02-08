package app.designer;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;
import org.instantlogic.fabric.value.RelationValue;

import app.designer.entity.DomainEntryDesignEntity;

public class DomainEntryDesign 
	extends Design 
	implements Instance {

	public DomainEntryDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public DomainEntryDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, DomainEntryDesignEntity.INSTANCE, id);
	}
	
	protected DomainEntryDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<DomainEntryDesign, TextDesign> display
		= createRelationValue(DomainEntryDesignEntity.display);
		
	public TextDesign getDisplay() {
		return display.get();
	}
	
	public void setDisplay(TextDesign newValue) {
		display.set(newValue);
	}

	// Reverse relations
	
	public final ReadOnlyRelationValue<DomainEntryDesign, AttributeDesign> attribute
		= createReverseRelationValue(DomainEntryDesignEntity.attribute);

	public AttributeDesign getAttribute() {
		return attribute.get();
	}


}
