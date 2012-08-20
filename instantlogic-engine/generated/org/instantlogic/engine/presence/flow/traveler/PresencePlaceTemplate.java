package org.instantlogic.engine.presence.flow.traveler;

public class PresencePlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final PresencePlaceTemplate INSTANCE = new PresencePlaceTemplate();


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Presence> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.engine.presence.entity.PresenceEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.PresenceEntity.applicationName, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction1() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Presence> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.engine.presence.entity.PresenceEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.PresenceEntity.caseName, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.User> createDeduction2() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Traveler> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.User> d1 
		  		= org.instantlogic.fabric.deduction.ReverseRelationDeduction.create(org.instantlogic.engine.presence.entity.UserEntity.travelers, d0);
		return d1;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("F6P1F1", "Presence")      
        .putValue("applicationName", createDeduction0())      
        .putValue("userName", createDeduction2())      
        .putValue("caseName", createDeduction1()); 
	
	@Override
	public org.instantlogic.interaction.page.FragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "Presence";
    }
}