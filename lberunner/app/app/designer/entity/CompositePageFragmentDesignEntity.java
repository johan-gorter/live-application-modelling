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

import app.designer.CompositePageFragmentDesign;
import app.designer.PageCompositionDesign;
import app.designer.PageDesign;

public class CompositePageFragmentDesignEntity extends SimpleEntity {

	public static final CompositePageFragmentDesignEntity INSTANCE = new CompositePageFragmentDesignEntity();

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final Relation<CompositePageFragmentDesign, List<PageCompositionDesign>, PageCompositionDesign> items
		= new SimpleRelation<CompositePageFragmentDesign, List<PageCompositionDesign>, PageCompositionDesign>(
			"items", INSTANCE, PageCompositionDesignEntity.INSTANCE, PageCompositionDesign.class, PageCompositionDesignEntity.itemIn
		) {
	
			@Override
			public ReadOnlyRelationValues<CompositePageFragmentDesign, PageCompositionDesign> get(
					CompositePageFragmentDesign instance) {
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
	
	public static final Relation<CompositePageFragmentDesign, PageDesign, PageDesign> contentOfPage
		= new SimpleRelation<CompositePageFragmentDesign, PageDesign, PageDesign>(
			"contentOfPage", INSTANCE, CompositePageFragmentDesignEntity.INSTANCE, PageDesign.class, PageDesignEntity.content
		) {
	
			@Override
			public ReadOnlyRelationValue<CompositePageFragmentDesign, PageDesign> get(
					CompositePageFragmentDesign instance) {
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

	private CompositePageFragmentDesignEntity() {
		super("CompositePageFragmentDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new CompositePageFragmentDesign(caseInstance, id);
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
