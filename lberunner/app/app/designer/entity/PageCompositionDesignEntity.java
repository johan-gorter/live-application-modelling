package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class PageCompositionDesignEntity extends SimpleEntity {

	public static final PageCompositionDesignEntity INSTANCE = new PageCompositionDesignEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<PageCompositionDesign, PageFragmentDesign, PageFragmentDesign> pageFragment
		= new SimpleRelation<PageCompositionDesign, PageFragmentDesign, PageFragmentDesign>(
			"pageFragment", INSTANCE, PageFragmentDesignEntity.INSTANCE, PageFragmentDesign.class, PageFragmentDesignEntity.composedIn
		) {
	
			@Override
			public ReadOnlyRelationValue<PageCompositionDesign, PageFragmentDesign> get(
					PageCompositionDesign instance) {
				return instance.pageFragment;
			}
	
			public boolean isOwner() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<PageCompositionDesign, CompositePageFragmentDesign, CompositePageFragmentDesign> itemIn
		= new SimpleRelation<PageCompositionDesign, CompositePageFragmentDesign, CompositePageFragmentDesign>(
			"itemIn", INSTANCE, PageCompositionDesignEntity.INSTANCE, CompositePageFragmentDesign.class, CompositePageFragmentDesignEntity.items
		) {
	
			@Override
			public ReadOnlyRelationValue<PageCompositionDesign, CompositePageFragmentDesign> get(
					PageCompositionDesign instance) {
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

	private PageCompositionDesignEntity() {
		super("PageCompositionDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new PageCompositionDesign(caseInstance, id);
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