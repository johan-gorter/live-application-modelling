package lbe.page;

import lbe.CaseData;
import lbe.Session;

public class PageRenderer {
	
	private PageRenderer(){}
	
	public static PageElement renderPage(String caseId, CaseData data, Session session) {
		RenderContext renderContext = new RenderContext(caseId, data, session);
		PageElement element = session.getCurrentPage().render(renderContext);
		return element;
	}
}
