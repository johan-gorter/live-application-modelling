package org.instantlogic.designer.codegenerator.generator;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.designer.FragmentChildList;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.FragmentText;
import org.instantlogic.designer.FragmentValue;
import org.instantlogic.designer.SharedTemplateDesign;
import org.instantlogic.designer.codegenerator.classmodel.AbstractClassModel;
import org.instantlogic.designer.codegenerator.classmodel.ContentModel;
import org.instantlogic.designer.codegenerator.classmodel.ContentModel.Category;

public abstract class ContentGenerator extends AbstractGenerator {

	public static ContentModel generate(FragmentTemplateDesign fragment, AbstractClassModel deductionHolder) {
		ContentModel model = new ContentModel();
		model.id=fragment.getMetadata().getInstanceId();
		model.rootPackageName = deductionHolder.rootPackageName;
		model.isCustomized = fragment.getIsCustomized() == Boolean.TRUE;
		if (fragment instanceof SharedTemplateDesign) {
			model.category = Category.Shared;
			model.name = ((SharedTemplateDesign) fragment).getSharedTemplateDefinition().getName();
		} else {
			FragmentTemplateDesign fragmentTemplate = (FragmentTemplateDesign) fragment;
			model.category = Category.Widget;
			model.fragmentTypeName= fragmentTemplate.getFragmentTypeName();
			for (FragmentValue value : fragmentTemplate.getValues()) {
				int deductionIndex = deductionHolder.addDeductionScheme(DeductionSchemeGenerator.generate(deductionHolder.rootPackageName, value.getDeduction()));
				model.values.put(value.getName(), deductionIndex);
			}
			for (FragmentText text : fragmentTemplate.getTexts()) {
				model.texts.put(text.getName(), TextGenerator.generate(text.getText(), deductionHolder));
			}
			for (FragmentChildList childList : fragmentTemplate.getChildLists()) {
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
