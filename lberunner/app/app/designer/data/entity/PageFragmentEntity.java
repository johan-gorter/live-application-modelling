package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class PageFragmentEntity extends SimpleEntity {

	public static final PageFragmentEntity INSTANCE = new PageFragmentEntity();
	
	// Attributes
	
	public static final Attribute<PageFragmentInstance, java.lang.String, java.lang.String> presentation 
		= new SimpleAttribute<PageFragmentInstance, java.lang.String, java.lang.String>(
			"presentation", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<PageFragmentInstance, java.lang.String> get(PageFragmentInstance instance) {
				return instance.presentation;
			}
		};
	
	// Relations
	
	// Reverse relations
	
	public static final Relation<PageFragmentInstance, PageFragmentHolderInstance, PageFragmentHolderInstance> holder
		= new SimpleRelation<PageFragmentInstance, PageFragmentHolderInstance, PageFragmentHolderInstance>(
			"holder", INSTANCE, PageFragmentEntity.INSTANCE, PageFragmentHolderInstance.class, PageFragmentHolderEntity.pageFragment
		) {
	
			@Override
			public ReadOnlyRelationValue<PageFragmentInstance, PageFragmentHolderInstance> get(
					PageFragmentInstance instance) {
				return instance.holder;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<PageFragmentInstance, PageCompositionInstance, PageCompositionInstance> composedIn
		= new SimpleRelation<PageFragmentInstance, PageCompositionInstance, PageCompositionInstance>(
			"composedIn", INSTANCE, PageFragmentEntity.INSTANCE, PageCompositionInstance.class, PageCompositionEntity.pageFragment
		) {
	
			@Override
			public ReadOnlyRelationValue<PageFragmentInstance, PageCompositionInstance> get(
					PageFragmentInstance instance) {
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

	private PageFragmentEntity() {
		super("PageFragment");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new PageFragmentInstance(caseInstance, id);
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
