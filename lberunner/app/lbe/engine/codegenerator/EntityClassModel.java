package lbe.engine.codegenerator;

import java.util.ArrayList;
import java.util.List;

import lbe.engine.codegenerator.EntityClassModel.Attribute.DomainEntry;

public class EntityClassModel {

	public static class Attribute {

		public static class DomainEntry {
			public String name;
			public String display;
			
			public String getName() {
				return name;
			}
			public String getDisplay() {
				return display;
			}
		}
		
		public String name;
		public String className;
		public String itemClassName;
		public String question;
		public boolean multivalue;
		public boolean readonly;
		public String explanation;
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
		public String getQuestion() {
			return question;
		}
		public List<DomainEntry> getDomain() {
			return domain;
		}
		public String getItemClassName() {
			return itemClassName;
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
	
	public boolean caseEntity;
	public String appname;
	public String name;
	public String extendsFrom;
	public final List<Attribute> attributes = new ArrayList<Attribute>();
	public final List<Relation> relations = new ArrayList<Relation>();
	public final List<Relation> reverseRelations = new ArrayList<Relation>();
	
	public String getAppname() {
		return appname;
	}
	public String getName() {
		return name;
	}
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
}
