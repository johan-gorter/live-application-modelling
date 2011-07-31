package lbe.engine.codegenerator;

import java.util.ArrayList;
import java.util.List;

public class ApplicationClassModel {

	public String caseEntity;
	public String name;
	public String appname;
	public final List<String> exposedFlows = new ArrayList<String>();
	public final List<String> entities = new ArrayList<String>();
	
	public String getCaseEntity() {
		return caseEntity;
	}
	public String getName() {
		return name;
	}
	public String getAppname() {
		return appname;
	}
	public List<String> getExposedFlows() {
		return exposedFlows;
	}
	public List<String> getEntities() {
		return entities;
	}
}
