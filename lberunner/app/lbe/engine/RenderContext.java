package lbe.engine;

import java.util.ArrayList;
import java.util.List;

import lbe.instance.Instance;
import lbe.instance.value.ReadOnlyRelationValue;
import lbe.instance.value.RelationValue;
import lbe.instance.value.impl.AttributeValueImpl;
import lbe.model.Attribute;
import lbe.model.Relation;

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

	public Instance pushRelation(Relation<Instance, ? extends Instance, ? extends Instance> relation) {
		ReadOnlyRelationValue<Instance, ? extends Instance> value = (ReadOnlyRelationValue<Instance, ? extends Instance>) caseData.getValue(relation);
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

	public <I extends Instance, Value extends Object> Value getValue(Attribute<I, Value, ? extends Object> attribute) {
		return caseData.getValue(attribute).get();
	}
}
