package org.instantlogic.designer.sharedpagefragment;

public class ApplicationContextPageFragment extends org.instantlogic.interaction.page.SharedElement {
	
	public static ApplicationContextPageFragment INSTANCE = new ApplicationContextPageFragment();
	

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.ApplicationDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.ApplicationDesignEntity.name, d0);
		return d1;
	}

	
	public static final org.instantlogic.interaction.page.Element SHARED_INSTANCE = 
        new org.instantlogic.interaction.page.FragmentTemplate("2dd9cc27-3673-4d7f-82be-e73f053155ec", "Link")      .setEvent(org.instantlogic.designer.event.HomeEvent.INSTANCE)
      
        .putChildren("content",
                new org.instantlogic.interaction.page.FragmentTemplate("38036826-899a-47d1-a3fc-8f6bff87067e", "Block")      .setStyleNames(new String[]{"inactive-card"})
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("e6f78fe0-448f-4041-84ef-b46c70d21d24", "Heading3")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate(" (Application)")))
                )
        )
; 

	protected ApplicationContextPageFragment() {
	    INSTANCE=this;
	}
	
	static {
	    INSTANCE.setElement(SHARED_INSTANCE);
	}
	
}
