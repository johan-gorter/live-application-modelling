package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class StringProducerEntity extends SimpleEntity {

	public static final StringProducerEntity INSTANCE = new StringProducerEntity();
	
	// Attributes
	
	// Relations
	
	// Reverse relations
	
	public static final Relation<StringProducerInstance, TemplatedTextInstance, TemplatedTextInstance> untranslatedInTemplate
		= new SimpleRelation<StringProducerInstance, TemplatedTextInstance, TemplatedTextInstance>(
			"untranslatedInTemplate", INSTANCE, StringProducerEntity.INSTANCE, TemplatedTextInstance.class, TemplatedTextEntity.untranslated
		) {
	
			@Override
			public ReadOnlyRelationValue<StringProducerInstance, TemplatedTextInstance> get(
					StringProducerInstance instance) {
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

	private StringProducerEntity() {
		super("StringProducer");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new StringProducerInstance(caseInstance, id);
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
