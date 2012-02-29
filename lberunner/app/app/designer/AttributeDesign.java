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

public class AttributeDesign 
	extends Design 
	implements Instance {

	public AttributeDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public AttributeDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, AttributeDesignEntity.INSTANCE, id);
	}
	
	protected AttributeDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<AttributeDesign, java.lang.Boolean> readOnly
		= createAttributeValue(AttributeDesignEntity.readOnly);
	
	public java.lang.Boolean getReadOnly() {
		return readOnly.get();
	}

	public void setReadOnly(java.lang.Boolean newValue) {
		readOnly.set(newValue);
	}
	
	public final AttributeValue<AttributeDesign, java.lang.Boolean> multivalue
		= createAttributeValue(AttributeDesignEntity.multivalue);
	
	public java.lang.Boolean getMultivalue() {
		return multivalue.get();
	}

	public void setMultivalue(java.lang.Boolean newValue) {
		multivalue.set(newValue);
	}
	
	public final AttributeValue<AttributeDesign, java.lang.String> className
		= createAttributeValue(AttributeDesignEntity.className);
	
	public java.lang.String getClassName() {
		return className.get();
	}

	public void setClassName(java.lang.String newValue) {
		className.set(newValue);
	}
	
	// Relations
	
	public final RelationValue<AttributeDesign, TextDesign> question
		= createRelationValue(AttributeDesignEntity.question);
		
	public TextDesign getQuestion() {
		return question.get();
	}
	
	public void setQuestion(TextDesign newValue) {
		question.set(newValue);
	}
	
	public final RelationValue<AttributeDesign, TextDesign> explanation
		= createRelationValue(AttributeDesignEntity.explanation);
		
	public TextDesign getExplanation() {
		return explanation.get();
	}
	
	public void setExplanation(TextDesign newValue) {
		explanation.set(newValue);
	}
	
	public final RelationValues<AttributeDesign, DomainEntryDesign> domain
		= createRelationValues(AttributeDesignEntity.domain);
		
	public List<DomainEntryDesign> getDomain() {
		return domain.get();
	}
	
	public void setDomain(List<DomainEntryDesign> newValue) {
		domain.set(newValue);
	}
	
	public final RelationValue<AttributeDesign, DeductionSchemeDesign> relevance
		= createRelationValue(AttributeDesignEntity.relevance);
		
	public DeductionSchemeDesign getRelevance() {
		return relevance.get();
	}
	
	public void setRelevance(DeductionSchemeDesign newValue) {
		relevance.set(newValue);
	}
	
	public final RelationValue<AttributeDesign, DeductionSchemeDesign> rule
		= createRelationValue(AttributeDesignEntity.rule);
		
	public DeductionSchemeDesign getRule() {
		return rule.get();
	}
	
	public void setRule(DeductionSchemeDesign newValue) {
		rule.set(newValue);
	}
	
	public final RelationValue<AttributeDesign, DeductionSchemeDesign> _default
		= createRelationValue(AttributeDesignEntity._default);
		
	public DeductionSchemeDesign getDefault() {
		return _default.get();
	}
	
	public void setDefault(DeductionSchemeDesign newValue) {
		_default.set(newValue);
	}

	// Reverse relations
	
	public final ReadOnlyRelationValue<AttributeDesign, EntityDesign> entity
		= createReverseRelationValue(AttributeDesignEntity.entity);

	public EntityDesign getEntity() {
		return entity.get();
	}

	
	public final ReadOnlyRelationValues<AttributeDesign, AttributeDeductionDesign> attributeInDeductions
		= createReverseRelationValues(AttributeDesignEntity.attributeInDeductions);

	public List<AttributeDeductionDesign> getAttributeInDeductions() {
		return attributeInDeductions.get();
	}

	
	public final ReadOnlyRelationValues<AttributeDesign, FieldDesign> fields
		= createReverseRelationValues(AttributeDesignEntity.fields);

	public List<FieldDesign> getFields() {
		return fields.get();
	}


}
