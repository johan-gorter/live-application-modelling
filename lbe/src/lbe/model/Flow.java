package lbe.model;

public abstract class Flow extends Model {
	
	/**
	 * Source as in a graph with source and sinks.
	 * 
	 * @return
	 */
	public abstract FlowNodeBase getStart();
	
	public abstract Page[] getPages();

	public abstract Flow[] getSubflows();

	/**
	 * Finds the page (pagePath is in the format subflowName.subflowName.pageName)
	 */
	public Page getPage(String pagePath) {
		String[] split = pagePath.split("\\.");
		Flow currentFlow = this;
		nextSubflow: for (int i=0;i<split.length-1;i++) {
			String flowName = split[i];
			for (Flow flow: getSubflows()) {
				if (flow.getName().equals(flowName)) {
					currentFlow = flow;
					continue nextSubflow;
				}
			}
			throw new RuntimeException("Subflow not found: "+flowName);
		}
		String pageName = split[split.length-1];
		for (Page page : currentFlow.getPages()) {
			if (page.getName().equals(pageName)) {
				return page;
			}
		}
		throw new RuntimeException("Page not found: "+pagePath);
	}
	
}
