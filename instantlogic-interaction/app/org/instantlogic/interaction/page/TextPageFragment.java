package org.instantlogic.interaction.page;

import org.instantlogic.fabric.text.Text;
import org.instantlogic.interaction.util.RenderContext;

public class TextPageFragment extends PlaceFragmentTemplate {

	private final Text text;

	public TextPageFragment(Text text) {
		this.text = text;
	}

	@Override
	public String getName() {
		return null;
	}
	
	@Override
	public String getWidgetName() {
		return "text";
	}
	
	@Override
	public Fragment render(RenderContext context) {
		Fragment result = super.render(context);
		result.widgetData.put("text", text.renderText(context));
		return result;
	}
}
