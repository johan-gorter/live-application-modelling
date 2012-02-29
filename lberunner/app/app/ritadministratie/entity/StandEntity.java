package app.ritadministratie.entity;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.model.impl.SimpleAttribute;
import org.instantlogic.fabric.model.impl.SimpleEntity;
import org.instantlogic.fabric.model.impl.SimpleRelation;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;

import app.ritadministratie.Auto;
import app.ritadministratie.Maand;
import app.ritadministratie.Rit;
import app.ritadministratie.Stand;

public class StandEntity extends SimpleEntity {

	public static final StandEntity INSTANCE = new StandEntity();

	// Deductions
	
	// Attributes
	
	public static final Attribute<Stand, java.lang.Integer, java.lang.Integer> kmStand 
		= new SimpleAttribute<Stand, java.lang.Integer, java.lang.Integer>(
			"kmStand", INSTANCE, java.lang.Integer.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Stand, java.lang.Integer> get(Stand instance) {
				return instance.kmStand;
			}
		};
	
	public static final Attribute<Stand, java.lang.String, java.lang.String> adres 
		= new SimpleAttribute<Stand, java.lang.String, java.lang.String>(
			"adres", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Stand, java.lang.String> get(Stand instance) {
				return instance.adres;
			}
		};
	
	// Relations
	
	// Reverse relations
	
	public static final Relation<Stand, Auto, Auto> beginstandVanAuto
		= new SimpleRelation<Stand, Auto, Auto>(
			"beginstandVanAuto", INSTANCE, StandEntity.INSTANCE, Auto.class, AutoEntity.beginstand
		) {
	
			@Override
			public ReadOnlyRelationValue<Stand, Auto> get(
					Stand instance) {
				return instance.beginstandVanAuto;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<Stand, Maand, Maand> beginstandVanMaand
		= new SimpleRelation<Stand, Maand, Maand>(
			"beginstandVanMaand", INSTANCE, StandEntity.INSTANCE, Maand.class, MaandEntity.beginstand
		) {
	
			@Override
			public ReadOnlyRelationValue<Stand, Maand> get(
					Stand instance) {
				return instance.beginstandVanMaand;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<Stand, Rit, Rit> eindstandVanRit
		= new SimpleRelation<Stand, Rit, Rit>(
			"eindstandVanRit", INSTANCE, StandEntity.INSTANCE, Rit.class, RitEntity.eindstand
		) {
	
			@Override
			public ReadOnlyRelationValue<Stand, Rit> get(
					Stand instance) {
				return instance.eindstandVanRit;
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final Relation<Stand, Rit, Rit> beginstandVanRit
		= new SimpleRelation<Stand, Rit, Rit>(
			"beginstandVanRit", INSTANCE, StandEntity.INSTANCE, Rit.class, RitEntity.beginstand
		) {
	
			@Override
			public ReadOnlyRelationValue<Stand, Rit> get(
					Stand instance) {
				return instance.beginstandVanRit;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		kmStand,
		adres,
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		beginstandVanAuto,
		beginstandVanMaand,
		eindstandVanRit,
		beginstandVanRit,
	};

	private StandEntity() {
		super("Stand");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new Stand(caseInstance, id);
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
