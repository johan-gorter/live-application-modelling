package org.instantlogic.designer.codegenerator;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.DomainEntryDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.TextDesign;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;
import org.instantlogic.fabric.value.Multi;

public class EntityGenerator extends AbstractGenerator {

	public static class Attribute {

		public static class DomainEntry {
			public String name;
			public TextGenerator display;
			
			public String getName() {
				return name;
			}
			public TextGenerator getDisplay() {
				return display;
			}
		}
		
		public String name;
		public String className;
		public String itemClassName;
		public TextGenerator question;
		public boolean multivalue;
		public boolean readonly;
		public TextGenerator explanation;
		public List<DomainEntry> domain;
		public Integer relevanceDeductionIndex;
		public Integer ruleDeductionIndex;
		public Integer defaultDeductionIndex;
		
		public String getName() {
			return name;
		}
		public String getClassName() {
			return className;
		}
		public boolean isMultivalue() {
			return multivalue;
		}
		public boolean isReadonly() {
			return readonly;
		}
		public List<DomainEntry> getDomain() {
			return domain;
		}
		public String getItemClassName() {
			return itemClassName;
		}
		public TextGenerator getQuestion() {
			return question;
		}
		public TextGenerator getExplanation() {
			return explanation;
		}
		public Integer getRuleDeductionIndex() {
			return ruleDeductionIndex;
		}
		public Integer getDefaultDeductionIndex() {
			return defaultDeductionIndex;
		}
		public Integer getRelevanceDeductionIndex() {
			return relevanceDeductionIndex;
		}
	}
	
	public static class Relation extends Attribute {
		public boolean owner;
		public String to;
		public String item;
		public String reverseName;
		public boolean autoCreate;
		
		public boolean isOwner() {
			return owner;
		}

		public String getTo() {
			return to;
		}

		public String getItem() {
			return item;
		}

		public String getReverseName() {
			return reverseName;
		}

		public boolean isAutoCreate() {
			return autoCreate;
		}
	}
	
	public EntityDesign entityDesign;
	
	public EntityGenerator(EntityDesign entityDesign, String rootPackageName) {
		this.entityDesign = entityDesign;
		this.rootPackageName = rootPackageName;
	}
	
	public String extendsFrom;
	public final List<Attribute> attributes = new ArrayList<Attribute>();
	public final List<Relation> relations = new ArrayList<Relation>();
	public final List<Relation> reverseRelations = new ArrayList<Relation>();
	
	public List<Attribute> getAttributes() {
		return attributes;
	}
	public List<Relation> getRelations() {
		return relations;
	}
	public List<Relation> getReverseRelations() {
		return reverseRelations;
	}
	public String getExtendsFrom() {
		return extendsFrom;
	}

	@Override
	public void update(File applicationRoot) {
		if (observations!=null && !observations.isOutdated()) return;
		clearDeductionSchemes();
		entityDesign.getInstanceAdministration().startRecordingObservations();
		
		name = entityDesign.getName();
		isCustomized = entityDesign.getIsCustomized()==Boolean.TRUE;
		if (entityDesign.getExtendsFrom()!=null) {
			extendsFrom = entityDesign.getExtendsFrom().getName();
		}
		attributes.clear();
		for (AttributeDesign attributeDesign: entityDesign.getAttributes()) {
			Attribute attribute = new Attribute();
			attribute.name = javaSafeName(attributeDesign.getName());
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
				attribute.question = new TextGenerator(question, this);
			}
			TextDesign explanation = attributeDesign.getExplanation();
			if (explanation!=null) {
				attribute.explanation = new TextGenerator(explanation, this);
			}
			Multi<DomainEntryDesign> domain = attributeDesign.getDomain();
			if (domain.size()>0) {
				attribute.domain = generateDomain(domain);
			}
			if (attributeDesign.getRule()!=null) {
				attribute.ruleDeductionIndex = addDeductionScheme(attributeDesign.getRule());
			}
			attributes.add(attribute);
		}
		relations.clear();
		for (RelationDesign relationDesign: entityDesign.getRelations()) {
			Relation relation = new Relation();
			relation.name = javaSafeName(relationDesign.getName());
			relation.multivalue = (relationDesign.getMultivalue()==Boolean.TRUE);
			relation.readonly = (relationDesign.getReadOnly()==Boolean.TRUE);
			relation.owner = (relationDesign.getOwner()==Boolean.TRUE);
			relation.autoCreate = (relationDesign.getAutoCreate()==Boolean.TRUE);
			relation.item = relationDesign.getTo().getName();
			relation.to = rootPackageName+"."+relation.item;
			if (relation.multivalue) {
				relation.to = "org.instantlogic.fabric.value.Multi<"+relation.to+">";
			}
			relation.reverseName=relationDesign.getReverseName();
			if (relationDesign.getRule()!=null) {
				relation.ruleDeductionIndex = addDeductionScheme(relationDesign.getRule());
			}
			
			relations.add(relation);
		}
		reverseRelations.clear();
		for (RelationDesign relationDesign: entityDesign.getReverseRelations()) {
			Relation relation = new Relation();
			relation.name = javaSafeName(relationDesign.getReverseName());
			relation.multivalue = (relationDesign.getReverseMultivalue()==Boolean.TRUE);
			relation.reverseName = javaSafeName(relationDesign.getName());
			relation.item = relationDesign.getFrom().getName();
			relation.to = rootPackageName+"."+relation.item;
			if (relation.multivalue) {
				relation.to = "org.instantlogic.fabric.value.Multi<"+relation.to+">";
			}
			reverseRelations.add(relation);
		}
		AbstractGenerator.generateFile(AbstractGenerator.entityTemplate, this, "entity", name, "Entity", rootPackageName, applicationRoot, false);
		AbstractGenerator.generateFile(AbstractGenerator.instanceTemplate, this, null, name, "", rootPackageName, applicationRoot, this.isCustomized);
		
		this.observations = new ObservationsOutdatedObserver(entityDesign.getInstanceAdministration().stopRecordingObservations(), null);
	}
	
	@Override
	public void delete(File applicationRoot) {
		AbstractGenerator.deleteFile("entity", name, "Entity", rootPackageName, applicationRoot);
		AbstractGenerator.deleteFile(null, name, "Instance", rootPackageName, applicationRoot);
		AbstractGenerator.deleteFile(null, name, "AbstractInstance", rootPackageName, applicationRoot);
	}
	
	private List<EntityGenerator.Attribute.DomainEntry> generateDomain(Multi<DomainEntryDesign> domain) {
		List<EntityGenerator.Attribute.DomainEntry> result = new ArrayList<EntityGenerator.Attribute.DomainEntry>();
		for (DomainEntryDesign entry: domain) {
			EntityGenerator.Attribute.DomainEntry resultEntry = new EntityGenerator.Attribute.DomainEntry();
			resultEntry.name = entry.getName();
			resultEntry.display = new TextGenerator(entry.getDisplay(), this);
			result.add(resultEntry);
		}
		return result;
	}

}
