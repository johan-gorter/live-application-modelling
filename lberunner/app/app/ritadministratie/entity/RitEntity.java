package app.ritadministratie.entity;

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

import app.ritadministratie.Dag;
import app.ritadministratie.Rit;
import app.ritadministratie.Stand;

public class RitEntity extends SimpleEntity {

	public static final RitEntity INSTANCE = new RitEntity();

	// Deductions

	private static Deduction<app.ritadministratie.Stand> createDeduction0() {
		    Deduction<app.ritadministratie.Stand> d0 = new custom.ritadministratie.RitBeginstandDeductionCustomization();
		return d0;
	}

	
	// Attributes
	
	public static final Attribute<Rit, java.lang.String, java.lang.String> via 
		= new SimpleAttribute<Rit, java.lang.String, java.lang.String>(
			"via", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Rit, java.lang.String> get(Rit instance) {
				return instance.via;
			}
		};
	
	public static final Attribute<Rit, java.lang.Integer, java.lang.Integer> priveKm 
		= new SimpleAttribute<Rit, java.lang.Integer, java.lang.Integer>(
			"priveKm", INSTANCE, java.lang.Integer.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Rit, java.lang.Integer> get(Rit instance) {
				return instance.priveKm;
			}
		};
	
	public static final Attribute<Rit, java.lang.Boolean, java.lang.Boolean> priveRit 
		= new SimpleAttribute<Rit, java.lang.Boolean, java.lang.Boolean>(
			"priveRit", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Rit, java.lang.Boolean> get(Rit instance) {
				return instance.priveRit;
			}
		};
	
	// Relations
	
	public static final Relation<Rit, Stand, Stand> eindstand
		= new SimpleRelation<Rit, Stand, Stand>(
			"eindstand", INSTANCE, StandEntity.INSTANCE, Stand.class, StandEntity.eindstandVanRit
		) {
	
			@Override
			public ReadOnlyRelationValue<Rit, Stand> get(
					Rit instance) {
				return instance.eindstand;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
			
		};
	
	public static final Relation<Rit, Stand, Stand> beginstand
		= new SimpleRelation<Rit, Stand, Stand>(
			"beginstand", INSTANCE, StandEntity.INSTANCE, Stand.class, StandEntity.beginstandVanRit
		) {
	
			@Override
			public ReadOnlyRelationValue<Rit, Stand> get(
					Rit instance) {
				return instance.beginstand;
			}
	
			public boolean isReadonly() {
				return true;
			}

			private Deduction<Stand> RULE = createDeduction0();
			@Override
			public Deduction<Stand> getRule() {
				return RULE;
			}
			
		};
	
	// Reverse relations
	
	public static final Relation<Rit, Dag, Dag> dag
		= new SimpleRelation<Rit, Dag, Dag>(
			"dag", INSTANCE, RitEntity.INSTANCE, Dag.class, DagEntity.ritten
		) {
	
			@Override
			public ReadOnlyRelationValue<Rit, Dag> get(
					Rit instance) {
				return instance.dag;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		via,
		priveKm,
		priveRit,
	};
	private static final Relation[] RELATIONS = new Relation[]{
		eindstand,
		beginstand,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		dag,
	};

	private RitEntity() {
		super("Rit");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new Rit(caseInstance, id);
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
