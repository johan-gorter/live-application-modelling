package lbe.engine.codegenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lbe.instance.Observations;

import app.designer.data.instance.ButtonInstance;
import app.designer.data.instance.CompositePageFragmentInstance;
import app.designer.data.instance.ConstantTextInstance;
import app.designer.data.instance.FieldInstance;
import app.designer.data.instance.HeaderInstance;
import app.designer.data.instance.LinkInstance;
import app.designer.data.instance.PageCompositionInstance;
import app.designer.data.instance.PageFragmentInstance;
import app.designer.data.instance.PageInstance;
import app.designer.data.instance.SelectInstance;

public class PageGenerator extends AbstractGenerator {

	public String flowname;
	public ContentClassModel content;
	
	private PageInstance pageInstance;
	
	private Observations observations;
	
	public PageGenerator(PageInstance pageInstance, String appname, String flowname) {
		this.pageInstance = pageInstance;
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
		pageInstance.getCase().startRecordingObservations();
		
		name = pageInstance.name.get();
		customization = pageInstance.customization.get();
		content = createContentClassModel(pageInstance.content.get());
		
		AbstractGenerator.generateFile(AbstractGenerator.pageTemplate, this, "flow/"+flowname.toLowerCase(), pageInstance.name.get(), "Page", appname, applicationRoot);
		
		this.observations = pageInstance.getCase().stopRecordingObservations();
	}

	@Override
	public void delete(File applicationRoot) {
		AbstractGenerator.deleteFile("flow/"+flowname.toLowerCase(), pageInstance.name.get(), "Page", appname, applicationRoot);
	}
	
	private ContentClassModel createContentClassModel(PageFragmentInstance fragment) {
		ContentClassModel result = new ContentClassModel();
		result.type=fragment.getModel().getName();
		result.presentation = fragment.getPresentation();
		if (fragment instanceof FieldInstance) {
			FieldInstance field = (FieldInstance) fragment;
			result.required = (field.required.get()== Boolean.TRUE);
			result.entity = field.attribute.get().entity.get().name.get();
			result.attribute = field.attribute.get().name.get();
			result.readOnly = (field.readOnly.get()==Boolean.TRUE);
		} else if (fragment instanceof ConstantTextInstance) {
			result.text = generateText((ConstantTextInstance)fragment);
		} else if (fragment instanceof ButtonInstance) {
			ButtonInstance button = (ButtonInstance)fragment;
			result.text = generateText(button.caption.get());
			result.event = button.event.get()==null?null:button.event.get().name.get();
		} else if (fragment instanceof LinkInstance) {
			LinkInstance link = (LinkInstance)fragment;
			result.text = generateText(link.caption.get());
			result.event = link.event.get()==null?null:link.event.get().name.get();
		} else if (fragment instanceof CompositePageFragmentInstance) {
			for (PageCompositionInstance composition : ((CompositePageFragmentInstance)fragment).items.get()) {
				result.children.add(createContentClassModel(composition.pageFragment.get()));
			}
			if (fragment instanceof HeaderInstance) {
				result.text = generateText(((HeaderInstance)fragment).text.get());
			}
			if (fragment instanceof SelectInstance) {
				SelectInstance selectFragment = (SelectInstance)fragment;
				result.relationEntity = selectFragment.relation.get().entity.get().name.get();
				result.relationName = selectFragment.relation.get().name.get();
			}
		}
		return result;
	}

	
}
