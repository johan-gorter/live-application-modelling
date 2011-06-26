package lbe.model.pageelement.impl;

import lbe.model.Attribute;
import lbe.model.pageelement.Button;
import lbe.model.pageelement.Field;
import lbe.model.pageelement.Text;

public class SimpleButton extends Button {

	private final String name;
	private final Text caption;

	public SimpleButton(String name, Text caption) {
		this.name = name;
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
}
