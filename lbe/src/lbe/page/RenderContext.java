package lbe.page;

import java.util.ArrayList;
import java.util.List;

import lbe.CaseData;
import lbe.Session;

//TODO: active instances
public class RenderContext {

	private final CaseData caseData;
	private final Session session;
	private final String caseId;
	
	private String idPrefix = null;
	private List<Integer> lastIds = new ArrayList<Integer>(25);

	public RenderContext(String caseId, CaseData caseData, Session session) {
		this.caseId = caseId;
		this.caseData = caseData;
		this.session = session;
	}

	public CaseData getCaseData() {
		return caseData;
	}

	public Session getSession() {
		return session;
	}

	public String initId(String pageName) {
		idPrefix = pageName;
		nextIdLevel();
		return pageName;
	}
	
	public void nextIdLevel() {
		lastIds.add(-1);
	}

	public void previousIdLevel() {
		lastIds.remove(lastIds.size()-1);
	}
	
	public String nextId() {
		int lastIndex = lastIds.size()-1;
		lastIds.set(lastIndex, lastIds.get(lastIndex)+1);
		StringBuilder result = new StringBuilder(); //We can optimize performance by reusing the StringBuilder
		result.append(idPrefix);
		for (Integer id: lastIds) {
			result.append("-");
			result.append(id);
		}
		return result.toString();
	}

	public String getCaseId() {
		return caseId;
	}
	
}
