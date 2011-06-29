package app.carinsurance.button;

import lbe.engine.RenderContext;
import lbe.model.pageelement.Button;
import lbe.model.pageelement.Text;
import lbe.model.pageelement.impl.ConstantText;

public class NextButton extends Button{

	public static final NextButton INSTANCE = new NextButton();
	private static final Text CAPTION = new ConstantText("Next");
	
	private NextButton(){};
	
	@Override
	public Text getCaption() {
		return CAPTION;
	}

	@Override
	public String getName() {
		return "Next";
	}

	@Override
	public String getTrigger() {
		return "next";
	}

}
