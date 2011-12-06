package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class DomainEntryDesignEntity extends SimpleEntity {

	public static final DomainEntryDesignEntity INSTANCE = new DomainEntryDesignEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<DomainEntryDesign, TextDesign, TextDesign> display
		= new SimpleRelation<DomainEntryDesign, TextDesign, TextDesign>(
			"display", INSTANCE, TextDesignEntity.INSTANCE, TextDesign.class, TextDesignEntity.displayOnDomainEntry
		) {
	
			@Override
			public ReadOnlyRelationValue<DomainEntryDesign, TextDesign> get(
					DomainEntryDesign instance) {
				return instance.display;
			}
	
			public boolean isOwner() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<DomainEntryDesign, AttributeDesign, AttributeDesign> attribute
		= new SimpleRelation<DomainEntryDesign, AttributeDesign, AttributeDesign>(
			"attribute", INSTANCE, DomainEntryDesignEntity.INSTANCE, AttributeDesign.class, AttributeDesignEntity.domain
		) {
	
			@Override
			public ReadOnlyRelationValue<DomainEntryDesign, AttributeDesign> get(
					DomainEntryDesign instance) {
				return instance.attribute;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		display,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		attribute,
	};

	private DomainEntryDesignEntity() {
		super("DomainEntryDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new DomainEntryDesign(caseInstance, id);
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
