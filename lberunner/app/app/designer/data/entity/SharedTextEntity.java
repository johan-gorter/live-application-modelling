package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class SharedTextEntity extends SimpleEntity {

	public static final SharedTextEntity INSTANCE = new SharedTextEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<SharedTextInstance, TextHolderInstance, TextHolderInstance> holder
		= new SimpleRelation<SharedTextInstance, TextHolderInstance, TextHolderInstance>(
			"holder", INSTANCE, TextHolderEntity.INSTANCE, TextHolderInstance.class, TextHolderEntity.usages
		) {
	
			@Override
			public ReadOnlyRelationValue<SharedTextInstance, TextHolderInstance> get(
					SharedTextInstance instance) {
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

	private SharedTextEntity() {
		super("SharedText");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new SharedTextInstance(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return TextEntity.INSTANCE;
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
