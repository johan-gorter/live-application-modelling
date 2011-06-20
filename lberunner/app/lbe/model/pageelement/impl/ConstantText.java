package lbe.model.pageelement.impl;

import lbe.engine.RenderContext;
import lbe.model.pageelement.Text;

public class ConstantText extends Text {

	private final String untranslated;
	
	public ConstantText(String untranslated) {
		this.untranslated = untranslated;
	}
	
	@Override
	public String render(RenderContext context) {
		return untranslated;
	}
	
	public ConstantText addTranslation(String languageCode, String translated) {
		// TODO translations
		throw new UnsupportedOperationException();
	}

}
