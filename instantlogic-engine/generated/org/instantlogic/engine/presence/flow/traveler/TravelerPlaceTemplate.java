package org.instantlogic.engine.presence.flow.traveler;

public class TravelerPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final TravelerPlaceTemplate INSTANCE = new TravelerPlaceTemplate();

	@Override
	public String getId() {
		return "7df52d96-367c-4a30-b9fc-095a512d1515";
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
        new org.instantlogic.interaction.page.FragmentTemplate("db10b0ac-183d-458a-9404-6410b55abe77", "Group")      
        .putChildren("content",
                new org.instantlogic.interaction.page.FragmentTemplate("7e06ef6d-b544-44f4-a794-d168d97ad575", "Presence")      
                .putValue("applicationName", createDeduction0())      
                .putValue("caseName", createDeduction1())      
                .putChildren("content",
                        new org.instantlogic.interaction.page.IfElseElement(createDeduction2(),
        new org.instantlogic.interaction.page.Element[] {
                                new org.instantlogic.interaction.page.FragmentTemplate("3c3ae63d-6bb9-4f17-a7c6-886956d14918", "Me")      
                                .putValue("username", createDeduction3()),                                new org.instantlogic.interaction.page.FragmentTemplate("1184922b-640a-4104-aaa3-9290a0b3f97a", "DebugVisibleToggle")      .setField(org.instantlogic.engine.presence.entity.TravelerEntity.INSTANCE, org.instantlogic.engine.presence.entity.TravelerEntity.debugVisible)
,                                new org.instantlogic.interaction.page.FragmentTemplate("19adf032-47b5-4216-a712-247c1d1f02c4", "Communicator")      
                                .putChildren("users",
                                        new org.instantlogic.interaction.page.SelectionElement(createDeduction4()
,                                                new org.instantlogic.interaction.page.FragmentTemplate("eeb0efc1-ac29-4e6d-a2cf-0fd7e4b4736c", "User")      
                                                .putValue("username", createDeduction5())      
                                                .putChildren("travelers",
                                                        new org.instantlogic.interaction.page.SelectionElement(createDeduction6()
,                                                                new org.instantlogic.interaction.page.FragmentTemplate("10c32edf-b706-4aef-a590-e6c0344990d6", "Traveler")      
                                                                .putValue("travelerId", createDeduction7())      
                                                                .putValue("placeTitle", createDeduction9())      
                                                                .putValue("placeUrl", createDeduction8()))
                                                )
)
                                )
        },
        new org.instantlogic.interaction.page.Element[] {
                                new org.instantlogic.interaction.page.FragmentTemplate("a6c43105-78cd-427f-b4b0-56075001b08c", "Login")        }
)
                )
,
                new org.instantlogic.interaction.page.SelectionElement(createDeduction10()
,                        new org.instantlogic.interaction.page.SelectionElement(createDeduction11()
,                                new org.instantlogic.interaction.page.FragmentTemplate("ed26dc2b-cd55-4cdb-ba07-572ec1159a95", "Avatar")      
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