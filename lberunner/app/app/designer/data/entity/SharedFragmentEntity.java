package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
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
	
	public static final Relation<SharedFragmentInstance, PageFragmentHolderInstance, PageFragmentHolderInstance> holder
		= new SimpleRelation<SharedFragmentInstance, PageFragmentHolderInstance, PageFragmentHolderInstance>(
			"holder", INSTANCE, PageFragmentHolderEntity.INSTANCE, PageFragmentHolderInstance.class, PageFragmentHolderEntity.usages
		) {
	
			@Override
			public ReadOnlyRelationValue<SharedFragmentInstance, PageFragmentHolderInstance> get(
					SharedFragmentInstance instance) {
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
		return new SharedFragmentInstance(caseInstance, id);
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
