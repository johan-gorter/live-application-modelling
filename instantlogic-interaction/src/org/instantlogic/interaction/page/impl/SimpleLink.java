package org.instantlogic.interaction.page.impl;

import org.instantlogic.core.text.Text;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.page.Link;


public class SimpleLink extends Link {

	private final FlowEvent flowEvent;
	private final Text caption;


	public SimpleLink(FlowEvent flowEvent, Text caption) {
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
