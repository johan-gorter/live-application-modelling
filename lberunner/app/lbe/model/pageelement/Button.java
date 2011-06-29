package lbe.model.pageelement;

import lbe.engine.ChangeContext;
import lbe.engine.PageElement;
import lbe.engine.RenderContext;

public abstract class Button extends PageElementBase {

	@Override
	public String getElementType() {
		return "button";
	}

	@Override
	public PageElement render(RenderContext context) {
		PageElement result = super.render(context);
		Text caption = getCaption();
		if (caption!=null) {
			result.display = caption.renderText(context);
		}
		return result;
	}

	public abstract Text getCaption();

	public abstract String getTrigger();

	@Override
	public void changeValue(ChangeContext changeContext) {
		String id = getName()+"@"+changeContext.nextId();
		
		if (id.equals(changeContext.getSubmit())) {
			changeContext.getFlowContext().setTrigger(getTrigger());
		}
	}
	
}
