package org.instantlogic.interaction.page.impl;

import org.instantlogic.core.text.Text;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.page.Button;


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
