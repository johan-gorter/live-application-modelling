package app.designer.event;

import app.designer.data.entity.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import lbe.model.Entity;
import lbe.model.impl.SimpleFlowEvent;

public class PageDetailsEvent extends SimpleFlowEvent {

	public static final PageDetailsEvent INSTANCE = new PageDetailsEvent();

	public PageDetailsEvent() {
		super("PageDetails", new Entity[]{
			PageEntity.INSTANCE,
		});
	}
}
