package lbe.engine.codegenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lbe.instance.Observations;
import app.designer.ButtonDesign;
import app.designer.CompositePageFragmentDesign;
import app.designer.ConstantTextDesign;
import app.designer.DeductionSchemeDesign;
import app.designer.FieldDesign;
import app.designer.HeaderDesign;
import app.designer.LinkDesign;
import app.designer.PageCompositionDesign;
import app.designer.PageDesign;
import app.designer.PageFragmentDesign;
import app.designer.SelectDesign;
import app.designer.TextDesign;

public class PageGenerator extends AbstractGenerator implements DeductionSchemeHolder {

	public String flowname;
	public ContentClassModel content;
	
	private PageDesign pageDesign;
	private List<DeductionSchemeGenerator> deductionSchemes = new ArrayList<DeductionSchemeGenerator>();
	
	private Observations observations;
	
	public PageGenerator(PageDesign pageDesign, String appname, String flowname) {
		this.pageDesign = pageDesign;
		this.appname = appname;
		this.flowname = flowname;
	}

	public String getFlowname() {
		return flowname;
	}

	public ContentClassModel getContent() {
		return content;
	}

	@Override
	public void update(File applicationRoot) {
		if (observations!=null && !observations.isOutdated()) return;
		deductionSchemes.clear();
		pageDesign.getCase().startRecordingObservations();
		
		name = pageDesign.name.get();
		customization = pageDesign.customization.get();
		content = createContentClassModel(pageDesign.content.get());
		
		AbstractGenerator.generateFile(AbstractGenerator.pageTemplate, this, "flow/"+flowname.toLowerCase(), pageDesign.name.get(), "Page", appname, applicationRoot);
		
		this.observations = pageDesign.getCase().stopRecordingObservations();
	}

	@Override
	public void delete(File applicationRoot) {
		AbstractGenerator.deleteFile("flow/"+flowname.toLowerCase(), pageDesign.name.get(), "Page", appname, applicationRoot);
	}
	
	private ContentClassModel createContentClassModel(PageFragmentDesign fragment) {
		ContentClassModel result = new ContentClassModel();
		result.type=fragment.getModel().getName();
		if (result.type.endsWith("Design")) {
			result.type = result.type.substring(0, result.type.length()-6);
		}
		result.presentation = fragment.getPresentation();
		if (fragment instanceof FieldDesign) {
			FieldDesign field = (FieldDesign) fragment;
			result.required = (field.required.get()== Boolean.TRUE);
			result.entity = field.attribute.get().entity.get().name.get();
			result.attribute = field.attribute.get().name.get();
			result.readOnly = (field.readOnly.get()==Boolean.TRUE);
		} else if (fragment instanceof TextDesign) {
			result.text = new TextGenerator((TextDesign)fragment, this);
		} else if (fragment instanceof ButtonDesign) {
			ButtonDesign button = (ButtonDesign)fragment;
			result.text = new TextGenerator(button.caption.get(), this);
			result.event = button.event.get()==null?null:button.event.get().name.get();
		} else if (fragment instanceof LinkDesign) {
			LinkDesign link = (LinkDesign)fragment;
			result.text = new TextGenerator(link.caption.get(), this);
			result.event = link.event.get()==null?null:link.event.get().name.get();
		} else if (fragment instanceof CompositePageFragmentDesign) {
			for (PageCompositionDesign composition : ((CompositePageFragmentDesign)fragment).items.get()) {
				result.children.add(createContentClassModel(composition.pageFragment.get()));
			}
			if (fragment instanceof HeaderDesign) {
				result.text = new TextGenerator(((HeaderDesign)fragment).text.get(), this);
			}
			if (fragment instanceof SelectDesign) {
				SelectDesign selectFragment = (SelectDesign)fragment;
				result.deductionIndex = addDeductionScheme(selectFragment.getDeduction());
			}
		}
		return result;
	}

	public List<DeductionSchemeGenerator> getDeductionSchemes() {
		return deductionSchemes;
	}
	
	public int addDeductionScheme(DeductionSchemeDesign scheme) {
		int deductionIndex = deductionSchemes.size();
		deductionSchemes.add(new DeductionSchemeGenerator(scheme, deductionIndex));
		return deductionIndex;
	}
}
