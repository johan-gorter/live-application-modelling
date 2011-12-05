package app.designer.entity;

import java.util.List;

import app.designer.*;
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
	
	public static final Relation<PageComposition, PageFragmentDesign, PageFragmentDesign> pageFragment
		= new SimpleRelation<PageComposition, PageFragmentDesign, PageFragmentDesign>(
			"pageFragment", INSTANCE, PageFragmentDesignEntity.INSTANCE, PageFragmentDesign.class, PageFragmentDesignEntity.composedIn
		) {
	
			@Override
			public ReadOnlyRelationValue<PageComposition, PageFragmentDesign> get(
					PageComposition instance) {
				return instance.pageFragment;
			}
	
			public boolean isOwner() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<PageComposition, CompositePageFragmentDesign, CompositePageFragmentDesign> itemIn
		= new SimpleRelation<PageComposition, CompositePageFragmentDesign, CompositePageFragmentDesign>(
			"itemIn", INSTANCE, PageCompositionEntity.INSTANCE, CompositePageFragmentDesign.class, CompositePageFragmentDesignEntity.items
		) {
	
			@Override
			public ReadOnlyRelationValue<PageComposition, CompositePageFragmentDesign> get(
					PageComposition instance) {
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
		return new PageComposition(caseInstance, id);
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
