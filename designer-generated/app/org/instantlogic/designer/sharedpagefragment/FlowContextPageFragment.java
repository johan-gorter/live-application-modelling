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
        new org.instantlogic.interaction.page.FragmentTemplate("4e50e1e9-530b-4514-a7b0-f05476eccf3b", "Group")      
        .putChildren("content",
                    org.instantlogic.designer.sharedpagefragment.ApplicationContextPageFragment.INSTANCE
,
                new org.instantlogic.interaction.page.FragmentTemplate("600816ee-f4b4-4dcb-8456-136ca162157b", "Link")      .setEvent(org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE)
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("ece7137f-162c-4416-9cd9-d6554962cd95", "Block")      .setStyleNames(new String[]{"inactive-card"})
      
                        .putChildren("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("57565289-f53e-4202-9a4f-8146f5fc5eea", "Heading3")      
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
