package app.ritadministratie.entity;

import java.util.List;

import app.ritadministratie.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import lbe.model.deduction.*;

public class AutoEntity extends SimpleEntity {

	public static final AutoEntity INSTANCE = new AutoEntity();

	// Deductions
	
	// Attributes
	
	public static final Attribute<Auto, java.lang.String, java.lang.String> kenteken 
		= new SimpleAttribute<Auto, java.lang.String, java.lang.String>(
			"kenteken", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Auto, java.lang.String> get(Auto instance) {
				return instance.kenteken;
			}
		};
	
	// Relations
	
	public static final Relation<Auto, List<Maand>, Maand> maanden
		= new SimpleRelation<Auto, List<Maand>, Maand>(
			"maanden", INSTANCE, MaandEntity.INSTANCE, Maand.class, MaandEntity.auto
		) {
	
			@Override
			public ReadOnlyRelationValues<Auto, Maand> get(
					Auto instance) {
				return instance.maanden;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
	
	public static final Relation<Auto, Stand, Stand> beginstand
		= new SimpleRelation<Auto, Stand, Stand>(
			"beginstand", INSTANCE, StandEntity.INSTANCE, Stand.class, StandEntity.beginstandVanAuto
		) {
	
			@Override
			public ReadOnlyRelationValue<Auto, Stand> get(
					Auto instance) {
				return instance.beginstand;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
			
		};
	
	// Reverse relations
	
	public static final Relation<Auto, Jaar, Jaar> jaar
		= new SimpleRelation<Auto, Jaar, Jaar>(
			"jaar", INSTANCE, AutoEntity.INSTANCE, Jaar.class, JaarEntity.autos
		) {
	
			@Override
			public ReadOnlyRelationValue<Auto, Jaar> get(
					Auto instance) {
				return instance.jaar;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		kenteken,
	};
	private static final Relation[] RELATIONS = new Relation[]{
		maanden,
		beginstand,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		jaar,
	};

	private AutoEntity() {
		super("Auto");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new custom.ritadministratie.AutoCustomization(caseInstance, id);
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
