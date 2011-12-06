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

public class Design 
	extends SimpleInstance 
	implements Instance {

	public Design(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public Design(CaseInstance caseInstance, long id) {
		super(caseInstance, DesignEntity.INSTANCE, id);
	}
	
	protected Design(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<Design, java.lang.String> name
		= createAttributeValue(DesignEntity.name);
	
	public java.lang.String getName() {
		return name.get();
	}

	public void setName(java.lang.String newValue) {
		name.set(newValue);
	}
	
	public final ReadOnlyAttributeValue<Design, java.lang.Boolean> valid
		= createReadOnlyAttributeValue(DesignEntity.valid);
	
	public java.lang.Boolean getValid() {
		return valid.get();
	}

	
	public final AttributeValue<Design, java.lang.String> customization
		= createAttributeValue(DesignEntity.customization);
	
	public java.lang.String getCustomization() {
		return customization.get();
	}

	public void setCustomization(java.lang.String newValue) {
		customization.set(newValue);
	}
	
	// Relations

	// Reverse relations

}
