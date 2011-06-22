package lbe.model.flow;

import java.util.Iterator;

import lbe.engine.FlowContext;
import lbe.engine.PageCoordinates.Coordinate;

public abstract class FlowSource extends FlowNodeBase {
	@Override
	public void jumpTo(FlowContext flowContext, Iterator<Coordinate> coordinates) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String flow(String entryName, FlowContext context) {
		throw new UnsupportedOperationException();
	}

}
