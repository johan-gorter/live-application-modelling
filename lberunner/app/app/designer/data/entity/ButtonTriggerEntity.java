package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class ButtonTriggerEntity extends SimpleEntity {

	public static final ButtonTriggerEntity INSTANCE = new ButtonTriggerEntity();
	
	// Attributes
	
	public static final Attribute<ButtonTriggerInstance, java.lang.String, java.lang.String> trigger 
		= new SimpleAttribute<ButtonTriggerInstance, java.lang.String, java.lang.String>(
			"trigger", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<ButtonTriggerInstance, java.lang.String> get(ButtonTriggerInstance instance) {
				return instance.trigger;
			}
		};
	
	// Relations
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		trigger,
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private ButtonTriggerEntity() {
		super("ButtonTrigger");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new ButtonTriggerInstance(caseInstance);
	}
	
	@Override
	public Entity extendsEntity() {
		return PageElementBaseEntity.INSTANCE;
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
