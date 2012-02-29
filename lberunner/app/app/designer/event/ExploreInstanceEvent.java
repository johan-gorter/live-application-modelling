package app.designer.event;

import app.designer.entity.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import lbe.model.Entity;
import lbe.model.impl.SimpleFlowEvent;

public class ExploreInstanceEvent extends SimpleFlowEvent {

	public static final ExploreInstanceEvent INSTANCE = new custom.designer.caseexplorer.ExploreInstanceEventCustomization();

	public ExploreInstanceEvent() {
		super("ExploreInstance", new Entity[]{
		});
	}
}
