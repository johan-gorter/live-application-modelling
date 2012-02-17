package app.ritadministratie.entity;

import java.util.List;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.model.impl.SimpleAttribute;
import org.instantlogic.fabric.model.impl.SimpleEntity;
import org.instantlogic.fabric.model.impl.SimpleRelation;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;
import org.instantlogic.fabric.value.ReadOnlyRelationValues;

import app.ritadministratie.Auto;
import app.ritadministratie.Dag;
import app.ritadministratie.Maand;
import app.ritadministratie.Stand;

public class MaandEntity extends SimpleEntity {

	public static final MaandEntity INSTANCE = new MaandEntity();

	// Deductions

	private static Deduction<app.ritadministratie.Stand> createDeduction0() {
		    Deduction<app.ritadministratie.Stand> d0 = new custom.ritadministratie.MaandBeginstandDeductionCustomization();
		return d0;
	}

	
	// Attributes
	
	public static final Attribute<Maand, java.lang.Integer, java.lang.Integer> maandNr 
		= new SimpleAttribute<Maand, java.lang.Integer, java.lang.Integer>(
			"maandNr", INSTANCE, java.lang.Integer.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Maand, java.lang.Integer> get(Maand instance) {
				return instance.maandNr;
			}
		};
	
	// Relations
	
	public static final Relation<Maand, List<Dag>, Dag> dagen
		= new SimpleRelation<Maand, List<Dag>, Dag>(
			"dagen", INSTANCE, DagEntity.INSTANCE, Dag.class, DagEntity.maand
		) {
	
			@Override
			public ReadOnlyRelationValues<Maand, Dag> get(
					Maand instance) {
				return instance.dagen;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final Relation<Maand, Stand, Stand> beginstand
		= new SimpleRelation<Maand, Stand, Stand>(
			"beginstand", INSTANCE, StandEntity.INSTANCE, Stand.class, StandEntity.beginstandVanMaand
		) {
	
			@Override
			public ReadOnlyRelationValue<Maand, Stand> get(
					Maand instance) {
				return instance.beginstand;
			}

			private Deduction<Stand> RULE = createDeduction0();
			@Override
			public Deduction<Stand> getRule() {
				return RULE;
			}
			
		};
	
	// Reverse relations
	
	public static final Relation<Maand, Auto, Auto> auto
		= new SimpleRelation<Maand, Auto, Auto>(
			"auto", INSTANCE, MaandEntity.INSTANCE, Auto.class, AutoEntity.maanden
		) {
	
			@Override
			public ReadOnlyRelationValue<Maand, Auto> get(
					Maand instance) {
				return instance.auto;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		maandNr,
	};
	private static final Relation[] RELATIONS = new Relation[]{
		dagen,
		beginstand,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		auto,
	};

	private MaandEntity() {
		super("Maand");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new custom.ritadministratie.MaandCustomization(caseInstance, id);
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
