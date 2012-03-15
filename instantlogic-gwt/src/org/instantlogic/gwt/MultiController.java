package org.instantlogic.gwt;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;
import org.instantlogic.fabric.value.Multi;
import org.instantlogic.fabric.value.ReadOnlyAttributeValues;

import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.Widget;

public class MultiController<T, C extends Controller> extends CompositeController {

	private ReadOnlyAttributeValues<?, T> model;
	private List<Controller> subControllers;
	private ControllerFactory<T, C> factory;
	private InsertPanel view;
	
	private ValueChangeObserver observer = new ValueChangeObserver() {
		
		@Override
		public void valueChanged(ValueChangeEvent event) {
			if (event.isMultivalueUpdate()) {
				switch (event.getMultiValueUpdateType()) {
				case INSERT:
					@SuppressWarnings("unchecked")
					Controller c = factory.create((T) event.getItemValue());
					subControllers.add(event.getIndex(), c);
					addWidget(c.getView(), event.getIndex());
					break;
				case DELETE:
					subControllers.remove(event.getIndex());
					removeWidget(event.getIndex());
				}

			} else {
				ListIterator<Controller> li = subControllers.listIterator(subControllers.size());
				int index = subControllers.size()-1;
				while (li.hasPrevious()) {
					Controller c = li.previous();
					c.close();
					removeWidget(index--);
				}
				init();
			}
		}
	};
	
	public MultiController(ReadOnlyAttributeValues<?, T> model, InsertPanel view, ControllerFactory<T, C> factory) {
		this.model = model;
		this.view = view;
		this.factory = factory;
		init();
		model.addValueChangeObserver(observer);
	}
	
	private void init() {
		subControllers = new ArrayList<Controller>();
		Multi<T> values = model.getValue();
		if (values!=null) {
			for (T value : values) {
				Controller c = this.factory.create(value);
				addWidget(c.getView(), subControllers.size());
				subControllers.add(c);
			}
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
	
	protected void addWidget(Widget widget, int beforeIndex) {
		this.view.insert(widget, beforeIndex);
	}

	protected void removeWidget(int index) {
		this.view.remove(index);
	}
}