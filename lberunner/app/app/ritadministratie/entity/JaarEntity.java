package app.ritadministratie.entity;

import java.util.List;

import app.ritadministratie.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class JaarEntity extends SimpleEntity {

	public static final JaarEntity INSTANCE = new JaarEntity();
	
	// Attributes
	
	public static final Attribute<Jaar, java.lang.Integer, java.lang.Integer> jaartal 
		= new SimpleAttribute<Jaar, java.lang.Integer, java.lang.Integer>(
			"jaartal", INSTANCE, java.lang.Integer.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Jaar, java.lang.Integer> get(Jaar instance) {
				return instance.jaartal;
			}
		};
	
	// Relations
	
	public static final Relation<Jaar, List<Auto>, Auto> autos
		= new SimpleRelation<Jaar, List<Auto>, Auto>(
			"autos", INSTANCE, AutoEntity.INSTANCE, Auto.class, AutoEntity.jaar
		) {
	
			@Override
			public ReadOnlyRelationValues<Jaar, Auto> get(
					Jaar instance) {
				return instance.autos;
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
		jaartal,
	};
	private static final Relation[] RELATIONS = new Relation[]{
		autos,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private JaarEntity() {
		super("Jaar");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new Jaar();
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
