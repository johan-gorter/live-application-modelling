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

	
	public static final org.instantlogic.interaction.page.Element SHARED_INSTANCE = 
        new org.instantlogic.interaction.page.FragmentTemplate("S29F1", "Row")      
        .putChildren("cells",
                new org.instantlogic.interaction.page.FragmentTemplate("S29F1P1F1", "Link")      .setEvent(org.instantlogic.example.izzy.event.IssueDetailsEvent.INSTANCE)
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("S29F1P1F1P1F1", "Cell")      
                        .putChildren("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("S29F1P1F1P1F1P1F1", "Paragraph")      
                                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0())))
                        )
,
                        new org.instantlogic.interaction.page.FragmentTemplate("S29F1P1F1P1F2", "Cell")      
                        .putChildren("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("S29F1P1F1P1F2P1F1", "Paragraph")      
                                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction1())))
                        )
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
