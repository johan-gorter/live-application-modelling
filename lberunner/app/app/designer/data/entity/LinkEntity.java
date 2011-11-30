package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class LinkEntity extends SimpleEntity {

	public static final LinkEntity INSTANCE = new LinkEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<LinkInstance, TextInstance, TextInstance> caption
		= new SimpleRelation<LinkInstance, TextInstance, TextInstance>(
			"caption", INSTANCE, TextEntity.INSTANCE, TextInstance.class, TextEntity.captionOnButton
		) {
	
			@Override
			public ReadOnlyRelationValue<LinkInstance, TextInstance> get(
					LinkInstance instance) {
				return instance.caption;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
		};
	
	public static final Relation<LinkInstance, EventInstance, EventInstance> event
		= new SimpleRelation<LinkInstance, EventInstance, EventInstance>(
			"event", INSTANCE, EventEntity.INSTANCE, EventInstance.class, EventEntity.firesFromButtons
		) {
	
			@Override
			public ReadOnlyRelationValue<LinkInstance, EventInstance> get(
					LinkInstance instance) {
				return instance.event;
			}
		};
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		caption,
		event,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private LinkEntity() {
		super("Link");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new LinkInstance(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return PageFragmentEntity.INSTANCE;
	}
	
	@Override
	public Attribute<? extends Instance, ? extends Object, ? extends Object>[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public Relation<? extends Instance, ? extends Object, ? extends Instance>[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public Relation<? extends Instance, ? extends Object, ? extends Instance>[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}
}
