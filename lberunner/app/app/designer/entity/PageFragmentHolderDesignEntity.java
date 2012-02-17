package app.designer.entity;

import java.util.List;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.model.impl.SimpleEntity;
import org.instantlogic.fabric.model.impl.SimpleRelation;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;
import org.instantlogic.fabric.value.ReadOnlyRelationValues;

import app.designer.ApplicationDesign;
import app.designer.PageFragmentDesign;
import app.designer.PageFragmentHolderDesign;
import app.designer.SharedFragmentDesign;

public class PageFragmentHolderDesignEntity extends SimpleEntity {

	public static final PageFragmentHolderDesignEntity INSTANCE = new PageFragmentHolderDesignEntity();

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final Relation<PageFragmentHolderDesign, PageFragmentDesign, PageFragmentDesign> pageFragment
		= new SimpleRelation<PageFragmentHolderDesign, PageFragmentDesign, PageFragmentDesign>(
			"pageFragment", INSTANCE, PageFragmentDesignEntity.INSTANCE, PageFragmentDesign.class, PageFragmentDesignEntity.holder
		) {
	
			@Override
			public ReadOnlyRelationValue<PageFragmentHolderDesign, PageFragmentDesign> get(
					PageFragmentHolderDesign instance) {
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
	
	public static final Relation<PageFragmentHolderDesign, ApplicationDesign, ApplicationDesign> shared
		= new SimpleRelation<PageFragmentHolderDesign, ApplicationDesign, ApplicationDesign>(
			"shared", INSTANCE, PageFragmentHolderDesignEntity.INSTANCE, ApplicationDesign.class, ApplicationDesignEntity.sharedPageFragments
		) {
	
			@Override
			public ReadOnlyRelationValue<PageFragmentHolderDesign, ApplicationDesign> get(
					PageFragmentHolderDesign instance) {
				return instance.shared;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<PageFragmentHolderDesign, List<SharedFragmentDesign>, SharedFragmentDesign> usages
		= new SimpleRelation<PageFragmentHolderDesign, List<SharedFragmentDesign>, SharedFragmentDesign>(
			"usages", INSTANCE, PageFragmentHolderDesignEntity.INSTANCE, SharedFragmentDesign.class, SharedFragmentDesignEntity.holder
		) {
	
			@Override
			public ReadOnlyRelationValues<PageFragmentHolderDesign, SharedFragmentDesign> get(
					PageFragmentHolderDesign instance) {
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

	private PageFragmentHolderDesignEntity() {
		super("PageFragmentHolderDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new PageFragmentHolderDesign(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return DesignEntity.INSTANCE;
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
