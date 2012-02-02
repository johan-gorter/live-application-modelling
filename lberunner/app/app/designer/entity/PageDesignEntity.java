package app.designer.entity;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.model.Relation;
import org.instantlogic.core.model.impl.SimpleEntity;
import org.instantlogic.core.model.impl.SimpleRelation;
import org.instantlogic.core.value.ReadOnlyRelationValue;

import app.designer.CompositePageFragmentDesign;
import app.designer.PageDesign;

public class PageDesignEntity extends SimpleEntity {

	public static final PageDesignEntity INSTANCE = new PageDesignEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<PageDesign, CompositePageFragmentDesign, CompositePageFragmentDesign> content
		= new SimpleRelation<PageDesign, CompositePageFragmentDesign, CompositePageFragmentDesign>(
			"content", INSTANCE, CompositePageFragmentDesignEntity.INSTANCE, CompositePageFragmentDesign.class, CompositePageFragmentDesignEntity.contentOfPage
		) {
	
			@Override
			public ReadOnlyRelationValue<PageDesign, CompositePageFragmentDesign> get(
					PageDesign instance) {
				return instance.content;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
		};
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		content,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private PageDesignEntity() {
		super("PageDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new PageDesign(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return FlowNodeBaseDesignEntity.INSTANCE;
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
