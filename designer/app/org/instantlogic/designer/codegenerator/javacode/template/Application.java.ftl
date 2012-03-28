package ${rootPackageName};

public<#if isCustomized> abstract</#if> class <#if isCustomized>Abstract</#if>${name}Application extends org.instantlogic.interaction.Application {

	public static final ${name}Application INSTANCE = new ${name}Application();
	
	protected ${name}Application() {
	}
	
	@Override
	public org.instantlogic.fabric.model.Entity<${rootPackageName}.${caseEntity}> getCaseEntity() {
		return ${rootPackageName}.entity.${caseEntity}Entity.INSTANCE;
	}
	
	private static final org.instantlogic.interaction.flow.Flow[] exposedFlows = new org.instantlogic.interaction.flow.Flow[] {
	<#list exposedFlows as exposedFlow>
		${exposedFlow}Flow.INSTANCE,
	</#list>
	};

	@Override
	public org.instantlogic.interaction.flow.Flow[] getExposedFlows() {
		return exposedFlows;
	}
	
	@Override
	public String getName() {
		return "${name}";
	}
}
