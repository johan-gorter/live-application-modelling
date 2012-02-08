package app.oldcarinsurance.button;

import org.instantlogic.fabric.text.ConstantText;
import org.instantlogic.fabric.text.Text;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.page.Button;

import app.oldcarinsurance.event.NextEvent;

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
