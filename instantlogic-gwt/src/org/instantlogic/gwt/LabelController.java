package org.instantlogic.gwt;

import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;

import com.google.gwt.user.client.ui.Label;

public class LabelController<V extends Object> extends FieldController<V, Label> {

	public LabelController(ReadOnlyAttributeValue<?, V> model, Label view) {
		super(model, view);
	}

	@Override
	protected void update() {
		String text = "";
		ValueAndLevel<V> valueAndLevel = getModel().getValueAndLevel();
		if (valueAndLevel.hasValue()) {
			text = valueAndLevel.getValue().toString();
		}
		getView().setText(text);
	}
}
