package lbe.model.impl;

import lbe.model.Text;
import lbe.page.RenderContext;

public class ConstantText extends Text {

	private final String defaultText;
	
	// TODO translations

	public ConstantText(String defaultText) {
		this.defaultText = defaultText;
	}
	
	@Override
	public String render(RenderContext context) {
		return defaultText;
	}

}
