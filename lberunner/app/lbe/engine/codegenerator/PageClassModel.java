package lbe.engine.codegenerator;

import java.util.ArrayList;
import java.util.List;

public class PageClassModel {

	public String appname;
	public String flowname;
	public String name;
	
	public final List<ContainerClassModel> containers = new ArrayList<ContainerClassModel>();

	public String getAppname() {
		return appname;
	}

	public String getFlowname() {
		return flowname;
	}

	public String getName() {
		return name;
	}

	public List<ContainerClassModel> getContainers() {
		return containers;
	}

}
