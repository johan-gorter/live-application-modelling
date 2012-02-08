package app.designer;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.RelationValue;

import app.designer.entity.HeaderDesignEntity;

public class HeaderDesign 
	extends CompositePageFragmentDesign 
	implements Instance {

	public HeaderDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public HeaderDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, HeaderDesignEntity.INSTANCE, id);
	}
	
	protected HeaderDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<HeaderDesign, TextDesign> text
		= createRelationValue(HeaderDesignEntity.text);
		
	public TextDesign getText() {
		return text.get();
	}
	
	public void setText(TextDesign newValue) {
		text.set(newValue);
	}

	// Reverse relations

}
