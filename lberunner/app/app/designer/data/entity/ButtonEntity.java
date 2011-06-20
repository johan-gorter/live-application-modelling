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
	
	// Reverse relations
	
	public static final Relation<ButtonInstance, ApplicationInstance, ApplicationInstance> application
		= new SimpleRelation<ButtonInstance, ApplicationInstance, ApplicationInstance>(
			"application", INSTANCE, ButtonEntity.INSTANCE, ApplicationInstance.class, ApplicationEntity.buttons
		) {
	
			@Override
			public ReadOnlyRelationValue<ButtonInstance, ApplicationInstance> get(
					ButtonInstance instance) {
				return instance.application;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		application,
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
