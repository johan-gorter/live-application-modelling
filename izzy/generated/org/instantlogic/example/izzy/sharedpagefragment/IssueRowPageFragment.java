package org.instantlogic.example.izzy.sharedpagefragment;

public class IssueRowPageFragment extends org.instantlogic.interaction.page.SharedElement {
	
	public static IssueRowPageFragment INSTANCE = new IssueRowPageFragment();
	

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Integer> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.Issue> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.Integer> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.number, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.Issue> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.example.izzy.entity.IssueEntity.headline, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction2() {
		    org.instantlogic.fabric.deduction.Deduction<java.lang.String> d0 
		    	= new org.instantlogic.example.izzy.deduction.IssuePreviewDeduction();
		return d0;
	}

	
	public static final org.instantlogic.interaction.page.Element SHARED_INSTANCE = 
        new org.instantlogic.interaction.page.FragmentTemplate("3e300c5b-05ef-44b3-a8d2-bb474b3d1064", "Row")      
        .putChildren("cells",
                new org.instantlogic.interaction.page.FragmentTemplate("84637dd1-7372-435a-9424-d0eecd915e5b", "Link")      .setEvent(org.instantlogic.example.izzy.event.IssueDetailsEvent.INSTANCE)
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("fdffab5c-a4e8-42d4-952e-733e7ccadb14", "Cell")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0())))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("4649e1ad-c2db-408e-8356-474e05d03992", "Cell")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction1())))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("3b4a119a-3b80-4bd8-b4d8-dc4b63f082d4", "Cell")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction2())))
                )
        )
; 

	protected IssueRowPageFragment() {
	    INSTANCE=this;
	}
	
	static {
	    INSTANCE.setElement(SHARED_INSTANCE);
	}
	
}
