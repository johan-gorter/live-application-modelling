package lbe.model.pageelement;

import lbe.engine.RenderContext;
import lbe.model.Model;

public abstract class Text extends Model {

	@Override
	public String getName() {
		return null;
	}
	
	public abstract String render(RenderContext context);

}
