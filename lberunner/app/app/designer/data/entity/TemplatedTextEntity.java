package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class TemplatedTextEntity extends SimpleEntity {

	public static final TemplatedTextEntity INSTANCE = new TemplatedTextEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<TemplatedTextInstance, List<StringProducerInstance>, StringProducerInstance> untranslated
		= new SimpleRelation<TemplatedTextInstance, List<StringProducerInstance>, StringProducerInstance>(
			"untranslated", INSTANCE, StringProducerEntity.INSTANCE, StringProducerInstance.class, StringProducerEntity.untranslatedInTemplate
		) {
	
			@Override
			public ReadOnlyRelationValues<TemplatedTextInstance, StringProducerInstance> get(
					TemplatedTextInstance instance) {
				return instance.untranslated;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		untranslated,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private TemplatedTextEntity() {
		super("TemplatedText");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new TemplatedTextInstance(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return TextEntity.INSTANCE;
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
