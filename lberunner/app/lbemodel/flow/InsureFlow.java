package lbemodel.flow;

import lbe.model.FlowModel;
import lbe.model.FlowNodeModelBase;
import lbe.model.PageModel;
import lbemodel.flow.insure.DriverPage;

public class InsureFlow extends FlowModel {
	
	public static final InsureFlow INSTANCE = new InsureFlow();
	private static final PageModel[] pages = new PageModel[]{DriverPage.INSTANCE};
	private static final FlowModel[] subflows = new FlowModel[]{};

	@Override
	public FlowNodeModelBase getStart() {
		return DriverPage.INSTANCE;
	}

	@Override
	public String getName() {
		return "Insure";
	}

	
	@Override
	public PageModel[] getPages() {
		return pages;
	}

	@Override
	public FlowModel[] getSubflows() {
		return subflows;
	}
	
}
