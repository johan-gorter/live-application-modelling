package app.designer.entity;

import java.util.List;

import app.designer.*;
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
	
	public static final Relation<PageFragmentHolder, PageFragmentDesign, PageFragmentDesign> pageFragment
		= new SimpleRelation<PageFragmentHolder, PageFragmentDesign, PageFragmentDesign>(
			"pageFragment", INSTANCE, PageFragmentDesignEntity.INSTANCE, PageFragmentDesign.class, PageFragmentDesignEntity.holder
		) {
	
			@Override
			public ReadOnlyRelationValue<PageFragmentHolder, PageFragmentDesign> get(
					PageFragmentHolder instance) {
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
	
	public static final Relation<PageFragmentHolder, Shared, Shared> shared
		= new SimpleRelation<PageFragmentHolder, Shared, Shared>(
			"shared", INSTANCE, PageFragmentHolderEntity.INSTANCE, Shared.class, SharedEntity.pageFragments
		) {
	
			@Override
			public ReadOnlyRelationValue<PageFragmentHolder, Shared> get(
					PageFragmentHolder instance) {
				return instance.shared;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<PageFragmentHolder, List<SharedFragment>, SharedFragment> usages
		= new SimpleRelation<PageFragmentHolder, List<SharedFragment>, SharedFragment>(
			"usages", INSTANCE, PageFragmentHolderEntity.INSTANCE, SharedFragment.class, SharedFragmentEntity.holder
		) {
	
			@Override
			public ReadOnlyRelationValues<PageFragmentHolder, SharedFragment> get(
					PageFragmentHolder instance) {
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
		return new PageFragmentHolder(caseInstance, id);
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
