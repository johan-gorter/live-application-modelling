package org.instantlogic.designer.codegenerator.generator;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.designer.CompositeTemplateDesign;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.SharedTemplateDesign;
import org.instantlogic.designer.WidgetChildList;
import org.instantlogic.designer.WidgetTemplateDesign;
import org.instantlogic.designer.WidgetText;
import org.instantlogic.designer.WidgetValue;
import org.instantlogic.designer.codegenerator.classmodel.AbstractClassModel;
import org.instantlogic.designer.codegenerator.classmodel.ContentModel;
import org.instantlogic.designer.codegenerator.classmodel.ContentModel.Category;

public abstract class ContentGenerator extends AbstractGenerator {

	public static ContentModel generate(FragmentTemplateDesign fragment, AbstractClassModel deductionHolder) {
		ContentModel model = new ContentModel();
		model.id=fragment.getMetadata().getInstanceId();
		model.rootPackageName = deductionHolder.rootPackageName;
		model.isCustomized = fragment.getIsCustomized() == Boolean.TRUE;
		if (fragment instanceof CompositeTemplateDesign) {
			model.category = Category.Composite;
			CompositeTemplateDesign composite = (CompositeTemplateDesign) fragment;
			for (FragmentTemplateDesign child : composite.getChildren()) {
				model.children.add(generate(child, deductionHolder));
			}
			for (DeductionSchemeDesign selection : composite.getSelections()) {
				model.deductionIndex = deductionHolder.addDeductionScheme(DeductionSchemeGenerator.generate(deductionHolder.rootPackageName, selection));
				// TODO: allow more than 1 deductionIndex
			}
		} else if (fragment instanceof SharedTemplateDesign) {
			model.category = Category.Shared;
			model.name = ((SharedTemplateDesign) fragment).getSharedTemplateDefinition().getName();
		} else {
			WidgetTemplateDesign widgetTemplate = (WidgetTemplateDesign) fragment;
			model.category = Category.Widget;
			model.widgetName= widgetTemplate.getWidgetTypeName();
			for (WidgetValue value : widgetTemplate.getValues()) {
				int deductionIndex = deductionHolder.addDeductionScheme(DeductionSchemeGenerator.generate(deductionHolder.rootPackageName, value.getDeduction()));
				model.values.put(value.getName(), deductionIndex);
			}
			for (WidgetText text : widgetTemplate.getTexts()) {
				model.texts.put(text.getName(), TextGenerator.generate(text.getText(), deductionHolder));
			}
			for (WidgetChildList childList : widgetTemplate.getChildLists()) {
				List<ContentModel> children = new ArrayList<ContentModel>();
				for (FragmentTemplateDesign child : childList.getChildren()) {
					children.add(generate(child, deductionHolder));
				}
				model.childLists.put(childList.getName(), children);
			}
		}
		return model;
	}
}
