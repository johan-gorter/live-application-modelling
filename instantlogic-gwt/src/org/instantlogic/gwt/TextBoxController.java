package org.instantlogic.gwt;

import org.instantlogic.fabric.value.AttributeValue;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.TextBox;

public class TextBoxController<V extends Object> extends FieldController<V, TextBox> {

	private ChangeHandler changeHandler = new ChangeHandler() {
		
		@SuppressWarnings("unchecked")
		@Override
		public void onChange(ChangeEvent event) {
			String text = getView().getValue();
			V value = null;
			if (text!=null && text.length()>0) {
				if (getModel().getModel().getDatatype()==Integer.class) {
					value = (V)Integer.valueOf(text);
				}
				if (getModel().getModel().getDatatype()==String.class) {
					value = (V)text;
				}
			}
			((AttributeValue<?,V>)getModel()).set(value);
		}
	};

	public TextBoxController(AttributeValue<?, V> model, TextBox view) {
		super(model, view);
		getView().addChangeHandler(changeHandler);
	}

	protected void update() {
		String text = "";
		Object value = getModel().getValue();
		if (value!=null) {
			text = value.toString();
		}
		getView().setValue(text);
	}
}
