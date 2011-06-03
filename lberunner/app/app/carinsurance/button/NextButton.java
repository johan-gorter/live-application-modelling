package app.carinsurance.button;

import lbe.engine.RenderContext;
import lbe.model.pageelement.Button;

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
