package app.${appname}.flow.${flowname?lower_case};

import app.${appname}.flow.*;
import app.${appname}.container.*;
import app.${appname}.button.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;

public class ${name}Page extends Page {

	public static final ${name}Page INSTANCE = new ${name}Page();
	
	@Override
	public Container getRootContainer() {
		return ${name}Container.INSTANCE;
	}; 
	
	@Override
	public String getName() {
		return "${name}";
	}
	
}
