package custom.designer;

import lbe.engine.FlowContext;
import lbe.engine.FlowEventOccurrence;
import app.designer.data.entity.PageEntity;
import app.designer.data.instance.CompositePageFragmentInstance;
import app.designer.data.instance.FieldInstance;
import app.designer.data.instance.PageCompositionInstance;
import app.designer.data.instance.PageFragmentInstance;
import app.designer.data.instance.PageInstance;
import app.designer.event.FieldDetailsEvent;
import app.designer.flow.AddFieldFlow;

public class AddFieldFlowCustomization extends AddFieldFlow {
	
	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		PageInstance page = (PageInstance) context.getSelectedInstance(PageEntity.INSTANCE);
		CompositePageFragmentInstance targetFragment = page.content.get();
		// Find a suitable spot... Fine for now
		while (targetFragment.items.get().size()==1 && targetFragment.items.get().get(0).pageFragment.get() instanceof CompositePageFragmentInstance) {
			targetFragment = (CompositePageFragmentInstance) targetFragment.items.get().get(0).pageFragment.get();
		}

		FieldInstance fieldInstance = new FieldInstance(context.getCaseInstance());
		PageCompositionInstance composition = new PageCompositionInstance(context.getCaseInstance());
		composition.pageFragment.set(fieldInstance);
		targetFragment.items.add(composition);
		
		occurrence = new FlowEventOccurrence(FieldDetailsEvent.INSTANCE, fieldInstance);
		return occurrence;
	}
}
