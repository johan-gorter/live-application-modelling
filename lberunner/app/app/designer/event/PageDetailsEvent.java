package app.designer.event;

import org.instantlogic.core.model.Entity;
import org.instantlogic.interaction.flow.impl.SimpleFlowEvent;

import app.designer.entity.PageDesignEntity;

public class PageDetailsEvent extends SimpleFlowEvent {

	public static final PageDetailsEvent INSTANCE = new PageDetailsEvent();

	public PageDetailsEvent() {
		super("PageDetails", new Entity[]{
			PageDesignEntity.INSTANCE,
		});
	}
}
