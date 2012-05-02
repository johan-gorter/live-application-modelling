package org.instantlogic.designer.codegenerator.generator;

import org.instantlogic.designer.CompositeTemplateDesign;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.SharedTemplateDesign;
import org.instantlogic.designer.TextDesign;
import org.instantlogic.designer.WidgetTemplateDesign;
import org.instantlogic.designer.codegenerator.classmodel.AbstractClassModel;
import org.instantlogic.designer.codegenerator.classmodel.ContentModel;
import org.instantlogic.designer.codegenerator.classmodel.ContentModel.Category;

public abstract class ContentGenerator extends AbstractGenerator {

	public static ContentModel generate(FragmentTemplateDesign fragment, AbstractClassModel deductionHolder) {
		ContentModel model = new ContentModel();
		if (fragment instanceof CompositeTemplateDesign) {
			model.category = Category.Composite;
		} else if (fragment instanceof SharedTemplateDesign) {
			model.category = Category.Shared;
		} else {
			model.category = Category.Widget;
		}
		model.widgetName=fragment.getMetadata().getEntity().getName();
		if (model.widgetName.endsWith("Design")) {
			model.widgetName = model.widgetName.substring(0, model.widgetName.length()-6);
		}
		model.id=fragment.getMetadata().getInstanceLocalId();
		model.rootPackageName = deductionHolder.rootPackageName;
		model.isCustomized = fragment.getIsCustomized() == Boolean.TRUE;
		if (fragment instanceof SharedTemplateDesign) {
			model.name = ((SharedTemplateDesign) fragment).getSharedTemplateDefinition().getName();
		} else if (fragment instanceof WidgetTemplateDesign) {
			WidgetTemplateDesign field = (WidgetTemplateDesign) fragment;
		} else if (fragment instanceof TextDesign) {
			model.text = TextGenerator.generate((TextDesign)fragment, deductionHolder);
		} else if (fragment instanceof CompositeTemplateDesign) {
			CompositeTemplateDesign composite = (CompositeTemplateDesign) fragment;
			for (FragmentTemplateDesign child : composite.getChildren()) {
				model.children.add(generate(child, deductionHolder));
			}
			for (DeductionSchemeDesign selection : composite.getSelections()) {
				model.deductionIndex = deductionHolder.addDeductionScheme(DeductionSchemeGenerator.generate(deductionHolder.rootPackageName, selection));
				// TODO: allow more than 1 deductionIndex
			}
		}
		return model;
	}
}
