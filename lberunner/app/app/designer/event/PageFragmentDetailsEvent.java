package app.designer.event;

import app.designer.entity.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import lbe.model.Entity;
import lbe.model.impl.SimpleFlowEvent;

public class PageFragmentDetailsEvent extends SimpleFlowEvent {

	public static final PageFragmentDetailsEvent INSTANCE = new PageFragmentDetailsEvent();

	public PageFragmentDetailsEvent() {
		super("PageFragmentDetails", new Entity[]{
			FieldDesignEntity.INSTANCE,
		});
	}
}
