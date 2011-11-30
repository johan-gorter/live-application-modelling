package lbe.engine.codegenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.designer.data.instance.ConceptInstance;
import app.designer.data.instance.EntityInstance;
import app.designer.data.instance.FlowEdgeInstance;
import app.designer.data.instance.FlowInstance;
import app.designer.data.instance.FlowNodeBaseInstance;
import app.designer.data.instance.FlowSourceInstance;
import app.designer.data.instance.PageInstance;
import app.designer.data.instance.SubFlowInstance;

public class FlowGenerator extends AbstractGenerator {

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

	public static class FlowSource {
		public String startEvent;
		public String endNode;
		public String endEvent;
		
		public String getEndNode() {
			return endNode;
		}
		public String getStartEvent() {
			return startEvent;
		}
		public String getEndEvent() {
			return endEvent;
		}
	}

	public static class FlowEdge {
		public String startNode;
		public String endNode;
		public String startEvent;
		public String endEvent;
		
		public String getStartNode() {
			return startNode;
		}
		public String getEndNode() {
			return endNode;
		}
		public String getStartEvent() {
			return startEvent;
		}
		public String getEndEvent() {
			return endEvent;
		}
	}

	private FlowInstance flowInstance;
	
	public FlowGenerator(FlowInstance flowInstance, String appName) {
		this.flowInstance = flowInstance;
		this.appname = appName;
	}
	
	public final List<FlowSource> sources = new ArrayList<FlowSource>();
	public final List<FlowNode> nodes = new ArrayList<FlowNode>();
	public final List<FlowEdge> edges = new ArrayList<FlowEdge>();
	public final List<String> parameters = new ArrayList<String>();
	
	private Map<String, PageGenerator> pageGenerators = new HashMap<String, PageGenerator>();
	private Map<String, SubFlowGenerator> subFlowGenerators = new HashMap<String, SubFlowGenerator>();

	public List<FlowNode> getNodes() {
		return nodes;
	}

	public List<FlowSource> getSources() {
		return sources;
	}

	public List<FlowEdge> getEdges() {
		return edges;
	}

	public List<String> getParameters() {
		return parameters;
	}

	@Override
	public void update(File applicationRoot) {
		if (observations!=null && !observations.isOutdated()) {
			updateAll(pageGenerators.values(), applicationRoot);
			updateAll(subFlowGenerators.values(), applicationRoot);
			return;
		}
		flowInstance.getCase().startRecordingObservations();

		String flowName = flowInstance.name.get();
		
		customization = flowInstance.customization.get();
		name = flowInstance.name.get();
		sources.clear();
		for (FlowSourceInstance source: flowInstance.sources.get()) {
			FlowSource flowSource = new FlowSource();
			flowSource.startEvent = source.startEvent.get()==null?null:source.startEvent.get().name.get();
			flowSource.endNode = source.endNode.get()==null?null:edgePoint(source.endNode.get());
			flowSource.endEvent = source.endEvent.get()==null?null:source.endEvent.get().name.get();
			sources.add(flowSource);
		}
		nodes.clear();
		for (FlowNodeBaseInstance nodeInstance: flowInstance.nodes.get()) {
			FlowNode node = new FlowNode();
			node.name = nodeInstance.name.get();
			node.type = nodeInstance.getModel().getName();
			nodes.add(node);
		}
		edges.clear();
		for (FlowEdgeInstance edgeInstance: flowInstance.edges.get()) {
			FlowEdge edge = new FlowEdge();
			edge.startNode = edgePoint(edgeInstance.startNode.get());
			if (edgeInstance.startEvent.get()!=null) {
				edge.startEvent = edgeInstance.startEvent.get().name.get();
			}
			edge.endNode = edgePoint(edgeInstance.endNode.get());
			if (edgeInstance.endEvent.get()!=null) {
				edge.endEvent = edgeInstance.endEvent.get().name.get();
			}
			edges.add(edge);
		}
		parameters.clear();
		for (EntityInstance selectInstance: flowInstance.parameters.get()) {
			parameters.add(selectInstance.name.get());
		}

		AbstractGenerator.generateFile(AbstractGenerator.flowTemplate, this, "flow", name, "Flow", appname, applicationRoot);
		
		List<ConceptInstance> newPages = updateGenerators(pageGenerators, getPages(flowInstance.nodes.get()), applicationRoot);
		for(ConceptInstance newPage : newPages) {
			PageGenerator pageGenerator = new PageGenerator((PageInstance)newPage, appname, flowName);
			pageGenerator.update(applicationRoot);
			pageGenerators.put(newPage.getName(), pageGenerator);
		}
		List<ConceptInstance> newSubFlows = updateGenerators(subFlowGenerators, getSubFlows(flowInstance.nodes.get()), applicationRoot);
		for(ConceptInstance newSubFlow : newSubFlows) {
			SubFlowGenerator subFlowGenerator = new SubFlowGenerator((SubFlowInstance)newSubFlow, appname, flowName);
			subFlowGenerator.update(applicationRoot);
			subFlowGenerators.put(newSubFlow.getName(), subFlowGenerator);
		}
		this.observations = flowInstance.getCase().stopRecordingObservations();
	}

	private List<SubFlowInstance> getSubFlows(List<FlowNodeBaseInstance> list) {
		ArrayList<SubFlowInstance> result = new ArrayList<SubFlowInstance>();
		for (FlowNodeBaseInstance node:list) {
			if (node instanceof SubFlowInstance) {
				result.add((SubFlowInstance) node);
			}
		}
		return result;
	}

	private List<PageInstance> getPages(List<FlowNodeBaseInstance> list) {
		ArrayList<PageInstance> result = new ArrayList<PageInstance>();
		for (FlowNodeBaseInstance node:list) {
			if (node instanceof PageInstance) {
				result.add((PageInstance) node);
			}
		}
		return result;
	}

	@Override
	public void delete(File applicationRoot) {
		AbstractGenerator.deleteFile("flow", name.toLowerCase(), "Flow", appname, applicationRoot);
		File dir =new File(applicationRoot,"flow/"+name.toLowerCase()); 
		purge(dir);
		dir.delete();
	}

	private static String edgePoint(FlowNodeBaseInstance flowNodeBaseInstance) {
		String name = flowNodeBaseInstance.name.get();
		String typeName = flowNodeBaseInstance.getModel().getName();
		return name+typeName+".INSTANCE";
	}
}
