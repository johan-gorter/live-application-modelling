package org.instantlogic.engine.presence.flow.traveler;

public class TravelerPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final TravelerPlaceTemplate INSTANCE = new TravelerPlaceTemplate();


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


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction2() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Traveler> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.User> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.user, d0);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> d2 
		  		= org.instantlogic.fabric.deduction.HasValueDeduction.create(d1);
		return d2;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction3() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Traveler> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.User> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.user, d0);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d2 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.UserEntity.username, d1);
		return d2;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> createDeduction4() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Traveler> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.communicatorVisible, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.User>> createDeduction5() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Presence> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.engine.presence.entity.PresenceEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.User>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.PresenceEntity.activeUsers, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction6() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.User> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.engine.presence.entity.UserEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.UserEntity.username, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.Traveler>> createDeduction7() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.User> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.engine.presence.entity.UserEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.Traveler>> d1 
		  		= org.instantlogic.fabric.deduction.ReverseRelationDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.user, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction8() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Traveler> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.id, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction9() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Traveler> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Place> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.currentPlace, d0);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d2 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.PlaceEntity.url, d1);
		return d2;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Place> createDeduction10() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Traveler> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Place> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.currentPlace, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.Traveler>> createDeduction11() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Place> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.engine.presence.entity.PlaceEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.Traveler>> d1 
		  		= org.instantlogic.fabric.deduction.ReverseRelationDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.currentPlace, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction12() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Traveler> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.User> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.user, d0);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d2 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.UserEntity.username, d1);
		return d2;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction13() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Traveler> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.focus, d0);
		return d1;
	}

	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("F6P1F1", "Group")      
        .putChildren("content",
                new org.instantlogic.interaction.page.FragmentTemplate("F6P1F1P1F1", "Presence")      
                .putValue("applicationName", createDeduction0())      
                .putValue("caseName", createDeduction1())      
                .putChildren("content",
                        new org.instantlogic.interaction.page.IfElseElement(createDeduction2(),
        new org.instantlogic.interaction.page.Element[] {
                                new org.instantlogic.interaction.page.FragmentTemplate("F6P1F1P1F1P3I1F2", "Me")      
                                .putValue("username", createDeduction3()),                                new org.instantlogic.interaction.page.FragmentTemplate("F6P1F1P1F1P3I1F3", "DebugVisibleToggle")      .setField(org.instantlogic.engine.presence.entity.TravelerEntity.INSTANCE, org.instantlogic.engine.presence.entity.TravelerEntity.debugVisible)
,                                new org.instantlogic.interaction.page.IfElseElement(createDeduction4(),
        new org.instantlogic.interaction.page.Element[] {
                                        new org.instantlogic.interaction.page.FragmentTemplate("F6P1F1P1F1P3I1I4F2", "Communicator")      
                                        .putChildren("users",
                                                new org.instantlogic.interaction.page.SelectionElement(createDeduction5()
,                                                        new org.instantlogic.interaction.page.FragmentTemplate("F6P1F1P1F1P3I1I4F2P1S1F2", "User")      
                                                        .putValue("username", createDeduction6()),                                                        new org.instantlogic.interaction.page.SelectionElement(createDeduction7()
,                                                                new org.instantlogic.interaction.page.FragmentTemplate("F6P1F1P1F1P3I1I4F2P1S1S3F2", "Traveler")      
                                                                .putValue("travelerId", createDeduction8())      
                                                                .putValue("placeUrl", createDeduction9()))
)
                                        )
        },
        new org.instantlogic.interaction.page.Element[] {
                                        new org.instantlogic.interaction.page.FragmentTemplate("F6P1F1P1F1P3I1I4F3", "ShowCommunicatorButton")        }
)
        },
        new org.instantlogic.interaction.page.Element[] {
                                new org.instantlogic.interaction.page.FragmentTemplate("F6P1F1P1F1P3I1F5", "Login")        }
)
                )
,
                new org.instantlogic.interaction.page.SelectionElement(createDeduction10()
,                        new org.instantlogic.interaction.page.SelectionElement(createDeduction11()
,                                new org.instantlogic.interaction.page.FragmentTemplate("F6P1F1P1S2S2F2", "Avatar")      
                                .putValue("username", createDeduction12())      
                                .putValue("focus", createDeduction13()))
)
        )
; 
	
	
	@Override
	public org.instantlogic.interaction.page.FragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "Traveler";
    }
}