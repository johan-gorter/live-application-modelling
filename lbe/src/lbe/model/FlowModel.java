package lbe.model;

public abstract class FlowModel extends ModelBase {
	
	/**
	 * Source as in a graph with source and sinks.
	 * 
	 * @return
	 */
	public abstract FlowNodeModelBase getStart();
	
	public abstract PageModel[] getPages();

	public abstract FlowModel[] getSubflows();

	/**
	 * Finds the page (pagePath is in the format subflowName.subflowName.pageName)
	 */
	public PageModel getPage(String pagePath) {
		String[] split = pagePath.split("\\.");
		FlowModel currentFlow = this;
		nextSubflow: for (int i=0;i<split.length-1;i++) {
			String flowName = split[i];
			for (FlowModel flow: getSubflows()) {
				if (flow.getName().equals(flowName)) {
					currentFlow = flow;
					continue nextSubflow;
				}
			}
			throw new RuntimeException("Subflow not found: "+flowName);
		}
		String pageName = split[split.length-1];
		for (PageModel page : currentFlow.getPages()) {
			if (page.getName().equals(pageName)) {
				return page;
			}
		}
		throw new RuntimeException("Page not found: "+pagePath);
	}
	
}
