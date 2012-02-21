package org.instantlogic.interaction.flow;

import org.instantlogic.interaction.page.CompositePageFragment;
import org.instantlogic.interaction.page.PageElement;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public abstract class Page extends FlowNodeBase {
	
	public abstract CompositePageFragment getRootContainer();

	public FlowEventOccurrence submit(ChangeContext changeContext) {
		return getRootContainer().submit(changeContext);
	}

	public PageElement render(final RenderContext renderContext) {
		PageRootElement result = new PageRootElement();
		result.caseId = renderContext.getCaseId();
		result.caseVersion = renderContext.getCaseInstance().getInstanceAdministration().getVersion();
		result.language = renderContext.getLanguage();
		result.params = new PageRootParamsElement();
		result.elementType = "page";
		result.id = renderContext.getPageCoordinates();
		result.name = getName();
		PageElement contentElements = getRootContainer().render(renderContext);
		contentElements.id = renderContext.getPageCoordinates()+"-root";
		result.content = new PageElement[]{contentElements};
		return result;
	}

	public class PageRootParamsElement {
		public String integerformat = "#0";
		public String numberformat = "#0.000";
		public String currencyformat = "#0.00";
		public String percentageformat = "#0.0";
	}
	
	public class PageRootElement extends PageElement {
		public String caseId;
		public long caseVersion;
		public PageRootParamsElement params;
		public String language;
	}
}
