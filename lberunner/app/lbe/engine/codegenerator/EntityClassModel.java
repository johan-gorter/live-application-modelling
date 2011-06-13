package lbe.engine.codegenerator;

import java.util.ArrayList;
import java.util.List;

public class EntityClassModel {

	public static class Attribute {
		public String name;
		public String className;
		public boolean multivalue;
		public boolean readonly;
		
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
	}
	
	public static class Relation extends Attribute {
		public boolean owner;
		public String to;
		public String item;
		public String reverseName;
		
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
