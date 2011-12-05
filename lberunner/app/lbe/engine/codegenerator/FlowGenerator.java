package lbe.engine.codegenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.designer.Concept;
import app.designer.EntityDesign;
import app.designer.FlowDesign;
import app.designer.FlowEdgeDesign;
import app.designer.FlowNodeBaseDesign;
import app.designer.FlowSourceDesign;
import app.designer.PageDesign;
import app.designer.SubFlowDesign;

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

	private FlowDesign flowDesign;
	
	public FlowGenerator(FlowDesign flowDesign, String appName) {
		this.flowDesign = flowDesign;
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
		flowDesign.getCase().startRecordingObservations();

		String flowName = flowDesign.name.get();
		
		customization = flowDesign.customization.get();
		name = flowDesign.name.get();
		sources.clear();
		for (FlowSourceDesign source: flowDesign.sources.get()) {
			FlowSource flowSource = new FlowSource();
			flowSource.startEvent = source.startEvent.get()==null?null:source.startEvent.get().name.get();
			flowSource.endNode = source.endNode.get()==null?null:edgePoint(source.endNode.get());
			flowSource.endEvent = source.endEvent.get()==null?null:source.endEvent.get().name.get();
			sources.add(flowSource);
		}
		nodes.clear();
		for (FlowNodeBaseDesign nodeDesign: flowDesign.nodes.get()) {
			FlowNode node = new FlowNode();
			node.name = nodeDesign.name.get();
			node.type = nodeDesign.getModel().getName();
			node.type = node.type.substring(0, node.type.length()-6); // remove Design
			nodes.add(node);
		}
		edges.clear();
		for (FlowEdgeDesign edgeDesign: flowDesign.edges.get()) {
			FlowEdge edge = new FlowEdge();
			edge.startNode = edgePoint(edgeDesign.startNode.get());
			if (edgeDesign.startEvent.get()!=null) {
				edge.startEvent = edgeDesign.startEvent.get().name.get();
			}
			edge.endNode = edgePoint(edgeDesign.endNode.get());
			if (edgeDesign.endEvent.get()!=null) {
				edge.endEvent = edgeDesign.endEvent.get().name.get();
			}
			edges.add(edge);
		}
		parameters.clear();
		for (EntityDesign selectDesign: flowDesign.parameters.get()) {
			parameters.add(selectDesign.name.get());
		}

		AbstractGenerator.generateFile(AbstractGenerator.flowTemplate, this, "flow", name, "Flow", appname, applicationRoot);
		if (applicationRoot!=null) {
			new File(new File(applicationRoot,"flow"), name.toLowerCase()).mkdirs();
		}
		
		List<Concept> newPages = updateGenerators(pageGenerators, getPages(flowDesign.nodes.get()), applicationRoot);
		for(Concept newPage : newPages) {
			PageGenerator pageGenerator = new PageGenerator((PageDesign)newPage, appname, flowName);
			pageGenerator.update(applicationRoot);
			pageGenerators.put(newPage.getName(), pageGenerator);
		}
		List<Concept> newSubFlows = updateGenerators(subFlowGenerators, getSubFlows(flowDesign.nodes.get()), applicationRoot);
		for(Concept newSubFlow : newSubFlows) {
			SubFlowGenerator subFlowGenerator = new SubFlowGenerator((SubFlowDesign)newSubFlow, appname, flowName);
			subFlowGenerator.update(applicationRoot);
			subFlowGenerators.put(newSubFlow.getName(), subFlowGenerator);
		}
		this.observations = flowDesign.getCase().stopRecordingObservations();
	}

	private List<SubFlowDesign> getSubFlows(List<FlowNodeBaseDesign> list) {
		ArrayList<SubFlowDesign> result = new ArrayList<SubFlowDesign>();
		for (FlowNodeBaseDesign node:list) {
			if (node instanceof SubFlowDesign) {
				result.add((SubFlowDesign) node);
			}
		}
		return result;
	}

	private List<PageDesign> getPages(List<FlowNodeBaseDesign> list) {
		ArrayList<PageDesign> result = new ArrayList<PageDesign>();
		for (FlowNodeBaseDesign node:list) {
			if (node instanceof PageDesign) {
				result.add((PageDesign) node);
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

	private static String edgePoint(FlowNodeBaseDesign flowNodeBaseDesign) {
		String name = flowNodeBaseDesign.name.get();
		String typeName = flowNodeBaseDesign.getModel().getName();
		typeName = typeName.substring(0, typeName.length()-6);// Remove Design
		return name+typeName+".INSTANCE";
	}
}
