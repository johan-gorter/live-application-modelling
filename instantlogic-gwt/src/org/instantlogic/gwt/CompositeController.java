package org.instantlogic.gwt;

import java.util.ArrayList;
import java.util.List;


public abstract class CompositeController extends Controller {

	private List<Controller> subControllers = new ArrayList<Controller>();
	
	public void addSubController(Controller controller) {
		subControllers.add(controller);
	}
	
	@Override
	public void close() {
		for (Controller subController : subControllers) {
			subController.close();
		}
		subControllers.clear();
	}
}
