package lbe.model.pageelement.impl;

import lbe.engine.RenderContext;
import lbe.model.pageelement.Text;

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
