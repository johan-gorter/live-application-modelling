package lbe.engine.codegenerator;

import java.util.ArrayList;
import java.util.List;

import app.designer.ButtonDesign;
import app.designer.CompositePageFragmentDesign;
import app.designer.FieldDesign;
import app.designer.HeaderDesign;
import app.designer.LinkDesign;
import app.designer.PageCompositionDesign;
import app.designer.PageFragmentDesign;
import app.designer.SelectDesign;
import app.designer.SharedFragmentDesign;
import app.designer.TextDesign;

public class ContentClassModel {

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
	public String customization;
	public String presentation;
	public final List<ContentClassModel> children = new ArrayList<ContentClassModel>();
	
	public ContentClassModel(PageFragmentDesign fragment, AbstractGenerator deductionHolder) {
		type=fragment.getModel().getName();
		if (type.endsWith("Design")) {
			type = type.substring(0, type.length()-6);
		}
		presentation = fragment.getPresentation();
		customization = fragment.getCustomization();
		if (fragment instanceof SharedFragmentDesign) {
			name = fragment.getHolder().getName();
		} else if (fragment instanceof FieldDesign) {
			FieldDesign field = (FieldDesign) fragment;
			required = (field.required.get()== Boolean.TRUE);
			entity = field.attribute.get().entity.get().name.get();
			attribute = field.attribute.get().name.get();
			readOnly = (field.readOnly.get()==Boolean.TRUE);
		} else if (fragment instanceof TextDesign) {
			text = new TextGenerator((TextDesign)fragment, deductionHolder);
		} else if (fragment instanceof ButtonDesign) {
			ButtonDesign button = (ButtonDesign)fragment;
			text = new TextGenerator(button.caption.get(), deductionHolder);
			event = button.event.get()==null?null:button.event.get().name.get();
		} else if (fragment instanceof LinkDesign) {
			LinkDesign link = (LinkDesign)fragment;
			text = new TextGenerator(link.caption.get(), deductionHolder);
			event = link.event.get()==null?null:link.event.get().name.get();
		} else if (fragment instanceof CompositePageFragmentDesign) {
			for (PageCompositionDesign composition : ((CompositePageFragmentDesign)fragment).items.get()) {
				children.add(new ContentClassModel(composition.pageFragment.get(), deductionHolder));
			}
			if (fragment instanceof HeaderDesign) {
				text = new TextGenerator(((HeaderDesign)fragment).text.get(), deductionHolder);
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

	public List<ContentClassModel> getChildren() {
		return children;
	}
	public TextGenerator getText() {
		return text;
	}
	public String getEvent() {
		return event;
	}
	public String getCustomization() {
		return customization;
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
