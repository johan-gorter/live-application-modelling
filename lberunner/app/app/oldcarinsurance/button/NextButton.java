package app.oldcarinsurance.button;

import app.oldcarinsurance.event.NextEvent;
import lbe.engine.RenderContext;
import lbe.model.FlowEvent;
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
	public FlowEvent getEvent() {
		return NextEvent.INSTANCE;
	}
}
