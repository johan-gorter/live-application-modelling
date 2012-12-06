package org.instantlogic.engine.presence.flow.traveler;

public class TravelerPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final TravelerPlaceTemplate INSTANCE = new TravelerPlaceTemplate();

	@Override
	public String getId() {
		return "5e0ff8f4-b397-4a2a-bfdc-898dd19b8cbb";
	}
	

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
        new org.instantlogic.interaction.page.FragmentTemplate("f78a44e3-ce35-4082-883e-f7fc505a79a8", "Group")      
        .putChildren("content",
                new org.instantlogic.interaction.page.FragmentTemplate("c6d05be5-41b7-4476-9a97-4f92f962af78", "Presence")      
                .putValue("applicationName", createDeduction0())      
                .putValue("caseName", createDeduction1())      
                .putChildren("content",
                        new org.instantlogic.interaction.page.IfElseElement(createDeduction2(),
        new org.instantlogic.interaction.page.Element[] {
                                new org.instantlogic.interaction.page.FragmentTemplate("4669850f-b721-4712-9523-6447ad936322", "Me")      
                                .putValue("username", createDeduction3()),                                new org.instantlogic.interaction.page.FragmentTemplate("c3a47eaa-3e03-452e-ba81-246d67286da7", "DebugVisibleToggle")      .setField(org.instantlogic.engine.presence.entity.TravelerEntity.INSTANCE, org.instantlogic.engine.presence.entity.TravelerEntity.debugVisible)
,                                new org.instantlogic.interaction.page.IfElseElement(createDeduction4(),
        new org.instantlogic.interaction.page.Element[] {
                                        new org.instantlogic.interaction.page.FragmentTemplate("42ef957d-d062-4bd3-8e09-21cdf55ee6a5", "Communicator")      
                                        .putChildren("users",
                                                new org.instantlogic.interaction.page.SelectionElement(createDeduction5()
,                                                        new org.instantlogic.interaction.page.FragmentTemplate("1ccf3f54-a012-468f-9199-6b2d0e8c1ee8", "User")      
                                                        .putValue("username", createDeduction6()),                                                        new org.instantlogic.interaction.page.SelectionElement(createDeduction7()
,                                                                new org.instantlogic.interaction.page.FragmentTemplate("6c56b0fb-46c3-4722-8d7b-2ccb1e09779a", "Traveler")      
                                                                .putValue("travelerId", createDeduction8())      
                                                                .putValue("placeUrl", createDeduction9()))
)
                                        )
        },
        new org.instantlogic.interaction.page.Element[] {
                                        new org.instantlogic.interaction.page.FragmentTemplate("73a93475-9841-465d-bd7f-1e571a4f8f19", "ShowCommunicatorButton")        }
)
        },
        new org.instantlogic.interaction.page.Element[] {
                                new org.instantlogic.interaction.page.FragmentTemplate("690a9b63-6668-4cb2-95c7-ceb21f01532c", "Login")        }
)
                )
,
                new org.instantlogic.interaction.page.SelectionElement(createDeduction10()
,                        new org.instantlogic.interaction.page.SelectionElement(createDeduction11()
,                                new org.instantlogic.interaction.page.FragmentTemplate("cf96ae4b-b47f-44cd-82d3-cfdd8a4f090f", "Avatar")      
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