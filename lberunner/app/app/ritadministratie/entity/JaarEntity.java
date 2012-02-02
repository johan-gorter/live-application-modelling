package app.ritadministratie.entity;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.model.Relation;
import org.instantlogic.core.model.impl.SimpleAttribute;
import org.instantlogic.core.model.impl.SimpleCaseEntity;
import org.instantlogic.core.model.impl.SimpleEntity;
import org.instantlogic.core.model.impl.SimpleRelation;
import org.instantlogic.core.value.ReadOnlyAttributeValue;
import org.instantlogic.core.value.ReadOnlyRelationValues;

import app.ritadministratie.Auto;
import app.ritadministratie.Ijking;
import app.ritadministratie.Jaar;

public class JaarEntity extends SimpleCaseEntity {

	public static final JaarEntity INSTANCE = new JaarEntity();

	private static final Entity[] entities = new Entity[] {
		JaarEntity.INSTANCE,
		AutoEntity.INSTANCE,
		MaandEntity.INSTANCE,
		DagEntity.INSTANCE,
		RitEntity.INSTANCE,
		StandEntity.INSTANCE,
		TrajectEntity.INSTANCE,
		IjkingEntity.INSTANCE,
	};
	
	private static final SortedMap<String, Entity> entityMap = new TreeMap<String, Entity>();
	static {
		for (Entity entity:entities) {
			entityMap.put(entity.getName(), entity);
		}
	}
	@Override
	public SortedMap<String, Entity> getEntities() {
		return entityMap;
	}
	
	
	// Deductions
	
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
	
	public static final Relation<Jaar, List<Ijking>, Ijking> ijkingen
		= new SimpleRelation<Jaar, List<Ijking>, Ijking>(
			"ijkingen", INSTANCE, IjkingEntity.INSTANCE, Ijking.class, IjkingEntity.jaar
		) {
	
			@Override
			public ReadOnlyRelationValues<Jaar, Ijking> get(
					Jaar instance) {
				return instance.ijkingen;
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
		ijkingen,
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
