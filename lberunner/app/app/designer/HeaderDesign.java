package app.designer;

import java.util.List;

import app.designer.*;
import app.designer.entity.*;
import lbe.instance.*;
import lbe.instance.impl.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class HeaderDesign 
	extends CompositePageFragmentDesign 
	implements Instance {

	public HeaderDesign(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public HeaderDesign(CaseInstance caseInstance, long id) {
		super(caseInstance, HeaderDesignEntity.INSTANCE, id);
	}
	
	protected HeaderDesign(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<HeaderDesign, TextDesign> text
		= createRelationValue(HeaderDesignEntity.text);
		
	public TextDesign getText() {
		return text.get();
	}
	
	public void setText(TextDesign newValue) {
		text.set(newValue);
	}

	// Reverse relations

}
