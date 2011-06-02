package lbe;

import lbe.model.flow.Flow;
import lbe.model.flow.FlowNodeBase;
import lbe.model.flow.Page;
import lbe.model.pageelement.PageElementBase;

import org.junit.Test;

public class FlowModelTest {

	@Test
	public void testGetPage() {
		final Page pageModel = new Page() {
			
			@Override
			public String getName() {
				return "pageName";
			}

			@Override
			public PageElementBase[] getRootContainers() {
				return new PageElementBase[0];
			}
		};
		Flow flowModel = new Flow() {
			
			@Override
			public String getName() {
				return "flowName";
			}
			
			@Override
			public Flow[] getSubflows() {
				return new Flow[]{};
			}
			
			@Override
			public FlowNodeBase getStart() {
				return null;
			}
			
			@Override
			public Page[] getPages() {
				return new Page[]{pageModel};
			}
		};
		
		flowModel.getPage("pageName");
	}

}
