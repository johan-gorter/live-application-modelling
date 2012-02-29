package app.carinsurance.entity;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.model.impl.SimpleEntity;
import org.instantlogic.fabric.model.impl.SimpleRelation;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;

import app.carinsurance.CarinsuranceCase;
import app.carinsurance.Driver;

public class CarinsuranceCaseEntity extends SimpleEntity {

	public static final CarinsuranceCaseEntity INSTANCE = new CarinsuranceCaseEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<CarinsuranceCase, Driver, Driver> driver
		= new SimpleRelation<CarinsuranceCase, Driver, Driver>(
			"driver", INSTANCE, DriverEntity.INSTANCE, Driver.class, DriverEntity.carinsuranceCase
		) {
	
			@Override
			public ReadOnlyRelationValue<CarinsuranceCase, Driver> get(
					CarinsuranceCase instance) {
				return instance.driver;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
		};
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		driver,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private CarinsuranceCaseEntity() {
		super("CarinsuranceCase");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new CarinsuranceCase();
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
