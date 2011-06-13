package app.designerbootstrap.data.instance;

import java.util.List;

import app.designerbootstrap.data.entity.*;
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
	
	// Relations
	
	public final RelationValues<ApplicationInstance, EntityInstance> entities
		= createRelationValues(ApplicationEntity.entities);
	
	public final RelationValue<ApplicationInstance, EntityInstance> caseEntity
		= createRelationValue(ApplicationEntity.caseEntity);

	// Reverse relations

}
