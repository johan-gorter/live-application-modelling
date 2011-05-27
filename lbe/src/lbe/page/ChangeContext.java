package lbe.page;

import lbe.CaseData;
import lbe.Session;
import lbe.model.AttributeModel;

public class ChangeContext extends RenderContext {

	private String pageElementId;
	private Object value;

	public ChangeContext(String caseId, CaseData caseData, Session session, String pageElementId, Object value) {
		super(caseId, caseData, session);
		this.pageElementId = pageElementId;
		this.value = value;
	}

	public String getPageElementId() {
		return pageElementId;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(AttributeModel attribute, Object value) {
		getCaseData().getValue(attribute).set(value);
	}
	
}
