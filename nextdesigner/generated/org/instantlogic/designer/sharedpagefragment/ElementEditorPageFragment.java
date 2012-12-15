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


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction2() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTypeDesign> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type, d0);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> d2 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FragmentTypeDesignEntity.hasAttribute, d1);
		return d2;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction3() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.EntityDesign> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity, d0);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> d2 
		  		= org.instantlogic.fabric.deduction.HasValueDeduction.create(d1);
		return d2;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction4() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.ElementDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.ElementDesignEntity.previewMode, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction5() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.ElementDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.ElementDesignEntity.editorOpen, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction6() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTypeDesign> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type, d0);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d2 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d1);
		return d2;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PropertyDesign>> createDeduction7() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PropertyDesign>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.properties, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign>> createDeduction8() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.PropertyDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.PropertyDesignEntity.children, d0);
		return d1;
	}

	
	public static final org.instantlogic.interaction.page.Element SHARED_INSTANCE = 
        new org.instantlogic.interaction.page.FragmentTemplate("5a7181b5-d1f5-4d87-bf9d-a5d8d36b0634", "Block")      .setStyleNames(new String[]{"element"})
      
        .putChildren("content",
                new org.instantlogic.interaction.page.SelectionElement(createDeduction0()
,                        new org.instantlogic.interaction.page.IfElseElement(createDeduction1(),
        new org.instantlogic.interaction.page.Element[] {
                                new org.instantlogic.interaction.page.FragmentTemplate("e03b756b-65f8-44f0-809d-cad9c1ae9852", "Block")      .setStyleNames(new String[]{"editor"})
      
                                .putChildren("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("d4590902-ca79-4173-9793-19e144c51a21", "Input")      .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type)
,
                                        new org.instantlogic.interaction.page.IfElseElement(createDeduction2(),
        new org.instantlogic.interaction.page.Element[] {
                                                new org.instantlogic.interaction.page.FragmentTemplate("c8006f14-c7e4-44a3-8fae-68e83ce57929", "Block")      
                                                .putChildren("content",
                                                        new org.instantlogic.interaction.page.FragmentTemplate("7fed55a4-4d60-489b-96db-3717bc52ff70", "Input")      .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity)
,
                                                        new org.instantlogic.interaction.page.IfElseElement(createDeduction3(),
        new org.instantlogic.interaction.page.Element[] {
                                                                new org.instantlogic.interaction.page.FragmentTemplate("023438b5-50ec-484c-b788-b43da3b60114", "Block")      
                                                                .putChildren("content",
                                                                        new org.instantlogic.interaction.page.FragmentTemplate("87a9657f-b5b4-42a3-aa32-5bc460165eb0", "Input")      .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.attribute)
,
                                                                        new org.instantlogic.interaction.page.FragmentTemplate("c1e73b5b-a465-4be1-9ff3-60968a6d8414", "Button")      .setEvent(org.instantlogic.designer.event.NewAttributeForFragmentTemplateEvent.INSTANCE)
      
                                                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("New attribute")))
                                                                )
        },
        new org.instantlogic.interaction.page.Element[] {
        }
)
                                                )
        },
        new org.instantlogic.interaction.page.Element[] {
        }
)
                                )
        },
        new org.instantlogic.interaction.page.Element[] {
        }
)
,                        new org.instantlogic.interaction.page.FragmentTemplate("c6d5c113-df8f-453b-9351-26ceec1da0c3", "PreviewLine")      
                        .putValue("previewMode", createDeduction4())      
                        .putChildren("content",
                                new org.instantlogic.interaction.page.IfElseElement(createDeduction5(),
        new org.instantlogic.interaction.page.Element[] {
                                        new org.instantlogic.interaction.page.FragmentTemplate("18154b55-67be-4058-92ca-f72b4bd99b78", "Button")      .setStyleNames(new String[]{"editor-toggle"})
      .setEvent(org.instantlogic.designer.event.CloseEditorEvent.INSTANCE)
      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Close editor")))
        },
        new org.instantlogic.interaction.page.Element[] {
                                        new org.instantlogic.interaction.page.FragmentTemplate("1bc8cf4d-267e-45f5-b262-73922a4ef36d", "Button")      .setStyleNames(new String[]{"editor-toggle"})
      .setEvent(org.instantlogic.designer.event.OpenEditorEvent.INSTANCE)
      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Edit")))
        }
)
,
                                new org.instantlogic.interaction.page.FragmentTemplate("c4de896b-aad5-4608-a43c-29af64523011", "Block")      .setStyleNames(new String[]{"info"})
      
                                .putChildren("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("31ce0113-c64f-48e6-b590-ff525511751d", "Heading5")      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction6())))
                                )
,
                                new org.instantlogic.interaction.page.FragmentTemplate("f6749358-291b-4bce-911c-38d1e39f57ec", "Preview")      
                                .putChildren("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("40c780c6-fea5-4d9a-8218-4b83edfb6672", "PreviewPlaceholder")          .addCustomFilter(new org.instantlogic.designer.fragmentfilter.PreviewFragmentFilter())
                                )
                        )
,                        new org.instantlogic.interaction.page.SelectionElement(createDeduction7()
,                                new org.instantlogic.interaction.page.SelectionElement(createDeduction8()
,                                            new org.instantlogic.interaction.page.SharedElementHolder("dfe73a09-eaec-4c55-80ab-5e8171bb2cf0", org.instantlogic.designer.sharedpagefragment.ElementEditorPageFragment.INSTANCE)
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
