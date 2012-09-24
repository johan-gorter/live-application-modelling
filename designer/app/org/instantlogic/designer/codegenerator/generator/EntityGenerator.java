package org.instantlogic.designer.codegenerator.generator;


import java.util.Collections;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.DataTypeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.StaticInstanceDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel;
import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel.Attribute;
import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel.StaticInstance;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class EntityGenerator extends AbstractGenerator {

	public EntityDesign entityDesign;
	
	public EntityGenerator(EntityDesign entityDesign) {
		this.entityDesign = entityDesign;
	}
	
	@Override
	public void update(GeneratedClassModels context) {
		if (observations!=null && !observations.isOutdated()) return;

		entityDesign.getMetadata().getCaseAdministration().startRecordingObservations();
		
		EntityClassModel model = initModel();

		model.rootPackageName = context.rootPackageName;
		if (entityDesign.getExtendsFrom()!=null) {
			model.extendsFrom = entityDesign.getExtendsFrom().getTechnicalNameCapitalized();
		}
		for (EntityDesign extension : entityDesign.getExtensions()) {
			model.extensions.add(extension.getTechnicalNameCapitalized());
		}
		for (AttributeDesign attributeDesign: entityDesign.getAttributes()) {
			EntityClassModel.Attribute attribute = new EntityClassModel.Attribute();
			attribute.name = attributeDesign.getName();
			attribute.technicalName = attributeDesign.getTechnicalName();
			attribute.javaIdentifier = attributeDesign.getJavaIdentifier();
			setDatatype(attribute, attributeDesign.getDataType());
			attribute.itemClassName = attributeDesign.getDataType().getJavaClassName();
			attribute.multivalue = (attributeDesign.getDataType().getMultivalue()==Boolean.TRUE);
			if (attribute.multivalue) {
				attribute.className="org.instantlogic.fabric.value.Multi<"+attribute.itemClassName+">";
			} else {
				attribute.className=attribute.itemClassName;
			}
			attribute.readonly = (attributeDesign.getReadOnly()==Boolean.TRUE);
			TextTemplateDesign question = attributeDesign.getQuestion();
			if (question!=null) {
				attribute.question = TextGenerator.generate(question, model);
			}
			TextTemplateDesign explanation = attributeDesign.getExplanation();
			if (explanation!=null) {
				attribute.explanation = TextGenerator.generate(explanation, model);
			}
			if (attributeDesign.getRelevance()!=null) {
				attribute.relevanceDeductionIndex = model.addDeductionScheme(DeductionSchemeGenerator.generate(model.rootPackageName, attributeDesign.getRelevance()));
			}
			if (attributeDesign.getRule()!=null) {
				attribute.ruleDeductionIndex = model.addDeductionScheme(DeductionSchemeGenerator.generate(model.rootPackageName, attributeDesign.getRule()));
			}
			if (attributeDesign.getDefault()!=null) {
				attribute.defaultDeductionIndex = model.addDeductionScheme(DeductionSchemeGenerator.generate(model.rootPackageName, attributeDesign.getDefault()));
			}
			model.attributes.add(attribute);
		}
		for (RelationDesign relationDesign: entityDesign.getRelations()) {
			EntityClassModel.Relation relation = new EntityClassModel.Relation();
			relation.name = relationDesign.getName();
			relation.technicalName = relationDesign.getTechnicalName();
			relation.javaIdentifier = relationDesign.getJavaIdentifier();
			relation.multivalue = (relationDesign.getDataType().getMultivalue()==Boolean.TRUE);
			relation.readonly = (relationDesign.getReadOnly()==Boolean.TRUE);
			relation.owner = (relationDesign.getOwner()==Boolean.TRUE);
			relation.autoCreate = (relationDesign.getAutoCreate()==Boolean.TRUE);
			relation.item = relationDesign.getTo().getTechnicalNameCapitalized();
			relation.to = model.rootPackageName+"."+relation.item;
			if (relation.multivalue) {
				relation.to = "org.instantlogic.fabric.value.Multi<"+relation.to+">";
			}
			relation.reverseName=relationDesign.getReverseName();
			relation.reverseJavaIdentifier = relationDesign.getReverseJavaIdentifier();
			if (relationDesign.getRule()!=null) {
				relation.ruleDeductionIndex = model.addDeductionScheme(DeductionSchemeGenerator.generate(model.rootPackageName, relationDesign.getRule()));
			}
			
			model.relations.add(relation);
		}
		for (RelationDesign relationDesign: entityDesign.getReverseRelations()) {
			if (relationDesign.getReverseName()!=null) {
				EntityClassModel.Relation relation = new EntityClassModel.Relation();
				relation.name = relationDesign.getReverseName();
				relation.technicalName = relationDesign.getReverseTechnicalName();
				relation.javaIdentifier = relationDesign.getReverseJavaIdentifier();
				relation.multivalue = (relationDesign.getReverseMultivalue()==Boolean.TRUE);
				relation.reverseName = relationDesign.getTechnicalNameCapitalized();
				relation.reverseJavaIdentifier = relationDesign.getJavaIdentifier();
				relation.item = relationDesign.getFrom().getTechnicalNameCapitalized();
				relation.to = model.rootPackageName+"."+relation.item;
				if (relation.multivalue) {
					relation.to = "org.instantlogic.fabric.value.Multi<"+relation.to+">";
				}
				model.reverseRelations.add(relation);
			}
		}
		sortNames(model);
		for (StaticInstanceDesign staticInstanceDesign: entityDesign.getStaticInstances()) {
			StaticInstance staticInstance = new StaticInstance();
			staticInstance.name = staticInstanceDesign.getName();
			staticInstance.javaIdentifier = staticInstanceDesign.getJavaIdentifier();
			staticInstance.description = TextGenerator.generate(staticInstanceDesign.getDescription(), model);
			model.staticInstances.add(staticInstance);
		}
		this.observations = new ObservationsOutdatedObserver(entityDesign.getMetadata().getCaseAdministration().stopRecordingObservations(), null);
		context.updatedEntities.add(model);
	}

	private void setDatatype(Attribute attribute, DataTypeDesign dataType) {
		if (dataType.getDataCategory()!=null) {
			attribute.dataType.put("category", dataType.getDataCategory().getMetadata().getStaticName());
		}
		if (dataType.getPercentage() == Boolean.TRUE) {
			attribute.dataType.put("percentage", true);
		}
		if (dataType.getWholeNumber() == Boolean.TRUE) {
			attribute.dataType.put("wholeNumber", true);
		}
		if (dataType.getExactRounding() == Boolean.TRUE) {
			attribute.dataType.put("exactRounding", true);
		}
		if (dataType.getMultiLine() == Boolean.TRUE) {
			attribute.dataType.put("multiLine", true);
		}
		if (dataType.getFormatted() == Boolean.TRUE) {
			attribute.dataType.put("formatted", true);
		}
		// In the future: Unit-prefix, unit-suffix, decimalPlaces
	}

	private void sortNames(EntityClassModel model) {
		Collections.sort(model.attributes);
		Collections.sort(model.relations);
		Collections.sort(model.reverseRelations);
	}

	private EntityClassModel initModel() {
		EntityClassModel model = new EntityClassModel();
		model.name = entityDesign.getName();
		model.technicalNameCapitalized = entityDesign.getTechnicalNameCapitalized();
		model.isCustomized = entityDesign.getIsCustomized()==Boolean.TRUE;
		return model;
	}
	
	@Override
	public void delete(GeneratedClassModels context) {
		EntityClassModel model = initModel();
		context.deletedEntities.add(model);
	}

}
