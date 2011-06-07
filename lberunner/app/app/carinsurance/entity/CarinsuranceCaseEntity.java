package app.carinsurance.entity;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.value.RelationValue;
import lbe.instance.value.impl.AttributeValueImpl;
import lbe.model.Attribute;
import lbe.model.Entity;
import lbe.model.Relation;
import lbe.model.impl.SimpleRelation;

public class CarinsuranceCaseEntity extends Entity {

	public static final CarinsuranceCaseEntity INSTANCE = new CarinsuranceCaseEntity();
	
	public static final Relation<CarinsuranceCaseInstance, DriverInstance, DriverInstance> driver 
		= new SimpleRelation<CarinsuranceCaseInstance, DriverInstance, DriverInstance>("driver", INSTANCE, 
				DriverEntity.INSTANCE, DriverInstance.class, DriverEntity.carinsuranceCase) {

		@Override
		public AttributeValueImpl<CarinsuranceCaseInstance, DriverInstance> get(
				CarinsuranceCaseInstance instance) {
			return instance.driver;
		}
		
		public boolean isOwner() {
			return true;
		};
	};
	
	
	private static final Attribute[] ATTRIBUTES = new Attribute[]{};
	private static final Relation[] RELATIONS = new Relation[]{driver};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{};

	@Override
	public String getName() {
		return "CarinsuranceCase";
	}

	@Override
	public Attribute[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public Relation[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public Relation[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}

	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		throw new RuntimeException("Only one case instance is allowed per case");
	}

	@Override
	public Entity extendsEntity() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
