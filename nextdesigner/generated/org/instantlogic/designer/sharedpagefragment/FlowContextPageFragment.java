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
        new org.instantlogic.interaction.page.FragmentTemplate("6f993a20-e59b-4ec2-84a6-8c6edd1d1e5f", "Group")      
        .putChildren("content",
                    new org.instantlogic.interaction.page.SharedElementHolder("6c5624cc-3a53-4df3-a8a2-40f73639941e", org.instantlogic.designer.sharedpagefragment.ApplicationContextPageFragment.INSTANCE)
,
                new org.instantlogic.interaction.page.FragmentTemplate("df85e8a8-9421-4863-9667-2d59dc33c575", "Link")      .setEvent(org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE)
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("f644bdb7-adba-413a-b134-845b9ebb5c62", "Block")      .setStyleNames(new String[]{"inactive-card"})
      
                        .putChildren("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("8d006d97-4f67-48f1-a387-a4de175a4fc8", "Heading3")      
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
