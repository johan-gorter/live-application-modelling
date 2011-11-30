package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class TextEntity extends SimpleEntity {

	public static final TextEntity INSTANCE = new TextEntity();
	
	// Attributes
	
	// Relations
	
	// Reverse relations
	
	public static final Relation<TextInstance, AttributeInstance, AttributeInstance> questionOnAttribute
		= new SimpleRelation<TextInstance, AttributeInstance, AttributeInstance>(
			"questionOnAttribute", INSTANCE, TextEntity.INSTANCE, AttributeInstance.class, AttributeEntity.question
		) {
	
			@Override
			public ReadOnlyRelationValue<TextInstance, AttributeInstance> get(
					TextInstance instance) {
				return instance.questionOnAttribute;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<TextInstance, AttributeInstance, AttributeInstance> explanationOnAttribute
		= new SimpleRelation<TextInstance, AttributeInstance, AttributeInstance>(
			"explanationOnAttribute", INSTANCE, TextEntity.INSTANCE, AttributeInstance.class, AttributeEntity.explanation
		) {
	
			@Override
			public ReadOnlyRelationValue<TextInstance, AttributeInstance> get(
					TextInstance instance) {
				return instance.explanationOnAttribute;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<TextInstance, DomainEntryInstance, DomainEntryInstance> displayOnDomainEntry
		= new SimpleRelation<TextInstance, DomainEntryInstance, DomainEntryInstance>(
			"displayOnDomainEntry", INSTANCE, TextEntity.INSTANCE, DomainEntryInstance.class, DomainEntryEntity.display
		) {
	
			@Override
			public ReadOnlyRelationValue<TextInstance, DomainEntryInstance> get(
					TextInstance instance) {
				return instance.displayOnDomainEntry;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<TextInstance, TextHolderInstance, TextHolderInstance> holder
		= new SimpleRelation<TextInstance, TextHolderInstance, TextHolderInstance>(
			"holder", INSTANCE, TextEntity.INSTANCE, TextHolderInstance.class, TextHolderEntity.text
		) {
	
			@Override
			public ReadOnlyRelationValue<TextInstance, TextHolderInstance> get(
					TextInstance instance) {
				return instance.holder;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<TextInstance, HeaderInstance, HeaderInstance> textOnHeader
		= new SimpleRelation<TextInstance, HeaderInstance, HeaderInstance>(
			"textOnHeader", INSTANCE, TextEntity.INSTANCE, HeaderInstance.class, HeaderEntity.text
		) {
	
			@Override
			public ReadOnlyRelationValue<TextInstance, HeaderInstance> get(
					TextInstance instance) {
				return instance.textOnHeader;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<TextInstance, LinkInstance, LinkInstance> captionOnButton
		= new SimpleRelation<TextInstance, LinkInstance, LinkInstance>(
			"captionOnButton", INSTANCE, TextEntity.INSTANCE, LinkInstance.class, LinkEntity.caption
		) {
	
			@Override
			public ReadOnlyRelationValue<TextInstance, LinkInstance> get(
					TextInstance instance) {
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
		holder,
		textOnHeader,
		captionOnButton,
	};

	private TextEntity() {
		super("Text");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new TextInstance(caseInstance, id);
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
