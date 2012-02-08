package app.designer.entity;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.model.impl.SimpleEntity;
import org.instantlogic.fabric.model.impl.SimpleRelation;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;

import app.designer.HeaderDesign;
import app.designer.TextDesign;

public class HeaderDesignEntity extends SimpleEntity {

	public static final HeaderDesignEntity INSTANCE = new HeaderDesignEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<HeaderDesign, TextDesign, TextDesign> text
		= new SimpleRelation<HeaderDesign, TextDesign, TextDesign>(
			"text", INSTANCE, TextDesignEntity.INSTANCE, TextDesign.class, TextDesignEntity.textOnHeader
		) {
	
			@Override
			public ReadOnlyRelationValue<HeaderDesign, TextDesign> get(
					HeaderDesign instance) {
				return instance.text;
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
		text,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private HeaderDesignEntity() {
		super("HeaderDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new HeaderDesign(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return CompositePageFragmentDesignEntity.INSTANCE;
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
