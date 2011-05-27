package lbe.model;

import lbe.page.ChangeContext;
import lbe.page.PageElement;
import lbe.page.RenderContext;

public abstract class PageModel extends FlowNodeModelBase {
	
	public class PageRootParamsElement {
		
	}
	
	public class PageRootElement extends PageElement {
		public String caseId;
		public int caseVersion;
		public PageRootParamsElement params;
		public String language;
	}

	public abstract PageElementModelBase[] getRootContainers();

	public PageElement render(final RenderContext renderContext) {
		PageRootElement result = new PageRootElement();
		result.caseId = renderContext.getCaseId();
		result.caseVersion = renderContext.getCaseData().getVersion();
		result.language = renderContext.getLanguage();
		result.params = new PageRootParamsElement();
		result.elementType = "page";
		result.id = getName();
		result.name = getName();
		PageElement[] contentElements = ContainerModel.renderChildren(renderContext, getRootContainers());
		result.content = contentElements;
		return result;
	}

	public void changeValue(ChangeContext changeContext) {
		ContainerModel.changeValue(changeContext, getRootContainers());
	}

}
