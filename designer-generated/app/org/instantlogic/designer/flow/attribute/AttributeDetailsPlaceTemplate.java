package org.instantlogic.designer.flow.attribute;

public class AttributeDetailsPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final AttributeDetailsPlaceTemplate INSTANCE = new AttributeDetailsPlaceTemplate();

	@Override
	public String getId() {
		return "1e0a7090-7e6c-429f-bc56-41151734b0d0";
	}
	

	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.EntityDesign> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.AttributeDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.EntityDesign> d1 
		  		= org.instantlogic.fabric.deduction.ReverseRelationDeduction.create(org.instantlogic.designer.entity.EntityDesignEntity.attributes, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.Design> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.DataTypeDesign> createDeduction2() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.AttributeDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.DataTypeDesign> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.AttributeDesignEntity.dataType, d0);
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
        new org.instantlogic.interaction.page.FragmentTemplate("37b397d0-f7bf-47be-870a-56d8c7199a99", "Page")      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.SelectionElement(createDeduction0()
,                            new org.instantlogic.interaction.page.SharedElementHolder("a2a252fa-bf60-4ed7-95b7-86a5c5996664", org.instantlogic.designer.sharedpagefragment.EntityContextPageFragment.INSTANCE)
)
,
                new org.instantlogic.interaction.page.FragmentTemplate("1b4dfae6-06c9-4de1-a614-db5a0ead6037", "Block")      .setStyleNames(new String[]{"card"})
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("c6740d06-642c-44af-bf84-38cc684498e6", "Heading3")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction1()),new org.instantlogic.fabric.text.StringTemplate(" (Attribute)")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("523e8c59-10f0-4c9f-80a8-9dd7246e6855", "Input")      .setField(org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("615ef362-5a1a-458b-a81a-b36644f3ee35", "Heading4")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Data type")))
,
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction2()
,                                new org.instantlogic.interaction.page.FragmentTemplate("edc3e5c3-86e7-45f9-ac13-2e418b4aa7d3", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.dataCategory)
,                                new org.instantlogic.interaction.page.FragmentTemplate("e9460529-cb0f-4fe2-9526-c6a8c104df1a", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.multiLine)
,                                new org.instantlogic.interaction.page.FragmentTemplate("c93e45dd-1c79-4533-a7a4-c7596b94598b", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.formatted)
,                                new org.instantlogic.interaction.page.FragmentTemplate("b619f863-0ea3-436f-b30e-10d62872700c", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.percentage)
,                                new org.instantlogic.interaction.page.FragmentTemplate("cf5c3c34-f8d4-4511-a2eb-ea3c19df21fb", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.wholeNumber)
,                                new org.instantlogic.interaction.page.FragmentTemplate("c1b992d8-948b-4f89-b7df-60e4d1d2ce67", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.exactRounding)
)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("20493ad4-15e8-4b19-8476-6c9100836026", "Heading4")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Value")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("f11a2aea-40af-44ee-8f8c-d5088106fb23", "Input")      .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasRelevance)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("34afaf80-badc-450a-9aeb-49c860d2b026", "Input")      .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasRule)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("46ae9b7c-a9e5-4e72-967f-0727600da873", "Input")      .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.writeable)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("3ef93f25-5523-4295-a7c1-e563ec473fd7", "Input")      .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasDefault)
                )
        )
; 
	
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction3()),new org.instantlogic.fabric.text.StringTemplate(" (Attribute)"));
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
        return "AttributeDetails";
    }
}