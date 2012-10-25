package org.instantlogic.designer.flow.attribute;

public class AttributeDetailsPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final AttributeDetailsPlaceTemplate INSTANCE = new AttributeDetailsPlaceTemplate();


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.Design> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.DataTypeDesign> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.AttributeDesign> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.DataTypeDesign> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.AttributeDesignEntity.dataType, d0);
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
        new org.instantlogic.interaction.page.FragmentTemplate("F39P1F2", "Page")      
        .putChildren("mainContent",
                    org.instantlogic.designer.sharedpagefragment.EntityContextPageFragment.INSTANCE
,
                new org.instantlogic.interaction.page.FragmentTemplate("F39P1F2P1F2", "Block")      .setStyleNames(new String[]{"card"})
      
                .putChildren("content",
                        new org.instantlogic.interaction.page.FragmentTemplate("F39P1F2P1F2P1F1", "Heading1")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()),new org.instantlogic.fabric.text.StringTemplate(" (Attribute)")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("F39P1F2P1F2P1F2", "Input")      .setField(org.instantlogic.designer.entity.DesignEntity.INSTANCE, org.instantlogic.designer.entity.DesignEntity.name)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("F39P1F2P1F2P1F3", "Heading2")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Data type")))
,
                        new org.instantlogic.interaction.page.SelectionElement(createDeduction1()
,                                new org.instantlogic.interaction.page.FragmentTemplate("F39P1F2P1F2P1S4F1", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.dataCategory)
,                                new org.instantlogic.interaction.page.FragmentTemplate("F39P1F2P1F2P1S4F2", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.multiLine)
,                                new org.instantlogic.interaction.page.FragmentTemplate("F39P1F2P1F2P1S4F3", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.formatted)
,                                new org.instantlogic.interaction.page.FragmentTemplate("F39P1F2P1F2P1S4F4", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.percentage)
,                                new org.instantlogic.interaction.page.FragmentTemplate("F39P1F2P1F2P1S4F5", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.wholeNumber)
,                                new org.instantlogic.interaction.page.FragmentTemplate("F39P1F2P1F2P1S4F6", "Input")      .setField(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.exactRounding)
)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("F39P1F2P1F2P1F5", "Heading2")      
                        .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Value")))
,
                        new org.instantlogic.interaction.page.FragmentTemplate("F39P1F2P1F2P1F6", "Input")      .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasRelevance)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("F39P1F2P1F2P1F7", "Input")      .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasRule)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("F39P1F2P1F2P1F8", "Input")      .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.writeable)
,
                        new org.instantlogic.interaction.page.FragmentTemplate("F39P1F2P1F2P1F9", "Input")      .setField(org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.hasDefault)
                )
        )
; 
	
	private static final org.instantlogic.fabric.text.TextTemplate TITLE = new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction2()),new org.instantlogic.fabric.text.StringTemplate(" (Attribute)"));
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