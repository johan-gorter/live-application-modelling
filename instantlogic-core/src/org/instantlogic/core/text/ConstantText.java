package org.instantlogic.core.text;


import org.instantlogic.core.util.DeductionContext;

public class ConstantText extends Text {

	private final String untranslated;
	
	public ConstantText(String untranslated) {
		this.untranslated = untranslated;
	}
	
	@Override
	public String renderText(DeductionContext context) {
		return untranslated;
	}
	
	public ConstantText addTranslation(String languageCode, String translated) {
		// TODO translations
		throw new UnsupportedOperationException();
	}

}
