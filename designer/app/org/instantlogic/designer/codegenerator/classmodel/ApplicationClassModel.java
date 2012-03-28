package org.instantlogic.designer.codegenerator.classmodel;

import java.util.ArrayList;
import java.util.List;

public class ApplicationClassModel extends AbstractClassModel {

	public String caseEntity;
	public final List<String> exposedFlows  = new ArrayList<String>();
	public final List<String> entities = new ArrayList<String>();
	
	public String getCaseEntity() {
		return caseEntity;
	}
	public List<String> getExposedFlows() {
		return exposedFlows;
	}
	public List<String> getEntities() {
		return entities;
	}
}
