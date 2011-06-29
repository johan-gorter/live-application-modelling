package lbe.model.pageelement.impl;

import lbe.model.Attribute;
import lbe.model.pageelement.Button;
import lbe.model.pageelement.Field;
import lbe.model.pageelement.Text;

public class SimpleButton extends Button {

	private final String name;
	private final String trigger;
	private final Text caption;


	public SimpleButton(String trigger, Text caption) {
		this.name = trigger;
		this.trigger = trigger;
		this.caption = caption;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public Text getCaption() {
		return caption;
	}

	@Override
	public String getTrigger() {
		return trigger;
	}
}
