package app.designer.data.instance;

import java.util.List;

import app.designer.*;
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
		super(ApplicationEntity.INSTANCE, DesignerApplication.INSTANCE);
	}

	// Attributes
	
	public final AttributeValue<ApplicationInstance, java.lang.String> name
		= createAttributeValue(ApplicationEntity.name);
	
	public java.lang.String getName() {
		return name.get();
	}

	
	public final AttributeValue<ApplicationInstance, java.lang.String> customization
		= createAttributeValue(ApplicationEntity.customization);
	
	public java.lang.String getCustomization() {
		return customization.get();
	}

	
	// Relations
	
	public final RelationValues<ApplicationInstance, EntityInstance> entities
		= createRelationValues(ApplicationEntity.entities);
	
	public final RelationValue<ApplicationInstance, EntityInstance> caseEntity
		= createRelationValue(ApplicationEntity.caseEntity);
	
	public final RelationValues<ApplicationInstance, FlowInstance> flows
		= createRelationValues(ApplicationEntity.flows);
	
	public final RelationValues<ApplicationInstance, EventInstance> events
		= createRelationValues(ApplicationEntity.events);
	
	public final RelationValues<ApplicationInstance, FlowInstance> exposedFlows
		= createRelationValues(ApplicationEntity.exposedFlows);
	
	public final RelationValue<ApplicationInstance, SharedInstance> shared
		= createRelationValue(ApplicationEntity.shared);

	// Reverse relations

}
