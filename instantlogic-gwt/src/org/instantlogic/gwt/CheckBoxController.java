package org.instantlogic.gwt;

import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.SimpleCheckBox;

public class CheckBoxController extends FieldController<Boolean, SimpleCheckBox>{

	private ClickHandler clickHandler = new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			Boolean value = getView().getValue();
			((AttributeValue<?,Boolean>)getModel()).setValue(value);
		}
	};

	public CheckBoxController(ReadOnlyAttributeValue<?, Boolean> model, SimpleCheckBox view) {
		super(model, view);
		view.addClickHandler(clickHandler);
	}

	@Override
	protected void update() {
		boolean value = getModel().getValue() == Boolean.TRUE;
		getView().setValue(value);
	}

}
