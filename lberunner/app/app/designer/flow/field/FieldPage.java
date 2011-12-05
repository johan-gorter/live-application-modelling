package app.designer.flow.field;

import app.designer.event.*;
import app.designer.flow.*;
import app.designer.entity.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class FieldPage extends Page {

	public static final FieldPage INSTANCE = new FieldPage();
	
	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(new PageFragment[]{
            new SimpleLink(HomeEvent.INSTANCE, new ConstantText("Home")),
            new SimpleLink(FlowDetailsEvent.INSTANCE, new ConstantText("Flow")),
            new SimpleLink(PageDetailsEvent.INSTANCE, new ConstantText("Page")),
            new SimpleLink(ExploreInstanceEvent.INSTANCE, new ConstantText("Open in case explorer")),
            new SimpleField(FieldDesignEntity.INSTANCE, FieldDesignEntity.required),
            new SimpleField(FieldDesignEntity.INSTANCE, FieldDesignEntity.readOnly),
            new SimpleCompositePageFragment(FieldDesignEntity.attribute, new PageFragment[]{
                new SimpleField(ConceptEntity.INSTANCE, ConceptEntity.name).setRequired(),
                new SimpleField(AttributeDesignEntity.INSTANCE, AttributeDesignEntity.className).setRequired()
            })
        }); 
	
	@Override
	public CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "Field";
	}
	
}
