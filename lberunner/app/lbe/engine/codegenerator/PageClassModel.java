package lbe.engine.codegenerator;

import java.util.ArrayList;
import java.util.List;

public class PageClassModel {

	public static class PageElement {
		public String name;
		public String type;
		
		public String getName() {
			return name;
		}
		public String getType() {
			return type;
		}
	}

	public String appname;
	public String flowname;
	public String name;
	
	public final List<PageElement> rootElements = new ArrayList<PageElement>();

	public String getAppname() {
		return appname;
	}

	public String getFlowname() {
		return flowname;
	}

	public String getName() {
		return name;
	}

	public List<PageElement> getRootElements() {
		return rootElements;
	}

}
