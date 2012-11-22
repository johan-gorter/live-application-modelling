package org.instantlogic.designer.flow.flow;

public class FlowDetailsPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final FlowDetailsPlaceTemplate INSTANCE = new FlowDetailsPlaceTemplate();


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.Design> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		    org.instantlogic.fabric.deduction.Deduction<java.lang.String> d2 
		    	= new org.instantlogic.designer.deduction.CapitalizeFirstDeduction(d1);
		return d2;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowNodeBaseDesign>> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FlowDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowNodeBaseDesign>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FlowDesignEntity.nodes, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction2() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FlowNodeBaseDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction3() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.Design> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		    org.instantlogic.fabric.deduction.Deduction<java.lang.String> d2 
		    	= new org.instantlogic.designer.deduction.CapitalizeFirstDeduction(d1);
		return d2;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("F43P2F2", "Page")      .setStyleNames(new String[]{"margin", "designer"})
      
        .putChildren("mainContent",
                    org.instantlogic.designer.sharedpagefragment.ApplicationContextPageFragment.INSTANCE
,
                new org.instantlogic.interaction.page.FragmentTemplate("F43P2F2P1F2", "Block")      .setStyleNames(new String[]{"card"})
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("F43P2F2P1F2P1F1", "Heading3")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate(" (Flow)")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("F43P2F2P1F2P1F2", "Input")      .setField(org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("F43P2F2P1F2P1F3", "Heading4")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Nodes")))
,
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction1()
,                                new org.instantlogic.interaction.page.FragmentTemplate("F43P2F2P1F2P1S4F2", "Link")      .setEvent(org.instantlogic.designer.event.FlowNodeDetailsEvent.INSTANCE)
      
                                .putChildren("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("F43P2F2P1F2P1S4F2P1F1", "Block")      
                                        .putChildren("content",
                                                new org.instantlogic.interaction.page.FragmentTemplate("F43P2F2P1F2P1S4F2P1F1P1F1", "Strong")      
                                                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction2())))
                                        )
                                )
)
                )
        )
; 
	
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction3()),new org.instantlogic.fabric.text.StringTemplate(" (Flow)"));
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
        return "FlowDetails";
    }
}