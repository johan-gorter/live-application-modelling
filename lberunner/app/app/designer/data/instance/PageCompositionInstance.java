package app.designer.data.instance;

import java.util.List;

import app.designer.*;
import app.designer.data.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class PageCompositionInstance 
	extends SimpleInstance 
	implements Instance {

	public PageCompositionInstance(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public PageCompositionInstance(CaseInstance caseInstance, long id) {
		super(caseInstance, PageCompositionEntity.INSTANCE, id);
	}
	
	protected PageCompositionInstance(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	public final AttributeValues<PageCompositionInstance, java.lang.String> presentationStyles
		= createAttributeValues(PageCompositionEntity.presentationStyles);
	
	public List<java.lang.String> getPresentationStyles() {
		return presentationStyles.get();
	}

	
	// Relations
	
	public final RelationValue<PageCompositionInstance, PageFragmentInstance> pageFragment
		= createRelationValue(PageCompositionEntity.pageFragment);

	// Reverse relations
	
	public final ReadOnlyRelationValue<PageCompositionInstance, CompositePageFragmentInstance> container
		= createReverseRelationValue(PageCompositionEntity.container);

}
