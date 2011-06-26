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

public class ToolboxInstance 
	extends SimpleInstance 
	implements Instance {

	public ToolboxInstance(CaseInstance caseInstance) {
		super(caseInstance, ToolboxEntity.INSTANCE);
	}
	
	protected ToolboxInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	// Attributes
	
	// Relations
	
	public final RelationValues<ToolboxInstance, ContainerInstance> containers
		= createRelationValues(ToolboxEntity.containers);
	
	public final RelationValues<ToolboxInstance, TextInstance> texts
		= createRelationValues(ToolboxEntity.texts);

	// Reverse relations
	
	public final ReadOnlyRelationValue<ToolboxInstance, ApplicationInstance> application
		= createReverseRelationValue(ToolboxEntity.application);

}
