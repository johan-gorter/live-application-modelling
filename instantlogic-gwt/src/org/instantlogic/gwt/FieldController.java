package org.instantlogic.gwt;

import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeListener;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;

import com.google.gwt.user.client.ui.Widget;

public abstract class FieldController<V, W extends Widget> extends Controller {

	private ReadOnlyAttributeValue<?, V> model;
	
	private W view;

	private ValueChangeListener valueChangeListener = new ValueChangeListener() {
		
		@Override
		public boolean valueChanged(ValueChangeEvent event) {
			update();
			return true; // Keep listening
		}
	};

	public FieldController(ReadOnlyAttributeValue<?, V> model, W view) {
		super();
		this.model = model;
		this.view = view;
		
		update();
		this.model.addValueChangeListener(valueChangeListener);
	}

	protected abstract void update();
	
	public ReadOnlyAttributeValue<?, V> getModel() {
		return model;
	}

	@Override
	public W getView() {
		return view;
	}

	@Override
	public void close() {
		this.model.removeValueChangeListener(valueChangeListener);
	}
	
}
