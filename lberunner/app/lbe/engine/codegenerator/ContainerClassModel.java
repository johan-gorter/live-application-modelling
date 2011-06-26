package lbe.engine.codegenerator;

import java.util.ArrayList;
import java.util.List;

public class ContainerClassModel {

	public static class Element {
		public String type;
		public String name;
		public String entity;
		public String attribute;
		public boolean required;
		public boolean readOnly;
		public String untranslated;
		public String caption;
		
		public String getType() {
			return type;
		}
		public String getEntity() {
			return entity;
		}
		public String getAttribute() {
			return attribute;
		}
		public boolean isRequired() {
			return required;
		}
		public boolean isReadOnly() {
			return readOnly;
		}
		public String getName() {
			return name;
		}
		public String getUntranslated() {
			return untranslated;
		}
		public String getCaption() {
			return caption;
		}
	}

	public String appname;
	public String name;
	
	public String display;
	public String relationEntity;
	public String relationName;
	
	public final List<Element> children = new ArrayList<Element>();
	public String subpackageName;

	public String getAppname() {
		return appname;
	}

	public String getName() {
		return name;
	}

	public List<Element> getChildren() {
		return children;
	}

	public String getDisplay() {
		return display;
	}

	public String getRelationEntity() {
		return relationEntity;
	}

	public String getRelationName() {
		return relationName;
	}

	public String getSubpackageName() {
		return subpackageName;
	}
}
