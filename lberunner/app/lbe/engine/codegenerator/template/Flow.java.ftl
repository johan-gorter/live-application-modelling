package app.${appname}.flow;

import app.${appname}.data.entity.*;
import app.${appname}.flow.*;
import app.${appname}.flow.${name?lower_case}.*;
import lbe.model.flow.*;
import lbe.model.flow.impl.*;

public class ${name}Flow extends Flow {

	public static final ${name}Flow INSTANCE = new ${name}Flow();
	
	private ${name}Flow() {
	}
	
	<#list sources as source>
	private static final FlowSource ${source?upper_case} = new SimpleFlowSource("${source}");
	</#list>

	<#list sinks as sink>
	private static final FlowSource ${sink?upper_case} = new SimpleFlowSource("${sink}");
	</#list>

	private static final FlowSource[] SOURCES = new FlowSource[]{
	<#list sources as source>
		${source?upper_case},
	</#list>
	};

	private static final FlowSink[] SINKS = new FlowSink[] {
	<#list sinks as sink>
		${sink?upper_case},
	</#list>
	};
	
	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
	<#list nodes as node>
		${node.name}${node.type}.INSTANCE,
	</#list>
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
	<#list edges as edge>
		new FlowEdge(${edge.from}, null, ${edge.to}, null)
	</#list>
	};
	
	@Override
	public String getName() {
		return "${name}";
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
