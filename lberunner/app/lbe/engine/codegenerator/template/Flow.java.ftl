package ${rootPackageName}.flow;

import ${rootPackageName}.entity.*;
import ${rootPackageName}.flow.*;
import ${rootPackageName}.event.*;
import ${rootPackageName}.flow.${name?lower_case}.*;
import lbe.model.Entity;
import lbe.model.flow.*;

public class ${name}Flow extends Flow {

	public static final ${name}Flow INSTANCE = new <#if customization??>${customization}<#else>${name}Flow</#if>();
	
	protected ${name}Flow() {
	}
	
	private static final FlowSource[] SOURCES = new FlowSource[]{
	<#list sources as source>
		new FlowSource(
			<#if source.startEvent??>${source.startEvent}Event.INSTANCE<#else>null</#if>,
			<#if source.endNode??>${source.endNode}<#else>null</#if>,
			<#if source.endEvent??>${source.endEvent}Event.INSTANCE<#else>null</#if>
		),
	</#list>
	};

	private static final FlowNodeBase[] NODES = new FlowNodeBase[]{
	<#list nodes as node>
		${node.name}${node.type}.INSTANCE,
	</#list>
	};
	
	private static final FlowEdge[] EDGES = new FlowEdge[]{
	<#list edges as edge>
		new FlowEdge(
			${edge.startNode}, 
			<#if edge.startEvent??>${edge.startEvent}Event.INSTANCE<#else>null</#if>,
			${edge.endNode},
			<#if edge.endEvent??>${edge.endEvent}Event.INSTANCE<#else>null</#if>
		),
	</#list>
	};
	
	private static final Entity[] PARAMETERS = new Entity[]{
	<#list parameters as parameter>
		${parameter}Entity.INSTANCE,
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
	public FlowNodeBase[] getNodes() {
		return NODES;
	}

	@Override
	public FlowEdge[] getEdges() {
		return EDGES;
	}

	@Override
	public Entity[] getParameters() {
		return PARAMETERS;
	}
}
