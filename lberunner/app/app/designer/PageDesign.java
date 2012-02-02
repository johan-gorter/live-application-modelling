package app.designer;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.value.RelationValue;

import app.designer.entity.PageDesignEntity;

public class PageDesign 
	extends FlowNodeBaseDesign 
	implements Instance {

	public PageDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public PageDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, PageDesignEntity.INSTANCE, id);
	}
	
	protected PageDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<PageDesign, CompositePageFragmentDesign> content
		= createRelationValue(PageDesignEntity.content);
		
	public CompositePageFragmentDesign getContent() {
		return content.get();
	}
	
	public void setContent(CompositePageFragmentDesign newValue) {
		content.set(newValue);
	}

	// Reverse relations

}
