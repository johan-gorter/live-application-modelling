package app.ritadministratie.entity;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.model.Relation;
import org.instantlogic.core.model.impl.SimpleEntity;
import org.instantlogic.core.model.impl.SimpleRelation;
import org.instantlogic.core.value.ReadOnlyRelationValue;

import app.ritadministratie.Ijking;
import app.ritadministratie.Jaar;

public class IjkingEntity extends SimpleEntity {

	public static final IjkingEntity INSTANCE = new IjkingEntity();

	// Deductions
	
	// Attributes
	
	// Relations
	
	// Reverse relations
	
	public static final Relation<Ijking, Jaar, Jaar> jaar
		= new SimpleRelation<Ijking, Jaar, Jaar>(
			"jaar", INSTANCE, IjkingEntity.INSTANCE, Jaar.class, JaarEntity.ijkingen
		) {
	
			@Override
			public ReadOnlyRelationValue<Ijking, Jaar> get(
					Ijking instance) {
				return instance.jaar;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		jaar,
	};

	private IjkingEntity() {
		super("Ijking");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new Ijking(caseInstance, id);
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
