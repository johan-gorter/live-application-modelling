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

public class EntityDesign 
	extends Design 
	implements Instance {

	public EntityDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public EntityDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, EntityDesignEntity.INSTANCE, id);
	}
	
	protected EntityDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<EntityDesign, EntityDesign> extendsFrom
		= createRelationValue(EntityDesignEntity.extendsFrom);
		
	public EntityDesign getExtendsFrom() {
		return extendsFrom.get();
	}
	
	public void setExtendsFrom(EntityDesign newValue) {
		extendsFrom.set(newValue);
	}
	
	public final RelationValues<EntityDesign, AttributeDesign> attributes
		= createRelationValues(EntityDesignEntity.attributes);
		
	public List<AttributeDesign> getAttributes() {
		return attributes.get();
	}
	
	public void setAttributes(List<AttributeDesign> newValue) {
		attributes.set(newValue);
	}
	
	public final RelationValues<EntityDesign, RelationDesign> relations
		= createRelationValues(EntityDesignEntity.relations);
		
	public List<RelationDesign> getRelations() {
		return relations.get();
	}
	
	public void setRelations(List<RelationDesign> newValue) {
		relations.set(newValue);
	}

	// Reverse relations
	
	public final ReadOnlyRelationValue<EntityDesign, ApplicationDesign> application
		= createReverseRelationValue(EntityDesignEntity.application);

	public ApplicationDesign getApplication() {
		return application.get();
	}

	
	public final ReadOnlyRelationValue<EntityDesign, ApplicationDesign> caseEntityInApplication
		= createReverseRelationValue(EntityDesignEntity.caseEntityInApplication);

	public ApplicationDesign getCaseEntityInApplication() {
		return caseEntityInApplication.get();
	}

	
	public final ReadOnlyRelationValues<EntityDesign, EntityDesign> extensions
		= createReverseRelationValues(EntityDesignEntity.extensions);

	public List<EntityDesign> getExtensions() {
		return extensions.get();
	}

	
	public final ReadOnlyRelationValues<EntityDesign, RelationDesign> reverseRelations
		= createReverseRelationValues(EntityDesignEntity.reverseRelations);

	public List<RelationDesign> getReverseRelations() {
		return reverseRelations.get();
	}

	
	public final ReadOnlyRelationValues<EntityDesign, EventDesign> parameterInEvent
		= createReverseRelationValues(EntityDesignEntity.parameterInEvent);

	public List<EventDesign> getParameterInEvent() {
		return parameterInEvent.get();
	}

	
	public final ReadOnlyRelationValues<EntityDesign, FlowDesign> parameterInFlows
		= createReverseRelationValues(EntityDesignEntity.parameterInFlows);

	public List<FlowDesign> getParameterInFlows() {
		return parameterInFlows.get();
	}


}
