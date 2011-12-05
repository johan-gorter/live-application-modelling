package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class LinkDesignEntity extends SimpleEntity {

	public static final LinkDesignEntity INSTANCE = new LinkDesignEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<LinkDesign, TextDesign, TextDesign> caption
		= new SimpleRelation<LinkDesign, TextDesign, TextDesign>(
			"caption", INSTANCE, TextDesignEntity.INSTANCE, TextDesign.class, TextDesignEntity.captionOnButton
		) {
	
			@Override
			public ReadOnlyRelationValue<LinkDesign, TextDesign> get(
					LinkDesign instance) {
				return instance.caption;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
		};
	
	public static final Relation<LinkDesign, EventDesign, EventDesign> event
		= new SimpleRelation<LinkDesign, EventDesign, EventDesign>(
			"event", INSTANCE, EventDesignEntity.INSTANCE, EventDesign.class, EventDesignEntity.firesFromButtons
		) {
	
			@Override
			public ReadOnlyRelationValue<LinkDesign, EventDesign> get(
					LinkDesign instance) {
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

	private LinkDesignEntity() {
		super("LinkDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new LinkDesign(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return PageFragmentDesignEntity.INSTANCE;
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
