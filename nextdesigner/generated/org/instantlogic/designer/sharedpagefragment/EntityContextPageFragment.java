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
        new org.instantlogic.interaction.page.FragmentTemplate("9e077137-5fd5-4f7a-b8f8-05647f955978", "Group")      
        .putChildren("content",
                    new org.instantlogic.interaction.page.SharedElementHolder("2536dfd2-6a1b-4261-8590-bedb86694880", org.instantlogic.designer.sharedpagefragment.ApplicationContextPageFragment.INSTANCE)
,
                new org.instantlogic.interaction.page.FragmentTemplate("e0d3791f-8174-4da2-981e-a45894e09092", "Link")      .setEvent(org.instantlogic.designer.event.EntityDetailsEvent.INSTANCE)
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("161d419c-d412-4e94-b528-41019d4cc779", "Block")      .setStyleNames(new String[]{"inactive-card"})
      
                        .putChildren("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("4ba6f729-0b0a-4935-bcc3-584f2c9de91b", "Heading3")      
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
