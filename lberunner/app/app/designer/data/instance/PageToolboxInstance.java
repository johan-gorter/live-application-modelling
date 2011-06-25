package app.designer.data.instance;

import java.util.List;

import app.designer.data.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class PageToolboxInstance 
	extends SimpleInstance 
	implements Instance {

	public PageToolboxInstance(CaseInstance caseInstance) {
		super(caseInstance, PageToolboxEntity.INSTANCE);
	}
	
	protected PageToolboxInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	// Attributes
	
	// Relations
	
	public final RelationValues<PageToolboxInstance, ButtonInstance> buttons
		= createRelationValues(PageToolboxEntity.buttons);
	
	public final RelationValues<PageToolboxInstance, ContainerInstance> containers
		= createRelationValues(PageToolboxEntity.containers);
	
	public final RelationValues<PageToolboxInstance, TextInstance> texts
		= createRelationValues(PageToolboxEntity.texts);

	// Reverse relations
	
	public final ReadOnlyRelationValue<PageToolboxInstance, ApplicationInstance> application
		= createReverseRelationValue(PageToolboxEntity.application);

}
