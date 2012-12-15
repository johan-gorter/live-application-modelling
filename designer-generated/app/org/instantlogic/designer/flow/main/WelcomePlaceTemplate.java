package org.instantlogic.designer.flow.main;

public class WelcomePlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final WelcomePlaceTemplate INSTANCE = new WelcomePlaceTemplate();

	@Override
	public String getId() {
		return "46948295-8377-4d37-95b4-23e506d915b7";
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
        new org.instantlogic.interaction.page.FragmentTemplate("cdabc05a-403f-4d25-a8dc-8a4fe596e5a0", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("cb54e4a3-f0e5-43c9-9768-e69f61ee79ec", "Block")      .setStyleNames(new String[]{"card"})
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("d0a123b5-2edc-4fbe-8b46-004e2db53895", "Heading3")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate(" (Application)")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("88952ce7-ae3f-4370-8e5f-cbb2b2adb8f9", "Paragraph")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Welcome to the Designer")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("49cbad7d-f70a-4980-b402-cef55b14d08a", "Table")      
                        .putChildren("columns",
                                new org.instantlogic.interaction.page.FragmentTemplate("c4e01e45-33d9-42b2-8643-b9e4c1447987", "Column")      
                                .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Entities")))
                        )
      
                        .putChildren("rows",
                                new org.instantlogic.interaction.page.SelectionElement(createDeduction1()
,                                        new org.instantlogic.interaction.page.FragmentTemplate("0fafd46a-3f05-4352-b1bd-3be1c0b30373", "Row")      
                                        .putChildren("cells",
                                                new org.instantlogic.interaction.page.FragmentTemplate("1966a573-357b-46b2-ad46-d76d198f6457", "Cell")      
                                                .putChildren("content",
                                                        new org.instantlogic.interaction.page.FragmentTemplate("b89d594c-fe33-4b02-a89d-4404ce7ff480", "Link")      .setEvent(org.instantlogic.designer.event.EntityDetailsEvent.INSTANCE)
      
                                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction2())))
                                                )
                                        )
)
                        )
,
                        new org.instantlogic.interaction.page.FragmentTemplate("a846ce27-2519-4d15-b103-5427b5c2bfc5", "Button")      .setEvent(org.instantlogic.designer.event.AddEntityEvent.INSTANCE)
      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Add entity")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("70bf0cc8-31d8-42f0-852a-43fb0c6b9e30", "Table")      
                        .putChildren("columns",
                                new org.instantlogic.interaction.page.FragmentTemplate("de60199e-79c6-4d04-ab12-70ee076e9e87", "Column")      
                                .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Flows")))
                        )
      
                        .putChildren("rows",
                                new org.instantlogic.interaction.page.SelectionElement(createDeduction3()
,                                        new org.instantlogic.interaction.page.FragmentTemplate("d648eb3d-7500-473f-adc0-1203c6d8d24e", "Row")      
                                        .putChildren("cells",
                                                new org.instantlogic.interaction.page.FragmentTemplate("c9ff68cf-1075-4f06-a6ac-5f9faa354f2b", "Cell")      
                                                .putChildren("content",
                                                        new org.instantlogic.interaction.page.FragmentTemplate("9b38f5c2-8169-4460-887b-f931ce11b022", "Link")      .setEvent(org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE)
      
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