package app.designer.flow.entity;

import app.designer.*;
import app.designer.event.*;
import app.designer.flow.*;
import app.designer.entity.*;
import app.designer.sharedpagefragment.*;
import lbe.instance.*;
import lbe.model.flow.*;
import lbe.model.deduction.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class EntityPage extends Page {

	public static final EntityPage INSTANCE = new EntityPage();


	private static Deduction<?> createDeduction0() {
		Deduction<Design> d0 = SelectedInstanceDeduction.create(DesignEntity.INSTANCE);
		Deduction<java.lang.String> d1 = AttributeDeduction.create(DesignEntity.name, d0);
		return d1;
	}


	private static Deduction<?> createDeduction1() {
		Deduction<EntityDesign> d0 = SelectedInstanceDeduction.create(EntityDesignEntity.INSTANCE);
		Deduction<java.util.List<AttributeDesign>> d1 = AttributeDeduction.create(EntityDesignEntity.attributes, d0);
		return d1;
	}

	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(new PageFragment[]{
            new SimpleLink(HomeEvent.INSTANCE, new ConstantText("Home")),
            new SimpleLink(ExploreInstanceEvent.INSTANCE, new ConstantText("Open in case explorer")),
            new SimpleField(DesignEntity.INSTANCE, DesignEntity.name),
            new ConstantText("Attributes"),
            new SimpleCompositePageFragment(createDeduction1(), new PageFragment[]{
                new SimpleCompositePageFragment(new PageFragment[]{
                    new SimpleLink(AttributeDetailsEvent.INSTANCE, new TemplatedText().add(createDeduction0()))
                }).withPresentation("row")
            })
        }); 
	
	@Override
	public CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "Entity";
	}
	
}
