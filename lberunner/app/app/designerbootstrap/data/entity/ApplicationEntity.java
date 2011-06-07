package app.designerbootstrap.data.entity;

import java.util.List;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.value.RelationValue;
import lbe.instance.value.RelationValues;
import lbe.model.Attribute;
import lbe.model.Entity;
import lbe.model.Relation;
import lbe.model.impl.SimpleEntity;
import lbe.model.impl.SimpleRelation;
import app.designerbootstrap.data.instance.ApplicationInstance;
import app.designerbootstrap.data.instance.EntityInstance;

public class ApplicationEntity extends SimpleEntity {

	public static final ApplicationEntity INSTANCE = new ApplicationEntity();
	
	public static final Relation<ApplicationInstance, List<EntityInstance>, EntityInstance> entities 
		= new SimpleRelation<ApplicationInstance, List<EntityInstance>, EntityInstance>("entities", INSTANCE, 
				AttributeEntity.INSTANCE, EntityInstance.class, EntityEntity.application) {
	
		@Override
		public RelationValues<ApplicationInstance, EntityInstance> get(
				ApplicationInstance instance) {
			return instance.entities;
		}
		
		public boolean isOwner() {
			return true;
		}
		
		public boolean isMultivalue() {
			return true;
		};
	};

	public static final Relation<ApplicationInstance, EntityInstance, EntityInstance> caseEntity
		= new SimpleRelation<ApplicationInstance, EntityInstance, EntityInstance>("caseEntity", INSTANCE, 
				EntityEntity.INSTANCE, EntityInstance.class, EntityEntity.caseEntityInApplication) {
	
		@Override
		public RelationValue<ApplicationInstance, EntityInstance> get(
				ApplicationInstance instance) {
			return instance.caseEntity;
		}
	};

	
	
	
	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		entities,
		caseEntity
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{};
	
	public ApplicationEntity() {
		super("Application");
	}

	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new ApplicationInstance();
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
