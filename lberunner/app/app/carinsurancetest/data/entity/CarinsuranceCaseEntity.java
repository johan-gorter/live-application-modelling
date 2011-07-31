package app.carinsurancetest.data.entity;

import java.util.List;

import app.carinsurancetest.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class CarinsuranceCaseEntity extends SimpleEntity {

	public static final CarinsuranceCaseEntity INSTANCE = new CarinsuranceCaseEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<CarinsuranceCaseInstance, DriverInstance, DriverInstance> driver
		= new SimpleRelation<CarinsuranceCaseInstance, DriverInstance, DriverInstance>(
			"driver", INSTANCE, DriverEntity.INSTANCE, DriverInstance.class, DriverEntity.carinsuranceCase
		) {
	
			@Override
			public ReadOnlyRelationValue<CarinsuranceCaseInstance, DriverInstance> get(
					CarinsuranceCaseInstance instance) {
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
		return new CarinsuranceCaseInstance();
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
