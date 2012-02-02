package custom.designer.caseexplorer;

import java.util.ArrayList;
import java.util.List;

import lbe.engine.RenderContext;

import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.model.Relation;
import org.instantlogic.core.text.ConstantText;
import org.instantlogic.core.text.Text;
import org.instantlogic.core.util.DeductionContext;
import org.instantlogic.interaction.page.CompositePageFragment;
import org.instantlogic.interaction.page.PageFragment;
import org.instantlogic.interaction.page.TextPageFragment;
import org.instantlogic.interaction.page.impl.SimpleButton;
import org.instantlogic.interaction.page.impl.SimpleCompositePageFragment;
import org.instantlogic.interaction.page.impl.SimpleField;

import app.designer.event.ExploreInstanceEvent;
import app.designer.flow.caseexplorerinstance.InstancePage;

public class InstancePageCustomization extends InstancePage {
	
	public static class InstanceButtonText extends Text {

		@Override
		public String renderText(DeductionContext context) {
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
			children.add(new TextPageFragment(new ConstantText("Instance "+instance.getInstanceId()+" of type "+instance.getModel().getName())));
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
			children.add(new TextPageFragment(new ConstantText(relation.getName()+": ")));
			Object value = relation.get(instance).get();
			if (value!=null) {
				children.add(
					new SimpleCompositePageFragment(relation.toDeduction(), 
						new PageFragment[]{
							new SimpleButton(ExploreInstanceEvent.INSTANCE, new InstanceButtonText())
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
            new TextPageFragment(new ConstantText("Case Explorer")),
            new InstanceExplorerFragment()
        }); 
	
	
	@Override
	public CompositePageFragment getRootContainer() {
		return CONTENT;
	}
}
