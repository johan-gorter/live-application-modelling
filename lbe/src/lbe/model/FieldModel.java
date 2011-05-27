package lbe.model;

import lbe.page.ChangeContext;
import lbe.page.PageElement;
import lbe.page.RenderContext;

public abstract class FieldModel extends PageElementModelBase {
	
	public FieldModel() {}
	
	@Override
	public String getName() {
		return getAttribute().getName();
	}
	
	@Override
	public String getElementType() {
		return "field";
	}
	
	@Override
	public PageElement render(RenderContext context) {
		PageElement result = super.render(context);
		AttributeModel attribute = getAttribute();
		result.datatype = attribute.getDatatype();
		result.value = context.getValue(attribute);
		result.required = isRequired();
		result.question = getQuestion(context);
		result.explain = getExplain(context);
		result.multivalue = attribute.isMultivalue()?Boolean.TRUE:null;
		result.domain = attribute.getDomain(context);
		return result;
	}
	
	@Override
	public void changeValue(ChangeContext changeContext) {
		String id = getName()+"@"+changeContext.nextId();
		if (id.equals(changeContext.getPageElementId())) {
			changeContext.setValue(getAttribute(), changeContext.getValue());
		}
	}

	public abstract AttributeModel getAttribute();
	
	public abstract boolean isRequired();
	
	private String getExplain(RenderContext context) {
		return getAttribute().getExplain(context);
	}

	private String getQuestion(RenderContext context) {
		return getAttribute().getQuestion(context);
	}

}
