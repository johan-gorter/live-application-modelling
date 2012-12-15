package org.instantlogic.designer.flow.placetemplate;

public class PlaceTemplateDetailsPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final PlaceTemplateDetailsPlaceTemplate INSTANCE = new PlaceTemplateDetailsPlaceTemplate();

	@Override
	public String getId() {
		return "c9d3d75e-b4b3-4f3b-bd3b-381c23fe6e70";
	}
	

	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FlowDesign> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FlowNodeBaseDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.FlowDesign> d1 
		  		= org.instantlogic.fabric.deduction.ReverseRelationDeduction.create(org.instantlogic.designer.entity.FlowDesignEntity.nodes, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.Design> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.ElementDesign> createDeduction2() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.PlaceTemplateDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.ElementDesign> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.content, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction3() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.Design> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("b9a35b02-3f62-4c31-895a-e4cad98679b9", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.SelectionElement(createDeduction0()
,                            new org.instantlogic.interaction.page.SharedElementHolder("30c28e2d-0c3a-4449-997a-94f5a9ef93e0", org.instantlogic.designer.sharedpagefragment.FlowContextPageFragment.INSTANCE)
)
,
                new org.instantlogic.interaction.page.FragmentTemplate("8f7d9eee-a1c5-4993-b38b-e68c678e742a", "Block")      .setStyleNames(new String[]{"card"})
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("0b4f8e54-8521-469e-b98c-ee55e0c949d5", "Heading3")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction1()),new org.instantlogic.fabric.text.StringTemplate(" (Place template)")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("dd18e50c-3d36-45d3-8dfd-f042aea891ae", "Input")      .setField(org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("5bd914b8-9220-41fb-be55-2eebf7b4ca29", "Heading4")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Content")))
,
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction2()
,                                new org.instantlogic.interaction.page.FragmentTemplate("0d099ae7-6281-4883-8e8f-ee6c5bd948c9", "ElementEditor")      
                                .putChildren("content",
                                            new org.instantlogic.interaction.page.SharedElementHolder("dc978283-7627-4ec8-8146-36134479eb8f", org.instantlogic.designer.sharedpagefragment.ElementEditorPageFragment.INSTANCE)
                                )
)
                )
        )
; 
	
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction3()),new org.instantlogic.fabric.text.StringTemplate(" (Place)"));
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