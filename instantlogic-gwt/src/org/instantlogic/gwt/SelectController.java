package org.instantlogic.gwt;

import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;

import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.Widget;

public class SelectController<T, C extends Controller> extends CompositeController {

	private ReadOnlyAttributeValue<?, T> model;
	private Controller subController;
	private ControllerFactory<T, C> factory;
	private InsertPanel view;
	
	private ValueChangeObserver observer = new ValueChangeObserver() {
		
		@Override
		public void valueChanged(ValueChangeEvent event) {
			update();
		}
	};
	
	public SelectController(ReadOnlyAttributeValue<?, T> model, InsertPanel view, ControllerFactory<T, C> factory) {
		this.model = model;
		this.view = view;
		this.factory = factory;
		update();
		model.addValueChangeObserver(observer);
	}
	
	private void update() {
		if (subController!=null) {
			close();
			subController = null;
			this.view.remove(0);
		}
		T value = model.getValue();
		if (value!=null) {
			subController = this.factory.create(value);
			addSubController(subController);
			this.view.add(subController.getView());
		}
	}
	
	@Override
	public void close() {
		model.removeValueChangeObserver(observer);
		super.close();
	}

	@Override
	public Widget getView() {
		return (Widget) view;
	}
}
