package org.instantlogic.designer.flow;

import org.instantlogic.designer.AttributeDeductionDesign;
import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.CompositeTemplateDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.WidgetTemplateDesign;
import org.instantlogic.designer.PageCompositionDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.SelectDesign;
import org.instantlogic.designer.entity.PlaceDesignEntity;
import org.instantlogic.designer.event.FieldDetailsEvent;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class AddFieldFlow extends AbstractAddFieldFlow {
	
	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		Instance application = context.getCaseInstance();
		PlaceTemplateDesign page = (PlaceTemplateDesign) context.getSelectedInstance(PlaceDesignEntity.INSTANCE);
		CompositeTemplateDesign targetFragment = page.getContent();
		EntityDesign entity = null;
		// Find a suitable spot... Fine for now
		while (targetFragment.getItems().size()==1 && targetFragment.getItems().get(0).getPageFragment() instanceof CompositeTemplateDesign) {
			if (targetFragment instanceof SelectDesign) {
				AttributeDeductionDesign output = (AttributeDeductionDesign) ((SelectDesign)targetFragment).getDeduction().getOutput();
				entity = ((RelationDesign)output.getAttribute()).getTo();
			}
			targetFragment = (CompositeTemplateDesign) targetFragment.getItems().get(0).getPageFragment();
		}

		// Create new attribute
		AttributeDesign attribute = new AttributeDesign();
		attribute.setName("NewAttribute"+application.getMetadata().getCaseAdministration().getVersion());
		attribute.setJavaClassName("java.lang.String");
		entity.addToAttributes(attribute);
		
		WidgetTemplateDesign field = new WidgetTemplateDesign();
		field.setAttribute(attribute);
		PageCompositionDesign composition = new PageCompositionDesign();
		composition.setPageFragment(field);
		targetFragment.addToItems(composition);
		
		occurrence = new FlowEventOccurrence(FieldDetailsEvent.INSTANCE, field);
		return occurrence;
	}
}
