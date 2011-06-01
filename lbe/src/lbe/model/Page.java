package lbe.model;

import lbe.page.ChangeContext;
import lbe.page.PageElement;
import lbe.page.RenderContext;

public abstract class Page extends FlowNodeBase {
	
	public class PageRootParamsElement {
		public String integerformat = "#0";
		public String numberformat = "#0.000";
		public String currencyformat = "#0.00";
		public String percentageformat = "#0.0";
	}
	
	public class PageRootElement extends PageElement {
		public String caseId;
		public int caseVersion;
		public PageRootParamsElement params;
		public String language;
	}

	public abstract PageElementBase[] getRootContainers();

	public PageElement render(final RenderContext renderContext) {
		PageRootElement result = new PageRootElement();
		result.caseId = renderContext.getCaseId();
		result.caseVersion = renderContext.getCaseData().getVersion();
		result.language = renderContext.getLanguage();
		result.params = new PageRootParamsElement();
		result.elementType = "page";
		result.id = getName();
		result.name = getName();
		PageElement[] contentElements = Container.renderChildren(renderContext, getRootContainers());
		result.content = contentElements;
		return result;
	}

	public void changeValue(ChangeContext changeContext) {
		Container.changeValue(changeContext, getRootContainers());
	}

}
