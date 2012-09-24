package org.instantlogic.designer.flow.main;

public class WelcomePlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final WelcomePlaceTemplate INSTANCE = new WelcomePlaceTemplate();


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign>> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.ApplicationDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.ApplicationDesignEntity.entities, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.Design> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowDesign>> createDeduction2() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.ApplicationDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowDesign>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.ApplicationDesignEntity.flows, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction3() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FlowDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("F20P2F1", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("F20P2F1P1F1", "Heading1")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Welcome"))
)
,
                new org.instantlogic.interaction.page.FragmentTemplate("F20P2F1P1F2", "Paragraph")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Welcome to the Designer"))
)
,
                new org.instantlogic.interaction.page.FragmentTemplate("F20P2F1P1F3", "Table")      
                .putChildren("columns",
                        new org.instantlogic.interaction.page.FragmentTemplate("F20P2F1P1F3P1F1", "Column")      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Entities"))
)
                )
      
                .putChildren("rows",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction0()
,                                new org.instantlogic.interaction.page.FragmentTemplate("F20P2F1P1F3P2S1F2", "Row")      
                                .putChildren("cells",
                                        new org.instantlogic.interaction.page.FragmentTemplate("F20P2F1P1F3P2S1F2P1F1", "Cell")      
                                        .putChildren("content",
                                                new org.instantlogic.interaction.page.FragmentTemplate("F20P2F1P1F3P2S1F2P1F1P1F1", "Link")      .setEvent(org.instantlogic.designer.event.EntityDetailsEvent.INSTANCE)
      
                                                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction1()))
)
                                        )
                                )
)
                )
,
                new org.instantlogic.interaction.page.FragmentTemplate("F20P2F1P1F4", "Table")      
                .putChildren("columns",
                        new org.instantlogic.interaction.page.FragmentTemplate("F20P2F1P1F4P1F1", "Column")      
                        .putText("header", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Flows"))
)
                )
      
                .putChildren("rows",
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction2()
,                                new org.instantlogic.interaction.page.FragmentTemplate("F20P2F1P1F4P2S1F2", "Row")      
                                .putChildren("cells",
                                        new org.instantlogic.interaction.page.FragmentTemplate("F20P2F1P1F4P2S1F2P1F1", "Cell")      
                                        .putChildren("content",
                                                new org.instantlogic.interaction.page.FragmentTemplate("F20P2F1P1F4P2S1F2P1F1P1F1", "Link")      .setEvent(org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE)
      
                                                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction3()))
)
                                        )
                                )
)
                )
        )
; 
	
	@Override
	public org.instantlogic.interaction.page.FragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "Welcome";
    }
}