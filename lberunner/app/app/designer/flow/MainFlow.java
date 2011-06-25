package app.designer.flow;

import app.designer.data.entity.*;
import app.designer.flow.*;
import app.designer.flow.main.*;
import lbe.model.flow.*;
import lbe.model.flow.impl.*;

public class MainFlow extends Flow {

	public static final MainFlow INSTANCE = new MainFlow();
	
	private MainFlow() {
	}
	
	private static final FlowSource START = new SimpleFlowSource("start");


	private static final FlowSource[] SOURCES = new FlowSource[]{
		START,
	};

	private static final FlowSink[] SINKS = new FlowSink[] {
	};
	
	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
		WelcomePage.INSTANCE,
		PageToolboxPage.INSTANCE,
		ContainerPage.INSTANCE,
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
		new FlowEdge(START, null, WelcomePage.INSTANCE, null),
		new FlowEdge(WelcomePage.INSTANCE, null, PageToolboxPage.INSTANCE, null),
		new FlowEdge(PageToolboxPage.INSTANCE, null, ContainerPage.INSTANCE, null),
	};
	
	@Override
	public String getName() {
		return "Main";
	}

	@Override
	public FlowSource[] getSources() {
		return SOURCES;
	}

	@Override
	public FlowSink[] getSinks() {
		return SINKS;
	}
	
	@Override
	public FlowNodeBase[] getNodes() {
		return NODES;
	}

	@Override
	public FlowEdge[] getEdges() {
		return EDGES;
	}
}
