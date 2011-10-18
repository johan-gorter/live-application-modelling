package lbe.model.flow;

public class FlowEdge {
	private FlowNodeBase from;
	private String exitName;
	
	private FlowNodeBase to;
	private String entryName;
	
	
	public FlowEdge() {
	}

	public FlowEdge(FlowNodeBase from, String exitName, FlowNodeBase to, String entryName) {
		this.from = from;
		this.exitName = exitName;
		this.to = to;
		this.entryName = entryName;
	}
	
	public FlowNodeBase getFrom() {
		return from;
	}
	public void setFrom(FlowNodeBase from) {
		this.from = from;
	}
	public String getExitName() {
		return exitName;
	}
	public void setExitName(String exitName) {
		this.exitName = exitName;
	}
	public FlowNodeBase getTo() {
		return to;
	}
	public void setTo(FlowNodeBase to) {
		this.to = to;
	}
	public String getEntryName() {
		return entryName;
	}
	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}
}
