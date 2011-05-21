package lbe.model;

import lbe.page.PageElement;
import lbe.page.RenderContext;

public abstract class PageModel extends FlowNodeModelBase {
	
	public abstract PageElementModelBase[] getRootContainers();

	public PageElement render(final RenderContext renderContext) {
		PageElement[] contentElements = ContainerModel.renderChildren(renderContext, getRootContainers());
		PageElement result = new PageElement() {
			public String caseId = renderContext.getCaseId();
			public int caseVersion = renderContext.getCaseData().getVersion();
		};
		result.elementType = "page";
		result.id = renderContext.initId(getName());
		result.content = contentElements;
		return result;
	}

}
