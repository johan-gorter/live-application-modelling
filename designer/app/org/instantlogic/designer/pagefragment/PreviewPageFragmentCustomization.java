package org.instantlogic.designer.pagefragment;


import org.instantlogic.designer.ButtonDesign;
import org.instantlogic.designer.ConstantTextDesign;
import org.instantlogic.designer.WidgetTemplateDesign;
import org.instantlogic.designer.HeaderDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.TextDesign;
import org.instantlogic.designer.entity.PageFragmentDesignEntity;
import org.instantlogic.interaction.page.Fragment;
import org.instantlogic.interaction.page.PageTemplateElement;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.util.RenderContext;

public class PreviewPageFragmentCustomization extends FragmentTemplate {

	@Override
	public Fragment render(RenderContext context) {
		FragmentTemplateDesign design = (FragmentTemplateDesign) context.getSelectedInstance(PageFragmentDesignEntity.INSTANCE);
		Fragment result = new Fragment();
		result.widget = design.getName();
		if (design.getPresentation()!=null) {
//			result.presentationStyles = design.getPresentation().split(" ");
		}
		if (design instanceof WidgetTemplateDesign) {
//			transformToField(result, (FieldDesign)design);
		} else if (design instanceof HeaderDesign) {
//			transformToHeader(result, (HeaderDesign)design);
		} else if (design instanceof ButtonDesign) {
//			transformToButton(result, (ButtonDesign)design);
		}
		return result;
	}
	
	private void transformToButton(PageTemplateElement result, ButtonDesign design) {
		result.id="button-"+result.id;
		result.elementType="button";
		result.display = previewText(design.getCaption());
	}

	private void transformToHeader(PageTemplateElement result, HeaderDesign design) {
		result.id = "header-"+result.id;
		result.display = previewText(design.getText());
	}

	private void transformToField(PageTemplateElement result, WidgetTemplateDesign design) {
		result.id = "field-"+result.id;
		result.elementType = "field";
		result.datatype = datatypeToString(design.getAttribute().getClassName());
		result.question = previewText(design.getAttribute().getQuestion());
	}

	private String previewText(TextDesign text) {
		if (text instanceof ConstantTextDesign) {
			return ((ConstantTextDesign)text).getUntranslated();
		}
		return "?";
	}

	private String datatypeToString(String className) {
		if ("java.lang.String".equals(className)) {
			return "text";
		}
		if ("java.lang.Double".equals(className)) {
			return "number";
		}
		return className.substring(className.lastIndexOf('.')+1).toLowerCase();
	}

	@Override
	public String getId() {
		return null;
	}
	
}
