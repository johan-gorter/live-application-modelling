package org.instantlogic.designer.flow.placetemplate;

public class PlaceTemplateDetailsPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final PlaceTemplateDetailsPlaceTemplate INSTANCE = new PlaceTemplateDetailsPlaceTemplate();


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.Design> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.ElementDesign> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.PlaceTemplateDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.ElementDesign> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.content, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction2() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.Design> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("5e43f2b9-4309-41d2-a724-cc5f6fc9b1c7", "Page")      .setStyleNames(new String[]{"margin", "designer"})
      
        .putChildren("mainContent",
                    org.instantlogic.designer.sharedpagefragment.FlowContextPageFragment.INSTANCE
,
                new org.instantlogic.interaction.page.FragmentTemplate("891b6434-9f40-4b27-9200-e8761a1efb4c", "Block")      .setStyleNames(new String[]{"card"})
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("f2bb23dc-5147-4d61-8650-d62c68b2679a", "Heading3")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate(" (Place template)")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("08215c56-a239-4a78-b6f1-343c920d1925", "Input")      .setField(org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("b5bcdbce-5ec5-449a-80c4-66cb34822bc0", "Heading4")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Content")))
,
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction1()
,                                new org.instantlogic.interaction.page.FragmentTemplate("7a5b4c17-08d1-439d-b9bf-d92eda096866", "ElementEditor")      
                                .putChildren("content",
                                            org.instantlogic.designer.sharedpagefragment.ElementEditorPageFragment.INSTANCE
                                )
)
                )
        )
; 
	
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction2()),new org.instantlogic.fabric.text.StringTemplate(" (Place)"));
	@Override
	protected org.instantlogic.fabric.text.TextTemplate getTitle() {
		return TITLE;
	}
	
	@Override
	public org.instantlogic.interaction.page.FragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "PlaceTemplateDetails";
    }
}