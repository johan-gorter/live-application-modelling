package ${rootPackageName}.flow.${flowname?lower_case};

public class ${name}SubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final ${name}SubFlow INSTANCE = new ${name}SubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.Flow getFlow() {
		return ${rootPackageName}.flow.${subFlowName}Flow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "${name}";
	}
}
