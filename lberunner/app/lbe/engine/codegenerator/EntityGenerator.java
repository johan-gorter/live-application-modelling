package lbe.engine.codegenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import app.designer.data.instance.AttributeInstance;
import app.designer.data.instance.DomainEntryInstance;
import app.designer.data.instance.EntityInstance;
import app.designer.data.instance.RelationInstance;
import app.designer.data.instance.TextInstance;

import lbe.engine.codegenerator.EntityGenerator.Attribute.DomainEntry;

public class EntityGenerator extends AbstractGenerator{

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
	
	public EntityInstance entityInstance;
	
	public EntityGenerator(EntityInstance entityInstance, String appname) {
		this.entityInstance = entityInstance;
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
		entityInstance.getCase().startRecordingObservations();
		
		name=entityInstance.name.get();
		customization = entityInstance.customization.get();
		caseEntity = (entityInstance.caseEntityInApplication.get()!=null);
		applicationName = entityInstance.application.get().name.get();
		if (entityInstance.extendsFrom.get()!=null) {
			extendsFrom = entityInstance.extendsFrom.get().name.get();
		}
		attributes.clear();
		for (AttributeInstance attributeInstance: entityInstance.attributes.get()) {
			Attribute attribute = new Attribute();
			attribute.name = attributeInstance.name.get();
			attribute.customization = attributeInstance.customization.get();
			attribute.itemClassName = attributeInstance.className.get();
			attribute.multivalue = (attributeInstance.multivalue.get()==Boolean.TRUE);
			if (attribute.multivalue) {
				attribute.className="List<"+attribute.itemClassName+">";
			} else {
				attribute.className=attribute.itemClassName;
			}
			attribute.readonly = (attributeInstance.readOnly.get()==Boolean.TRUE);
			TextInstance question = attributeInstance.question.get();
			if (question!=null) {
				attribute.question = generateText(question);
			}
			TextInstance explanation = attributeInstance.explanation.get();
			if (explanation!=null) {
				attribute.explanation = generateText(explanation);
			}
			List<DomainEntryInstance> domain = attributeInstance.domain.get();
			if (domain.size()>0) {
				attribute.domain = generateDomain(domain);
			}
			attributes.add(attribute);
		}
		relations.clear();
		for (RelationInstance relationInstance: entityInstance.relations.get()) {
			Relation relation = new Relation();
			relation.name = relationInstance.name.get();
			relation.multivalue = (relationInstance.multivalue.get()==Boolean.TRUE);
			relation.readonly = (relationInstance.readOnly.get()==Boolean.TRUE);
			relation.owner = (relationInstance.owner.get()==Boolean.TRUE);
			relation.autoCreate = (relationInstance.autoCreate.get()==Boolean.TRUE);
			relation.item = relationInstance.to.get().name.get();
			relation.to = relation.multivalue?"List<"+relation.item+"Instance>":relation.item+"Instance";
			relation.reverseName=relationInstance.reverseName.get();
			relations.add(relation);
		}
		reverseRelations.clear();
		for (RelationInstance relationInstance: entityInstance.reverseRelations.get()) {
			Relation relation = new Relation();
			relation.name = relationInstance.reverseName.get();
			relation.multivalue = (relationInstance.reverseMultivalue.get()==Boolean.TRUE);
			relation.reverseName = relationInstance.name.get();
			relation.item = relationInstance.entity.get().name.get();
			relation.to = relation.multivalue?"List<"+relation.item+"Instance>":relation.item+"Instance";
			reverseRelations.add(relation);
		}
		AbstractGenerator.generateFile(AbstractGenerator.entityTemplate, this, "data/entity", name, "Entity", appname, applicationRoot);
		AbstractGenerator.generateFile(AbstractGenerator.instanceTemplate, this, "data/instance", name, "Instance", appname, applicationRoot);
		
		this.observations = entityInstance.getCase().stopRecordingObservations();
	}
	
	@Override
	public void delete(File applicationRoot) {
		AbstractGenerator.deleteFile("data/entity", name, "Entity", appname, applicationRoot);
		AbstractGenerator.deleteFile("data/instance", name, "Instance", appname, applicationRoot);
	}
	
	private List<DomainEntry> generateDomain(List<DomainEntryInstance> domain) {
		List<DomainEntry> result = new ArrayList<DomainEntry>();
		for (DomainEntryInstance entry: domain) {
			DomainEntry resultEntry = new DomainEntry();
			resultEntry.name = entry.name.get();
			resultEntry.display = generateText(entry.display.get());
			result.add(resultEntry);
		}
		return result;
	}

}
