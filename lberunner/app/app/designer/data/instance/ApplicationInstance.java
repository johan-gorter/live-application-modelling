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

public class ApplicationInstance 
	extends SimpleCaseInstance 
	implements Instance {

	public ApplicationInstance() {
		super(ApplicationEntity.INSTANCE);
	}

	// Attributes
	
	public final AttributeValue<ApplicationInstance, java.lang.String> name
		= createAttributeValue(ApplicationEntity.name);
	
	// Relations
	
	public final RelationValues<ApplicationInstance, EntityInstance> entities
		= createRelationValues(ApplicationEntity.entities);
	
	public final RelationValue<ApplicationInstance, EntityInstance> caseEntity
		= createRelationValue(ApplicationEntity.caseEntity);
	
	public final RelationValues<ApplicationInstance, FlowInstance> flows
		= createRelationValues(ApplicationEntity.flows);
	
	public final RelationValues<ApplicationInstance, ContainerInstance> containers
		= createRelationValues(ApplicationEntity.containers);
	
	public final RelationValues<ApplicationInstance, ButtonInstance> buttons
		= createRelationValues(ApplicationEntity.buttons);
	
	public final RelationValues<ApplicationInstance, FlowInstance> exposedFlows
		= createRelationValues(ApplicationEntity.exposedFlows);

	// Reverse relations

}
