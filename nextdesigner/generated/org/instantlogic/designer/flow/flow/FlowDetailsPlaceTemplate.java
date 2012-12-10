package org.instantlogic.designer.flow.flow;

public class FlowDetailsPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final FlowDetailsPlaceTemplate INSTANCE = new FlowDetailsPlaceTemplate();

	@Override
	public String getId() {
		return "a2963a77-71f2-4a78-b7ce-56bc0ee54b80";
	}
	

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
        new org.instantlogic.interaction.page.FragmentTemplate("67c0fa2c-b357-4854-aff3-b8612d0a1901", "Page")      .setStyleNames(new String[]{"margin", "designer"})
      
        .putChildren("mainContent",
                    new org.instantlogic.interaction.page.SharedElementHolder("50b22e8f-ef03-4127-9cfa-ad200a7abab3", org.instantlogic.designer.sharedpagefragment.ApplicationContextPageFragment.INSTANCE)
,
                new org.instantlogic.interaction.page.FragmentTemplate("353b6c9c-c9e0-4328-a654-ee4be62a7768", "Block")      .setStyleNames(new String[]{"card"})
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("f612130e-05cb-430f-9f74-81de6063e81f", "Heading3")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate(" (Flow)")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("76d63219-3731-435e-8055-438ef3d2509e", "Input")      .setField(org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("03b6e892-c09c-4667-9765-1f0fd0b810ab", "Heading4")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Nodes")))
,
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction1()
,                                new org.instantlogic.interaction.page.FragmentTemplate("7aa02716-33d6-4db2-a22a-b851382e29ce", "Link")      .setEvent(org.instantlogic.designer.event.FlowNodeDetailsEvent.INSTANCE)
      
                                .putChildren("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("456d47ab-7027-42c2-94ce-d07f0cee6b7c", "Block")      
                                        .putChildren("content",
                                                new org.instantlogic.interaction.page.FragmentTemplate("46d38354-f77b-4e76-9367-d95a6a5beba6", "Strong")      
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