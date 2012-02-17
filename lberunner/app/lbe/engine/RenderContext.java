package lbe.engine;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.fabric.util.AbstractDeductionContext;


public class RenderContext extends AbstractDeductionContext{

	private final FlowContext flowContext;
	
	private List<Integer> lastIds = new ArrayList<Integer>(25);
	private final String pageCoordinates;

	public RenderContext(FlowContext flowContext, String pageCoordinates) {
		super(flowContext);
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

	public String getPageCoordinates() {
		return pageCoordinates;
	}

	public FlowContext getFlowContext() {
		return flowContext;
	}
}
