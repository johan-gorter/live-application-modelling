package custom.designer.caseexplorer;

import java.util.ArrayList;
import java.util.List;

import lbe.engine.PageElement;
import lbe.engine.RenderContext;
import lbe.instance.Instance;
import lbe.model.Attribute;
import lbe.model.pageelement.CompositePageFragment;
import lbe.model.pageelement.PageFragment;
import lbe.model.pageelement.impl.ConstantText;
import lbe.model.pageelement.impl.SimpleButton;
import lbe.model.pageelement.impl.SimpleCompositePageFragment;
import lbe.model.pageelement.impl.SimpleField;
import app.designer.data.entity.ConceptEntity;
import app.designer.flow.caseexplorerinstance.InstancePage;

public class InstancePageCustomization extends InstancePage {
	
	public static class InstanceExplorerFragment extends SimpleCompositePageFragment {

		public InstanceExplorerFragment() {
			super(null);
		}

		@Override
		public PageFragment[] getChildren(RenderContext context) {
			Instance instance = context.getSelectedInstance(null);
			List<PageFragment> children = new ArrayList<PageFragment>();
			children.add(new ConstantText("Instance "+instance.getInstanceId()+" of type "+instance.getModel().getName()));
			addFields(children, instance, context);
			return children.toArray(new PageFragment[children.size()]);
		}
		
		@Override
		public String getElementType() {
			return "container";
		}

		@Override
		public String getName() {
			return null;
		}
		
		private void addFields(List<PageFragment> children, Instance instance, RenderContext context) {
			for (Attribute<? extends Instance, ? extends Object, ? extends Object> attribute:instance.getModel().getAttributes()) {
				children.add(new ConstantText("Field- "+attribute.getName()));
			}
		}
	}
	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(new PageFragment[]{
            new ConstantText("Case Explorer"),
            new InstanceExplorerFragment()
        }); 
	
	
	@Override
	public CompositePageFragment getRootContainer() {
		return CONTENT;
	}
}
