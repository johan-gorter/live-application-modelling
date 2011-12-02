package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class PageCompositionEntity extends SimpleEntity {

	public static final PageCompositionEntity INSTANCE = new PageCompositionEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<PageCompositionInstance, PageFragmentInstance, PageFragmentInstance> pageFragment
		= new SimpleRelation<PageCompositionInstance, PageFragmentInstance, PageFragmentInstance>(
			"pageFragment", INSTANCE, PageFragmentEntity.INSTANCE, PageFragmentInstance.class, PageFragmentEntity.composedIn
		) {
	
			@Override
			public ReadOnlyRelationValue<PageCompositionInstance, PageFragmentInstance> get(
					PageCompositionInstance instance) {
				return instance.pageFragment;
			}
	
			public boolean isOwner() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<PageCompositionInstance, CompositePageFragmentInstance, CompositePageFragmentInstance> itemIn
		= new SimpleRelation<PageCompositionInstance, CompositePageFragmentInstance, CompositePageFragmentInstance>(
			"itemIn", INSTANCE, PageCompositionEntity.INSTANCE, CompositePageFragmentInstance.class, CompositePageFragmentEntity.items
		) {
	
			@Override
			public ReadOnlyRelationValue<PageCompositionInstance, CompositePageFragmentInstance> get(
					PageCompositionInstance instance) {
				return instance.itemIn;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		pageFragment,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		itemIn,
	};

	private PageCompositionEntity() {
		super("PageComposition");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new PageCompositionInstance(caseInstance, id);
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
