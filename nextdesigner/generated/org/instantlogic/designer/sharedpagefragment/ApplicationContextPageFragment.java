package org.instantlogic.designer.sharedpagefragment;

public class ApplicationContextPageFragment extends org.instantlogic.interaction.page.SharedElement {
	
	

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.ApplicationDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.ApplicationDesignEntity.name, d0);
		return d1;
	}

	
	public static final org.instantlogic.interaction.page.Element SHARED_INSTANCE = 
        new org.instantlogic.interaction.page.FragmentTemplate("S45F1", "Link")      .setEvent(org.instantlogic.designer.event.HomeEvent.INSTANCE)
      
        .putChildren("content",
                new org.instantlogic.interaction.page.FragmentTemplate("S45F1P1F1", "Block")      .setStyleNames(new String[]{"inactive-card"})
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("S45F1P1F1P1F1", "Heading1")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate(" (Application)")))
                )
        )
; 

	public static ApplicationContextPageFragment INSTANCE = new ApplicationContextPageFragment();
	
	protected ApplicationContextPageFragment() {
		super(SHARED_INSTANCE);
	}
	
}