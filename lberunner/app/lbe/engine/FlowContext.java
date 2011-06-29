package lbe.engine;

import java.util.ArrayList;
import java.util.List;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.model.Entity;
import lbe.model.flow.Flow;
import lbe.model.flow.FlowNodeBase;
import lbe.model.flow.Page;

public class FlowContext {

	private static class NodeStackNode {
		
		public final Flow flow;
		public final List<Instance> activeInstances = new ArrayList<Instance>(10);
		
		private NodeStackNode(Flow flow) {
			this.flow = flow;
		}
		
		public Instance getActiveInstance(Entity entity) {
			for (Instance active: activeInstances) {
				if (active.getModel()==entity) {
					return active;
				}
			}
			return null;
		}

		public void popActiveInstance(Instance instance) {
			Instance removed = this.activeInstances.remove(this.activeInstances.size()-1);
			if (removed !=instance) {
				throw new RuntimeException("Asymmetric push/pop");
			}
		}
	}
	
	private final CaseData caseData;
	private final String caseId;
	private final List<NodeStackNode> stack = new ArrayList<NodeStackNode>(10);
	private String trigger;

	private Page page;
	private PageCoordinates pageCoordinates;

	
	public FlowContext(Flow startFlow, CaseData caseData, String caseId) {
		this.caseData = caseData;
		this.caseId = caseId;
		NodeStackNode nodeStackNode = new NodeStackNode(startFlow);
		nodeStackNode.activeInstances.add(caseData.getCaseInstance());
		stack.add(nodeStackNode);
	}
	
	public void pushActiveInstance(Instance instance) {
		getStackTop().activeInstances.add(instance);
	}

	private NodeStackNode getStackTop() {
		return this.stack.get(stack.size()-1);
	}
	
	public void popActiveInstance(Instance instance) {
		getStackTop().popActiveInstance(instance);
	}
	
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public PageCoordinates getPageCoordinates() {
		return pageCoordinates;
	}

	public void setPageCoordinates(PageCoordinates pageCoordinates) {
		this.pageCoordinates = pageCoordinates;
	}
	
	public boolean isReady() {
		return page!=null;
	}

	public CaseData getCaseData() {
		return caseData;
	}

	public String getCaseId() {
		return caseId;
	}

	public void pushActiveInstances(List<Long> activateInstances) {
		CaseInstance caseInstance = caseData.getCaseInstance();
		for (long id: activateInstances) {
			pushActiveInstance(caseInstance.getInstanceById(id));
		}
		throw new UnsupportedOperationException();
	}

	public Instance getActiveInstance(Entity entity) {
		for (int i=stack.size()-1;i>=0;i--) {
			Instance instance = stack.get(i).getActiveInstance(entity);
			if (instance!=null) {
				return instance;
			}
		}
		throw new RuntimeException("No active instance of entity "+entity.getName());
	}

	public String getTrigger() {
		return trigger;
	}

	public void setTrigger(String trigger) {
		this.trigger = trigger;
	}

	public void flow() {
		Page currentPage = getPage();
		setPage(null);
		String currentTrigger = getTrigger();
		setTrigger(null);
		do {
			currentTrigger = getStackTop().flow.flow(currentPage, currentTrigger, this);
		} while (getPage()==null);
	}
}
