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
        new org.instantlogic.interaction.page.FragmentTemplate("29ace753-ac84-4a47-8fe2-4dd8f2d677d7", "Row")      
        .putChildren("cells",
                new org.instantlogic.interaction.page.FragmentTemplate("1b7eb1c3-1753-4c6b-a48b-323185aef969", "Link")      .setEvent(org.instantlogic.example.izzy.event.IssueDetailsEvent.INSTANCE)
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("00e3f348-6ea4-4593-955d-6c9dc679c99f", "Cell")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0())))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("1e2b425f-af4c-4537-9d8e-eb4c04473bea", "Cell")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction1())))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("29cef55f-7e73-41f4-8e80-430de01fee2a", "Cell")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction2())))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("6bbfb4fd-6c2c-4310-a090-778d644d290a", "Cell")      
                        .putChildren("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("e25292dc-3c50-4cc5-9cdb-d1ec28c39262", "PresenceIndicator")                        )
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
