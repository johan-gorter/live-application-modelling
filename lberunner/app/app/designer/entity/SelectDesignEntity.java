package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class SelectDesignEntity extends SimpleEntity {

	public static final SelectDesignEntity INSTANCE = new SelectDesignEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<SelectDesign, RelationDesign, RelationDesign> relation
		= new SimpleRelation<SelectDesign, RelationDesign, RelationDesign>(
			"relation", INSTANCE, RelationDesignEntity.INSTANCE, RelationDesign.class, RelationDesignEntity.relationInselects
		) {
	
			@Override
			public ReadOnlyRelationValue<SelectDesign, RelationDesign> get(
					SelectDesign instance) {
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

	private SelectDesignEntity() {
		super("SelectDesign");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new SelectDesign(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return CompositePageFragmentDesignEntity.INSTANCE;
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
