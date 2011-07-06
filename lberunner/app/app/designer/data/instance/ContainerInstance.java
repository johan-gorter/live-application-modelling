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

public class ContainerInstance 
	extends PageElementBaseInstance 
	implements Instance {

	public ContainerInstance(CaseInstance caseInstance) {
		super(caseInstance, ContainerEntity.INSTANCE);
	}
	
	protected ContainerInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	// Attributes
	
	// Relations
	
	public final RelationValues<ContainerInstance, ContainerItemInstance> items
		= createRelationValues(ContainerEntity.items);
	
	public final RelationValue<ContainerInstance, RelationInstance> relation
		= createRelationValue(ContainerEntity.relation);
	
	public final RelationValue<ContainerInstance, TextInstance> display
		= createRelationValue(ContainerEntity.display);

	// Reverse relations
	
	public final ReadOnlyRelationValue<ContainerInstance, ToolboxInstance> toolbox
		= createReverseRelationValue(ContainerEntity.toolbox);
	
	public final ReadOnlyRelationValue<ContainerInstance, PageInstance> rootContainerInPage
		= createReverseRelationValue(ContainerEntity.rootContainerInPage);

}