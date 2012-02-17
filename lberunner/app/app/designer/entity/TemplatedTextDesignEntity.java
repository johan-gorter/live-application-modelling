package app.designer.entity;

import java.util.List;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.model.impl.SimpleEntity;
import org.instantlogic.fabric.model.impl.SimpleRelation;
import org.instantlogic.fabric.value.ReadOnlyRelationValues;

import app.designer.StringProducerDesign;
import app.designer.TemplatedTextDesign;

public class TemplatedTextDesignEntity extends SimpleEntity {

	public static final TemplatedTextDesignEntity INSTANCE = new TemplatedTextDesignEntity();

	// Deductions
	
	// Attributes
	
	// Relations
	
	public static final Relation<TemplatedTextDesign, List<StringProducerDesign>, StringProducerDesign> untranslated
		= new SimpleRelation<TemplatedTextDesign, List<StringProducerDesign>, StringProducerDesign>(
			"untranslated", INSTANCE, StringProducerDesignEntity.INSTANCE, StringProducerDesign.class, StringProducerDesignEntity.untranslatedInTemplate
		) {
	
			@Override
			public ReadOnlyRelationValues<TemplatedTextDesign, StringProducerDesign> get(
					TemplatedTextDesign instance) {
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

	private TemplatedTextDesignEntity() {
		super("TemplatedTextDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new TemplatedTextDesign(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return TextDesignEntity.INSTANCE;
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
