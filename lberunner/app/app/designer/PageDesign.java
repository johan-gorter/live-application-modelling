package app.designer;

import java.util.List;

import app.designer.*;
import app.designer.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

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
