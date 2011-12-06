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

public class Header 
	extends CompositePageFragmentDesign 
	implements Instance {

	public Header(CaseInstance caseInstance) {
		this(caseInstance, 0);
	}
	
	public Header(CaseInstance caseInstance, long id) {
		super(caseInstance, HeaderEntity.INSTANCE, id);
	}
	
	protected Header(CaseInstance caseInstance, Entity model, long id) {
		super(caseInstance, model, id);
	}

	// Attributes
	
	// Relations
	
	public final RelationValue<Header, TextDesign> text
		= createRelationValue(HeaderEntity.text);
		
	public TextDesign getText() {
		return text.get();
	}
	
	public void setText(TextDesign newValue) {
		text.set(newValue);
	}

	// Reverse relations

}
