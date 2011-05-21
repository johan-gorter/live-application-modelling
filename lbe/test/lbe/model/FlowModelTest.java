package lbe.model;

import org.junit.Test;

public class FlowModelTest {

	@Test
	public void testGetPage() {
		final PageModel pageModel = new PageModel() {
			
			@Override
			public String getName() {
				return "pageName";
			}

			@Override
			public PageElementModelBase[] getRootContainers() {
				return new PageElementModelBase[0];
			}
		};
		FlowModel flowModel = new FlowModel() {
			
			@Override
			public String getName() {
				return "flowName";
			}
			
			@Override
			public FlowModel[] getSubflows() {
				return new FlowModel[]{};
			}
			
			@Override
			public FlowNodeModelBase getStart() {
				return null;
			}
			
			@Override
			public PageModel[] getPages() {
				return new PageModel[]{pageModel};
			}
		};
		
		flowModel.getPage("pageName");
	}

}
