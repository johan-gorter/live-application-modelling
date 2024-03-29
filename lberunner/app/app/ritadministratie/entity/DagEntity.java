package app.ritadministratie.entity;

import java.util.List;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.model.impl.SimpleAttribute;
import org.instantlogic.fabric.model.impl.SimpleEntity;
import org.instantlogic.fabric.model.impl.SimpleRelation;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;
import org.instantlogic.fabric.value.ReadOnlyRelationValues;

import app.ritadministratie.Dag;
import app.ritadministratie.Maand;
import app.ritadministratie.Rit;

public class DagEntity extends SimpleEntity {

	public static final DagEntity INSTANCE = new DagEntity();

	// Deductions
	
	// Attributes
	
	public static final Attribute<Dag, java.lang.Integer, java.lang.Integer> dagNr 
		= new SimpleAttribute<Dag, java.lang.Integer, java.lang.Integer>(
			"dagNr", INSTANCE, java.lang.Integer.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Dag, java.lang.Integer> get(Dag instance) {
				return instance.dagNr;
			}
		};
	
	// Relations
	
	public static final Relation<Dag, List<Rit>, Rit> ritten
		= new SimpleRelation<Dag, List<Rit>, Rit>(
			"ritten", INSTANCE, RitEntity.INSTANCE, Rit.class, RitEntity.dag
		) {
	
			@Override
			public ReadOnlyRelationValues<Dag, Rit> get(
					Dag instance) {
				return instance.ritten;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	// Reverse relations
	
	public static final Relation<Dag, Maand, Maand> maand
		= new SimpleRelation<Dag, Maand, Maand>(
			"maand", INSTANCE, DagEntity.INSTANCE, Maand.class, MaandEntity.dagen
		) {
	
			@Override
			public ReadOnlyRelationValue<Dag, Maand> get(
					Dag instance) {
				return instance.maand;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		dagNr,
	};
	private static final Relation[] RELATIONS = new Relation[]{
		ritten,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		maand,
	};

	private DagEntity() {
		super("Dag");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new Dag(caseInstance, id);
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
