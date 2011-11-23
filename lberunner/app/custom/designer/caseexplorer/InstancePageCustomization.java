package custom.designer.caseexplorer;

import java.util.ArrayList;
import java.util.List;

import lbe.engine.PageElement;
import lbe.engine.RenderContext;
import lbe.instance.Instance;
import lbe.model.Attribute;
import lbe.model.Entity;
import lbe.model.Relation;
import lbe.model.impl.SimpleFlowEvent;
import lbe.model.pageelement.CompositePageFragment;
import lbe.model.pageelement.Field;
import lbe.model.pageelement.PageFragment;
import lbe.model.pageelement.Text;
import lbe.model.pageelement.impl.ConstantText;
import lbe.model.pageelement.impl.SimpleButton;
import lbe.model.pageelement.impl.SimpleCompositePageFragment;
import lbe.model.pageelement.impl.SimpleField;
import app.designer.data.entity.ConceptEntity;
import app.designer.flow.caseexplorerinstance.InstancePage;

public class InstancePageCustomization extends InstancePage {
	
	public static final SimpleFlowEvent NAVIGATE_EVENT = new SimpleFlowEvent("navigate", new Entity[]{});
	
	public static class InstanceButtonText extends Text {

		@Override
		public String renderText(RenderContext context) {
			Instance selected = context.getSelectedInstance(null);
			return selected.getModel().getName() + selected.getInstanceId();
		}
		
	}
	
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
			addButtons(children, instance, context);
			return children.toArray(new PageFragment[children.size()]);
		}
		
		private void addButtons(List<PageFragment> children, Instance instance, RenderContext context) {
			for (Relation relation: instance.getModel().getRelations()) {
				addRelation(children, instance, relation);
			}
			for (Relation relation: instance.getModel().getReverseRelations()) {
				addRelation(children, instance, relation);
			}
		}

		private void addRelation(List<PageFragment> children, Instance instance, Relation relation) {
			children.add(new ConstantText(relation.getName()+": "));
			Object value = relation.get(instance).get();
			if (value!=null) {
				children.add(
					new SimpleCompositePageFragment(relation, 
						new PageFragment[]{
							new SimpleButton(NAVIGATE_EVENT, new InstanceButtonText())
						}
					)
				);
			}
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
				children.add(new SimpleField(instance.getModel(), attribute));
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
