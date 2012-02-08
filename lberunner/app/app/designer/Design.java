package app.designer;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.impl.SimpleInstance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;

import app.designer.entity.DesignEntity;

public class Design 
	extends SimpleInstance<Design> 
	implements Instance<Design> {

	public Design(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public Design(CaseInstance caseInstance, long id) {
		super(caseInstance, id);
	}
	
	protected Design(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, id);
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

	
	public final ReadOnlyAttributeValue<Design, java.lang.String> javaName
		= createReadOnlyAttributeValue(DesignEntity.javaName);
	
	public java.lang.String getJavaName() {
		return javaName.get();
	}

	
	public final AttributeValue<Design, java.lang.String> customization
		= createAttributeValue(DesignEntity.customization);
	
	public java.lang.String getCustomization() {
		return customization.get();
	}

	public void setCustomization(java.lang.String newValue) {
		customization.set(newValue);
	}

	@Override
	public Entity<Design> getModel() {
		return DesignEntity.INSTANCE;
	}
	
	// Relations

	// Reverse relations

}
