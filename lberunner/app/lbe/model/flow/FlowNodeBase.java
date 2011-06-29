package lbe.model.flow;

import java.util.Iterator;

import lbe.engine.FlowContext;
import lbe.engine.PageCoordinates.Coordinate;
import lbe.model.Model;

public abstract class FlowNodeBase extends Model {

	public abstract void jumpTo(FlowContext flowContext, Iterator<Coordinate> coordinates);

}
