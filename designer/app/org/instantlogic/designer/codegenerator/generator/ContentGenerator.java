package org.instantlogic.designer.codegenerator.generator;

import org.instantlogic.designer.ButtonDesign;
import org.instantlogic.designer.CompositeTemplateDesign;
import org.instantlogic.designer.CustomPageFragmentDesign;
import org.instantlogic.designer.WidgetTemplateDesign;
import org.instantlogic.designer.HeaderDesign;
import org.instantlogic.designer.LinkDesign;
import org.instantlogic.designer.PageCompositionDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.SelectDesign;
import org.instantlogic.designer.SharedFragmentDesign;
import org.instantlogic.designer.TextDesign;
import org.instantlogic.designer.codegenerator.classmodel.AbstractClassModel;
import org.instantlogic.designer.codegenerator.classmodel.ContentModel;
import org.instantlogic.designer.codegenerator.classmodel.ContentModel.Category;

public abstract class ContentGenerator extends AbstractGenerator {

	public static ContentModel generate(FragmentTemplateDesign fragment, AbstractClassModel deductionHolder) {
		ContentModel model = new ContentModel();
		if (fragment instanceof CompositeTemplateDesign) {
			model.category = Category.Composite;
		} else if (fragment instanceof SharedFragmentDesign) {
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
		model.presentation = fragment.getPresentation();
		model.isCustomized = fragment.getIsCustomized() == Boolean.TRUE;
		if (fragment instanceof SharedFragmentDesign) {
			model.name = ((SharedFragmentDesign) fragment).getPageFragmentHolder().getName();
		} else if (fragment instanceof WidgetTemplateDesign) {
			WidgetTemplateDesign field = (WidgetTemplateDesign) fragment;
			model.required = (field.getRequired()== Boolean.TRUE);
			model.entity = field.getAttribute().getBelongsToEntity().getName();
			model.attribute = field.getAttribute().getName();
			model.readOnly = (field.getReadOnly()==Boolean.TRUE);
		} else if (fragment instanceof TextDesign) {
			model.text = TextGenerator.generate((TextDesign)fragment, deductionHolder);
		} else if (fragment instanceof ButtonDesign) {
			ButtonDesign button = (ButtonDesign)fragment;
			model.text = TextGenerator.generate(button.getCaption(), deductionHolder);
			model.event = button.getEvent()==null?null:deductionHolder.getRootPackageName()+".event."+button.getEvent().getName();
		} else if (fragment instanceof LinkDesign) {
			LinkDesign link = (LinkDesign)fragment;
			model.text = TextGenerator.generate(link.getCaption(), deductionHolder);
			model.event = link.getEvent()==null?null:deductionHolder.getRootPackageName()+".event."+link.getEvent().getName();
		} else if (fragment instanceof CompositeTemplateDesign) {
			for (PageCompositionDesign composition : ((CompositeTemplateDesign)fragment).getItems()) {
				model.children.add(generate(composition.getPageFragment(), deductionHolder));
			}
			if (fragment instanceof HeaderDesign) {
				model.text = TextGenerator.generate(((HeaderDesign)fragment).getText(), deductionHolder);
			}
			if (fragment instanceof SelectDesign) {
				SelectDesign selectFragment = (SelectDesign)fragment;
				model.deductionIndex = deductionHolder.addDeductionScheme(DeductionSchemeGenerator.generate(deductionHolder.rootPackageName, selectFragment.getDeduction()));
			}
			if (fragment instanceof CustomPageFragmentDesign) {
				model.implementationClassName = ((CustomPageFragmentDesign)fragment).getImplementationClassName(); 
			}
		}
		return model;
	}
}
