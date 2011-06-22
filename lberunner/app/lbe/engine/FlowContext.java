package lbe.engine;

import java.util.ArrayList;
import java.util.List;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.model.Entity;
import lbe.model.flow.Page;

public class FlowContext {

	private final CaseData caseData;
	private final String caseId;
	private final List<Instance> activeInstances = new ArrayList<Instance>(10);
	
	private Page page;
	private PageCoordinates pageCoordinates;

	
	public FlowContext(CaseData caseData, String caseId) {
		this.caseData = caseData;
		this.caseId = caseId;
		activeInstances.add(caseData.getCaseInstance());
	}
	
	public void pushActiveInstance(Instance instance) {
		this.activeInstances.add(instance);
	}
	
	public void popActiveInstance(Instance instance) {
		if (this.activeInstances.size()<=1) {// CaseInstance must remain at all times
			throw new RuntimeException("Asymmetric push/pop");
		}
		Instance removed = this.activeInstances.remove(this.activeInstances.size()-1);
		if (removed !=instance) {
			throw new RuntimeException("Asymmetric push/pop");
		}
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
		for (int i=activeInstances.size()-1;i>=0;i--) {
			Instance instance = activeInstances.get(i);
			if (instance.getModel()==entity) {
				return instance;
			}
		}
		throw new RuntimeException("No active instance of entity "+entity.getName());
	}
}
