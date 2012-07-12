package org.instantlogic.designer.codegenerator.generator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.DomainEntryDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.TextDesign;
import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;
import org.instantlogic.fabric.value.Multi;

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
			model.extendsFrom = entityDesign.getExtendsFrom().getName();
		}
		for (AttributeDesign attributeDesign: entityDesign.getAttributes()) {
			EntityClassModel.Attribute attribute = new EntityClassModel.Attribute();
			attribute.name = attributeDesign.getName();
			attribute.technicalName = attributeDesign.getTechnicalName();
			attribute.javaIdentifier = attributeDesign.getJavaIdentifier();
			attribute.itemClassName = attributeDesign.getClassName();
			attribute.multivalue = (attributeDesign.getMultivalue()==Boolean.TRUE);
			if (attribute.multivalue) {
				attribute.className="org.instantlogic.fabric.value.Multi<"+attribute.itemClassName+">";
			} else {
				attribute.className=attribute.itemClassName;
			}
			attribute.readonly = (attributeDesign.getReadOnly()==Boolean.TRUE);
			TextDesign question = attributeDesign.getQuestion();
			if (question!=null) {
				attribute.question = TextGenerator.generate(question, model);
			}
			TextDesign explanation = attributeDesign.getExplanation();
			if (explanation!=null) {
				attribute.explanation = TextGenerator.generate(explanation, model);
			}
			Multi<DomainEntryDesign> domain = attributeDesign.getDomain();
			if (domain.size()>0) {
				attribute.domain = generateDomain(domain, model);
			}
			if (attributeDesign.getRule()!=null) {
				attribute.ruleDeductionIndex = model.addDeductionScheme(DeductionSchemeGenerator.generate(model.rootPackageName, attributeDesign.getRule()));
			}
			model.attributes.add(attribute);
		}
		for (RelationDesign relationDesign: entityDesign.getRelations()) {
			EntityClassModel.Relation relation = new EntityClassModel.Relation();
			relation.name = relationDesign.getName();
			relation.technicalName = relationDesign.getTechnicalName();
			relation.javaIdentifier = relationDesign.getJavaIdentifier();
			relation.multivalue = (relationDesign.getMultivalue()==Boolean.TRUE);
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
		sortNames(model);
		this.observations = new ObservationsOutdatedObserver(entityDesign.getMetadata().getCaseAdministration().stopRecordingObservations(), null);
		context.updatedEntities.add(model);
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
	
	private List<EntityClassModel.Attribute.DomainEntry> generateDomain(Multi<DomainEntryDesign> domain, EntityClassModel model) {
		List<EntityClassModel.Attribute.DomainEntry> result = new ArrayList<EntityClassModel.Attribute.DomainEntry>();
		for (DomainEntryDesign entry: domain) {
			EntityClassModel.Attribute.DomainEntry resultEntry = new EntityClassModel.Attribute.DomainEntry();
			resultEntry.name = entry.getName();
			resultEntry.display = TextGenerator.generate(entry.getDisplay(), model);
			result.add(resultEntry);
		}
		return result;
	}

	@Override
	public void delete(GeneratedClassModels context) {
		EntityClassModel model = initModel();
		context.deletedEntities.add(model);
	}

}
