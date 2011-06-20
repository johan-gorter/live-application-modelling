package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class DomainEntryEntity extends SimpleEntity {

	public static final DomainEntryEntity INSTANCE = new DomainEntryEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<DomainEntryInstance, TextInstance, TextInstance> display
		= new SimpleRelation<DomainEntryInstance, TextInstance, TextInstance>(
			"display", INSTANCE, TextEntity.INSTANCE, TextInstance.class, TextEntity.displayOnDomainEntry
		) {
	
			@Override
			public ReadOnlyRelationValue<DomainEntryInstance, TextInstance> get(
					DomainEntryInstance instance) {
				return instance.display;
			}
	
			public boolean isOwner() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<DomainEntryInstance, AttributeInstance, AttributeInstance> attribute
		= new SimpleRelation<DomainEntryInstance, AttributeInstance, AttributeInstance>(
			"attribute", INSTANCE, DomainEntryEntity.INSTANCE, AttributeInstance.class, AttributeEntity.domain
		) {
	
			@Override
			public ReadOnlyRelationValue<DomainEntryInstance, AttributeInstance> get(
					DomainEntryInstance instance) {
				return instance.attribute;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		display,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		attribute,
	};

	private DomainEntryEntity() {
		super("DomainEntry");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new DomainEntryInstance(caseInstance);
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
