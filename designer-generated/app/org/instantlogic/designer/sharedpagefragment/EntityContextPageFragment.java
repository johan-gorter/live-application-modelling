package org.instantlogic.designer.sharedpagefragment;

public class EntityContextPageFragment extends org.instantlogic.interaction.page.SharedElement {
	
	public static EntityContextPageFragment INSTANCE = new EntityContextPageFragment();
	

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.EntityDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}

	
	public static final org.instantlogic.interaction.page.Element SHARED_INSTANCE = 
        new org.instantlogic.interaction.page.FragmentTemplate("9177cf64-f0a5-438d-b57a-22bfe4a3d0d5", "Group")      
        .putChildren("content",
                    new org.instantlogic.interaction.page.SharedElementHolder("52cedd3a-f336-4aa9-b9ec-f10639959e6f", org.instantlogic.designer.sharedpagefragment.ApplicationContextPageFragment.INSTANCE)
,
                new org.instantlogic.interaction.page.FragmentTemplate("ea73ae83-7512-47a5-ac5e-8be5966fed1d", "Link")      .setEvent(org.instantlogic.designer.event.EntityDetailsEvent.INSTANCE)
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("fcf9435d-0e9c-4bd7-96e3-4584230fdcc9", "Block")      .setStyleNames(new String[]{"inactive-card"})
      
                        .putChildren("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("26e2316d-8c8d-41c3-8c9e-60834fcfe746", "Heading3")      
                                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate(" (Entity)")))
                        )
                )
        )
; 

	protected EntityContextPageFragment() {
	    INSTANCE=this;
	}
	
	static {
	    INSTANCE.setElement(SHARED_INSTANCE);
	}
	
}
