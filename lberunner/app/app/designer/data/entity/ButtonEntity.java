package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class ButtonEntity extends SimpleEntity {

	public static final ButtonEntity INSTANCE = new ButtonEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<ButtonInstance, TextInstance, TextInstance> caption
		= new SimpleRelation<ButtonInstance, TextInstance, TextInstance>(
			"caption", INSTANCE, TextEntity.INSTANCE, TextInstance.class, TextEntity.captionOnButton
		) {
	
			@Override
			public ReadOnlyRelationValue<ButtonInstance, TextInstance> get(
					ButtonInstance instance) {
				return instance.caption;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<ButtonInstance, PageToolboxInstance, PageToolboxInstance> pageToolbox
		= new SimpleRelation<ButtonInstance, PageToolboxInstance, PageToolboxInstance>(
			"pageToolbox", INSTANCE, ButtonEntity.INSTANCE, PageToolboxInstance.class, PageToolboxEntity.buttons
		) {
	
			@Override
			public ReadOnlyRelationValue<ButtonInstance, PageToolboxInstance> get(
					ButtonInstance instance) {
				return instance.pageToolbox;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		caption,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		pageToolbox,
	};

	private ButtonEntity() {
		super("Button");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new ButtonInstance(caseInstance);
	}
	
	@Override
	public Entity extendsEntity() {
		return ConceptEntity.INSTANCE;
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
