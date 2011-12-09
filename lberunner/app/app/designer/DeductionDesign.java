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
