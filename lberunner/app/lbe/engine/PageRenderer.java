package lbe.engine;

import lbe.engine.ChangeContext.FieldChange;
import lbe.model.flow.Page;

public class PageRenderer {
	
	//TODO: inline in Case
	private PageRenderer(){}
	
	public static PageElement renderPage(FlowContext flowContext) {
		RenderContext renderContext = new RenderContext(flowContext);
		PageElement element = flowContext.getPage().render(renderContext);
		return element;
	}

	public static void submit(FlowContext flowContext, ChangeContext.FieldChange[] fieldChanges,
			String submit) {
		ChangeContext changeContext = new ChangeContext(flowContext, fieldChanges, submit);
		flowContext.getPage().changeValue(changeContext);
	}
}
