package org.instantlogic.designer.codegenerator;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.designer.Design;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FlowEdgeDesign;
import org.instantlogic.designer.FlowNodeBaseDesign;
import org.instantlogic.designer.FlowSourceDesign;
import org.instantlogic.designer.PageDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;
import org.instantlogic.fabric.value.Multi;

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
		this.rootPackageName = appName;
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
		CaseAdministration caseAdministration = flowDesign.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();

		String flowName = flowDesign.getName();
		
		isCustomized = flowDesign.getIsCustomized();
		name = flowDesign.getName();
		sources.clear();
		for (FlowSourceDesign source: flowDesign.getSources()) {
			FlowSource flowSource = new FlowSource();
			flowSource.startEvent = source.getStartEvent()==null?null:source.getStartEvent().getName();
			flowSource.endNode = source.getEndEvent()==null?null:edgePoint(source.getEndNode());
			flowSource.endEvent = source.getEndEvent()==null?null:source.getEndEvent().getName();
			sources.add(flowSource);
		}
		nodes.clear();
		for (FlowNodeBaseDesign nodeDesign: flowDesign.getNodes()) {
			FlowNode node = new FlowNode();
			node.name = nodeDesign.getName();
			node.type = nodeDesign.getInstanceEntity().getName();
			node.type = node.type.substring(0, node.type.length()-6); // remove Design
			nodes.add(node);
		}
		edges.clear();
		for (FlowEdgeDesign edgeDesign: flowDesign.getEdges()) {
			FlowEdge edge = new FlowEdge();
			edge.startNode = edgePoint(edgeDesign.getStartNode());
			if (edgeDesign.getStartEvent()!=null) {
				edge.startEvent = edgeDesign.getStartEvent().getName();
			}
			edge.endNode = edgePoint(edgeDesign.getEndNode());
			if (edgeDesign.getEndEvent()!=null) {
				edge.endEvent = edgeDesign.getEndEvent().getName();
			}
			edges.add(edge);
		}
		parameters.clear();
		for (EntityDesign selectDesign: flowDesign.getParameters()) {
			parameters.add(selectDesign.getName());
		}

		AbstractGenerator.generateFile(AbstractGenerator.flowTemplate, this, "flow", name, "Flow", rootPackageName, applicationRoot, this.isCustomized);
		if (applicationRoot!=null) {
			new File(new File(applicationRoot,"flow"), name.toLowerCase()).mkdirs();
		}
		
		List<Design> newPages = updateGenerators(pageGenerators, getPages(flowDesign.getNodes()), applicationRoot);
		for(Design newPage : newPages) {
			PageGenerator pageGenerator = new PageGenerator((PageDesign)newPage, rootPackageName, flowName);
			pageGenerator.update(applicationRoot);
			pageGenerators.put(newPage.getName(), pageGenerator);
		}
		List<Design> newSubFlows = updateGenerators(subFlowGenerators, getSubFlows(flowDesign.getNodes()), applicationRoot);
		for(Design newSubFlow : newSubFlows) {
			SubFlowGenerator subFlowGenerator = new SubFlowGenerator((SubFlowDesign)newSubFlow, rootPackageName, flowName);
			subFlowGenerator.update(applicationRoot);
			subFlowGenerators.put(newSubFlow.getName(), subFlowGenerator);
		}
		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
	}

	private List<SubFlowDesign> getSubFlows(Multi<FlowNodeBaseDesign> list) {
		ArrayList<SubFlowDesign> result = new ArrayList<SubFlowDesign>();
		for (FlowNodeBaseDesign node:list) {
			if (node instanceof SubFlowDesign) {
				result.add((SubFlowDesign) node);
			}
		}
		return result;
	}

	private List<PageDesign> getPages(Multi<FlowNodeBaseDesign> list) {
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
		AbstractGenerator.deleteFile("flow", name.toLowerCase(), "Flow", rootPackageName, applicationRoot);
		File dir =new File(applicationRoot,"flow/"+name.toLowerCase()); 
		purge(dir);
		dir.delete();
	}

	private static String edgePoint(FlowNodeBaseDesign flowNodeBaseDesign) {
		String name = flowNodeBaseDesign.getName();
		String typeName = flowNodeBaseDesign.getInstanceEntity().getName();
		typeName = typeName.substring(0, typeName.length()-6);// Remove Design
		return name+typeName+".INSTANCE";
	}
}
