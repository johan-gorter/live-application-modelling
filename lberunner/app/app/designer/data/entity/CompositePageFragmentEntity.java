package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class CompositePageFragmentEntity extends SimpleEntity {

	public static final CompositePageFragmentEntity INSTANCE = new CompositePageFragmentEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<CompositePageFragmentInstance, List<PageCompositionInstance>, PageCompositionInstance> items
		= new SimpleRelation<CompositePageFragmentInstance, List<PageCompositionInstance>, PageCompositionInstance>(
			"items", INSTANCE, PageCompositionEntity.INSTANCE, PageCompositionInstance.class, PageCompositionEntity.itemIn
		) {
	
			@Override
			public ReadOnlyRelationValues<CompositePageFragmentInstance, PageCompositionInstance> get(
					CompositePageFragmentInstance instance) {
				return instance.items;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<CompositePageFragmentInstance, PageInstance, PageInstance> contentOfPage
		= new SimpleRelation<CompositePageFragmentInstance, PageInstance, PageInstance>(
			"contentOfPage", INSTANCE, CompositePageFragmentEntity.INSTANCE, PageInstance.class, PageEntity.content
		) {
	
			@Override
			public ReadOnlyRelationValue<CompositePageFragmentInstance, PageInstance> get(
					CompositePageFragmentInstance instance) {
				return instance.contentOfPage;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		items,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		contentOfPage,
	};

	private CompositePageFragmentEntity() {
		super("CompositePageFragment");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new CompositePageFragmentInstance(caseInstance, id);
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
