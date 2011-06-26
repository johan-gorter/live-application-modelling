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
	
	public static final Relation<TextInstance, ToolboxInstance, ToolboxInstance> toolbox
		= new SimpleRelation<TextInstance, ToolboxInstance, ToolboxInstance>(
			"toolbox", INSTANCE, TextEntity.INSTANCE, ToolboxInstance.class, ToolboxEntity.texts
		) {
	
			@Override
			public ReadOnlyRelationValue<TextInstance, ToolboxInstance> get(
					TextInstance instance) {
				return instance.toolbox;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<TextInstance, ContainerInstance, ContainerInstance> displayOnContainer
		= new SimpleRelation<TextInstance, ContainerInstance, ContainerInstance>(
			"displayOnContainer", INSTANCE, TextEntity.INSTANCE, ContainerInstance.class, ContainerEntity.display
		) {
	
			@Override
			public ReadOnlyRelationValue<TextInstance, ContainerInstance> get(
					TextInstance instance) {
				return instance.displayOnContainer;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<TextInstance, ButtonInstance, ButtonInstance> captionOnButton
		= new SimpleRelation<TextInstance, ButtonInstance, ButtonInstance>(
			"captionOnButton", INSTANCE, TextEntity.INSTANCE, ButtonInstance.class, ButtonEntity.caption
		) {
	
			@Override
			public ReadOnlyRelationValue<TextInstance, ButtonInstance> get(
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
		toolbox,
		displayOnContainer,
		captionOnButton,
	};

	private TextEntity() {
		super("Text");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new TextInstance(caseInstance);
	}
	
	@Override
	public Entity extendsEntity() {
		return PageElementBaseEntity.INSTANCE;
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
