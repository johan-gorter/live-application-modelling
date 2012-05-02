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
import org.instantlogic.interaction.page.CompositeFragmentTemplate;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.page.WidgetFragmentTemplate;
import org.instantlogic.interaction.util.RenderContext;

public class InstancePage extends AbstractInstancePage {

	public static class InstanceButtonText extends Text {

		@Override
		public String renderText(DeductionContext context) {
			Instance selected = context.getSelectedInstance(null);
			return selected.getMetadata().getEntity().getName() + selected.getMetadata().getInstanceId();
		}
		
	}
	
	public static class InstanceExplorerFragment extends CompositeFragmentTemplate {

		public InstanceExplorerFragment() {
			super(null);
		}

		@Override
		public FragmentTemplate[] getChildren(RenderContext context) {
			Instance instance = context.getSelectedInstance(null);
			List<FragmentTemplate> children = new ArrayList<FragmentTemplate>();
			children.add(new WidgetFragmentTemplate(null, "Header")
				.putText("text", new ConstantText("Instance "+instance.getMetadata().getInstanceId()+" of type "+instance.getMetadata().getEntity().getName())));
			addFields(children, instance, context);
			addButtons(children, instance, context);
			return children.toArray(new FragmentTemplate[children.size()]);
		}
		
		@SuppressWarnings("rawtypes")
		private void addButtons(List<FragmentTemplate> children, Instance instance, RenderContext context) {
			for (Relation relation: instance.getMetadata().getEntity().getRelations()) {
				addRelation(children, instance, relation);
			}
			for (Relation relation: instance.getMetadata().getEntity().getReverseRelations()) {
				addRelation(children, instance, relation);
			}
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		private void addRelation(List<FragmentTemplate> children, Instance instance, Relation relation) {
			children.add(new WidgetFragmentTemplate(null, "Paragraph")
				.putText("text", new ConstantText(relation.getName()+": ")));
			Object value = relation.get(instance).getValue();
			if (value!=null) {
				children.add(
					new CompositeFragmentTemplate(null, relation.toDeduction(), 
						new FragmentTemplate[]{
							new WidgetFragmentTemplate(null, "Button")
								.setEvent(ExploreInstanceEvent.INSTANCE)
						}
					)
				);
			}
		}

		private void addFields(List<FragmentTemplate> children, Instance instance, RenderContext context) {
			for (Attribute<? extends Instance, ? extends Object, ? extends Object> attribute:instance.getMetadata().getEntity().getAttributes()) {
				children.add(new WidgetFragmentTemplate(null, "").setField(instance.getMetadata().getEntity(), attribute, "Textfield"));
			}
		}
	}
	
	private static CompositeFragmentTemplate CONTENT = 
        new CompositeFragmentTemplate(null, new FragmentTemplate[]{
            new WidgetFragmentTemplate(null, "Header").putText("text", new ConstantText("Case Explorer")),
            new InstanceExplorerFragment()
        }); 
	
	
	@Override
	public CompositeFragmentTemplate getRootContainer() {
		return CONTENT;
	}
}
