package lbe.model.pageelement.impl;

import lbe.model.Attribute;
import lbe.model.FlowEvent;
import lbe.model.pageelement.Button;
import lbe.model.pageelement.Field;
import lbe.model.pageelement.Text;

public class SimpleButton extends Button {

	private final FlowEvent flowEvent;
	private final Text caption;


	public SimpleButton(FlowEvent flowEvent, Text caption) {
		this.flowEvent = flowEvent;
		this.caption = caption;
	}

	@Override
	public Text getCaption() {
		return caption;
	}

	@Override
	public FlowEvent getEvent() {
		return flowEvent;
	}

}
