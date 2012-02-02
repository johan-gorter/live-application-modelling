package app.designer;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.value.RelationValue;

import app.designer.entity.LinkDesignEntity;

public class LinkDesign 
	extends PageFragmentDesign 
	implements Instance<LinkDesign> {

	public LinkDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public LinkDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, LinkDesignEntity.INSTANCE, id);
	}
	
	protected LinkDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<LinkDesign, TextDesign> caption
		= createRelationValue(LinkDesignEntity.caption);
		
	public TextDesign getCaption() {
		return caption.get();
	}
	
	public void setCaption(TextDesign newValue) {
		caption.set(newValue);
	}
	
	public final RelationValue<LinkDesign, EventDesign> event
		= createRelationValue(LinkDesignEntity.event);
		
	public EventDesign getEvent() {
		return event.get();
	}
	
	public void setEvent(EventDesign newValue) {
		event.set(newValue);
	}

	// Reverse relations

}
