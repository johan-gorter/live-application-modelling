package custom.designer;

import lbe.engine.FlowContext;
import lbe.engine.FlowEventOccurrence;
import lbe.instance.CaseInstance;
import lbe.model.Entity;
import app.designer.data.entity.PageEntity;
import app.designer.data.instance.AttributeInstance;
import app.designer.data.instance.CompositePageFragmentInstance;
import app.designer.data.instance.EntityInstance;
import app.designer.data.instance.FieldInstance;
import app.designer.data.instance.PageCompositionInstance;
import app.designer.data.instance.PageFragmentInstance;
import app.designer.data.instance.PageInstance;
import app.designer.data.instance.SelectInstance;
import app.designer.event.FieldDetailsEvent;
import app.designer.flow.AddFieldFlow;

public class AddFieldFlowCustomization extends AddFieldFlow {
	
	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		CaseInstance application = context.getCaseInstance();
		PageInstance page = (PageInstance) context.getSelectedInstance(PageEntity.INSTANCE);
		CompositePageFragmentInstance targetFragment = page.content.get();
		EntityInstance entity = null;
		// Find a suitable spot... Fine for now
		while (targetFragment.items.get().size()==1 && targetFragment.items.get().get(0).pageFragment.get() instanceof CompositePageFragmentInstance) {
			if (targetFragment instanceof SelectInstance) {
				entity = ((SelectInstance)targetFragment).relation.get().to.get();
			}
			targetFragment = (CompositePageFragmentInstance) targetFragment.items.get().get(0).pageFragment.get();
		}

		// Create new attribute
		AttributeInstance attribute = new AttributeInstance(application);
		attribute.name.set("NewAttribute"+context.getCaseData().getVersion());
		attribute.className.set("java.lang.String");
		entity.attributes.add(attribute);
		
		FieldInstance field = new FieldInstance(application);
		field.attribute.set(attribute);
		PageCompositionInstance composition = new PageCompositionInstance(application);
		composition.pageFragment.set(field);
		targetFragment.items.add(composition);
		
		occurrence = new FlowEventOccurrence(FieldDetailsEvent.INSTANCE, field);
		return occurrence;
	}
}
