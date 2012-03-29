package org.instantlogic.designer.flow.main;

public class WelcomePage extends org.instantlogic.interaction.flow.Page {

	public static final WelcomePage INSTANCE = new WelcomePage();


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.Design> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign>> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.ApplicationDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.ApplicationDesignEntity.entities, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction2() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.Design> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowDesign>> createDeduction3() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.ApplicationDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowDesign>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.ApplicationDesignEntity.flows, d0);
		return d1;
	}

	
	private static org.instantlogic.interaction.page.CompositePageFragment CONTENT = 
        new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(new org.instantlogic.interaction.page.PageFragment[]{
            new org.instantlogic.interaction.page.TextPageFragment(new org.instantlogic.fabric.text.ConstantText("Welcome to the Designer")),
            new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(new org.instantlogic.interaction.page.PageFragment[]{
                new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(new org.instantlogic.interaction.page.PageFragment[]{
                    new org.instantlogic.interaction.page.TextPageFragment(new org.instantlogic.fabric.text.ConstantText("Entities")),
                    new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(createDeduction1(), new org.instantlogic.interaction.page.PageFragment[]{
                        new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(new org.instantlogic.interaction.page.PageFragment[]{
                            new org.instantlogic.interaction.page.impl.SimpleLink(org.instantlogic.designer.event.EntityDetailsEvent.INSTANCE, new org.instantlogic.fabric.text.TemplatedText().add(createDeduction0()))
                        }).withPresentation("row")
                    })
                }).withPresentation("column"),
                new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(new org.instantlogic.interaction.page.PageFragment[]{
                    new org.instantlogic.interaction.page.TextPageFragment(new org.instantlogic.fabric.text.ConstantText("Flows")),
                    new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(createDeduction3(), new org.instantlogic.interaction.page.PageFragment[]{
                        new org.instantlogic.interaction.page.impl.SimpleCompositePageFragment(new org.instantlogic.interaction.page.PageFragment[]{
                            new org.instantlogic.interaction.page.impl.SimpleLink(org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE, new org.instantlogic.fabric.text.TemplatedText().add(createDeduction2()))
                        }).withPresentation("row")
                    })
                }).withPresentation("column")
            }).withPresentation("four-columns")
        }); 
	
	@Override
	public org.instantlogic.interaction.page.CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "Welcome";
	}
	
}
