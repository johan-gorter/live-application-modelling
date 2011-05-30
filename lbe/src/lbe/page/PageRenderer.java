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

	public static void submit(String caseId, CaseData caseData, Session session, ChangeContext.FieldChange[] fieldChanges,
			String submit) {
		ChangeContext changeContext = new ChangeContext(caseId, caseData, session, fieldChanges, submit);
		session.getCurrentPage().changeValue(changeContext);
	}
}
