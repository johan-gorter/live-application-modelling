package org.instantlogic.designer.codegenerator.classmodel;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentModel {

	public enum Category {Shared, Composite, Widget}
	
	public Category category;
	// Text, Button, ...
	public String widgetName;
	public String answerWidgetName;

	//F1P2...
	public String id;

	public String rootPackageName;
	public String name;
	
	public TextModel text;

	public int deductionIndex;
	public String entity;
	public String attribute;
	public boolean required;
	public boolean readOnly;
	public String relationEntity;
	public String relationName;
	public String event;
	public boolean isCustomized;
	public String presentation;
	public final List<ContentModel> children = new ArrayList<ContentModel>();
	public String implementationClassName;
	
	public final Map<String, Object> staticWidgetData = new HashMap<String, Object>();
	
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

	public List<ContentModel> getChildren() {
		return children;
	}
	public TextModel getText() {
		return text;
	}
	public String getEvent() {
		return event;
	}
	public boolean getIsCustomized() {
		return isCustomized;
	}
	public String getPresentation() {
		return presentation;
	}
	public int getDeductionIndex() {
		return deductionIndex;
	}
	public String getEntity() {
		return entity;
	}
	public String getAttribute() {
		return attribute;
	}
	public String getImplementationClassName() {
		return implementationClassName;
	}
	public String getRootPackageName() {
		return rootPackageName;
	}
	public Category getCategory() {
		return category;
	}
	public String getWidgetName() {
		return widgetName;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAnswerWidgetName() {
		return answerWidgetName;
	}
	public Map<String, Object> getStaticWidgetData() {
		return staticWidgetData;
	}
}
