package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class PageFragmentDesignEntity extends SimpleEntity {

	public static final PageFragmentDesignEntity INSTANCE = new PageFragmentDesignEntity();
	
	// Attributes
	
	public static final Attribute<PageFragmentDesign, java.lang.String, java.lang.String> presentation 
		= new SimpleAttribute<PageFragmentDesign, java.lang.String, java.lang.String>(
			"presentation", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<PageFragmentDesign, java.lang.String> get(PageFragmentDesign instance) {
				return instance.presentation;
			}
		};
	
	// Relations
	
	// Reverse relations
	
	public static final Relation<PageFragmentDesign, PageFragmentHolderDesign, PageFragmentHolderDesign> holder
		= new SimpleRelation<PageFragmentDesign, PageFragmentHolderDesign, PageFragmentHolderDesign>(
			"holder", INSTANCE, PageFragmentDesignEntity.INSTANCE, PageFragmentHolderDesign.class, PageFragmentHolderDesignEntity.pageFragment
		) {
	
			@Override
			public ReadOnlyRelationValue<PageFragmentDesign, PageFragmentHolderDesign> get(
					PageFragmentDesign instance) {
				return instance.holder;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<PageFragmentDesign, PageCompositionDesign, PageCompositionDesign> composedIn
		= new SimpleRelation<PageFragmentDesign, PageCompositionDesign, PageCompositionDesign>(
			"composedIn", INSTANCE, PageFragmentDesignEntity.INSTANCE, PageCompositionDesign.class, PageCompositionDesignEntity.pageFragment
		) {
	
			@Override
			public ReadOnlyRelationValue<PageFragmentDesign, PageCompositionDesign> get(
					PageFragmentDesign instance) {
				return instance.composedIn;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		presentation,
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		holder,
		composedIn,
	};

	private PageFragmentDesignEntity() {
		super("PageFragmentDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new PageFragmentDesign(caseInstance, id);
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
