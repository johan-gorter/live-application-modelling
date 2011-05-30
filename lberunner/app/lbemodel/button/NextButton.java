package lbemodel.button;

import lbe.model.Button;
import lbe.page.RenderContext;

public class NextButton extends Button{

	public static final NextButton INSTANCE = new NextButton();
	
	private NextButton(){};
	
	@Override
	public String getDisplay(RenderContext context) {
		return "Next";
	}

	@Override
	public String getName() {
		return "Next";
	}

}
