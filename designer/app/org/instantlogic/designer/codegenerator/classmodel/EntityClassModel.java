package org.instantlogic.designer.codegenerator.classmodel;

import java.util.ArrayList;
import java.util.List;

public class EntityClassModel extends AbstractClassModel {

	public static class Attribute implements Comparable<Attribute>{

		public static class DomainEntry {
			public String name;
			public TextModel display;
			
			public String getName() {
				return name;
			}
			public TextModel getDisplay() {
				return display;
			}
		}
		
		public String name;
		public String technicalName;
		public String javaIdentifier;
		public String className;
		public String itemClassName;
		public TextModel question;
		public boolean multivalue;
		public boolean readonly;
		public TextModel explanation;
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
		public TextModel getQuestion() {
			return question;
		}
		public TextModel getExplanation() {
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
		@Override
		public int compareTo(Attribute o) {
			return this.name.compareTo(o.name);
		}
		public String getTechnicalName() {
			return technicalName;
		}
		public String getJavaIdentifier() {
			return javaIdentifier;
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

	public String extendsFrom;
	public final List<Attribute> attributes = new ArrayList<Attribute>();
	public final List<Relation> relations = new ArrayList<Relation>();
	public final List<Relation> reverseRelations = new ArrayList<Relation>();
	
	private String internalName;
	private String internalEntityName;
	public String technicalNameCapitalized;
	
	
	
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
	public String getInternalName() {
		if (internalName==null) {
			internalName = getRootPackageInternalPrefix()+technicalNameCapitalized;
		}
		return internalName;
	}
	public String getInternalEntityName() {
		if (internalEntityName==null) {
			internalEntityName = getRootPackageInternalPrefix()+"entity/"+technicalNameCapitalized+"Entity";
		}
		return internalEntityName;
	}
	public String getTechnicalNameCapitalized() {
		return technicalNameCapitalized;
	}
	
}
