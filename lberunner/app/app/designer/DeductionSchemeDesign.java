package app.designer;

import java.util.List;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.impl.SimpleInstance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;
import org.instantlogic.fabric.value.RelationValue;
import org.instantlogic.fabric.value.RelationValues;

import app.designer.entity.DeductionSchemeDesignEntity;

public class DeductionSchemeDesign 
	extends SimpleInstance 
	implements Instance {

	public DeductionSchemeDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public DeductionSchemeDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, DeductionSchemeDesignEntity.INSTANCE, id);
	}
	
	protected DeductionSchemeDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValues<DeductionSchemeDesign, DeductionDesign> deductions
		= createRelationValues(DeductionSchemeDesignEntity.deductions);
		
	public List<DeductionDesign> getDeductions() {
		return deductions.get();
	}
	
	public void setDeductions(List<DeductionDesign> newValue) {
		deductions.set(newValue);
	}
	
	public final RelationValue<DeductionSchemeDesign, DeductionDesign> output
		= createRelationValue(DeductionSchemeDesignEntity.output);
		
	public DeductionDesign getOutput() {
		return output.get();
	}
	
	public void setOutput(DeductionDesign newValue) {
		output.set(newValue);
	}

	// Reverse relations
	
	public final ReadOnlyRelationValue<DeductionSchemeDesign, AttributeDesign> relevanceOfAttribute
		= createReverseRelationValue(DeductionSchemeDesignEntity.relevanceOfAttribute);

	public AttributeDesign getRelevanceOfAttribute() {
		return relevanceOfAttribute.get();
	}

	
	public final ReadOnlyRelationValue<DeductionSchemeDesign, AttributeDesign> ruleOfAttribute
		= createReverseRelationValue(DeductionSchemeDesignEntity.ruleOfAttribute);

	public AttributeDesign getRuleOfAttribute() {
		return ruleOfAttribute.get();
	}

	
	public final ReadOnlyRelationValue<DeductionSchemeDesign, AttributeDesign> defaultOfAttribute
		= createReverseRelationValue(DeductionSchemeDesignEntity.defaultOfAttribute);

	public AttributeDesign getDefaultOfAttribute() {
		return defaultOfAttribute.get();
	}

	
	public final ReadOnlyRelationValue<DeductionSchemeDesign, FormattedValueDesign> templatedText
		= createReverseRelationValue(DeductionSchemeDesignEntity.templatedText);

	public FormattedValueDesign getTemplatedText() {
		return templatedText.get();
	}

	
	public final ReadOnlyRelationValue<DeductionSchemeDesign, SelectDesign> select
		= createReverseRelationValue(DeductionSchemeDesignEntity.select);

	public SelectDesign getSelect() {
		return select.get();
	}


}
