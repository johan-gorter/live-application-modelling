package lbe.model.flow;

import java.util.Iterator;

import lbe.engine.ChangeContext;
import lbe.engine.FlowContext;
import lbe.engine.PageCoordinates.Coordinate;
import lbe.engine.PageElement;
import lbe.engine.PageRenderer;
import lbe.engine.RenderContext;
import lbe.model.pageelement.Container;
import lbe.model.pageelement.PageElementBase;

public abstract class Page extends FlowNodeBase {
	
	public abstract Container getRootContainer();

	public void changeValue(ChangeContext changeContext) {
		getRootContainer().changeValue(changeContext);
	}

	public PageElement render(final RenderContext renderContext) {
		PageRootElement result = new PageRootElement();
		result.caseId = renderContext.getCaseId();
		result.caseVersion = renderContext.getCaseData().getVersion();
		result.language = renderContext.getLanguage();
		result.params = new PageRootParamsElement();
		result.elementType = "page";
		result.id = renderContext.getPageCoordinates().format();
		result.name = getName();
		PageElement contentElements = getRootContainer().render(renderContext);
		result.content = new PageElement[]{contentElements};
		return result;
	}

	public class PageRootParamsElement {
		public String integerformat = "#0";
		public String numberformat = "#0.000";
		public String currencyformat = "#0.00";
		public String percentageformat = "#0.0";
	}
	
	public class PageRootElement extends PageElement {
		public String caseId;
		public int caseVersion;
		public PageRootParamsElement params;
		public String language;
	}
	
	@Override
	public String flow(String entryName, FlowContext context) {
		context.getPageCoordinates().addCoordinate(new Coordinate(getName(), null));
		context.setPage(this);
		return null;
	}
	
	@Override
	public void jumpTo(FlowContext flowContext, Iterator<Coordinate> coordinates) {
		if (coordinates.hasNext()) {
			throw new RuntimeException("Page does not have subnodes");
		}
		flowContext.setPage(this);
	}
}
