package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class SharedFragmentEntity extends SimpleEntity {

	public static final SharedFragmentEntity INSTANCE = new SharedFragmentEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<SharedFragment, PageFragmentHolder, PageFragmentHolder> holder
		= new SimpleRelation<SharedFragment, PageFragmentHolder, PageFragmentHolder>(
			"holder", INSTANCE, PageFragmentHolderEntity.INSTANCE, PageFragmentHolder.class, PageFragmentHolderEntity.usages
		) {
	
			@Override
			public ReadOnlyRelationValue<SharedFragment, PageFragmentHolder> get(
					SharedFragment instance) {
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

	private SharedFragmentEntity() {
		super("SharedFragment");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new SharedFragment(caseInstance, id);
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
