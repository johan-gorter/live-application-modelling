package custom.designer;

import lbe.engine.FlowContext;
import lbe.engine.FlowEventOccurrence;
import lbe.instance.CaseInstance;
import app.designer.AttributeDesign;
import app.designer.CompositePageFragmentDesign;
import app.designer.EntityDesign;
import app.designer.FieldDesign;
import app.designer.PageComposition;
import app.designer.PageDesign;
import app.designer.Select;
import app.designer.entity.PageDesignEntity;
import app.designer.event.FieldDetailsEvent;
import app.designer.flow.AddFieldFlow;

public class AddFieldFlowCustomization extends AddFieldFlow {
	
	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		CaseInstance application = context.getCaseInstance();
		PageDesign page = (PageDesign) context.getSelectedInstance(PageDesignEntity.INSTANCE);
		CompositePageFragmentDesign targetFragment = page.content.get();
		EntityDesign entity = null;
		// Find a suitable spot... Fine for now
		while (targetFragment.items.get().size()==1 && targetFragment.items.get().get(0).pageFragment.get() instanceof CompositePageFragmentDesign) {
			if (targetFragment instanceof Select) {
				entity = ((Select)targetFragment).relation.get().to.get();
			}
			targetFragment = (CompositePageFragmentDesign) targetFragment.items.get().get(0).pageFragment.get();
		}

		// Create new attribute
		AttributeDesign attribute = new AttributeDesign(application);
		attribute.name.set("NewAttribute"+context.getCaseData().getVersion());
		attribute.className.set("java.lang.String");
		entity.attributes.add(attribute);
		
		FieldDesign field = new FieldDesign(application);
		field.attribute.set(attribute);
		PageComposition composition = new PageComposition(application);
		composition.pageFragment.set(field);
		targetFragment.items.add(composition);
		
		occurrence = new FlowEventOccurrence(FieldDetailsEvent.INSTANCE, field);
		return occurrence;
	}
}