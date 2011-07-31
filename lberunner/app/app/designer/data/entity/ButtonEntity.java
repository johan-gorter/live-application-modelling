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
	
	public static final Attribute<ButtonInstance, java.lang.String, java.lang.String> trigger 
		= new SimpleAttribute<ButtonInstance, java.lang.String, java.lang.String>(
			"trigger", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<ButtonInstance, java.lang.String> get(ButtonInstance instance) {
				return instance.trigger;
			}
		};
	
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

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		trigger,
	};
	private static final Relation[] RELATIONS = new Relation[]{
		caption,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private ButtonEntity() {
		super("Button");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new ButtonInstance(caseInstance, id);
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
