package org.instantlogic.designer.flow.caseexplorerinstance;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.designer.event.ExploreInstanceEvent;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.text.ConstantText;
import org.instantlogic.fabric.text.Text;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.interaction.page.CompositePageFragment;
import org.instantlogic.interaction.page.PlaceFragmentTemplate;
import org.instantlogic.interaction.page.TextPageFragment;
import org.instantlogic.interaction.page.impl.SimpleButton;
import org.instantlogic.interaction.page.impl.SimpleCompositePageFragment;
import org.instantlogic.interaction.page.impl.SimpleField;
import org.instantlogic.interaction.util.RenderContext;

public class InstancePage extends AbstractInstancePage {

	public static class InstanceButtonText extends Text {

		@Override
		public String renderText(DeductionContext context) {
			Instance selected = context.getSelectedInstance(null);
			return selected.getMetadata().getEntity().getName() + selected.getMetadata().getInstanceId();
		}
		
	}
	
	public static class InstanceExplorerFragment extends SimpleCompositePageFragment {

		public InstanceExplorerFragment() {
			super(null);
		}

		@Override
		public PlaceFragmentTemplate[] getChildren(RenderContext context) {
			Instance instance = context.getSelectedInstance(null);
			List<PlaceFragmentTemplate> children = new ArrayList<PlaceFragmentTemplate>();
			children.add(new TextPageFragment(new ConstantText("Instance "+instance.getMetadata().getInstanceId()+" of type "+instance.getMetadata().getEntity().getName())));
			addFields(children, instance, context);
			addButtons(children, instance, context);
			return children.toArray(new PlaceFragmentTemplate[children.size()]);
		}
		
		@SuppressWarnings("rawtypes")
		private void addButtons(List<PlaceFragmentTemplate> children, Instance instance, RenderContext context) {
			for (Relation relation: instance.getMetadata().getEntity().getRelations()) {
				addRelation(children, instance, relation);
			}
			for (Relation relation: instance.getMetadata().getEntity().getReverseRelations()) {
				addRelation(children, instance, relation);
			}
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		private void addRelation(List<PlaceFragmentTemplate> children, Instance instance, Relation relation) {
			children.add(new TextPageFragment(new ConstantText(relation.getName()+": ")));
			Object value = relation.get(instance).getValue();
			if (value!=null) {
				children.add(
					new SimpleCompositePageFragment(relation.toDeduction(), 
						new PlaceFragmentTemplate[]{
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
		
		private void addFields(List<PlaceFragmentTemplate> children, Instance instance, RenderContext context) {
			for (Attribute<? extends Instance, ? extends Object, ? extends Object> attribute:instance.getMetadata().getEntity().getAttributes()) {
				children.add(new SimpleField(instance.getMetadata().getEntity(), attribute));
			}
		}
	}
	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(new PlaceFragmentTemplate[]{
            new TextPageFragment(new ConstantText("Case Explorer")),
            new InstanceExplorerFragment()
        }); 
	
	
	@Override
	public CompositePageFragment getRootContainer() {
		return CONTENT;
	}
}
