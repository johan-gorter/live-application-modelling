package org.instantlogic.interaction.page;

import org.instantlogic.fabric.text.Text;
import org.instantlogic.interaction.util.RenderContext;

public class TextPageFragment extends PageFragment {

	private final Text text;

	public TextPageFragment(Text text) {
		this.text = text;
	}

	@Override
	public String getName() {
		return null;
	}
	
	@Override
	public String getElementType() {
		return "text";
	}
	
	@Override
	public PageElement render(RenderContext context) {
		PageElement result = super.render(context);
		result.display = text.renderText(context);
		return result;
	}
}
