package lbemodel.button;

import lbe.model.ButtonModel;
import lbe.page.RenderContext;

public class NextButton extends ButtonModel{

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
