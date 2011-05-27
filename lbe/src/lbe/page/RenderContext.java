package lbe.page;

import java.util.ArrayList;
import java.util.List;

import lbe.CaseData;
import lbe.Session;
import lbe.instance.AttributeValue;
import lbe.instance.Instance;
import lbe.model.AttributeModel;
import lbe.model.RelationModel;

//TODO: active instances
public class RenderContext {

	private final CaseData caseData;
	private final Session session;
	private final String caseId;
	
	private List<Integer> lastIds = new ArrayList<Integer>(25);

	public RenderContext(String caseId, CaseData caseData, Session session) {
		this.caseId = caseId;
		this.caseData = caseData;
		this.session = session;
		nextIdLevel();
	}

	public CaseData getCaseData() {
		return caseData;
	}

	public Session getSession() {
		return session;
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
		for (Integer id: lastIds) {
			if (result.length()>0) {
				result.append("-");
			}
			result.append(id);
		}
		return result.toString();
	}

	public String getCaseId() {
		return caseId;
	}

	public String getLanguage() {
		return "en-US";
	}

	public Instance pushRelation(RelationModel<Instance, Instance> relation) {
		AttributeValue<Instance, Instance> value = caseData.getValue(relation);
		Instance instance = value.get();
		if (instance==null) {
			throw new RuntimeException("Relation yielded unknown");
		}
		caseData.pushActiveInstance(instance);
		return instance;
	}
	
	public void popInstance(Instance instance) {
		caseData.popActiveInstance(instance);
	}

	public <I extends Instance, Value extends Object> Value getValue(AttributeModel<I, Value> attribute) {
		return caseData.getValue(attribute).get();
	}
}
