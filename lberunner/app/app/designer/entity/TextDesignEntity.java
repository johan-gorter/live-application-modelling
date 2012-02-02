package app.designer.entity;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.model.Relation;
import org.instantlogic.core.model.impl.SimpleEntity;
import org.instantlogic.core.model.impl.SimpleRelation;
import org.instantlogic.core.value.ReadOnlyRelationValue;

import app.designer.AttributeDesign;
import app.designer.DomainEntryDesign;
import app.designer.HeaderDesign;
import app.designer.LinkDesign;
import app.designer.TextDesign;

public class TextDesignEntity extends SimpleEntity {

	public static final TextDesignEntity INSTANCE = new TextDesignEntity();
	
	// Attributes
	
	// Relations
	
	// Reverse relations
	
	public static final Relation<TextDesign, AttributeDesign, AttributeDesign> questionOnAttribute
		= new SimpleRelation<TextDesign, AttributeDesign, AttributeDesign>(
			"questionOnAttribute", INSTANCE, TextDesignEntity.INSTANCE, AttributeDesign.class, AttributeDesignEntity.question
		) {
	
			@Override
			public ReadOnlyRelationValue<TextDesign, AttributeDesign> get(
					TextDesign instance) {
				return instance.questionOnAttribute;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<TextDesign, AttributeDesign, AttributeDesign> explanationOnAttribute
		= new SimpleRelation<TextDesign, AttributeDesign, AttributeDesign>(
			"explanationOnAttribute", INSTANCE, TextDesignEntity.INSTANCE, AttributeDesign.class, AttributeDesignEntity.explanation
		) {
	
			@Override
			public ReadOnlyRelationValue<TextDesign, AttributeDesign> get(
					TextDesign instance) {
				return instance.explanationOnAttribute;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<TextDesign, DomainEntryDesign, DomainEntryDesign> displayOnDomainEntry
		= new SimpleRelation<TextDesign, DomainEntryDesign, DomainEntryDesign>(
			"displayOnDomainEntry", INSTANCE, TextDesignEntity.INSTANCE, DomainEntryDesign.class, DomainEntryDesignEntity.display
		) {
	
			@Override
			public ReadOnlyRelationValue<TextDesign, DomainEntryDesign> get(
					TextDesign instance) {
				return instance.displayOnDomainEntry;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<TextDesign, HeaderDesign, HeaderDesign> textOnHeader
		= new SimpleRelation<TextDesign, HeaderDesign, HeaderDesign>(
			"textOnHeader", INSTANCE, TextDesignEntity.INSTANCE, HeaderDesign.class, HeaderDesignEntity.text
		) {
	
			@Override
			public ReadOnlyRelationValue<TextDesign, HeaderDesign> get(
					TextDesign instance) {
				return instance.textOnHeader;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<TextDesign, LinkDesign, LinkDesign> captionOnButton
		= new SimpleRelation<TextDesign, LinkDesign, LinkDesign>(
			"captionOnButton", INSTANCE, TextDesignEntity.INSTANCE, LinkDesign.class, LinkDesignEntity.caption
		) {
	
			@Override
			public ReadOnlyRelationValue<TextDesign, LinkDesign> get(
					TextDesign instance) {
				return instance.captionOnButton;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		questionOnAttribute,
		explanationOnAttribute,
		displayOnDomainEntry,
		textOnHeader,
		captionOnButton,
	};

	private TextDesignEntity() {
		super("TextDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new TextDesign(caseInstance, id);
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
