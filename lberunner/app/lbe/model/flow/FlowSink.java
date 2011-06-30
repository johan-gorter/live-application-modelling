package lbe.model.flow;

import java.util.Iterator;

import lbe.engine.FlowContext;
import lbe.engine.PageCoordinates.Coordinate;

public abstract class FlowSink extends FlowNodeBase {

	@Override
	public void jumpTo(FlowContext flowContext, Coordinate thisCoordinate, Iterator<Coordinate> nextCoordinates) {
		throw new UnsupportedOperationException();
	}
	
}
