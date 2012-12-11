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
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.fragmentTypeName, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PropertyDesign>> createDeduction7() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FragmentTemplateDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.PropertyDesign>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.properties, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction8() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.PropertyDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.PropertyDesignEntity.propertyName, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign>> createDeduction9() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.PropertyDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.PropertyDesignEntity.children, d0);
		return d1;
	}

	
	public static final org.instantlogic.interaction.page.Element SHARED_INSTANCE = 
        new org.instantlogic.interaction.page.FragmentTemplate("2c3eefeb-cdf0-4293-a40c-3a268d3f0686", "Block")      .setStyleNames(new String[]{"element"})
      
        .putChildren("content",
                new org.instantlogic.interaction.page.SelectionElement(createDeduction0()
,                        new org.instantlogic.interaction.page.IfElseElement(createDeduction1(),
        new org.instantlogic.interaction.page.Element[] {
                                new org.instantlogic.interaction.page.FragmentTemplate("e0765c97-f64d-40c0-99e1-260bc48839de", "Block")      .setStyleNames(new String[]{"editor"})
      
                                .putChildren("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("0717c6c6-9ca8-4aa8-a6e9-5b507ffa0d65", "Input")      .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type)
,
                                        new org.instantlogic.interaction.page.IfElseElement(createDeduction2(),
        new org.instantlogic.interaction.page.Element[] {
                                                new org.instantlogic.interaction.page.FragmentTemplate("f4d08820-2dca-4b16-97c5-c124a055f520", "Block")      
                                                .putChildren("content",
                                                        new org.instantlogic.interaction.page.FragmentTemplate("a807306f-55c7-4bda-8268-bc1f9ae768c7", "Input")      .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity)
,
                                                        new org.instantlogic.interaction.page.IfElseElement(createDeduction3(),
        new org.instantlogic.interaction.page.Element[] {
                                                                new org.instantlogic.interaction.page.FragmentTemplate("ad416910-1438-4565-82e0-3d30ea0cf7c0", "Block")      
                                                                .putChildren("content",
                                                                        new org.instantlogic.interaction.page.FragmentTemplate("8c93cbf4-d09c-4b69-9a7b-c9a52c76ba64", "Input")      .setField(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE, org.instantlogic.designer.entity.FragmentTemplateDesignEntity.attribute)
,
                                                                        new org.instantlogic.interaction.page.FragmentTemplate("d5b6d64a-3721-4a16-8bc0-15d455176f5b", "Button")      .setEvent(org.instantlogic.designer.event.NewAttributeForFragmentTemplateEvent.INSTANCE)
      
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
,                        new org.instantlogic.interaction.page.FragmentTemplate("e35fc89e-a713-4a20-9c7f-71c6eb68bc54", "PreviewLine")      
                        .putValue("previewMode", createDeduction4())      
                        .putChildren("content",
                                new org.instantlogic.interaction.page.IfElseElement(createDeduction5(),
        new org.instantlogic.interaction.page.Element[] {
                                        new org.instantlogic.interaction.page.FragmentTemplate("f0c841cf-138d-4d08-9552-4cc2ade17043", "Button")      .setStyleNames(new String[]{"editor-toggle"})
      .setEvent(org.instantlogic.designer.event.CloseEditorEvent.INSTANCE)
      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Close editor")))
        },
        new org.instantlogic.interaction.page.Element[] {
                                        new org.instantlogic.interaction.page.FragmentTemplate("2aeab885-6a95-4bdd-ba1e-805220065636", "Button")      .setStyleNames(new String[]{"editor-toggle"})
      .setEvent(org.instantlogic.designer.event.OpenEditorEvent.INSTANCE)
      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Edit")))
        }
)
,
                                new org.instantlogic.interaction.page.FragmentTemplate("382dbec4-51d3-4767-b4f9-5510ba49eb7e", "Block")      .setStyleNames(new String[]{"info"})
      
                                .putChildren("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("c65e062a-d840-4194-85a1-e476d22d6dfb", "Paragraph")      
                                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction6())))
                                )
,
                                new org.instantlogic.interaction.page.FragmentTemplate("ef1408ec-7f26-4ba9-808b-a3da2516a078", "Preview")      
                                .putChildren("content",
                                        new org.instantlogic.interaction.page.FragmentTemplate("5bcf0c63-a35e-4274-a247-462b9e7fb7ce", "PreviewPlaceholder")          .addCustomFilter(new org.instantlogic.designer.fragmentfilter.PreviewFragmentFilter())
                                )
                        )
,                        new org.instantlogic.interaction.page.SelectionElement(createDeduction7()
,                                new org.instantlogic.interaction.page.FragmentTemplate("9f165345-693a-444c-93a5-c657269ad504", "Paragraph")      
                                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction8())))
,                                new org.instantlogic.interaction.page.SelectionElement(createDeduction9()
,                                            new org.instantlogic.interaction.page.SharedElementHolder("7bc87640-e5cd-461f-a4a2-9c0b8d9cf815", org.instantlogic.designer.sharedpagefragment.ElementEditorPageFragment.INSTANCE)
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
