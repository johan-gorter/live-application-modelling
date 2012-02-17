package org.instantlogic.gwt;

import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;

import com.google.gwt.user.client.ui.Widget;

public abstract class FieldController<V, W extends Widget> extends Controller {

	private ReadOnlyAttributeValue<?, V> model;
	
	private W view;

	private ValueChangeObserver valueChangeListener = new ValueChangeObserver() {
		
		@Override
		public void valueChanged(ValueChangeEvent event) {
			update();
		}
	};

	public FieldController(ReadOnlyAttributeValue<?, V> model, W view) {
		super();
		this.model = model;
		this.view = view;
		
		update();
		this.model.addValueChangeListener(valueChangeListener, true);
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
