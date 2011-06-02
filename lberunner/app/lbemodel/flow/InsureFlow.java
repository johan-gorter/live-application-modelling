package lbemodel.flow;

import lbe.model.flow.Flow;
import lbe.model.flow.FlowNodeBase;
import lbe.model.flow.Page;
import lbemodel.flow.insure.DriverPage;

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
