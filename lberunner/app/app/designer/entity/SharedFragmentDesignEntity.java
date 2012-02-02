package app.designer.entity;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.model.Relation;
import org.instantlogic.core.model.impl.SimpleEntity;
import org.instantlogic.core.model.impl.SimpleRelation;
import org.instantlogic.core.value.ReadOnlyRelationValue;

import app.designer.PageFragmentHolderDesign;
import app.designer.SharedFragmentDesign;

public class SharedFragmentDesignEntity extends SimpleEntity {

	public static final SharedFragmentDesignEntity INSTANCE = new SharedFragmentDesignEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<SharedFragmentDesign, PageFragmentHolderDesign, PageFragmentHolderDesign> holder
		= new SimpleRelation<SharedFragmentDesign, PageFragmentHolderDesign, PageFragmentHolderDesign>(
			"holder", INSTANCE, PageFragmentHolderDesignEntity.INSTANCE, PageFragmentHolderDesign.class, PageFragmentHolderDesignEntity.usages
		) {
	
			@Override
			public ReadOnlyRelationValue<SharedFragmentDesign, PageFragmentHolderDesign> get(
					SharedFragmentDesign instance) {
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

	private SharedFragmentDesignEntity() {
		super("SharedFragmentDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new SharedFragmentDesign(caseInstance, id);
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
