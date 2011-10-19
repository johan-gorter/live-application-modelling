package lbe.engine.codegenerator;

import java.util.ArrayList;
import java.util.List;

public class PageClassModel extends AbstractClassModel {

	public String flowname;
	public ContentClassModel content;
	
	public String getFlowname() {
		return flowname;
	}

	public ContentClassModel getContent() {
		return content;
	}
}
