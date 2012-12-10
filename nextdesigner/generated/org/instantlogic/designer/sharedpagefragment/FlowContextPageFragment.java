package org.instantlogic.designer.sharedpagefragment;

public class FlowContextPageFragment extends org.instantlogic.interaction.page.SharedElement {
	
	public static FlowContextPageFragment INSTANCE = new FlowContextPageFragment();
	

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FlowDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}

	
	public static final org.instantlogic.interaction.page.Element SHARED_INSTANCE = 
        new org.instantlogic.interaction.page.FragmentTemplate("23480fe4-ff25-4da2-a00b-f906b8a2d3c7", "Group")      
        .putChildren("content",
                    new org.instantlogic.interaction.page.SharedElementHolder("c9f326e4-3198-4144-88de-fb6365f67b29", org.instantlogic.designer.sharedpagefragment.ApplicationContextPageFragment.INSTANCE)
,
                new org.instantlogic.interaction.page.FragmentTemplate("8493475b-8f95-4aea-8731-ba14f1be1fe7", "Link")      .setEvent(org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE)
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("c66707a2-30c1-4933-a98e-52d55f878c87", "Block")      .setStyleNames(new String[]{"inactive-card"})
      
                        .putChildren("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("82afeab6-a7da-4d12-9b52-308179bb296c", "Heading3")      
                                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate(" (Flow)")))
                        )
                )
        )
; 

	protected FlowContextPageFragment() {
	    INSTANCE=this;
	}
	
	static {
	    INSTANCE.setElement(SHARED_INSTANCE);
	}
	
}
