package ${rootPackageName};

public<#if isCustomized> abstract</#if> class <#if isCustomized>Abstract</#if>${technicalNameCapitalized}Application extends org.instantlogic.interaction.Application {

	public static final ${technicalNameCapitalized}Application INSTANCE = new ${technicalNameCapitalized}Application();
	
	protected ${technicalNameCapitalized}Application() {
	}
	
	@Override
	public org.instantlogic.fabric.model.Entity<${rootPackageName}.${caseEntity}> getCaseEntity() {
		return ${rootPackageName}.entity.${caseEntity}Entity.INSTANCE;
	}

    <#if mainFlow??>	
	@Override
	public org.instantlogic.interaction.flow.Flow getMainFlow() {
		return ${rootPackageName}.flow.${mainFlow}Flow.INSTANCE;
	}
	</#if>
	
	@Override
	public String getName() {
		return "${name}";
	}
}
