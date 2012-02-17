package app.designer;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;

import app.designer.entity.PageFragmentDesignEntity;

public class PageFragmentDesign 
	extends Design 
	implements Instance<PageFragmentDesign> {

	public PageFragmentDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public PageFragmentDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, PageFragmentDesignEntity.INSTANCE, id);
	}
	
	protected PageFragmentDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValue<PageFragmentDesign, java.lang.String> presentation
		= createAttributeValue(PageFragmentDesignEntity.presentation);
	
	public java.lang.String getPresentation() {
		return presentation.get();
	}

	public void setPresentation(java.lang.String newValue) {
		presentation.set(newValue);
	}
	
	// Relations

	// Reverse relations
	
	public final ReadOnlyRelationValue<PageFragmentDesign, PageFragmentHolderDesign> holder
		= createReverseRelationValue(PageFragmentDesignEntity.holder);

	public PageFragmentHolderDesign getHolder() {
		return holder.get();
	}

	
	public final ReadOnlyRelationValue<PageFragmentDesign, PageCompositionDesign> composedIn
		= createReverseRelationValue(PageFragmentDesignEntity.composedIn);

	public PageCompositionDesign getComposedIn() {
		return composedIn.get();
	}


}
