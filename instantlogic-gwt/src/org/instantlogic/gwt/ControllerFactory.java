package org.instantlogic.gwt;

public interface ControllerFactory<T, C extends Controller> {

	C create(T model);
}
