package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class SharedTextDesignEntity extends SimpleEntity {

	public static final SharedTextDesignEntity INSTANCE = new SharedTextDesignEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<SharedTextDesign, TextHolder, TextHolder> holder
		= new SimpleRelation<SharedTextDesign, TextHolder, TextHolder>(
			"holder", INSTANCE, TextHolderEntity.INSTANCE, TextHolder.class, TextHolderEntity.usages
		) {
	
			@Override
			public ReadOnlyRelationValue<SharedTextDesign, TextHolder> get(
					SharedTextDesign instance) {
				return instance.holder;
			}
		};
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		holder,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private SharedTextDesignEntity() {
		super("SharedTextDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new SharedTextDesign(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return TextDesignEntity.INSTANCE;
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
