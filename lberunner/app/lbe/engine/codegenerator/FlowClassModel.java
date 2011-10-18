package lbe.engine.codegenerator;

import java.util.ArrayList;
import java.util.List;

import app.designer.data.instance.EntityInstance;

import lbe.model.Entity;

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
		public String entryName;
		public String exitName;
		
		public String getFrom() {
			return from;
		}
		public String getTo() {
			return to;
		}
		public String getEntryName() {
			return entryName;
		}
		public String getExitName() {
			return exitName;
		}
	}
	
	public String appname;
	public String name;
	
	public final List<String> sources = new ArrayList<String>();
	public final List<String> sinks = new ArrayList<String>();
	public final List<FlowNode> nodes = new ArrayList<FlowNode>();
	public final List<FlowEdge> edges = new ArrayList<FlowEdge>();
	public final List<String> parameters = new ArrayList<String>();

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

	public List<String> getParameters() {
		return parameters;
	}
}
