package org.instantlogic.engine.presence.flow.traveler;

@SuppressWarnings({"unchecked"})
public class TravelerPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final TravelerPlaceTemplate INSTANCE = new TravelerPlaceTemplate();

	@Override
	public String getId() {
		return "09fb2aef-0994-4319-9a40-93de0a550b6d";
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


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.User>> createDeduction4() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Presence> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.engine.presence.entity.PresenceEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.User>> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.PresenceEntity.activeUsers, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction5() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.User> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.engine.presence.entity.UserEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.UserEntity.username, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.Traveler>> createDeduction6() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.User> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.engine.presence.entity.UserEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.fabric.value.Multi<org.instantlogic.engine.presence.Traveler>> d1 
		  		= org.instantlogic.fabric.deduction.ReverseRelationDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.user, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction7() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Traveler> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.id, d0);
		return d1;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction8() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Traveler> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Place> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.currentPlace, d0);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d2 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.PlaceEntity.url, d1);
		return d2;
	}


	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction9() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Traveler> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.engine.presence.Place> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.TravelerEntity.currentPlace, d0);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d2 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.engine.presence.entity.PlaceEntity.title, d1);
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
        new org.instantlogic.interaction.page.FragmentTemplate("c5d855da-745e-4d48-b513-dfdb0c661937", "Group")      
        .putChildren("content",
                new org.instantlogic.interaction.page.FragmentTemplate("b54f7ecf-6fa9-4bce-9427-ab96d5971eeb", "Presence")      
                .putValue("applicationName", createDeduction0())      
                .putValue("caseName", createDeduction1())      
                .putChildren("content",
                        new org.instantlogic.interaction.page.IfElseElement(createDeduction2(),
        new org.instantlogic.interaction.page.Element[] {
                                new org.instantlogic.interaction.page.FragmentTemplate("a1047bca-b451-4f03-86d3-867235af4855", "Me")      
                                .putValue("username", createDeduction3()),                                new org.instantlogic.interaction.page.FragmentTemplate("8108a2e9-ffba-4a95-93d8-fee66fa9d586", "DebugVisibleToggle")      .setField(org.instantlogic.engine.presence.entity.TravelerEntity.INSTANCE, org.instantlogic.engine.presence.entity.TravelerEntity.debugVisible)
,                                new org.instantlogic.interaction.page.FragmentTemplate("7458dac5-9dbc-4b81-8fb0-9728d8c17b2a", "Communicator")      
                                .putChildren("users",
                                        new org.instantlogic.interaction.page.SelectionElement(createDeduction4()
,                                                new org.instantlogic.interaction.page.FragmentTemplate("b46c045e-2fbb-45b6-861a-f6175bd38a98", "User")      
                                                .putValue("username", createDeduction5())      
                                                .putChildren("travelers",
                                                        new org.instantlogic.interaction.page.SelectionElement(createDeduction6()
,                                                                new org.instantlogic.interaction.page.FragmentTemplate("3806b737-c3d4-4d06-ba45-cfc90df51832", "Traveler")      
                                                                .putValue("travelerId", createDeduction7())      
                                                                .putValue("placeTitle", createDeduction9())      
                                                                .putValue("placeUrl", createDeduction8()))
                                                )
)
                                )
        },
        new org.instantlogic.interaction.page.Element[] {
                                new org.instantlogic.interaction.page.FragmentTemplate("ae289a22-8d3d-41fd-b7d7-02fee29c18ad", "Login")        }
)
                )
,
                new org.instantlogic.interaction.page.SelectionElement(createDeduction10()
,                        new org.instantlogic.interaction.page.SelectionElement(createDeduction11()
,                                new org.instantlogic.interaction.page.FragmentTemplate("29b85bb3-1d94-4ea5-a227-e67cfb68e5b2", "Avatar")      
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