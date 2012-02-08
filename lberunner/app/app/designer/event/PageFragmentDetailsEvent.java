package app.designer.event;

import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.flow.impl.SimpleFlowEvent;

import app.designer.entity.FieldDesignEntity;

public class PageFragmentDetailsEvent extends SimpleFlowEvent {

	public static final PageFragmentDetailsEvent INSTANCE = new PageFragmentDetailsEvent();

	public PageFragmentDetailsEvent() {
		super("PageFragmentDetails", new Entity[]{
			FieldDesignEntity.INSTANCE,
		});
	}
}
