package org.instantlogic.designer.codegenerator;


import java.util.ArrayList;
import java.util.List;

import org.instantlogic.designer.ButtonDesign;
import org.instantlogic.designer.CompositePageFragmentDesign;
import org.instantlogic.designer.FieldDesign;
import org.instantlogic.designer.HeaderDesign;
import org.instantlogic.designer.LinkDesign;
import org.instantlogic.designer.PageCompositionDesign;
import org.instantlogic.designer.PageFragmentDesign;
import org.instantlogic.designer.SelectDesign;
import org.instantlogic.designer.SharedFragmentDesign;
import org.instantlogic.designer.TextDesign;

public class ContentGenerator {

	public String type;
	public String name;
	public TextGenerator text;

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
	public final List<ContentGenerator> children = new ArrayList<ContentGenerator>();
	
	public ContentGenerator(PageFragmentDesign fragment, AbstractGenerator deductionHolder) {
		type=fragment.getMetadata().getEntity().getName();
		if (type.endsWith("Design")) {
			type = type.substring(0, type.length()-6);
		}
		presentation = fragment.getPresentation();
		isCustomized = fragment.getIsCustomized();
		if (fragment instanceof SharedFragmentDesign) {
			name = fragment.getHolder().getName();
		} else if (fragment instanceof FieldDesign) {
			FieldDesign field = (FieldDesign) fragment;
			required = (field.getRequired()== Boolean.TRUE);
			entity = field.getAttribute().getBelongsToEntity().getName();
			attribute = field.getAttribute().getName();
			readOnly = (field.getReadOnly()==Boolean.TRUE);
		} else if (fragment instanceof TextDesign) {
			text = new TextGenerator((TextDesign)fragment, deductionHolder);
		} else if (fragment instanceof ButtonDesign) {
			ButtonDesign button = (ButtonDesign)fragment;
			text = new TextGenerator(button.getCaption(), deductionHolder);
			event = button.getEvent()==null?null:button.getEvent().getName();
		} else if (fragment instanceof LinkDesign) {
			LinkDesign link = (LinkDesign)fragment;
			text = new TextGenerator(link.getCaption(), deductionHolder);
			event = link.getEvent()==null?null:link.getEvent().getName();
		} else if (fragment instanceof CompositePageFragmentDesign) {
			for (PageCompositionDesign composition : ((CompositePageFragmentDesign)fragment).getItems()) {
				children.add(new ContentGenerator(composition.getPageFragment(), deductionHolder));
			}
			if (fragment instanceof HeaderDesign) {
				text = new TextGenerator(((HeaderDesign)fragment).getText(), deductionHolder);
			}
			if (fragment instanceof SelectDesign) {
				SelectDesign selectFragment = (SelectDesign)fragment;
				deductionIndex = deductionHolder.addDeductionScheme(selectFragment.getDeduction());
			}
		}
	}
	
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

	public List<ContentGenerator> getChildren() {
		return children;
	}
	public TextGenerator getText() {
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
}
