package lbe.page;

import java.util.Date;

import lbe.CaseData;
import lbe.Session;
import lbe.model.PageModel;

public class PageRenderer {
	
	private PageRenderer(){}
	
	public static Page renderPage(String caseId, CaseData data, Session session) {
		RenderContext renderContext = new RenderContext(caseId, data, session);
		PageElement element = session.getCurrentPage().render(renderContext);
		
		Page page = new Page();
		page.setStructure(element);
		page.setCaseVersion(data.getVersion());
		return page;
	}
}
