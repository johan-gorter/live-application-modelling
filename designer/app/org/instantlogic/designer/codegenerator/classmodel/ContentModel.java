package org.instantlogic.designer.codegenerator.classmodel;


import java.util.ArrayList;
import java.util.List;

import org.instantlogic.designer.codegenerator.generator.TextGenerator;

public class ContentModel {

	public String type;
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
	
	public String getType() {
		return type;
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

	public String getName() {
		return name;
	}
	public String getImplementationClassName() {
		return implementationClassName;
	}
}
