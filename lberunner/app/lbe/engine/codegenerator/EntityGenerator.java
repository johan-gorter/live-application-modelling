package lbe.engine.codegenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lbe.engine.codegenerator.EntityGenerator.Attribute.DomainEntry;
import app.designer.AttributeDesign;
import app.designer.DomainEntryDesign;
import app.designer.EntityDesign;
import app.designer.RelationDesign;
import app.designer.TextDesign;

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
		
		public String customization;
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
		public String getCustomization() {
			return customization;
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
	
	public EntityGenerator(EntityDesign entityDesign, String appname) {
		this.entityDesign = entityDesign;
		this.appname = appname;
	}
	
	public boolean caseEntity;
	public String extendsFrom;
	public final List<Attribute> attributes = new ArrayList<Attribute>();
	public final List<Relation> relations = new ArrayList<Relation>();
	public final List<Relation> reverseRelations = new ArrayList<Relation>();
	public String applicationName;
	
	public List<Attribute> getAttributes() {
		return attributes;
	}
	public List<Relation> getRelations() {
		return relations;
	}
	public List<Relation> getReverseRelations() {
		return reverseRelations;
	}
	public boolean isCaseEntity() {
		return caseEntity;
	}
	public String getExtendsFrom() {
		return extendsFrom;
	}
	public String getApplicationName() {
		return applicationName;
	}

	@Override
	public void update(File applicationRoot) {
		if (observations!=null && !observations.isOutdated()) return;
		clearDeductionSchemes();
		entityDesign.getCase().startRecordingObservations();
		
		name=entityDesign.name.get();
		customization = entityDesign.customization.get();
		caseEntity = (entityDesign.caseEntityInApplication.get()!=null);
		applicationName = entityDesign.application.get().name.get();
		if (entityDesign.extendsFrom.get()!=null) {
			extendsFrom = entityDesign.extendsFrom.get().name.get();
		}
		attributes.clear();
		for (AttributeDesign attributeDesign: entityDesign.attributes.get()) {
			Attribute attribute = new Attribute();
			attribute.name = attributeDesign.name.get();
			attribute.customization = attributeDesign.customization.get();
			attribute.itemClassName = attributeDesign.className.get();
			attribute.multivalue = (attributeDesign.multivalue.get()==Boolean.TRUE);
			if (attribute.multivalue) {
				attribute.className="List<"+attribute.itemClassName+">";
			} else {
				attribute.className=attribute.itemClassName;
			}
			attribute.readonly = (attributeDesign.readOnly.get()==Boolean.TRUE);
			TextDesign question = attributeDesign.question.get();
			if (question!=null) {
				attribute.question = new TextGenerator(question, this);
			}
			TextDesign explanation = attributeDesign.explanation.get();
			if (explanation!=null) {
				attribute.explanation = new TextGenerator(explanation, this);
			}
			List<DomainEntryDesign> domain = attributeDesign.domain.get();
			if (domain.size()>0) {
				attribute.domain = generateDomain(domain);
			}
			if (attributeDesign.getRule()!=null) {
				attribute.ruleDeductionIndex = addDeductionScheme(attributeDesign.getRule());
			}
			attributes.add(attribute);
		}
		relations.clear();
		for (RelationDesign relationDesign: entityDesign.relations.get()) {
			Relation relation = new Relation();
			relation.name = relationDesign.name.get();
			relation.multivalue = (relationDesign.multivalue.get()==Boolean.TRUE);
			relation.readonly = (relationDesign.readOnly.get()==Boolean.TRUE);
			relation.owner = (relationDesign.owner.get()==Boolean.TRUE);
			relation.autoCreate = (relationDesign.autoCreate.get()==Boolean.TRUE);
			relation.item = relationDesign.to.get().name.get();
			relation.to = relation.multivalue?"List<"+relation.item+">":relation.item;
			relation.reverseName=relationDesign.reverseName.get();
			if (relationDesign.getRule()!=null) {
				relation.ruleDeductionIndex = addDeductionScheme(relationDesign.getRule());
			}
			
			relations.add(relation);
		}
		reverseRelations.clear();
		for (RelationDesign relationDesign: entityDesign.reverseRelations.get()) {
			Relation relation = new Relation();
			relation.name = relationDesign.reverseName.get();
			relation.multivalue = (relationDesign.reverseMultivalue.get()==Boolean.TRUE);
			relation.reverseName = relationDesign.name.get();
			relation.item = relationDesign.from.get().name.get();
			relation.to = relation.multivalue?"List<"+relation.item+">":relation.item;
			reverseRelations.add(relation);
		}
		AbstractGenerator.generateFile(AbstractGenerator.entityTemplate, this, "entity", name, "Entity", appname, applicationRoot);
		AbstractGenerator.generateFile(AbstractGenerator.instanceTemplate, this, null, name, "", appname, applicationRoot);
		
		this.observations = entityDesign.getCase().stopRecordingObservations();
	}
	
	@Override
	public void delete(File applicationRoot) {
		AbstractGenerator.deleteFile("entity", name, "Entity", appname, applicationRoot);
		AbstractGenerator.deleteFile(null, name, "Instance", appname, applicationRoot);
	}
	
	private List<DomainEntry> generateDomain(List<DomainEntryDesign> domain) {
		List<DomainEntry> result = new ArrayList<DomainEntry>();
		for (DomainEntryDesign entry: domain) {
			DomainEntry resultEntry = new DomainEntry();
			resultEntry.name = entry.name.get();
			resultEntry.display = new TextGenerator(entry.display.get(), this);
			result.add(resultEntry);
		}
		return result;
	}

}
