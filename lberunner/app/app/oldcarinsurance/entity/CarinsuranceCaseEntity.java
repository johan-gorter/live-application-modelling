package app.oldcarinsurance.entity;

import java.util.SortedMap;
import java.util.TreeMap;

import org.instantlogic.fabric.CaseInstance;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.CaseEntity;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.model.impl.SimpleRelation;
import org.instantlogic.fabric.value.AttributeValue;

import app.oldcarinsurance.CarinsuranceCase;
import app.oldcarinsurance.Driver;

public class CarinsuranceCaseEntity extends CaseEntity {

	public static final CarinsuranceCaseEntity INSTANCE = new CarinsuranceCaseEntity();
	
	public static final Relation<CarinsuranceCase, Driver, Driver> driver 
		= new SimpleRelation<CarinsuranceCase, Driver, Driver>("driver", INSTANCE, 
				DriverEntity.INSTANCE, Driver.class, DriverEntity.carinsuranceCase) {

		@Override
		public AttributeValue<CarinsuranceCase, Driver> get(
				CarinsuranceCase instance) {
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

	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	private static final Entity[] entities = new Entity[] {
		app.oldcarinsurance.entity.CarinsuranceCaseEntity.INSTANCE,
		DriverEntity.INSTANCE
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
	
	
}
