package ${rootPackageName}.flow.${flowname?lower_case};

import app.${appname}.flow.*;
import lbe.model.flow.*;

public class ${name}SubFlow extends SubFlow {

	public static final ${name}SubFlow INSTANCE = new ${name}SubFlow();
	
	@Override
	public Flow getFlow() {
		return ${subFlowName}Flow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "${name}";
	}
}
