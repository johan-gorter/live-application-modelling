package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class PageFragmentHolderEntity extends SimpleEntity {

	public static final PageFragmentHolderEntity INSTANCE = new PageFragmentHolderEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<PageFragmentHolderInstance, PageFragmentInstance, PageFragmentInstance> pageFragment
		= new SimpleRelation<PageFragmentHolderInstance, PageFragmentInstance, PageFragmentInstance>(
			"pageFragment", INSTANCE, PageFragmentEntity.INSTANCE, PageFragmentInstance.class, PageFragmentEntity.holder
		) {
	
			@Override
			public ReadOnlyRelationValue<PageFragmentHolderInstance, PageFragmentInstance> get(
					PageFragmentHolderInstance instance) {
				return instance.pageFragment;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<PageFragmentHolderInstance, SharedInstance, SharedInstance> shared
		= new SimpleRelation<PageFragmentHolderInstance, SharedInstance, SharedInstance>(
			"shared", INSTANCE, PageFragmentHolderEntity.INSTANCE, SharedInstance.class, SharedEntity.pageFragments
		) {
	
			@Override
			public ReadOnlyRelationValue<PageFragmentHolderInstance, SharedInstance> get(
					PageFragmentHolderInstance instance) {
				return instance.shared;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<PageFragmentHolderInstance, List<SharedFragmentInstance>, SharedFragmentInstance> usages
		= new SimpleRelation<PageFragmentHolderInstance, List<SharedFragmentInstance>, SharedFragmentInstance>(
			"usages", INSTANCE, PageFragmentHolderEntity.INSTANCE, SharedFragmentInstance.class, SharedFragmentEntity.holder
		) {
	
			@Override
			public ReadOnlyRelationValues<PageFragmentHolderInstance, SharedFragmentInstance> get(
					PageFragmentHolderInstance instance) {
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
		pageFragment,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		shared,
		usages,
	};

	private PageFragmentHolderEntity() {
		super("PageFragmentHolder");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new PageFragmentHolderInstance(caseInstance, id);
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
