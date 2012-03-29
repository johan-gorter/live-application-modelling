package ${rootPackageName}.flow;

public<#if isCustomized> abstract</#if> class <#if isCustomized>Abstract</#if>${name}Flow extends org.instantlogic.interaction.flow.Flow {

	public static final ${name}Flow INSTANCE = new <#if customization??>${customization}<#else>${name}Flow</#if>();
	
	private static final org.instantlogic.interaction.flow.FlowSource[] SOURCES = new org.instantlogic.interaction.flow.FlowSource[]{
	<#list sources as source>
		new org.instantlogic.interaction.flow.FlowSource(
			<#if source.startEvent??>${rootPackageName}.event.${source.startEvent}Event.INSTANCE<#else>null</#if>,
			<#if source.endNode??>${rootPackageName}.flow.${name?lower_case}.${source.endNode}<#else>null</#if>,
			<#if source.endEvent??>${rootPackageName}.event.${source.endEvent}Event.INSTANCE<#else>null</#if>
		),
	</#list>
	};

	private static final org.instantlogic.interaction.flow.FlowNodeBase[] NODES = new org.instantlogic.interaction.flow.FlowNodeBase[]{
	<#list nodes as node>
		${rootPackageName}.flow.${name?lower_case}.${node.name}${node.type}.INSTANCE,
	</#list>
	};
	
	private static final org.instantlogic.interaction.flow.FlowEdge[] EDGES = new org.instantlogic.interaction.flow.FlowEdge[]{
	<#list edges as edge>
		new org.instantlogic.interaction.flow.FlowEdge(
			${rootPackageName}.flow.${name?lower_case}.${edge.startNode}, 
			<#if edge.startEvent??>${rootPackageName}.event.${edge.startEvent}Event.INSTANCE<#else>null</#if>,
			${rootPackageName}.flow.${name?lower_case}.${edge.endNode},
			<#if edge.endEvent??>${rootPackageName}.event.${edge.endEvent}Event.INSTANCE<#else>null</#if>
		),
	</#list>
	};
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
	<#list parameters as parameter>
		${rootPackageName}.entity.${parameter}Entity.INSTANCE,
	</#list>
	};
	
	@Override
	public String getName() {
		return "${name}";
	}

	@Override
	public org.instantlogic.interaction.flow.FlowSource[] getSources() {
		return SOURCES;
	}

	@Override
	public org.instantlogic.interaction.flow.FlowNodeBase[] getNodes() {
		return NODES;
	}

	@Override
	public org.instantlogic.interaction.flow.FlowEdge[] getEdges() {
		return EDGES;
	}

	@Override
	public org.instantlogic.fabric.model.Entity[] getParameters() {
		return PARAMETERS;
	}
}
