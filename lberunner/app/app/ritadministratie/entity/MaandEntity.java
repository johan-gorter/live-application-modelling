package app.ritadministratie.entity;

import java.util.List;

import app.ritadministratie.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class MaandEntity extends SimpleEntity {

	public static final MaandEntity INSTANCE = new MaandEntity();
	
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
