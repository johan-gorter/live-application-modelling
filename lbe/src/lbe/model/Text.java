package lbe.model;

import lbe.page.RenderContext;

public abstract class Text extends Model {

	@Override
	public String getName() {
		return null;
	}
	
	public abstract String render(RenderContext context);

}
