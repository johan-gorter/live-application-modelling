package org.instantlogic.designer.flow.main;

public class WelcomePlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final WelcomePlaceTemplate INSTANCE = new WelcomePlaceTemplate();

	@Override
	public String getId() {
		return "c6db5b3d-ac77-45d1-9b25-36a309745007";
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
        new org.instantlogic.interaction.page.FragmentTemplate("2a1141a5-d3e8-4e25-ad76-acee823addcc", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("339e2d07-7f34-4bce-bad3-d273bb9059db", "Block")      .setStyleNames(new String[]{"card"})
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("6f4d8d03-91e2-46e4-a87a-05c89a2a5711", "Heading3")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate(" (Application)")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("80a44cd0-ba62-46aa-aa27-7a17f89bbeef", "Paragraph")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Welcome to the Designer")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("6e809a82-3164-4fd4-838f-cb8700788047", "Table")      
                        .putChildren("columns",
                                new org.instantlogic.interaction.page.FragmentTemplate("dcdffe88-933c-4601-a80e-3ca77e9b9253", "Column")      
                                .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Entities")))
                        )
      
                        .putChildren("rows",
                                new org.instantlogic.interaction.page.SelectionElement(createDeduction1()
,                                        new org.instantlogic.interaction.page.FragmentTemplate("ceb97827-684d-4d76-bd76-65eec2194a26", "Row")      
                                        .putChildren("cells",
                                                new org.instantlogic.interaction.page.FragmentTemplate("c31cd72b-8ab8-43d4-8ed4-0cf6a917b2d5", "Cell")      
                                                .putChildren("content",
                                                        new org.instantlogic.interaction.page.FragmentTemplate("1b26a263-bb75-47e3-a9c5-9a1b8854f02a", "Link")      .setEvent(org.instantlogic.designer.event.EntityDetailsEvent.INSTANCE)
      
                                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction2())))
                                                )
                                        )
)
                        )
,
                        new org.instantlogic.interaction.page.FragmentTemplate("cb27ae26-819c-4d5b-9271-1a4ac2cde20c", "Button")      .setEvent(org.instantlogic.designer.event.AddEntityEvent.INSTANCE)
      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Add entity")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("31f537b3-c5d4-48b8-b57a-f70f9f692c1a", "Table")      
                        .putChildren("columns",
                                new org.instantlogic.interaction.page.FragmentTemplate("d9cfaf5d-ec4c-424a-98e6-570129d15dc1", "Column")      
                                .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Flows")))
                        )
      
                        .putChildren("rows",
                                new org.instantlogic.interaction.page.SelectionElement(createDeduction3()
,                                        new org.instantlogic.interaction.page.FragmentTemplate("f1da1bda-bc6b-4f7c-91b6-86f0be29a6d2", "Row")      
                                        .putChildren("cells",
                                                new org.instantlogic.interaction.page.FragmentTemplate("35839e37-45f2-460c-8e4a-c50e739f25b2", "Cell")      
                                                .putChildren("content",
                                                        new org.instantlogic.interaction.page.FragmentTemplate("53e3dfa4-b51c-4f0e-bc53-ebb10e415e51", "Link")      .setEvent(org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE)
      
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