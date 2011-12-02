package app.designer.flow.field;

import app.designer.event.*;
import app.designer.flow.*;
import app.designer.data.entity.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class FieldPage extends Page {

	public static final FieldPage INSTANCE = new FieldPage();
	
	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(new PageFragment[]{
            new SimpleField(FieldEntity.INSTANCE, FieldEntity.required),
            new SimpleField(FieldEntity.INSTANCE, FieldEntity.readOnly),
            new SimpleCompositePageFragment(FieldEntity.attribute, new PageFragment[]{
                new SimpleField(ConceptEntity.INSTANCE, ConceptEntity.name).setRequired(),
                new SimpleField(AttributeEntity.INSTANCE, AttributeEntity.className).setRequired()
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
