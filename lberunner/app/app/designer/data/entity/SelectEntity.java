package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class SelectEntity extends SimpleEntity {

	public static final SelectEntity INSTANCE = new SelectEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<SelectInstance, RelationInstance, RelationInstance> relation
		= new SimpleRelation<SelectInstance, RelationInstance, RelationInstance>(
			"relation", INSTANCE, RelationEntity.INSTANCE, RelationInstance.class, RelationEntity.relationInselects
		) {
	
			@Override
			public ReadOnlyRelationValue<SelectInstance, RelationInstance> get(
					SelectInstance instance) {
				return instance.relation;
			}
		};
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		relation,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private SelectEntity() {
		super("Select");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new SelectInstance(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return CompositePageFragmentEntity.INSTANCE;
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
