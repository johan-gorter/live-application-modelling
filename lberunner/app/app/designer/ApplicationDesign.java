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

public class ApplicationDesign 
	extends SimpleCaseInstance 
	implements Instance {

	public ApplicationDesign() {
		super(ApplicationDesignEntity.INSTANCE, DesignerApplication.INSTANCE);
	}

	// Attributes
	
	public final AttributeValue<ApplicationDesign, java.lang.String> name
		= createAttributeValue(ApplicationDesignEntity.name);
	
	public java.lang.String getName() {
		return name.get();
	}

	
	public final AttributeValue<ApplicationDesign, java.lang.String> customization
		= createAttributeValue(ApplicationDesignEntity.customization);
	
	public java.lang.String getCustomization() {
		return customization.get();
	}

	
	// Relations
	
	public final RelationValues<ApplicationDesign, EntityDesign> entities
		= createRelationValues(ApplicationDesignEntity.entities);
	
	public final RelationValue<ApplicationDesign, EntityDesign> caseEntity
		= createRelationValue(ApplicationDesignEntity.caseEntity);
	
	public final RelationValues<ApplicationDesign, FlowDesign> flows
		= createRelationValues(ApplicationDesignEntity.flows);
	
	public final RelationValues<ApplicationDesign, EventDesign> events
		= createRelationValues(ApplicationDesignEntity.events);
	
	public final RelationValues<ApplicationDesign, FlowDesign> exposedFlows
		= createRelationValues(ApplicationDesignEntity.exposedFlows);
	
	public final RelationValue<ApplicationDesign, Shared> shared
		= createRelationValue(ApplicationDesignEntity.shared);

	// Reverse relations

}
