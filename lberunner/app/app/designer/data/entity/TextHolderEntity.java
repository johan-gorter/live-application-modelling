package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
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
	
	public static final Relation<TextHolderInstance, TextInstance, TextInstance> text
		= new SimpleRelation<TextHolderInstance, TextInstance, TextInstance>(
			"text", INSTANCE, TextEntity.INSTANCE, TextInstance.class, TextEntity.holder
		) {
	
			@Override
			public ReadOnlyRelationValue<TextHolderInstance, TextInstance> get(
					TextHolderInstance instance) {
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
	
	public static final Relation<TextHolderInstance, SharedInstance, SharedInstance> shared
		= new SimpleRelation<TextHolderInstance, SharedInstance, SharedInstance>(
			"shared", INSTANCE, TextHolderEntity.INSTANCE, SharedInstance.class, SharedEntity.texts
		) {
	
			@Override
			public ReadOnlyRelationValue<TextHolderInstance, SharedInstance> get(
					TextHolderInstance instance) {
				return instance.shared;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<TextHolderInstance, List<SharedTextInstance>, SharedTextInstance> usages
		= new SimpleRelation<TextHolderInstance, List<SharedTextInstance>, SharedTextInstance>(
			"usages", INSTANCE, TextHolderEntity.INSTANCE, SharedTextInstance.class, SharedTextEntity.holder
		) {
	
			@Override
			public ReadOnlyRelationValues<TextHolderInstance, SharedTextInstance> get(
					TextHolderInstance instance) {
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
		return new TextHolderInstance(caseInstance, id);
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
