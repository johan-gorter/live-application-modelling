package app.carinsurance.flow;

import app.carinsurance.flow.insure.DriverPage;
import lbe.model.flow.Flow;
import lbe.model.flow.FlowNodeBase;
import lbe.model.flow.Page;

public class InsureFlow extends Flow {
	
	public static final InsureFlow INSTANCE = new InsureFlow();
	private static final Page[] pages = new Page[]{DriverPage.INSTANCE};
	private static final Flow[] subflows = new Flow[]{};

	@Override
	public FlowNodeBase getStart() {
		return DriverPage.INSTANCE;
	}

	@Override
	public String getName() {
		return "Insure";
	}

	
	@Override
	public Page[] getPages() {
		return pages;
	}

	@Override
	public Flow[] getSubflows() {
		return subflows;
	}
	
}
