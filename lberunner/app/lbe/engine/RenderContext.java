package lbe.engine;

import java.util.ArrayList;
import java.util.List;

import lbe.instance.Instance;
import lbe.instance.value.ReadOnlyAttributeValue;
import lbe.instance.value.ReadOnlyRelationValue;
import lbe.model.Attribute;
import lbe.model.Entity;
import lbe.model.Relation;

public class RenderContext {

	private final FlowContext flowContext;
	
	private List<Integer> lastIds = new ArrayList<Integer>(25);
	private final List<Instance> activeInstances = new ArrayList<Instance>(10);
	private final String pageCoordinates;

	public RenderContext(FlowContext flowContext, String pageCoordinates) {
		this.pageCoordinates = pageCoordinates;
		this.flowContext = flowContext;
		nextIdLevel();
	}

	public CaseData getCaseData() {
		return flowContext.getCaseData();
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
		return flowContext.getCaseId();
	}

	public String getLanguage() {
		return "en-US";
	}

	public Instance pushRelation(Relation<Instance, ? extends Instance, ? extends Instance> relation) {
		ReadOnlyRelationValue<Instance, ? extends Instance> value = (ReadOnlyRelationValue<Instance, ? extends Instance>) getAttributeValue(relation);
		Instance instance = value.get();
		if (instance==null) {
			throw new RuntimeException("Relation yielded unknown");
		}
		pushActiveInstance(instance);
		return instance;
	}
	
	public void popInstance(Instance instance) {
		popActiveInstance(instance);
	}

	public <I extends Instance, Value extends Object> Value getValue(Attribute<I, Value, ? extends Object> attribute) {
		return getAttributeValue(attribute).get();
	}
	
	public void pushActiveInstance(Instance instance) {
		this.activeInstances.add(instance);
	}
	
	public void popActiveInstance(Instance instance) {
		if (this.activeInstances.size()<=0) {
			throw new RuntimeException("Asymmetric push/pop");
		}
		Instance removed = this.activeInstances.remove(this.activeInstances.size()-1);
		if (removed !=instance) {
			throw new RuntimeException("Asymmetric push/pop");
		}
	}
	
	@SuppressWarnings("unchecked")
	public <I extends Instance, Value extends Object> ReadOnlyAttributeValue<I, Value> getAttributeValue(Attribute<I, Value, ? extends Object> attribute) {
		Entity entity = attribute.getEntity();
		I instance = (I) getActiveInstance(entity);
		return attribute.get(instance);
	}

	private Instance getActiveInstance(Entity entity) {
		for (int i=activeInstances.size()-1;i>=0;i--) {
			Instance instance = activeInstances.get(i);
			if (instance.getModel()==entity) {
				return instance;
			}
		}
		return flowContext.getActiveInstance(entity);
	}
	

	public String getPageCoordinates() {
		return pageCoordinates;
	}

	public FlowContext getFlowContext() {
		return flowContext;
	}
}
