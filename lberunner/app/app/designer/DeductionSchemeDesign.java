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
