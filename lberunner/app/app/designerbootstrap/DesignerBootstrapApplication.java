package app.designerbootstrap;

import lbe.model.Application;
import lbe.model.Entity;
import lbe.model.flow.Flow;

public class DesignerBootstrapApplication extends Application {

	private static Flow[] exposedFlows = new Flow[]{};

	@Override
	public Entity getCaseModel() {
		return null;
	}

	@Override
	public Flow[] getExposedFlows() {
		return exposedFlows;
	}

}
