package org.instantlogic.designer.flow.main;

public class WelcomePlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final WelcomePlaceTemplate INSTANCE = new WelcomePlaceTemplate();

	@Override
	public String getId() {
		return "22cc02dc-1a3a-49ea-bf59-82b83b5bbde2";
	}
	

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
        new org.instantlogic.interaction.page.FragmentTemplate("f375f320-4608-4fc4-9a6b-25414ee8cfb4", "Page")      .setStyleNames(new String[]{"margin", "designer"})
      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("9ce28212-f24d-4580-ba78-33c2d4e78939", "Block")      .setStyleNames(new String[]{"card"})
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("efc792b4-d0e2-45cc-8140-382e18098927", "Heading3")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate(" (Application)")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("324284b7-75a5-4b5d-9b6a-cfe4ee6c57ce", "Paragraph")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Welcome to the Designer")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("cddb37c0-76e5-4e34-8b54-dbb64e1fd146", "Table")      
                        .putChildren("columns",
                                new org.instantlogic.interaction.page.FragmentTemplate("f55cedde-bbd3-4ffe-bc46-dfe603401dd3", "Column")      
                                .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Entities")))
                        )
      
                        .putChildren("rows",
                                new org.instantlogic.interaction.page.SelectionElement(createDeduction1()
,                                        new org.instantlogic.interaction.page.FragmentTemplate("e7235516-c90c-4574-bcdd-6adb3a458ec7", "Row")      
                                        .putChildren("cells",
                                                new org.instantlogic.interaction.page.FragmentTemplate("e259c8bc-a063-4173-b75a-24df6dd81f58", "Cell")      
                                                .putChildren("content",
                                                        new org.instantlogic.interaction.page.FragmentTemplate("4a365eed-c198-4045-bc43-a79bb45da1ac", "Link")      .setEvent(org.instantlogic.designer.event.EntityDetailsEvent.INSTANCE)
      
                                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction2())))
                                                )
                                        )
)
                        )
,
                        new org.instantlogic.interaction.page.FragmentTemplate("33b4653c-7e62-49d2-abd8-c44fb3bbbd33", "Button")      .setEvent(org.instantlogic.designer.event.AddEntityEvent.INSTANCE)
      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Add entity")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("57b65267-0e84-425a-8129-9af30fef85ae", "Table")      
                        .putChildren("columns",
                                new org.instantlogic.interaction.page.FragmentTemplate("ef22989c-7a3d-494b-b32d-bb2f18c4ecbe", "Column")      
                                .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Flows")))
                        )
      
                        .putChildren("rows",
                                new org.instantlogic.interaction.page.SelectionElement(createDeduction3()
,                                        new org.instantlogic.interaction.page.FragmentTemplate("373a0364-a0d7-4510-8424-1eb585ed0fb6", "Row")      
                                        .putChildren("cells",
                                                new org.instantlogic.interaction.page.FragmentTemplate("5e446994-c7da-4ee0-ba90-8646e47c3db9", "Cell")      
                                                .putChildren("content",
                                                        new org.instantlogic.interaction.page.FragmentTemplate("7a6486fa-685f-423b-b498-7553d3e1ca49", "Link")      .setEvent(org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE)
      
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