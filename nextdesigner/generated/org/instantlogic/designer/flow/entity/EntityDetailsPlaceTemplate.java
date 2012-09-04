package org.instantlogic.designer.flow.entity;

public class EntityDetailsPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final EntityDetailsPlaceTemplate INSTANCE = new EntityDetailsPlaceTemplate();


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.designer.Design> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.designer.entity.DesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.designer.entity.DesignEntity.name, d0);
		return d1;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("F26P1F1", "Page")      
        .putChildren("headerContent",
                new org.instantlogic.interaction.page.FragmentTemplate("F26P1F1P1F1", "Heading1")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Entity"))
)
        )
      
        .putChildren("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("F26P1F1P2F1", "Paragraph")      
                .putText("text", new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()))
)
        )
; 
	
	@Override
	public org.instantlogic.interaction.page.FragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "EntityDetails";
    }
}