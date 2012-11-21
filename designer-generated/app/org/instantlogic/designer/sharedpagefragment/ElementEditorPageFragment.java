package org.instantlogic.designer.sharedpagefragment;

public class ElementEditorPageFragment extends org.instantlogic.interaction.page.SharedElement {
	
	public static ElementEditorPageFragment INSTANCE = new ElementEditorPageFragment();
	

	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.ElementDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> d1 
		  		= org.instantlogic.fabric.deduction.CastInstanceDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.ElementDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.ElementDesignEntity.editorOpen, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction2() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.fragmentTypeName, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PropertyDesign>> createDeduction3() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PropertyDesign>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.properties, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction4() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.PropertyDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.PropertyDesignEntity.propertyName, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign>> createDeduction5() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.PropertyDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.PropertyDesignEntity.children, d0);
		return d1;
	}

	
	public static final org.instantlogic.interaction.page.Element SHARED_INSTANCE = 
        new org.instantlogic.interaction.page.FragmentTemplate("S57F1", "Block")      .setStyleNames(new String[]{"element"})
      
        .putChildren("content",
                new org.instantlogic.interaction.page.SelectionElement(createDeduction0()
,                        new org.instantlogic.interaction.page.IfElseElement(createDeduction1(),
        new org.instantlogic.interaction.page.Element[] {
                                new org.instantlogic.interaction.page.FragmentTemplate("S57F1P1S1I1F2", "Block")      .setStyleNames(new String[]{"editor"})
      
                                .putChildren("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("S57F1P1S1I1F2P1F1", "Input")      .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.fragmentTypeName)
,
                                        new org.instantlogic.interaction.page.FragmentTemplate("S57F1P1S1I1F2P1F2", "Button")      .setEvent(org.instantlogic.designer.event.CloseEditorEvent.INSTANCE)
      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Close editor")))
                                )
        },
        new org.instantlogic.interaction.page.Element[] {
                                new org.instantlogic.interaction.page.FragmentTemplate("S57F1P1S1I1F3", "Button")      .setEvent(org.instantlogic.designer.event.OpenEditorEvent.INSTANCE)
      
                                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Open editor")))
        }
)
,                        new org.instantlogic.interaction.page.FragmentTemplate("S57F1P1S1F2", "PreviewLine")      
                        .putChildren("content",
                                new org.instantlogic.interaction.page.FragmentTemplate("S57F1P1S1F2P1F1", "Block")      .setStyleNames(new String[]{"info"})
      
                                .putChildren("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("S57F1P1S1F2P1F1P1F1", "Paragraph")      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction2())))
                                )
,
                                new org.instantlogic.interaction.page.FragmentTemplate("S57F1P1S1F2P1F2", "Block")      .setStyleNames(new String[]{"preview"})
      
                                .putChildren("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("S57F1P1S1F2P1F2P1F1", "Preview")          .addCustomFilter(new org.instantlogic.designer.fragmentfilter.PreviewFragmentFilter())
                                )
                        )
,                        new org.instantlogic.interaction.page.SelectionElement(createDeduction3()
,                                new org.instantlogic.interaction.page.FragmentTemplate("S57F1P1S1S3F1", "Paragraph")      
                                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction4())))
,                                new org.instantlogic.interaction.page.SelectionElement(createDeduction5()
,                                            org.instantlogic.designer.sharedpagefragment.ElementEditorPageFragment.INSTANCE
)
)
)
        )
; 

	protected ElementEditorPageFragment() {
	    INSTANCE=this;
	}
	
	static {
	    INSTANCE.setElement(SHARED_INSTANCE);
	}
	
}
