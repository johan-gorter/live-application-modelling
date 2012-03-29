package org.instantlogic.designer.flow;

import org.instantlogic.designer.AttributeDeductionDesign;
import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.CompositePageFragmentDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.FieldDesign;
import org.instantlogic.designer.PageCompositionDesign;
import org.instantlogic.designer.PageDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.SelectDesign;
import org.instantlogic.designer.entity.PageDesignEntity;
import org.instantlogic.designer.event.FieldDetailsEvent;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class AddFieldFlow extends AbstractAddFieldFlow {
	
	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		Instance application = context.getCaseInstance();
		PageDesign page = (PageDesign) context.getSelectedInstance(PageDesignEntity.INSTANCE);
		CompositePageFragmentDesign targetFragment = page.getContent();
		EntityDesign entity = null;
		// Find a suitable spot... Fine for now
		while (targetFragment.getItems().size()==1 && targetFragment.getItems().get(0).getPageFragment() instanceof CompositePageFragmentDesign) {
			if (targetFragment instanceof SelectDesign) {
				AttributeDeductionDesign output = (AttributeDeductionDesign) ((SelectDesign)targetFragment).getDeduction().getOutput();
				entity = ((RelationDesign)output.getAttribute()).getTo();
			}
			targetFragment = (CompositePageFragmentDesign) targetFragment.getItems().get(0).getPageFragment();
		}

		// Create new attribute
		AttributeDesign attribute = new AttributeDesign();
		attribute.setName("NewAttribute"+application.getMetadata().getCaseAdministration().getVersion());
		attribute.setClassName("java.lang.String");
		entity.addToAttributes(attribute);
		
		FieldDesign field = new FieldDesign();
		field.setAttribute(attribute);
		PageCompositionDesign composition = new PageCompositionDesign();
		composition.setPageFragment(field);
		targetFragment.addToItems(composition);
		
		occurrence = new FlowEventOccurrence(FieldDetailsEvent.INSTANCE, field);
		return occurrence;
	}
}
