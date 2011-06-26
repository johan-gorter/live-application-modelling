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

public class ContainerItemInstance 
	extends SimpleInstance 
	implements Instance {

	public ContainerItemInstance(CaseInstance caseInstance) {
		super(caseInstance, ContainerItemEntity.INSTANCE);
	}
	
	protected ContainerItemInstance(CaseInstance caseInstance, Entity model) {
		super(caseInstance, model);
	}

	// Attributes
	
	public final AttributeValues<ContainerItemInstance, java.lang.String> presentationStyles
		= createAttributeValues(ContainerItemEntity.presentationStyles);
	
	// Relations
	
	public final RelationValue<ContainerItemInstance, PageElementBaseInstance> element
		= createRelationValue(ContainerItemEntity.element);

	// Reverse relations
	
	public final ReadOnlyRelationValue<ContainerItemInstance, ContainerInstance> container
		= createReverseRelationValue(ContainerItemEntity.container);

}
