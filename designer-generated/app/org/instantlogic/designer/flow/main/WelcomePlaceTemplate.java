package org.instantlogic.designer.flow.main;

public class WelcomePlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final WelcomePlaceTemplate INSTANCE = new WelcomePlaceTemplate();


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.ApplicationDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.ApplicationDesignEntity.name, d0);
		    org.instantlogic.fabric.deduction.Deduction<java.lang.String> d2 
		    	= new org.instantlogic.designer.deduction.CapitalizeFirstDeduction(d1);
		return d2;
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


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction4() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FlowDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("263ddb98-0798-4443-9cae-66fdb29ba9f3", "Page")      .setStyleNames(new String[]{"margin", "designer"})
      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("7fd8bf32-2e29-4ca1-8f8b-974e8d0b9ff7", "Block")      .setStyleNames(new String[]{"card"})
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("900e28a0-48ac-4284-8f57-352c977fe27b", "Heading3")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate(" (Application)")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("f94e7efb-5974-4ce2-9976-2020d50af7b6", "Paragraph")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Welcome to the Designer")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("9a220d1e-0bd3-4669-a1d4-7356592a1fdd", "Table")      
                        .putChildren("columns",
                                new org.instantlogic.interaction.page.FragmentTemplate("ee01c386-501a-4213-a0ec-3bc90ff84ded", "Column")      
                                .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Entities")))
                        )
      
                        .putChildren("rows",
                                new org.instantlogic.interaction.page.SelectionElement(createDeduction1()
,                                        new org.instantlogic.interaction.page.FragmentTemplate("e0e42676-6bbc-43c6-847e-07c5b876e565", "Row")      
                                        .putChildren("cells",
                                                new org.instantlogic.interaction.page.FragmentTemplate("6559be56-8d71-4e1a-8313-69b0790c8694", "Cell")      
                                                .putChildren("content",
                                                        new org.instantlogic.interaction.page.FragmentTemplate("7acd90ae-2b22-434f-a4a6-523ff112c4df", "Link")      .setEvent(org.instantlogic.designer.event.EntityDetailsEvent.INSTANCE)
      
                                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction2())))
                                                )
                                        )
)
                        )
,
                        new org.instantlogic.interaction.page.FragmentTemplate("0997d86d-2dcd-4aa9-9a50-20549d737d23", "Button")      .setEvent(org.instantlogic.designer.event.AddEntityEvent.INSTANCE)
      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Add entity")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("461607e2-6e44-4bb5-8441-c3266ce27886", "Table")      
                        .putChildren("columns",
                                new org.instantlogic.interaction.page.FragmentTemplate("0bdada62-ba12-4692-ba01-b71abd2dd6de", "Column")      
                                .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Flows")))
                        )
      
                        .putChildren("rows",
                                new org.instantlogic.interaction.page.SelectionElement(createDeduction3()
,                                        new org.instantlogic.interaction.page.FragmentTemplate("7d13a40f-65cf-49e3-ab53-7e2f60d67da6", "Row")      
                                        .putChildren("cells",
                                                new org.instantlogic.interaction.page.FragmentTemplate("40938f7b-dae8-4758-a003-c34fa1cc6ec6", "Cell")      
                                                .putChildren("content",
                                                        new org.instantlogic.interaction.page.FragmentTemplate("f7c3f3c0-3250-45a3-a68d-93ed881f82fb", "Link")      .setEvent(org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE)
      
                                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction4())))
                                                )
                                        )
)
                        )
                )
        )
; 
	
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Welcome"));
	@Override
	protected org.instantlogic.fabric.text.TextTemplate getTitle() {
		return TITLE;
	}
	
	@Override
	public org.instantlogic.interaction.page.FragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "Welcome";
    }
}