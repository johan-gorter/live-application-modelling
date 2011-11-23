package lbe.engine.codegenerator;

import java.util.ArrayList;
import java.util.List;

public class ContentClassModel {

	public String type;

	public TextClassModel text;

	public String entity;
	public String attribute;
	public boolean required;
	public boolean readOnly;
	public String relationEntity;
	public String relationName;
	public String event;
	public String customization;
	public final List<ContentClassModel> children = new ArrayList<ContentClassModel>();
	
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

	public String getRelationEntity() {
		return relationEntity;
	}

	public String getRelationName() {
		return relationName;
	}

	public List<ContentClassModel> getChildren() {
		return children;
	}
	public TextClassModel getText() {
		return text;
	}
	public String getEvent() {
		return event;
	}
	public String getCustomization() {
		return customization;
	}
}
