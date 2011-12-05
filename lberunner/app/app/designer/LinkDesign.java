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

public class LinkDesign 
	extends PageFragmentDesign 
	implements Instance {

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
	
	public final RelationValue<LinkDesign, EventDesign> event
		= createRelationValue(LinkDesignEntity.event);

	// Reverse relations

}
