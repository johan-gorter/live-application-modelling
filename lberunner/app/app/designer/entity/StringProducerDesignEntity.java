package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class StringProducerDesignEntity extends SimpleEntity {

	public static final StringProducerDesignEntity INSTANCE = new StringProducerDesignEntity();
	
	// Attributes
	
	// Relations
	
	// Reverse relations
	
	public static final Relation<StringProducerDesign, TemplatedTextDesign, TemplatedTextDesign> untranslatedInTemplate
		= new SimpleRelation<StringProducerDesign, TemplatedTextDesign, TemplatedTextDesign>(
			"untranslatedInTemplate", INSTANCE, StringProducerDesignEntity.INSTANCE, TemplatedTextDesign.class, TemplatedTextDesignEntity.untranslated
		) {
	
			@Override
			public ReadOnlyRelationValue<StringProducerDesign, TemplatedTextDesign> get(
					StringProducerDesign instance) {
				return instance.untranslatedInTemplate;
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
		untranslatedInTemplate,
	};

	private StringProducerDesignEntity() {
		super("StringProducerDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new StringProducerDesign(caseInstance, id);
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
