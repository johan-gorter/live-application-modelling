package app.designer;

import java.util.List;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.impl.SimpleInstance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;
import org.instantlogic.fabric.value.ReadOnlyRelationValues;
import org.instantlogic.fabric.value.RelationValues;

import app.designer.entity.DeductionDesignEntity;

public class DeductionDesign 
	extends SimpleInstance 
	implements Instance {

	public DeductionDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public DeductionDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, DeductionDesignEntity.INSTANCE, id);
	}
	
	protected DeductionDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<DeductionDesign, java.lang.Boolean> multivalue
		= createAttributeValue(DeductionDesignEntity.multivalue);
	
	public java.lang.Boolean getMultivalue() {
		return multivalue.get();
	}

	public void setMultivalue(java.lang.Boolean newValue) {
		multivalue.set(newValue);
	}
	
	public final AttributeValue<DeductionDesign, java.lang.String> className
		= createAttributeValue(DeductionDesignEntity.className);
	
	public java.lang.String getClassName() {
		return className.get();
	}

	public void setClassName(java.lang.String newValue) {
		className.set(newValue);
	}
	
	public final AttributeValue<DeductionDesign, java.lang.String> customization
		= createAttributeValue(DeductionDesignEntity.customization);
	
	public java.lang.String getCustomization() {
		return customization.get();
	}

	public void setCustomization(java.lang.String newValue) {
		customization.set(newValue);
	}
	
	// Relations
	
	public final RelationValues<DeductionDesign, DeductionDesign> inputs
		= createRelationValues(DeductionDesignEntity.inputs);
		
	public List<DeductionDesign> getInputs() {
		return inputs.get();
	}
	
	public void setInputs(List<DeductionDesign> newValue) {
		inputs.set(newValue);
	}

	// Reverse relations
	
	public final ReadOnlyRelationValue<DeductionDesign, DeductionSchemeDesign> scheme
		= createReverseRelationValue(DeductionDesignEntity.scheme);

	public DeductionSchemeDesign getScheme() {
		return scheme.get();
	}

	
	public final ReadOnlyRelationValue<DeductionDesign, DeductionSchemeDesign> schemeOutput
		= createReverseRelationValue(DeductionDesignEntity.schemeOutput);

	public DeductionSchemeDesign getSchemeOutput() {
		return schemeOutput.get();
	}

	
	public final ReadOnlyRelationValues<DeductionDesign, DeductionDesign> outputs
		= createReverseRelationValues(DeductionDesignEntity.outputs);

	public List<DeductionDesign> getOutputs() {
		return outputs.get();
	}


}
