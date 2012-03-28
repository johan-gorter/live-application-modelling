package org.instantlogic.designer.codegenerator.generator;


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
import org.instantlogic.designer.codegenerator.classmodel.AbstractClassModel;
import org.instantlogic.designer.codegenerator.classmodel.FlowClassModel;
import org.instantlogic.designer.codegenerator.javacode.AbstractJavacodeGenerator;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;
import org.instantlogic.fabric.value.Multi;

public class FlowGenerator extends AbstractGenerator {

	private FlowDesign flowDesign;
	
	public FlowGenerator(FlowDesign flowDesign) {
		this.flowDesign = flowDesign;
	}
	
	private Map<String, PageGenerator> pageGenerators = new HashMap<String, PageGenerator>();
	private Map<String, SubFlowGenerator> subFlowGenerators = new HashMap<String, SubFlowGenerator>();

	@Override
	public void update(GeneratedClassModels context) {
		if (observations!=null && !observations.isOutdated()) {
			updateAll(pageGenerators.values(), context);
			updateAll(subFlowGenerators.values(), context);
			return;
		}
		
		CaseAdministration caseAdministration = flowDesign.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		
		FlowClassModel model = initModel();
		
		model.isCustomized = flowDesign.getIsCustomized();
		model.name = flowDesign.getName();
		for (FlowSourceDesign source: flowDesign.getSources()) {
			FlowClassModel.FlowSource flowSource = new FlowClassModel.FlowSource();
			flowSource.startEvent = source.getStartEvent()==null?null:source.getStartEvent().getName();
			flowSource.endNode = source.getEndEvent()==null?null:edgePoint(source.getEndNode());
			flowSource.endEvent = source.getEndEvent()==null?null:source.getEndEvent().getName();
			model.sources.add(flowSource);
		}
		for (FlowNodeBaseDesign nodeDesign: flowDesign.getNodes()) {
			FlowClassModel.FlowNode node = new FlowClassModel.FlowNode();
			node.name = nodeDesign.getName();
			node.type = nodeDesign.getInstanceEntity().getName();
			node.type = node.type.substring(0, node.type.length()-6); // remove Design
			model.nodes.add(node);
		}
		for (FlowEdgeDesign edgeDesign: flowDesign.getEdges()) {
			FlowClassModel.FlowEdge edge = new FlowClassModel.FlowEdge();
			edge.startNode = edgePoint(edgeDesign.getStartNode());
			if (edgeDesign.getStartEvent()!=null) {
				edge.startEvent = edgeDesign.getStartEvent().getName();
			}
			edge.endNode = edgePoint(edgeDesign.getEndNode());
			if (edgeDesign.getEndEvent()!=null) {
				edge.endEvent = edgeDesign.getEndEvent().getName();
			}
			model.edges.add(edge);
		}
		for (EntityDesign selectDesign: flowDesign.getParameters()) {
			model.parameters.add(selectDesign.getName());
		}
		
		List<Design> newPages = updateGenerators(pageGenerators, getPages(flowDesign.getNodes()), context);
		for(Design newPage : newPages) {
			PageGenerator pageGenerator = new PageGenerator((PageDesign)newPage);
			pageGenerator.update(context);
			pageGenerators.put(newPage.getName(), pageGenerator);
		}
		List<Design> newSubFlows = updateGenerators(subFlowGenerators, getSubFlows(flowDesign.getNodes()), context);
		for(Design newSubFlow : newSubFlows) {
			SubFlowGenerator subFlowGenerator = new SubFlowGenerator((SubFlowDesign)newSubFlow);
			subFlowGenerator.update(context);
			subFlowGenerators.put(newSubFlow.getName(), subFlowGenerator);
		}
		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
		context.updatedFlows.add(model);
	}
	
	@Override
	public void delete(GeneratedClassModels context) {
		FlowClassModel model = initModel();
		context.deletedFlows.add(model);
	}

	private FlowClassModel initModel() {
		FlowClassModel model = new FlowClassModel();
		model.name = flowDesign.getName();
		model.isCustomized = flowDesign.getIsCustomized()==Boolean.TRUE;
		return model;
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

	private static String edgePoint(FlowNodeBaseDesign flowNodeBaseDesign) {
		String name = flowNodeBaseDesign.getName();
		String typeName = flowNodeBaseDesign.getInstanceEntity().getName();
		typeName = typeName.substring(0, typeName.length()-6);// Remove Design
		return name+typeName+".INSTANCE";
	}
}
