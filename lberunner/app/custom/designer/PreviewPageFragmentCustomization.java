package custom.designer;

import app.designer.ButtonDesign;
import app.designer.ConstantTextDesign;
import app.designer.FieldDesign;
import app.designer.HeaderDesign;
import app.designer.PageFragmentDesign;
import app.designer.TextDesign;
import app.designer.entity.PageFragmentDesignEntity;
import lbe.engine.PageElement;
import lbe.engine.RenderContext;
import lbe.instance.Instance;
import lbe.model.pageelement.PageFragment;
import lbe.model.pageelement.impl.ConstantText;

public class PreviewPageFragmentCustomization extends PageFragment {

	@Override
	public PageElement render(RenderContext context) {
		PageFragmentDesign design = (PageFragmentDesign) context.getSelectedInstance(PageFragmentDesignEntity.INSTANCE);
		PageElement result = new PageElement();
		result.elementType = "container";
		result.name = design.getName();
		if (design.getPresentation()!=null) {
			result.presentationStyles = design.getPresentation().split(" ");
		}
		result.id = result.name+"@"+context.nextId();
		result.readonly = true;
		if (design instanceof FieldDesign) {
			transformToField(result, (FieldDesign)design);
		} else if (design instanceof HeaderDesign) {
			transformToHeader(result, (HeaderDesign)design);
		} else if (design instanceof ButtonDesign) {
			transformToButton(result, (ButtonDesign)design);
		}
		return result;
	}
	
	private void transformToButton(PageElement result, ButtonDesign design) {
		result.id="button-"+result.id;
		result.elementType="button";
		result.display = previewText(design.getCaption());
	}

	private void transformToHeader(PageElement result, HeaderDesign design) {
		result.id = "header-"+result.id;
		result.display = previewText(design.getText());
	}

	private void transformToField(PageElement result, FieldDesign design) {
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

	@Override
	public String getElementType() {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public String getName() {
		return null;
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
	
}
