package app.designer.event;

import app.designer.entity.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import lbe.model.Entity;
import lbe.model.impl.SimpleFlowEvent;

public class HomeEvent extends SimpleFlowEvent {

	public static final HomeEvent INSTANCE = new HomeEvent();

	public HomeEvent() {
		super("Home", new Entity[]{
		});
	}
}
