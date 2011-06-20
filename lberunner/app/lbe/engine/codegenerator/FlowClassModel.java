package lbe.engine.codegenerator;

import java.util.ArrayList;
import java.util.List;

public class FlowClassModel {

	public static class FlowNode {
		public String name;
		public String type;
		
		public String getName() {
			return name;
		}
		public String getType() {
			return type;
		}
	}

	public static class FlowEdge {
		public String from;
		public String to;
		
		public String getFrom() {
			return from;
		}
		public String getTo() {
			return to;
		}
	}
	
	public String appname;
	public String name;
	
	public final List<String> sources = new ArrayList<String>();
	public final List<String> sinks = new ArrayList<String>();
	public final List<FlowNode> nodes = new ArrayList<FlowNode>();
	public final List<FlowEdge> edges = new ArrayList<FlowEdge>();

	public String getAppname() {
		return appname;
	}

	public String getName() {
		return name;
	}

	public List<FlowNode> getNodes() {
		return nodes;
	}

	public List<String> getSources() {
		return sources;
	}

	public List<String> getSinks() {
		return sinks;
	}

	public List<FlowEdge> getEdges() {
		return edges;
	}
}
