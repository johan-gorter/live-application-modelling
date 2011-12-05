package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class TextHolderEntity extends SimpleEntity {

	public static final TextHolderEntity INSTANCE = new TextHolderEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<TextHolder, TextDesign, TextDesign> text
		= new SimpleRelation<TextHolder, TextDesign, TextDesign>(
			"text", INSTANCE, TextDesignEntity.INSTANCE, TextDesign.class, TextDesignEntity.holder
		) {
	
			@Override
			public ReadOnlyRelationValue<TextHolder, TextDesign> get(
					TextHolder instance) {
				return instance.text;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<TextHolder, Shared, Shared> shared
		= new SimpleRelation<TextHolder, Shared, Shared>(
			"shared", INSTANCE, TextHolderEntity.INSTANCE, Shared.class, SharedEntity.texts
		) {
	
			@Override
			public ReadOnlyRelationValue<TextHolder, Shared> get(
					TextHolder instance) {
				return instance.shared;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<TextHolder, List<SharedTextDesign>, SharedTextDesign> usages
		= new SimpleRelation<TextHolder, List<SharedTextDesign>, SharedTextDesign>(
			"usages", INSTANCE, TextHolderEntity.INSTANCE, SharedTextDesign.class, SharedTextDesignEntity.holder
		) {
	
			@Override
			public ReadOnlyRelationValues<TextHolder, SharedTextDesign> get(
					TextHolder instance) {
				return instance.usages;
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		text,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		shared,
		usages,
	};

	private TextHolderEntity() {
		super("TextHolder");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new TextHolder(caseInstance, id);
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
